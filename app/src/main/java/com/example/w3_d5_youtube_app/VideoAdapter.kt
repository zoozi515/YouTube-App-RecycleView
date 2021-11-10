package com.example.w3_d5_youtube_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.w3_d5_youtube_app.databinding.VideoItemBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer

class VideoAdapter(  private val videoList: Array<Array<String>>,
                  private val player: YouTubePlayer): RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    class VideoViewHolder(val binding: VideoItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        return VideoViewHolder(VideoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val current_title = videoList[position][0] //column 0 contains the videos name
        val current_link = videoList[position][1]  //column 1 contains the videos link

        holder.binding.apply {
            btVideo.text = current_title

            btVideo.setOnClickListener{
                player.loadVideo(current_link, 0f)
            }
        }
    }

    override fun getItemCount() = videoList.size
}