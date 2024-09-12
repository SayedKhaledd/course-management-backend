package com.example.coursemanagementapp.transformer;

import com.example.backendcoreservice.transformer.AbstractTransformer;
import com.example.coursemanagementapp.dto.ClientHistoryDto;
import com.example.coursemanagementapp.model.ClientHistory;
import com.example.coursemanagementapp.transformer.mapper.ClientHistoryMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientHistoryTransformer implements AbstractTransformer<ClientHistory, ClientHistoryDto, ClientHistoryMapper> {

    private final ClientHistoryMapper clienthistoryMapper;

    @Override
    public ClientHistoryMapper getMapper() {
        return clienthistoryMapper;
    }


}
