package com.qatrainer.core.config;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = {"com.qatrainer.core.model"})
public class CoreConfig {

}
