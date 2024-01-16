package com.example.peoplecounter.presentation.ui.login

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

class LoginViewModel: ViewModel() {
    companion object {
        private const val DEFAULT_WEB_CLIENT = "71818744483-kdtm3kemlsupe9vs054kaeeem2hjkq86.apps.googleusercontent.com"
    }

    private val googleSignInClient: MutableLiveData<GoogleSignInClient> = MutableLiveData()

    fun getGoogleSignInClient() = googleSignInClient as LiveData<GoogleSignInClient>

    fun setGoogleSignInClient(context: Context) {
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .requestProfile()
            .requestIdToken(DEFAULT_WEB_CLIENT)
            .build()
        val signInClient = GoogleSignIn.getClient(context, gso)
        googleSignInClient.postValue(signInClient)
    }
}