package com.nicollas.diospringapikotlin.entity

import jakarta.persistence.*
import lombok.Data


@Entity
@Table(name = "Customer")
@Data
class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private val id: Long? = null

    @Column(nullable = false)
    private var firstName: String = ""

    @Column(nullable = false)
    private var lastName: String = ""

    @Column(nullable = false, unique = true)
    private val cpf: String = ""

    @Column(nullable = false, unique = true)
    private var email: String = ""

    @Column(nullable = false)
    private var password: String = ""

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE], mappedBy = "customer")
    var creditList: List<Credit> = arrayListOf()


}