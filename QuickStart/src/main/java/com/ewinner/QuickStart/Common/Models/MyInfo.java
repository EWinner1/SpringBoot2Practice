package com.ewinner.QuickStart.Common.Models;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "info")
public class MyInfo {
    private List<DockerInfo> docker_configs;

    public List<DockerInfo> getDocker_configs() {
        return docker_configs;
    }

    public void setDocker_configs(List<DockerInfo> docker_configs) {
        this.docker_configs = docker_configs;
    }
}
