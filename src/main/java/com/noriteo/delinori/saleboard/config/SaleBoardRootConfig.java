package com.noriteo.delinori.saleboard.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.noriteo.delinori.saleboard.mapper")
@ComponentScan(basePackages = "com.noriteo.delinori.saleboard.service")
public class SaleBoardRootConfig {
}
