package com.example.urlshortenerprocessor

import com.example.urlshortenerprocessor.feign.GatewayFeignClient
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
@EnableFeignClients(basePackageClasses = [GatewayFeignClient::class])
class UrlShortenerProcessorApplication

fun main(args: Array<String>) {
    runApplication<UrlShortenerProcessorApplication>(*args)
}
