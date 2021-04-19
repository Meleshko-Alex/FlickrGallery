package com.meleshko.flickrgallery

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PhotoGalleryFragment : Fragment() {

    private lateinit var photoRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_photo_gallery, container, false)
        photoRecyclerView = view.findViewById(R.id.photo_recycler_view)
        photoRecyclerView.layoutManager = GridLayoutManager(context, 3)
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val flickrLiveData: LiveData<String> = FlickrFetchr().fetchContent()
        flickrLiveData.observe(
            this,
            Observer { responseString ->
                Log.i("ZZZ", "Response received: $responseString")
            }
        )
    }

    companion object {
        fun newInstance() = PhotoGalleryFragment()
    }
}