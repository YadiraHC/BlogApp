package com.example.appblog.domain.auth

import android.graphics.Bitmap
import com.google.firebase.auth.FirebaseUser

interface AuthRepo {
    suspend fun signIn(email: String, password: String): FirebaseUser?
    suspend fun signUp(email: String, password: String, username: String): FirebaseUser?
    suspend fun updateProfile(imageBitmap: Bitmap, username: String): Boolean  // Devuelve un Boolean
}
