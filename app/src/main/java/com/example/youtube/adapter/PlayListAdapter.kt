package com.example.youtube.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.youtube.databinding.ItemPlaylistBinding
import com.example.youtube.model.Item
import com.example.youtube.model.PlayList
import java.net.URL

class PlaylistsAdapter

 : RecyclerView.Adapter<PlaylistsAdapter.PlaylistsViewHolder>() {

    private var playLists = ArrayList<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaylistsViewHolder {
        return PlaylistsViewHolder(
            ItemPlaylistBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PlaylistsViewHolder, position: Int) {
        playLists[position].let { holder.bind(it) }
    }

    override fun getItemCount(): Int {
        return playLists.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(playLists: ArrayList<Item>) {
       this.playLists = playLists
       notifyDataSetChanged()
   }

    inner class PlaylistsViewHolder(private val binding: ItemPlaylistBinding ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Item) {
            binding.image.load(item.snippet.thumbnails.default.url)
            binding.tvTitle.text = item.snippet.title
            itemView.setOnClickListener {

            }

        }
    }
}
