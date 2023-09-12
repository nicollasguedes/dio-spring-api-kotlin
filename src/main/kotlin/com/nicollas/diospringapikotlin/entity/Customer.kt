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
    val id: Long? = null

    @Column(nullable = false)
    var firstName: String = ""

    @Column(nullable = false)
    var lastName: String = ""

    @Column(nullable = false, unique = true)
    val cpf: String = ""

    @Column(nullable = false, unique = true)
    var email: String = ""

    @Column(nullable = false)
    var password: String = ""

    @Column(nullable = false)
    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.REMOVE], mappedBy = "customer")
    var creditList: List<Credit> = arrayListOf()


}