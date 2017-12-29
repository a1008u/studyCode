package com.example.twittersample

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class TwitterSampleApplication

fun main(args: Array<String>) {
    SpringApplication.run(TwitterSampleApplication::class.java, *args)
}
