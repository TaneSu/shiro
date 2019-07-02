package com.yootk.ssm.action;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonAction {

    @RequestMapping("/login")
    public String login() {

        return "login" ;
    }

    @RequiresRoles("member")
    @RequiresPermissions("dept:add")
    @RequestMapping("/pages/welcome")
    public String welcome() {

        return "welcome" ;
    }

    @RequestMapping("/logoutInfo")
    public String logout() {

        return "logout_info" ;
    }
}
