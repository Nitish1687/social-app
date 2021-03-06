package com.nitish.controller;

import com.nitish.Bean.Advertisement;
import com.nitish.Bean.UserBean;
import com.nitish.service.SocialUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static java.lang.Integer.parseInt;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by nsm1211 on 16-09-2015.
 */
@Controller
public class SocialUserController {

    @Autowired
    private SocialUserService socialUserService;

    @RequestMapping(value = "/get/{userId}/user", method = GET)
    public @ResponseBody UserBean getUserById(@PathVariable String userId) {
        UserBean userBy = getUserBeanByID(userId);
        return userBy;
    }

    @RequestMapping(value = "/add/user", method = POST)
    public @ResponseBody UserBean addUser(@RequestBody UserBean userBean) {
       UserBean returnBean =  socialUserService.addUser(userBean);
        return returnBean;
    }

    @RequestMapping(value = "/user/{userId}/advertisement", method = GET)
    public @ResponseBody Advertisement getAdvertisementFor(@PathVariable String userId) {
        UserBean userBeanByID = getUserBeanByID(userId);
        return socialUserService.getAdvertisedProductForUser(userBeanByID);
    }

    private UserBean getUserBeanByID(String userId) {
        return socialUserService.getUserBy(parseInt(userId));
    }
}
