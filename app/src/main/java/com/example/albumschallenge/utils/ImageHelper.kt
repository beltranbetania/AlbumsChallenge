package com.example.albumschallenge.utils

fun normalizePhotoUrl(originalUrl: String, id: Int, width: Int = 600, height: Int = 400): String {
    if (!originalUrl.contains("via.placeholder.com", ignoreCase = true)) return originalUrl
    val colorSeed = originalUrl.substringAfterLast("/", id.toString())
    return "https://picsum.photos/seed/$colorSeed/$width/$height"
}