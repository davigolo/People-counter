package com.example.peoplecounter.presentation

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.peoplecounter.presentation.ui.theme.PeopleCounterTheme

class MainActivity : ComponentActivity() {
    companion object {
        lateinit var context: Context
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this.applicationContext
        setContent {
            PeopleCounterTheme {
            }
        }
    }
}
