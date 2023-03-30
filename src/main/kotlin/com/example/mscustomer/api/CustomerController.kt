package com.example.mscustomer.api

import com.example.mscustomer.service.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/customers")
class CustomerController @Autowired constructor(private val accountService: AccountService){
    @Value("\${server.port}")
    lateinit var port: String

    @GetMapping("/test")
    fun test(): String {
        val result = accountService.test()
        return "Customer server port: $port -> $result";
    }

    @GetMapping("/list")
    fun getCostumers() = listOf("Customer1", "Customer2", "Customer3") + accountService.getAccounts()
}