package com.nicollas.diospringapikotlin.service

import com.nicollas.diospringapikotlin.entity.Customer

interface CustomerService {
    fun save(customer: Customer): Customer
    fun findById(id: Long): Customer
    fun deleteById(id: Long)
}