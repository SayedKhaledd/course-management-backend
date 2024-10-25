package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.api.pagination.PaginationRequest;
import com.example.backendcoreservice.api.pagination.PaginationResponse;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.ClientDto;
import com.example.coursemanagementapp.dto.ClientSearchDto;
import com.example.coursemanagementapp.service.ClientService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/client")
@AllArgsConstructor
public class ClientController implements AbstractController<ClientService, ClientDto> {

    private final ClientService clientService;
    private final ApiResponseBuilder<ClientDto> apiResponseBuilder;


    @Override
    public ClientService getService() {
        return clientService;
    }

    @Override
    public ApiResponseBuilder<ClientDto> getApiResponseBuilder() {
        return apiResponseBuilder;
    }

    @GetMapping("/{id}")
    public ApiResponse<ClientDto> findById(@PathVariable Long id) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findById(id));
    }

    @GetMapping("/all")
    public ApiResponse<?> findAll() {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAll());
    }


    @PostMapping("/find-paginated-and-filtered")
    public ApiResponse<PaginationResponse<ClientDto>> findAllPaginatedAndFiltered(@Valid @RequestBody PaginationRequest<ClientSearchDto> paginationRequest) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllPaginatedAndFiltered(paginationRequest));
    }

    @PostMapping()
    public ApiResponse<ClientDto> create(@Validated(ClientDto.Create.class) @RequestBody ClientDto clientDto) {
        return getApiResponseBuilder().buildSuccessResponse(getService().create(clientDto));
    }


    @PutMapping("/{id}")
    public ApiResponse<ClientDto> update(@PathVariable Long id, @Validated(ClientDto.Update.class) @RequestBody ClientDto clientDto) {
        return getApiResponseBuilder().buildSuccessResponse(getService().update(clientDto, id));
    }

    @PatchMapping("/{id}/name")
    public ApiResponse<?> updateName(@PathVariable Long id, @RequestBody @Validated(ClientDto.UpdateName.class) ClientDto clientDto) {
        getService().updateName(id, clientDto);
        return getApiResponseBuilder().buildSuccessResponse();
    }


    @PatchMapping("/{id}/status/{statusId}")
    public ApiResponse<?> updateStatus(@PathVariable Long id, @PathVariable Long statusId) {
        getService().updateStatus(id, statusId);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/description")
    public ApiResponse<?> updateDescription(@PathVariable Long id, @RequestBody @Validated(ClientDto.UpdateDescription.class) ClientDto clientDto) {
        getService().updateDescription(id, clientDto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/email")
    public ApiResponse<?> updateEmail(@PathVariable Long id, @RequestBody @Validated(ClientDto.UpdateEmail.class) ClientDto clientDto) {
        getService().updateEmail(id, clientDto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/phone")
    public ApiResponse<?> updatePhone(@PathVariable Long id, @RequestBody @Validated(ClientDto.UpdatePhone.class) ClientDto clientDto) {
        getService().updatePhone(id, clientDto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/alternative-phone")
    public ApiResponse<?> updateAlternativePhone(@PathVariable Long id, @RequestBody @Validated(ClientDto.UpdateAlternativePhone.class) ClientDto clientDto) {
        getService().updateAlternativePhone(id, clientDto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/country")
    public ApiResponse<?> updateCountry(@PathVariable Long id, @RequestBody @Validated(ClientDto.UpdateCountry.class) ClientDto clientDto) {
        getService().updateCountry(id, clientDto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/nationality")
    public ApiResponse<?> updateNationality(@PathVariable Long id, @RequestBody @Validated(ClientDto.UpdateNationality.class) ClientDto clientDto) {
        getService().updateNationality(id, clientDto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/address")
    public ApiResponse<?> updateAddress(@PathVariable Long id, @RequestBody @Validated(ClientDto.UpdateAddress.class) ClientDto clientDto) {
        getService().updateAddress(id, clientDto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/specialty")
    public ApiResponse<?> updateSpecialty(@PathVariable Long id, @RequestBody @Validated(ClientDto.UpdateSpecialty.class) ClientDto clientDto) {
        getService().updateSpecialty(id, clientDto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    @PatchMapping("/{id}/referral-source/{referralSourceId}")
    public ApiResponse<?> updateReferralSource(@PathVariable Long id, @PathVariable Long referralSourceId) {
        getService().updateReferralSource(id, referralSourceId);
        return getApiResponseBuilder().buildSuccessResponse();
    }


    @DeleteMapping("/{id}")
    public ApiResponse<?> delete(@PathVariable Long id) {
        getService().delete(id);
        return getApiResponseBuilder().buildSuccessResponse();
    }


}
