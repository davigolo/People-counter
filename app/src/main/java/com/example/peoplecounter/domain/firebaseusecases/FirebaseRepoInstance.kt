package com.example.peoplecounter.domain.firebaseusecases

import com.example.peoplecounter.data.datasource.firebaserepo.FirebaseRepo
import com.example.peoplecounter.data.datasource.firebaserepo.FirebaseRepoImpl

object FirebaseRepoInstance {
    val firebaseRepo: FirebaseRepo by lazy { FirebaseRepoImpl() }
}