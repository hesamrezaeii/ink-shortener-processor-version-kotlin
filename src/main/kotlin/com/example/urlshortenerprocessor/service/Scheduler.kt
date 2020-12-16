package com.example.urlshortenerprocessor.service

import com.example.urlshortenerprocessor.feign.GatewayFeignClient
import com.example.urlshortenerprocessor.mongo.document.ClickHourly
import com.example.urlshortenerprocessor.mongo.document.UrlClick
import com.example.urlshortenerprocessor.mongo.repo.ClickHourlyRepo
import com.example.urlshortenerprocessor.mongo.repo.UrlClickRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.*

@Component
class Scheduler {
    @Autowired
    lateinit var urlClickRepo: UrlClickRepo

    @Autowired
    lateinit var clickHourlyRepo: ClickHourlyRepo

    @Autowired
    lateinit var gatewayFeignClient: GatewayFeignClient

    //@Scheduled(cron = "0 0 * ? * *")
    @Scheduled(fixedRate = 60*1000)
    fun run() {
        val cal = Calendar.getInstance()
        val now = cal.time
        cal.add(Calendar.HOUR, -1)
        val hourAgo = cal.time

        gatewayFeignClient.getLastTenShortUrls()?.forEach { shortUrl ->
            val urlClickObj: List<UrlClick> = urlClickRepo.findByShortUrlAndDateBetween(shortUrl, hourAgo, now)
            val clickHourly = ClickHourly(shortUrl, hourAgo, now, urlClickObj.size.toLong())
            print(clickHourlyRepo.save(clickHourly))
        }

    }
}

