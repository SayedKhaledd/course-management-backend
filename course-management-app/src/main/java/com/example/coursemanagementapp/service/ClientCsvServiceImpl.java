package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.exception.CustomException;
import com.example.backendcoreservice.util.CsvUtil;
import com.example.coursemanagementapp.dto.*;
import com.example.coursemanagementapp.transformer.ClientCsvTransformer;
import com.example.coursemanagementapp.validation.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class ClientCsvServiceImpl implements ClientCsvService {
    private final Map<String, ValidationHandler> validationHandlers;
    private final CourseService courseService;
    private final ClientStatusService clientStatusService;
    private final ReferralSourceService referralSourceService;
    private final ClientService clientService;
    private final ClientCsvTransformer clientCsvTransformer;


    @Override
    public List<ParsedClient> parseClients(MultipartFile file) {
        log.info("ClientCsvServiceImpl: parseClients() - called");
        List<ParsedClient> parsedClients = CsvUtil.readFileWithHeadersValidation(file, ParsedClient.class);
        validate(parsedClients);
        return parsedClients;
    }

    @Transactional
    @Override
    public void saveParsedClients(List<ParsedClient> parsedClients) {
        log.info("ClientCsvServiceImpl: saveClients() - called");
        validate(parsedClients);
        if (!hasErrors(parsedClients)) {
            List<ClientDto> clientDtos = transformParsedClientsToClientDtos(parsedClients);
            clientService.create(clientDtos);
        } else
            throw new CustomException("Validation errors found in the parsed clients");
    }


    private void validate(List<ParsedClient> parsedClients) {
        log.info("ClientCsvServiceImpl: validate() - called");
        validationHandlers.get(ValidationHandler.getDefaultBeanName(PhoneValidationHandler.class)).validate(parsedClients);
        validationHandlers.get(ValidationHandler.getDefaultBeanName(EmailValidationHandler.class)).validate(parsedClients);
        validationHandlers.get(ValidationHandler.getDefaultBeanName(AlternativePhoneNumberValidationHandler.class)).validate(parsedClients);
        validationHandlers.get(ValidationHandler.getDefaultBeanName(ReferralSourceValidationHandler.class)).validate(parsedClients);
        validationHandlers.get(ValidationHandler.getDefaultBeanName(StatusValidationHandler.class)).validate(parsedClients);
        validationHandlers.get(ValidationHandler.getDefaultBeanName(InitialCourseValidationHandler.class)).validate(parsedClients);
        validationHandlers.get(ValidationHandler.getDefaultBeanName(DatabaseValidationHandler.class)).validate(parsedClients);


    }

    private boolean hasErrors(List<ParsedClient> parsedClients) {
        return parsedClients.stream().anyMatch(client -> !client.isValid());
    }

    private List<ClientDto> transformParsedClientsToClientDtos(List<ParsedClient> parsedClients) {
        Set<String> referralSources = extractUniqueValues(parsedClients, ParsedClient::getReferralSource);
        Set<String> statuses = extractUniqueValues(parsedClients, ParsedClient::getStatus);
        Set<String> initialCourses = extractUniqueValues(parsedClients, ParsedClient::getInitialCourse);

        log.info("ClientCsvServiceImpl: transformParsedClientsToClientDtos() - referralSources: {}, statuses: {}, initialCourses: {}", referralSources, statuses, initialCourses);

        List<ReferralSourceDto> referralSourceDtos = referralSources.isEmpty() ? null : referralSourceService.findAllBySourcesIn(referralSources);
        List<ClientStatusDto> clientStatusDtos = statuses.isEmpty() ? null : clientStatusService.findAllByStatusesIn(statuses);
        List<CourseDto> courseDtos = initialCourses.isEmpty() ? null : courseService.findAllInitialCoursesByNamesIn(initialCourses);

        return parsedClients.stream().map(parsedClient -> {
            ClientDto clientDto = clientCsvTransformer.transformParsedClientToClientDto(parsedClient);
            setClientDtoFields(parsedClient, clientDto, referralSourceDtos, clientStatusDtos, courseDtos);
            return clientDto;
        }).toList();
    }

    private Set<String> extractUniqueValues(List<ParsedClient> parsedClients, Function<ParsedClient, String> extractor) {
        return parsedClients.stream()
                .map(extractor)
                .filter(value -> value != null && !value.isEmpty())
                .collect(Collectors.toSet());
    }

    private void setClientDtoFields(ParsedClient parsedClient, ClientDto clientDto, List<ReferralSourceDto> referralSourceDtos,
                                    List<ClientStatusDto> clientStatusDtos,
                                    List<CourseDto> courseDtos) {
        if (referralSourceDtos != null)
            referralSourceDtos.stream()
                    .filter(referralSourceDto -> referralSourceDto.getSource().getSource().equals(parsedClient.getReferralSource()))
                    .findFirst().ifPresent(referralSourceDto -> clientDto.setReferralSourceId(referralSourceDto.getId()));
        if (clientStatusDtos != null)
            clientStatusDtos.stream()
                    .filter(clientStatusDto -> clientStatusDto.getStatus().getStatus().equals(parsedClient.getStatus()))
                    .findFirst().ifPresent(clientStatusDto -> clientDto.setClientStatusId(clientStatusDto.getId()));
        if (courseDtos != null)
            courseDtos.stream()
                    .filter(courseDto -> courseDto.getName().equals(parsedClient.getInitialCourse()))
                    .findFirst().ifPresentOrElse(courseDto -> clientDto.setInitialCourseId(courseDto.getId()),
                            () -> {
                                throw new CustomException("Course not found for name: " + parsedClient.getInitialCourse());
                            }
                    );
    }
}
