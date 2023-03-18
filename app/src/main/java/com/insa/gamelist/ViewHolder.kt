package com.insa.gamelist

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

//ViewHolder class
class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
    val indexView: TextView = itemView.findViewById(R.id.index)
    val imageView: ImageView = itemView.findViewById(R.id.image);
    val titleView: TextView = itemView.findViewById(R.id.title)
    val cardView: CardView = itemView.findViewById(R.id.card)

    // Binds the game's data to the ViewHolder
    fun bind(game: Game, index: Int){
        Glide.with(itemView)    // Using Glide for performance
            .load(game.image)
            .override(900, 1100 ) // To improve performance and homogenize the pictures sizes
            .diskCacheStrategy(DiskCacheStrategy.ALL) // To cache resized images as well to improve speed
            .into(imageView)
        titleView.text=game.title
        indexView.text=(index+1).toString();
    }

    // Sets the fragment navigation on click to GameFragment.
    // Passes the right game's data to the fragment_game so it can display the correct data
    // without parsing the gamelist.json all over again
    fun setClickChangeFrag(game: Game){
        cardView.setOnClickListener {
            itemView.findNavController().navigate(ListFragmentDirections.actionListFragmentToGameFragment(game))
        }
    }
}