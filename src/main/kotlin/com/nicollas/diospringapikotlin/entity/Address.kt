package com.nicollas.diospringapikotlin.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import lombok.Data


@Embeddable
@Data
class Address {

    @Column(nullable = false)
    private val zipCode: String = ""

    @Column(nullable = false)
    private var street: String = ""
}