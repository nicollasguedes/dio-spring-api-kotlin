package com.nicollas.diospringapikotlin.dto.customer

import com.nicollas.diospringapikotlin.entity.Customer
import java.math.BigDecimal

data class CustomerView(
    val id: Long?,
    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income: BigDecimal,
    val email: String,
    val zipCode: String,
    val street: String,
) {

    constructor(customer: Customer): this (
        id = customer.id,
        firstName = customer.firstName,
        lastName = customer.lastName,
        cpf = customer.cpf,
        income = customer.income,
        email = customer.email,
        street = customer.address.street,
        zipCode = customer.address.zipCode
        )
}