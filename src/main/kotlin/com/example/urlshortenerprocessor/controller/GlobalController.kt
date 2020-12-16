package com.example.urlshortenerprocessor.controller

import com.example.urlshortenerprocessor.mongo.document.ClickHourly
import com.example.urlshortenerprocessor.mongo.document.UrlClick
import com.example.urlshortenerprocessor.mongo.repo.ClickHourlyRepo
import com.example.urlshortenerprocessor.mongo.repo.UrlClickRepo
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GlobalController(val clickHourlyRepo: ClickHourlyRepo, val urlClickRepo: UrlClickRepo) {
    @GetMapping("/all-click-hourly")
    fun allClickHourly(): List<ClickHourly> =
            clickHourlyRepo.findAll()

    fun allUrlClick(): List<UrlClick> =
            urlClickRepo.findAll()


    fun deleteAllClickHourly(): String {
        clickHourlyRepo.deleteAll()
        return "All of [ClickHourly] repository Cleared"
    }

    fun deleteAllUrlClick(): String {
        urlClickRepo.deleteAll()
        return "All of [UrlClick] repository Cleared"

    }
}