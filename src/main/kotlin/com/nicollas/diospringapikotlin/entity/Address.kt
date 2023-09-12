package com.nicollas.diospringapikotlin.entity

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import lombok.Data


@Embeddable
@Data
class Address(

    @Column(nullable = false)
    val zipCode: String = "",

    @Column(nullable = false)
    var street: String = ""
)