package com.example.coursemanagementapp.transformer;

import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;
import com.example.coursemanagementapp.transformer.mapper.UserMapper;
import com.example.coursemanagementapp.dto.UserDto;
import com.example.coursemanagementapp.model.User;
import com.example.backendcoreservice.transformer.AbstractTransformer;

@Component
@AllArgsConstructor
public class UserTransformer implements AbstractTransformer<User, UserDto, UserMapper> {

    private final UserMapper userMapper;

    @Override
    public UserMapper getMapper() {
        return userMapper;
    }


}
