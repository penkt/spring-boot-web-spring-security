package com.pengkey.web.restController;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.pengkey.request.BaseRequest;
import com.pengkey.response.BaseResponse;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/userManager")
public class UserManagerController {
    @Autowired
    private SessionRegistry sessionRegistry;

    @RequestMapping(value = "/getAllOnlineUser",method = {RequestMethod.GET,RequestMethod.POST})
    public BaseResponse getAllOnlineUser(){
        BaseResponse response=new BaseResponse();
        Map<String,Object>model= Maps.newConcurrentMap();
        model.put("count",sessionRegistry.getAllPrincipals().size());
        List<Object> allPrincipals = sessionRegistry.getAllPrincipals();
        List<String>userNameList= Lists.newArrayList();
        for (Object o:allPrincipals) {
            User user=(User)o;
            userNameList.add(user.getUsername());
        }
        if(CollectionUtils.isNotEmpty(userNameList)){
            model.put("userNameList",userNameList);
        }
        response.setModel(model);
        return response;
    }

}
