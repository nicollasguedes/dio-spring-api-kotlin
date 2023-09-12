package com.nicollas.diospringapikotlin.service.impl

import com.nicollas.diospringapikotlin.entity.Customer
import com.nicollas.diospringapikotlin.repository.CustomerRepository
import com.nicollas.diospringapikotlin.service.CustomerService
import org.springframework.stereotype.Service

@Service
class CustomerServiceImpl(
    private val customerRepository: CustomerRepository
) : CustomerService {

    override fun save(customer: Customer): Customer =
        this.customerRepository.save(customer)


    override fun findById(id: Long): Customer =
        this.customerRepository.findById(id).orElseThrow {
            throw RuntimeException("Id $id not Found")
        }


    override fun deleteById(id: Long) = this.customerRepository.deleteById(id)
}