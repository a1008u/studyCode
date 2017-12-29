package com.example.twittersample.controller

import com.example.twittersample.service.TwitterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.social.twitter.api.Twitter
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.text.SimpleDateFormat


@RestController
@RequestMapping(TWITTER_BASE_URI)
class TwitterController{

    @Autowired
    private lateinit var twitterService: TwitterService

    /**
     * @param hashTag String
     *
     */
    @RequestMapping(value = "{hashTag}", produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun getTweets(@PathVariable hashTag:String):MutableList<Json>{
        val jsonList = twitterService.findTweet(hashTag)
        return jsonList
    }
}

const val TWITTER_BASE_URI = "svc/v1/tweets"
data class Json(var user:String, var text:String, var profileImageUrl:String , var createdAt:String)




