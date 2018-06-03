package org.zwx.base.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zwx.base.dao.UserDao;
import org.zwx.base.entity.Group;
import org.zwx.base.entity.Resource;
import org.zwx.base.entity.User;

import java.util.List;

@Controller
public class MenuController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(method = RequestMethod.GET)
    public void menuList(Model model){
        String userName = (String) SecurityUtils.getSubject().getPrincipal();

        User user = userDao.findByName(userName);
        Group group = user.getGroup();
        List<Resource> resources = group.getResources();

    }

}
