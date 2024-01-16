package com.example.peoplecounter.presentation

import com.google.firebase.auth.FirebaseAuth

object FirebaseInstance {
    val firebaseInstance: FirebaseAuth by lazy { FirebaseAuth.getInstance() }
}