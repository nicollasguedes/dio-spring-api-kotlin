package com.nicollas.diospringapikotlin.entity

import com.nicollas.diospringapikotlin.enummeration.Status
import jakarta.persistence.*
import lombok.Data
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*


@Entity
@Table(name = "Credit")
@Data

class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    val id: Long? = null

    @Column(nullable = false)
    val email: String = ""

    @Column(nullable = false, unique = true)
    val creditCode: UUID = UUID.randomUUID()

    @Column(nullable = false)
    val creditValue: BigDecimal = BigDecimal.ZERO

    @Column(nullable = false)
    val dayFirstInstallment: LocalDate? = null

    @Column(nullable = false)
    @Enumerated
    @Embedded
    val status: Status = Status.IN_PROGRESS

    @ManyToOne
    var customer: Customer? = null
}