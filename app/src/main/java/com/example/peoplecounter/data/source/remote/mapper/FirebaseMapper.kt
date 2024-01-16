package com.example.peoplecounter.data.datasource.mapper

import com.example.peoplecounter.domain.model.bo.BusinessBO
import com.example.peoplecounter.domain.model.bo.EmployerBO
import com.example.peoplecounter.domain.model.dto.BusinessDTO
import com.example.peoplecounter.domain.model.dto.EmployerDTO

fun EmployerDTO?.toBO(): List<EmployerBO> {
    return this?.documents?.mapNotNull { documentDTO ->
        EmployerBO(
            name = documentDTO?.fields?.name?.stringValue,
            surname = documentDTO?.fields?.surname?.stringValue,
            age = documentDTO?.fields?.age?.integerValue
        )
    } ?: listOf()
}

fun BusinessDTO?.toBO(): List<BusinessBO> {
    return this?.documents?.mapNotNull { documentDTO ->
        BusinessBO(
            name = documentDTO?.fields?.name?.stringValue
        )
    } ?: listOf()
}