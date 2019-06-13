package com.practice.springbootadmin.client.controller;

import com.practice.springbootadmin.client.config.external.RoleProperty;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Luo Bao Ding
 * @since 2018/6/22
 */
@RestController
@ConfigurationProperties("echo")
@RefreshScope
public class EchoController {

    private List<String> greetings = new ArrayList<>();

    @Value("${message: hello default}")
    private String message;

    private RoleProperty roleProperty;

    @RequestMapping("/echo/{content}")
    public Object echo(@PathVariable(name = "content",required = false) String content) {
        if (StringUtils.isBlank(content)) {
            return "please url: /echo/{content}";
        }
        return content;
    }

    @RequestMapping("/peek/config")
    public Object peekConfig() {
        Map<String, Object> map = new HashMap<>(32);
        map.put("greetings", greetings);
        map.put("message", message);
        map.put("roleProperty", roleProperty);

        return map;
    }

    public List<String> getGreetings() {
        return greetings;
    }

    public void setGreetings(List<String> greetings) {
        this.greetings = greetings;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Autowired
    public void setRoleProperty(RoleProperty roleProperty) {
        this.roleProperty = roleProperty;
    }
}
