package com.example.albumschallenge.utils

import org.junit.Assert.assertEquals
import org.junit.Test

class ImageHelperTest {

    @Test
    fun `returns original URL when not placeholder`() {
        val url = "https://example.com/photo.jpg"
        val result = normalizePhotoUrl(url, id = 1)

        assertEquals(url, result)
    }

    @Test
    fun `replaces placeholder URL with picsum URL`() {
        val url = "https://via.placeholder.com/600/92c952"
        val result = normalizePhotoUrl(url, id = 5)

        val expectedPrefix = "https://picsum.photos/seed/"
        val expectedSuffix = "/600/400"

        assert(result.startsWith(expectedPrefix))
        assert(result.endsWith(expectedSuffix))
    }

    @Test
    fun `applies custom width and height`() {
        val url = "https://via.placeholder.com/300/abc"
        val result = normalizePhotoUrl(url, id = 1, width = 800, height = 600)

        assert(result.endsWith("/800/600"))
    }
}