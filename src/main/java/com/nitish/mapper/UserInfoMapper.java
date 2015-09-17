package com.nitish.mapper;

import com.nitish.Bean.UserBean;
import com.nitish.dto.UserDTO;
import org.springframework.stereotype.Component;

/**
 * Created by nsm1211 on 16-09-2015.
 */
@Component
public class UserInfoMapper implements Mapper<UserBean, UserDTO> {

    @Override
    public UserDTO mapToDTO(UserBean userBean) {
        return new UserDTO().builder()
                .userId(userBean.getUserId())
                .name(userBean.getName())
                .emailId(userBean.getEmailId())
                .build();
    }

    @Override
    public UserBean mapToBean(UserDTO userDTO) {
        return new UserBean()
                .builder()
                .userId(userDTO.getUserId())
                .name(userDTO.getName())
                .emailId(userDTO.getEmailId())
                .build();
    }
}
