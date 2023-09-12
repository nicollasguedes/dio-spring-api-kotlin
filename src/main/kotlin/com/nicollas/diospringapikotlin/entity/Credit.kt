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
    private val id: Long? = null

    @Column(nullable = false)
    private val email: String = ""

    @Column(nullable = false, unique = true)
    private val creditCode: UUID = UUID.randomUUID()

    @Column(nullable = false)
    private val creditValue: BigDecimal = BigDecimal.ZERO

    @Column(nullable = false)
    private val dayFirstInstallment: LocalDate? = null

    @Column(nullable = false)
    @Enumerated
    @Embedded
    private val status: Status = Status.IN_PROGRESS

    @ManyToOne
    private val customer: Customer? = null
}