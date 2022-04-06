package com.uin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wanglufei
 * @description: TODO
 * @date 2022/4/4/1:01 AM
 */
@Controller
public class NotificationsController {
    /**
     * 跳转页面
     *
     * @return java.lang.String
     * @author wanglufei
     * @date 2022/4/4 8:22 PM
     */
    @RequestMapping("/notifications")
    public String notifications() {
        return "notifications";
    }
}
