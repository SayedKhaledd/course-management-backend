package com.example.coursemanagementapp.service;

import com.example.coursemanagementapp.dto.ParsedClient;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ClientCsvService {

    List<ParsedClient> parseClients(MultipartFile file);

    void saveParsedClients(List<ParsedClient> parsedClients);
}
