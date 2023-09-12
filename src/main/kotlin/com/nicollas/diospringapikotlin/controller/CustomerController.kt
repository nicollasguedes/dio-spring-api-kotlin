package com.nicollas.diospringapikotlin.controller

import com.nicollas.diospringapikotlin.dto.customer.CustomerDTO
import com.nicollas.diospringapikotlin.dto.customer.CustomerView
import com.nicollas.diospringapikotlin.service.impl.CustomerServiceImpl
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customer")
class CustomerController(
    private val customerService: CustomerServiceImpl
) {

    @PostMapping
    fun saveCustomer(customerDTO: CustomerDTO): String {
        val savedCustomer = this.customerService.save(customerDTO.toEntity())
        return "Customer saved: ${savedCustomer.email}"
    }

    @GetMapping("/{customerId}")
    fun getByCustomerId(@PathVariable customerId: Long): CustomerView =
        CustomerView(customerService.findById(customerId))


    @DeleteMapping("/{customerId}")
    fun deleteByCustomerId(@PathVariable customerId: Long) = customerService.deleteById(customerId)
}