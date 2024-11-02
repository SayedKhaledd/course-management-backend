package com.example.coursemanagementapp.controller;

import com.example.coursemanagementapp.CourseManagementAppApplication;
import com.example.coursemanagementapp.dto.ClientDto;
import com.example.coursemanagementapp.service.ClientService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest(classes = {CourseManagementAppApplication.class})
@AutoConfigureMockMvc
class ClientControllerUnitTests {

    @MockBean
    private ClientService clientService;

    @Autowired
    private MockMvc mockMvc;


    @Nested
    class FindById {
        @Test
        void findById_IdIsValid_ReturnsClient() throws Exception {
            ClientDto clientDto = new ClientDto();
            given(clientService.findById(anyLong())).willReturn(clientDto);
            mockMvc.perform(get("/api/client/1"))
                    .andExpect(status().isOk())
                    .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                    .andExpect(content().json("{}"));
        }

        @Test
        void findById_ClientDoesNotExist_ThrowsException() throws Exception {
            given(clientService.findById(anyLong())).willThrow(EntityNotFoundException.class);
            mockMvc.perform(get("/api/client/999"))
                    .andExpect(status().isNotFound());
        }

        @Test
        @DisplayName("findById returns bad request when id is invalid")
        void findById_ClientDoesNotExist_ReturnsBadRequest() throws Exception {
            mockMvc.perform(get("/api/client/invalid-id")
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isBadRequest());
        }
    }


}
