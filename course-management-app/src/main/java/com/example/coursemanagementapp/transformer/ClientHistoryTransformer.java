package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.ClientHistoryMapper;
import com.example.coursemanagementapp.dto.ClientHistoryDto;
import com.example.coursemanagementapp.model.ClientHistory;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class ClientHistoryTransformer implements AbstractTransformer<ClientHistory, ClientHistoryDto, ClientHistoryMapper> {

    private final ClientHistoryMapper clienthistoryMapper;

    @Override
    public ClientHistoryMapper getMapper() {
        return clienthistoryMapper;
    }


}
