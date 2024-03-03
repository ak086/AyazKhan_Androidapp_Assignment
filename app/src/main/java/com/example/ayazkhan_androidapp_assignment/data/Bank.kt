package com.example.ayazkhan_androidapp_assignment.data

import androidx.compose.ui.graphics.Brush

data class Bank(
    val Bank: String,
    val ACNumber: String,
    val Type: String,
    val Balance: Long,
    val color: Brush
)