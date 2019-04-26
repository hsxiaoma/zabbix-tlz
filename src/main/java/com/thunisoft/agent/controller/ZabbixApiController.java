/*
 * @projectName zabbixMonitor
 * @package com.thunisoft.agent.controller
 * @className com.thunisoft.agent.controller.ZabbixApiController
 * @copyright Copyright 2019 Thuisoft, Inc. All rights reserved.
 */
package com.thunisoft.agent.controller;

import com.thunisoft.agent.api.ZabbixRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * ZabbixApiController
 * @description
 * @author tlz
 * @date 2019年04月22日 14:05
 * @version 1.1.0
 */
@RestController
@RequestMapping("/api")
public class ZabbixApiController {

    @Autowired
    ZabbixRequest zabbixRequest;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/sessionId")
    public String login() {
        return "";
    }

    @RequestMapping("/hostId")
    public String getHostId(@RequestParam(required = false) String[] ip, @RequestParam(required = false) String auth) {
        return "";
    }

    @RequestMapping("/itemId")
    public String getHostId(@RequestParam(required = false) String hostId) {
        return "";
    }

    @RequestMapping("/history")
    public String getHistory(@RequestParam(required = false) String hostId) {
        return "";
    }

}
