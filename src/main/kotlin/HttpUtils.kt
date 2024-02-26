package com.moneyforward.challenge

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URI

/**
 * Contains helper functions for executing GET requests.
 *
 * For simplicity, a few assumptions or decisions were made:
 * - Only HTTP OK is considered a valid response code
 * - Json response always contains snake_case attributes
 * - Uses blocking HTTP calls and minimal error handling
 */
class HttpUtils {
    companion object {
        /**
         * Executes a GET request and returns the response body.
         *
         * @throws IOException if there was an error making the HTTP request
         * @throws RuntimeException if the response code was not HTTP OK
         */
        fun httpGet(uri: String): String {
            val url = URI(uri).toURL()
            // note: there are many ways to make HTTP requests in Kotlin, this is just one of them
            with(url.openConnection() as HttpURLConnection) {
                requestMethod = "GET"
                if (responseCode != HttpURLConnection.HTTP_OK) {
                    throw RuntimeException("Request failed with response code $responseCode")
                }

                return inputStream.bufferedReader().use { it.readText() }
            }
        }

        /**
         * Executes a GET request and returns a typed [T] object.
         *
         * @throws IOException if there was an error making the HTTP request
         * @throws RuntimeException if the response code was not HTTP OK
         * @throws JsonProcessingException if the object mapping was unsuccessful
         */
        inline fun <reified T> simpleGetRequest(uri: String): T = mapper.readValue<T>(httpGet(uri))

        // note: jackson is a popular library for JSON serialization/deserialization
        val mapper: ObjectMapper = jacksonObjectMapper().setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
    }
}
