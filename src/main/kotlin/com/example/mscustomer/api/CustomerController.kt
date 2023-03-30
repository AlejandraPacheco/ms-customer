package com.example.mscustomer.api

import com.example.mscustomer.dto.TokenCredentialsDto
import com.example.mscustomer.service.AccountService
import com.example.mscustomer.service.KeycloakService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerController @Autowired constructor(private val accountService: AccountService,
                        private val keycloakService: KeycloakService) {
    companion object {
        val customers = listOf("John", "Jane", "Jake")
    }

    @Value("\${server.port}")
    lateinit var port: String

    @GetMapping("/test")
    fun test(): String {
        val result = accountService.test()
        return "Customer server port: $port -> $result";
    }

    @GetMapping("/list")
    fun getCostumers(): List<String> {
        return customers + accountService.getAccounts()
    }

    @GetMapping("/customer/{customer}")
    fun convertCurrency(@PathVariable customer: String): TokenCredentialsDto {
        if(!customers.contains(customer)){
            throw RuntimeException("Customer not found")
        }
        val result = keycloakService.token(mapOf(
            "grant_type" to "client_credentials",
            "client_id" to "backend",
            "client_secret" to "b3d3b3d3-3b3d-3b3d-3b3d-3b3d3b3d3b3d"
        ))
        println(result)
        return result
    }
}