package com.example.mscustomer.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty


@JsonIgnoreProperties(ignoreUnknown = true)
data class TokenCredentialsDto (
    @JsonProperty("access_token")
    val accessToken: String,
    @JsonProperty("expires_in")
    val expiresIn: Int,
    @JsonProperty("refresh_in")
    val refreshIn: Int,
    @JsonProperty("token_type")
    val tokenType: String,
    @JsonProperty("scope")
    val scope: String
)