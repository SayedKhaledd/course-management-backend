package com.example.coursemanagementapp.service;

import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.exception.CustomException;
import com.example.coursemanagementapp.dao.UserDao;
import com.example.coursemanagementapp.dto.HistoryDto;
import com.example.coursemanagementapp.dto.UserDto;
import com.example.coursemanagementapp.dto.search.UserSearchDto;
import com.example.coursemanagementapp.model.User;
import com.example.coursemanagementapp.transformer.UserTransformer;
import com.example.coursemanagementapp.validator.UserValidator;
import com.example.keycloakbackendclient.dto.KeycloakUserDto;
import com.example.keycloakbackendclient.service.KeycloakUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final UserTransformer userTransformer;
    private final KeycloakUserService keycloakUserService;
    private final HistoryService historyService;
    private final UserValidator userValidator;

    @Override
    public UserDao getDao() {
        return userDao;
    }

    @Override
    public UserTransformer getTransformer() {
        return userTransformer;
    }

    @Override
    public String getEntityName() {
        return User.class.getSimpleName();
    }

    @Transactional
    @Override
    public UserDto create(UserDto dto) {
        log.info("UserService: create - was called with user: {}", dto);
        dto.setEmail(dto.getEmail().toLowerCase().trim());
        UserDto userDto = UserService.super.create(dto);
        KeycloakUserDto keycloakUserDto = getTransformer().toKeycloakUserDto(dto);
        keycloakUserDto.setId(userDto.getId() + "");
        keycloakUserDto = keycloakUserService.registerUser(keycloakUserDto);
        userDto.setKeycloakId(keycloakUserDto.getKeycloakId());
        return UserService.super.update(userDto, userDto.getId());
    }

    @Override
    public PaginationResponse<UserDto> findAllPaginatedAndFiltered(PaginationRequest<UserSearchDto> paginationRequest) {
        log.info("UserService: findAllPaginatedAndFiltered - was called with paginationRequest: {}", paginationRequest);
        return buildPaginationResponse(getDao().findAllPaginatedAndFiltered(paginationRequest));
    }

    @Transactional
    @Override
    public void updateRole(Long id, UserDto userDto) {
        log.info("UserService: updateUserRole - was called with id: {} and role: {}", id, userDto.getRole().getRole());
        UserDto userDtoDb = findById(id);
        if (!userValidator.shouldUpdateRole(userDtoDb.getRole())) {
            throw new CustomException("You are not allowed to update this user's role");
        }
        keycloakUserService.updateUserRole(userDtoDb.getKeycloakId(), userDto.getRole().getRole());
        historyService.create(HistoryDto.HistoryDtoBuilder().
                entityId(id)
                .entityType(getEntityName())
                .fieldName("role")
                .oldValue(userDtoDb.getRole().getRole())
                .newValue(userDto.getRole().getRole())
                .build());
        getDao().updateRole(id, userDto.getRole().getRole());
    }

    @Transactional
    @Override
    public void updateFirstName(Long id, UserDto userDto) {
        log.info("UserService: updateFirstName - was called with id: {} and first name: {}", id, userDto.getFirstName());
        UserDto userDtoDb = findById(id);
        userDtoDb.setFirstName(userDto.getFirstName());
        keycloakUserService.updateKeycloakUser(getTransformer().toKeycloakUserDto(userDtoDb));
        historyService.create(HistoryDto.HistoryDtoBuilder().
                entityId(id)
                .entityType(getEntityName())
                .fieldName("firstName")
                .oldValue(userDtoDb.getFirstName())
                .newValue(userDto.getFirstName())
                .build());
        getDao().updateFirstName(id, userDto.getFirstName());

    }

    @Transactional
    @Override
    public void updateLastName(Long id, UserDto userDto) {
        log.info("UserService: updateLastName - was called with id: {} and last name: {}", id, userDto.getLastName());
        UserDto userDtoDb = findById(id);
        userDtoDb.setLastName(userDto.getLastName());
        keycloakUserService.updateKeycloakUser(getTransformer().toKeycloakUserDto(userDtoDb));
        historyService.create(HistoryDto.HistoryDtoBuilder().
                entityId(id)
                .entityType(getEntityName())
                .fieldName("lastName")
                .oldValue(userDtoDb.getLastName())
                .newValue(userDto.getLastName())
                .build());
        getDao().updateLastName(id, userDto.getLastName());

    }

    @Transactional
    @Override
    public void updateEmail(Long id, UserDto userDto) {
        log.info("UserService: updateEmail - was called with id: {} and email: {}", id, userDto.getEmail());
        UserDto userDtoDb = findById(id);
        userDtoDb.setEmail(userDto.getEmail());
        keycloakUserService.updateKeycloakUser(getTransformer().toKeycloakUserDto(userDtoDb));
        historyService.create(HistoryDto.HistoryDtoBuilder().
                entityId(id)
                .entityType(getEntityName())
                .fieldName("email")
                .oldValue(userDtoDb.getEmail())
                .newValue(userDto.getEmail())
                .build());
        getDao().updateEmail(id, userDto.getEmail());

    }

    @Transactional
    @Override
    public void updatePhoneNumber(Long id, UserDto userDto) {
        log.info("UserService: updatePhoneNumber - was called with id: {} and phone number: {}", id, userDto.getPhoneNumber());
        UserDto userDtoDb = findById(id);
        userDtoDb.setPhoneNumber(userDto.getPhoneNumber());
        keycloakUserService.updateKeycloakUser(getTransformer().toKeycloakUserDto(userDtoDb));
        historyService.create(HistoryDto.HistoryDtoBuilder().
                entityId(id)
                .entityType(getEntityName())
                .fieldName("phoneNumber")
                .oldValue(userDtoDb.getPhoneNumber())
                .newValue(userDto.getPhoneNumber())
                .build());
        getDao().updatePhoneNumber(id, userDto.getPhoneNumber());
    }

    @Transactional
    @Override
    public void delete(Long id) {
        log.info("UserService: delete - was called with id: {}", id);
        UserDto userDto = findById(id);
        keycloakUserService.deleteUser(userDto.getKeycloakId());
        UserService.super.delete(id);
    }
}
