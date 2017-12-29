package com.example.twittersample.config

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.http.converter.json.MappingJacksonValue
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice
import java.io.IOException

// CORSの対策をしているので、jsonpは一旦考えない
@ControllerAdvice
class JsonpAdvice : AbstractJsonpResponseBodyAdvice("cb") {

    @Bean
    fun MappingJackson2HttpMessageConverter(ctx: ApplicationContext): MappingJackson2HttpMessageConverter {

        val mapper = Jackson2ObjectMapperBuilder.json().applicationContext(ctx).build<ObjectMapper>()

        return object : MappingJackson2HttpMessageConverter(mapper) {

            @Throws(IOException::class)
            override fun writePrefix(generator: JsonGenerator?, obj: Any?) {
                if (obj !is MappingJacksonValue) return
                val funcName = obj.jsonpFunction
                if (funcName != null) generator!!.writeRaw(funcName + "(")
            }
        }
    }

}