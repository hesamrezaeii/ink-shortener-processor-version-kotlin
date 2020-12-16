package com.example.urlshortenerprocessor.feign


import com.example.urlshortenerprocessor.mongo.document.UrlClick
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod


@FeignClient(name = "feign-service", url = "http://localhost:8080")
interface GatewayFeignClient {
    @RequestMapping(method = [RequestMethod.GET], path = ["/api/ten-short-urls"])
    fun getLastTenShortUrls():List<String>?
}