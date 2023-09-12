package com.nicollas.diospringapikotlin.service.impl

import com.nicollas.diospringapikotlin.entity.Credit
import com.nicollas.diospringapikotlin.repository.CreditRepository
import com.nicollas.diospringapikotlin.service.CreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditServiceImpl(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerServiceImpl
) : CreditService {

    override fun save(credit: Credit, customerId: Long): Credit {
        credit.apply {
            customer = customerService.findById(customerId)
        }
        return this.creditRepository.save(credit)
    }

    override fun findById(id: Long): Credit = this.creditRepository.findById(id).orElseThrow {
        throw RuntimeException("Id $id not Found")
    }

    override fun findAllByCustomerId(customerId: Long): MutableList<Credit> =
        this.creditRepository.findAllByCustomerId(customerId)

    override fun findByCustomerIdAndCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = this.creditRepository.findByCustomerIdAndCreditCode(customerId, creditCode)
            ?: throw java.lang.RuntimeException("Credit Code: $creditCode. Not Found")

        return if (credit.customer?.id == customerId) credit else throw RuntimeException("Contact Admin")
    }

    override fun deleteById(id: Long) = this.creditRepository.deleteById(id)
}