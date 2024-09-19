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
    //get request find by id

    @GetMapping("{id}")
    public ApiResponse<ClientDto> findById(@PathVariable Long id) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findById(id));
    }


    //post request find all paginated and filtered
    @PostMapping("/find-paginated-and-filtered")
    public ApiResponse<PaginationResponse<ClientDto>> findAllPaginatedAndFiltered(@Valid @RequestBody PaginationRequest<ClientSearchDto> paginationRequest) {
        return getApiResponseBuilder().buildSuccessResponse(getService().findAllPaginatedAndFiltered(paginationRequest));
    }


    // post request to create client

    @PostMapping()
    public ApiResponse<ClientDto> create(@Validated(ClientDto.Create.class) @RequestBody ClientDto clientDto) {
        return getApiResponseBuilder().buildSuccessResponse(getService().create(clientDto));
    }

    //put update client, may not be used

    @PutMapping("/{id}")
    public ApiResponse<ClientDto> update(@PathVariable Long id, @Validated(ClientDto.Update.class) @RequestBody ClientDto clientDto) {
        return getApiResponseBuilder().buildSuccessResponse(getService().update(clientDto, id));
    }

    // patch requests to update:
    // client status
    @PatchMapping("/{id}/status/{statusId}")
    public ApiResponse<?> updateStatus(@PathVariable Long id, @PathVariable Long statusId) {
        getService().updateStatus(id, statusId);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    // description
    @PatchMapping("/{id}/description")
    public ApiResponse<?> updateStatus(@PathVariable Long id, @RequestBody @Validated(ClientDto.UpdateDescription.class) ClientDto clientDto) {
        getService().updateDescription(id, clientDto);
        return getApiResponseBuilder().buildSuccessResponse();
    }

    // email
//    @PatchMapping("/{id}/email")
//    public ApiResponse<?> updateEmail(@PathVariable Long id, @RequestBody String email) {
//        getService().updateEmail(id, email);
//        return getApiResponseBuilder().buildSuccessResponse();
//    }
//    // phone
//    @PatchMapping("/{id}/phone")
//    public ApiResponse<?> updatePhone(@PathVariable Long id, @RequestBody String phone) {
//        getService().updatePhone(id, phone);
//        return getApiResponseBuilder().buildSuccessResponse();
//    }
    // alternate phone
    // country
    // nationality
    // address
    // specialty
    // referral source


}
