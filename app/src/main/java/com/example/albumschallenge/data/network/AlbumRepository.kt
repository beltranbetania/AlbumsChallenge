package com.example.albumschallenge.data.network

import com.example.albumschallenge.data.model.Album
import com.example.albumschallenge.data.model.Photo

class AlbumRepository(private val api: ApiService) {

    suspend fun getAlbums(start: Int, limit: Int): List<Album> {
        return api.getAlbumsPaginated(start, limit)
    }

    suspend fun getPhotosByAlbumPaginated(
        albumId: Int,
        start: Int,
        limit: Int
    ): List<Photo> = api.getPhotosByAlbumPaginated(albumId, start, limit)
}