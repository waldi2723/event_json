package com.example.rest_event.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath*:Beans.xml"})
public class XmlConfiguration {
}