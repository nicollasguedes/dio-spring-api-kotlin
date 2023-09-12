package com.nicollas.diospringapikotlin.controller

import com.nicollas.diospringapikotlin.dto.credit.CreditDTO
import com.nicollas.diospringapikotlin.dto.credit.CreditView
import com.nicollas.diospringapikotlin.entity.Credit
import com.nicollas.diospringapikotlin.service.impl.CreditServiceImpl
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/credit")
class CreditController(
    private val creditService: CreditServiceImpl
) {

    @PostMapping("/{customerId}")
    fun saveCredit(@PathVariable customerId: Long, creditDTO: CreditDTO): String {
        val savedCredit = this.creditService.save(creditDTO.toEntity(), customerId)
        return "Credit saved: ${savedCredit.creditCode}"
    }

    @GetMapping("/{creditId}")
    fun getByCreditId(@PathVariable creditId: Long): CreditView =
        CreditView(creditService.findById(creditId))

    @GetMapping("/find-all-by-customer/{customerId}")
    fun findAllByCustomerId(@PathVariable customerId: Long): List<CreditView> {
        return creditService.findAllByCustomerId(customerId)
            .stream().map { credit: Credit -> CreditView(credit) }
            .collect(Collectors.toList())
    }

    @GetMapping("/find-all-by-code")
    fun findByCustomerIdAndCreditCode(
        @RequestParam(value = "customerId") customerId: Long,
        @RequestParam(value = "creditCode") creditCode: UUID ): CreditView {
        return CreditView(creditService.findByCustomerIdAndCreditCode(customerId, creditCode))
    }


    @DeleteMapping("/{creditId}")
    fun deleteByCreditId(@PathVariable creditId: Long) = creditService.deleteById(creditId)
}