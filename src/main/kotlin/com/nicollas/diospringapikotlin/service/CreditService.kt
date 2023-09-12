package com.nicollas.diospringapikotlin.service

import com.nicollas.diospringapikotlin.entity.Credit
import java.util.*

interface CreditService {
    fun findById(id: Long): Credit
    fun deleteById(id: Long)
    fun findAllByCustomerId(customerId: Long): MutableList<Credit>
    fun save(credit: Credit, customerId: Long): Credit
    fun findByCustomerIdAndCreditCode(customerId : Long, creditCode: UUID): Credit
}