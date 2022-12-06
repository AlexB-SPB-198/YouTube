package com.example.youtube.model

import android.text.style.LeadingMarginSpan

data class Thumbnails(
    val default: Default,
    val high: High,
    val maxres: Maxres,
    val medium: Medium,
    val standard: LeadingMarginSpan.Standard
)