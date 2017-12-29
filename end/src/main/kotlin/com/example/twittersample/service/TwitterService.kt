package com.example.twittersample.service

import com.example.twittersample.controller.Json
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.social.twitter.api.Twitter
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat

@Service
class TwitterService {

    @Autowired
    private lateinit var twitter: Twitter

    /**
     * @param hashTag String
     *  hastagの説明::: 「%23検索ワード」で「#検索ワード」として利用できる
     */
    fun findTweet(hashTag:String) :MutableList<Json> {

        val targetTweets= twitter.searchOperations().search(hashTag, 20).tweets

        val simpleDate = SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
        val jsonList = mutableListOf<Json>()
        targetTweets.forEach { tweet -> jsonList.add(Json(user = tweet.fromUser
                , text = tweet.text
                , profileImageUrl = tweet.profileImageUrl
                , createdAt = simpleDate.format(tweet.createdAt)
        )) }

        return jsonList
    }

}