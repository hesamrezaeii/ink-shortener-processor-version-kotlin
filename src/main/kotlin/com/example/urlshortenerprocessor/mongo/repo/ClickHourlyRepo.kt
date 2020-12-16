package com.example.urlshortenerprocessor.mongo.repo

import com.example.urlshortenerprocessor.mongo.document.ClickHourly
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface ClickHourlyRepo : MongoRepository<ClickHourly, String> {
    fun findByFromAndTo(from: Date, to: Date)
}