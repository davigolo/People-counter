package com.example.peoplecounter.data.datasource.webservice

import com.example.peoplecounter.domain.model.bo.BusinessBO
import com.example.peoplecounter.domain.model.bo.EmployerBO
import com.example.peoplecounter.domain.model.dto.BusinessDTO
import com.example.peoplecounter.domain.model.dto.EmployerDTO
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FirebaseWebService {

    @POST("boss/{bossId}/business/{businessId}/employers")
    fun addEmployer(@Path("bossId") bossId: String, @Path("businessId")businessId: String, @Body employerBO: EmployerBO): Call<Boolean>

    @POST("boss/{id}/business")
    fun addBusiness(@Path("id") bossId: String, @Body business: BusinessBO): Call<Boolean>

    @GET("boss/{bossId}/business/{businessId}/employers")
    fun getEmployers(@Path("bossId") bossId: String, @Path("businessId")businessId: String): Call<EmployerDTO>

    @GET("boss/{id}/business")
    fun getBusiness(@Path("id") bossId: String): Call<BusinessDTO>

}