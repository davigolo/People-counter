package com.example.peoplecounter.domain.model.dto

data class DocumentDTO(
    val name: String? = null,
    val fields: FieldsDTO? = null,
    val createTime: String? = null,
    val updateTime: String? = null
)