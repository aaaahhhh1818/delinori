package com.noriteo.delinori.reply.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.noriteo.delinori.reply.mapper")
@ComponentScan(basePackages = "com.noriteo.delinori.reply.service")
public class ReplyRootConfig {
}
