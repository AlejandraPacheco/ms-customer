package com.example.mscustomer.service

import com.example.mscustomer.dto.TokenCredentialsDto
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.http.MediaType

@FeignClient(name = "keycloak", url = "http://localhost:8080/realms/master/protocol/openid-connect/token")

interface KeycloakService {
    @PostMapping(consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE])
    fun token(formParams: Map<String, *>): TokenCredentialsDto
}