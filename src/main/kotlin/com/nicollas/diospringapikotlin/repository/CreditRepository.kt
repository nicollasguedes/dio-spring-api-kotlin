package com.nicollas.diospringapikotlin.repository

import com.nicollas.diospringapikotlin.entity.Credit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CreditRepository : JpaRepository<Credit, Long>