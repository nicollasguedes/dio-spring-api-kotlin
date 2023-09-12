package com.nicollas.diospringapikotlin.repository

import com.nicollas.diospringapikotlin.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CreditRepository : JpaRepository<Credit, Long> {

    fun findAllByCustomerId(customerId: Long): MutableList<Credit>

    fun findByCustomerIdAndCreditCode(customerId: Long, creditCode: UUID): Credit?
}