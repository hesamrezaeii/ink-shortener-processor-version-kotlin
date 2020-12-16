package com.example.urlshortenerprocessor.kafka.messageType

import java.util.*

data class UrlClickMessage(val shortUrl:String
                           ,val originalUrl:String,val date: Date
                           ,val ip:String,val userAgent:String)