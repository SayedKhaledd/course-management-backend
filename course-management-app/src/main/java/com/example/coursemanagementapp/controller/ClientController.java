package com.example.coursemanagementapp.controller;

import com.example.backendcoreservice.api.ApiResponse;
import com.example.backendcoreservice.api.ApiResponseBuilder;
import com.example.backendcoreservice.controller.AbstractController;
import com.example.coursemanagementapp.dto.ClientDto;
import com.example.coursemanagementapp.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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


    // post request to create client

    //put update client, may not be used

    // patch requests to update:
    // client status
    // description
    // email
    // phone
    // alternate phone
    // country
    // nationality
    // address
    // specialty
    // referral source


}
