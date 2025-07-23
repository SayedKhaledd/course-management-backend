package com.example.coursemanagementapp.transformer;

import com.example.coursemanagementapp.dto.ClientDto;
import com.example.coursemanagementapp.dto.ParsedClient;
import com.example.coursemanagementapp.transformer.mapper.ClientCsvMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ClientCsvTransformer {
    private final ClientCsvMapper clientCsvMapper;

    public ClientDto transformParsedClientToClientDto(ParsedClient parsedClient) {
        return clientCsvMapper.toClientDto(parsedClient);
    }
}
