package com.ewinner.QuickStart.Controllers;

import com.ewinner.QuickStart.Common.Models.MyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/yamls")
public class YamlController {

    @Value("${info.name}")
    private String serverName;
    @Value("${info.address}")
    private String serverAddress;
    private final Environment env;
    private final MyInfo info;
    public YamlController(Environment env, MyInfo info) {
        this.env = env;
        this.info = info;
    }
    @GetMapping("/getServerInfo")
    public String getServerInfo(){
        return "Server name is " + serverName + "\n: " + serverAddress;
    }
    @GetMapping("/getEnvInfo")
    public String getEnvironment(){
        return env.getProperty("info.address") == null ? "@Value: " + serverAddress : "@Env: " + env.getProperty("info.address");
    }
    @GetMapping("/getInfo")
    public String getInfo(){
        String dockerInfos = info.getDocker_configs().toString().replaceAll("(?<=}),", "\n");
        System.out.println(dockerInfos);
        return dockerInfos;
    }
}
