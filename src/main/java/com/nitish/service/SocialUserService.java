package com.nitish.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nitish.Bean.UserBean;
import com.nitish.dto.UserDTO;
import com.nitish.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
@PropertySource("classpath:application.properties")
public class SocialUserService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private UserInfoMapper mapper;

    @Value("${USER_SERVICE}")
    private String userService;

    public UserBean getUserBy(int userId) throws IOException {
        Map<String, Integer> uriParams = new HashMap<>();
        uriParams.put("userid", userId);
        ResponseEntity<UserDTO> forEntity = restTemplate.getForEntity(userService + "/get/{userid}/user", UserDTO.class, uriParams);
        return mapper.mapToBean(forEntity.getBody());
    }

    public UserBean addUser(UserBean userBean) {
        ResponseEntity<UserDTO> userDTOResponseEntity = restTemplate.postForEntity(userService + "add/user", mapper.mapToDTO(userBean), UserDTO.class);
        return mapper.mapToBean(userDTOResponseEntity.getBody());
    }

    private UserBean getBeanFromJson(String actualUserData, Class<UserBean> classType) throws IOException {
        return new ObjectMapper().readValue(actualUserData.getBytes(), classType);
    }
}
