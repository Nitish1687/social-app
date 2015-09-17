package com.nitish.Bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by nsm1211 on 16-09-2015.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserBean {
    private int userId;
    private String name;
    private String emailId;

}
