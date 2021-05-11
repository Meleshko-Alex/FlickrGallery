package com.meleshko.flickrgallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.meleshko.flickrgallery.api.GalleryItem

class PhotoGalleryViewModel : ViewModel() {

    val galleryItemLiveData:  LiveData<List<GalleryItem>>

    init {
        galleryItemLiveData = FlickrFetchr().searchPhotos("cats")
    }
}