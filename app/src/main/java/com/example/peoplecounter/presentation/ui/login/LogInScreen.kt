package com.example.peoplecounter.presentation.ui.login

import android.app.Activity
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.Fragment
import com.example.peoplecounter.presentation.FirebaseInstance
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.GoogleAuthProvider

    @Preview(showBackground = true)
    @Composable
    fun LoginScreen() {
        Column {
            TextField(
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "") })
            TextField(value = "", onValueChange = {})
        }
    }

    @Composable
    fun GoogleSignInLauncher() {
        val googleLauncher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.StartActivityForResult(),
            onResult = { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
                    try {
                        val account = task.getResult(ApiException::class.java)
                        val firebaseCredential = GoogleAuthProvider.getCredential(account.idToken, null)
                        FirebaseInstance.firebaseInstance.signInWithCredential(firebaseCredential)
                    } catch (ex: Exception) {
                        Log.e("google sign in exception: ", ex.toString())
                    }
                }
            })
    }
