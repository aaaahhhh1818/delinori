package com.noriteo.delinori.reply.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan(basePackages = "com.noriteo.delinori.reply.controller")
public class ReplyServletConfig {
}
