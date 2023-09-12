package com.nicollas.diospringapikotlin.dto.credit

import com.nicollas.diospringapikotlin.entity.Credit
import com.nicollas.diospringapikotlin.enummeration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

data class CreditView(
    val id: Long?,
    val creditCode: UUID,
    val creditValue: BigDecimal,
    val dayFirstInstallment: LocalDate?,
    val status: Status,
    val numberOfInstallments: Int
) {
    constructor(credit: Credit) : this(
        id = credit.id,
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        dayFirstInstallment = credit.dayFirstInstallment,
        status = credit.status,
        numberOfInstallments = credit.numberOfInstallments
    )
}