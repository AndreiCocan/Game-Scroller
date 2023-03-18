package com.insa.gamelist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import java.util.*
import kotlin.collections.ArrayList

//Adapter class for the RecyclerView
class Adapter(private val gameList: ArrayList<Game>,context: Context) : RecyclerView.Adapter<ViewHolder>(){

    // Inflates the card_cell layout for each game to make them appear in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        return ViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.card_cell,parent,false)
        )
    }

    // Returns the number of games displayed
    override fun getItemCount(): Int {
        return gameList.size
    }

    // Binds the data of each game to the corresponding ViewHolder
    // Sets OnClickChange to change to the GameFragment for each
    // ViewHolder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val game: Game = gameList[position]
        holder.bind(game,position);
        holder.setClickChangeFrag(gameList.get(position))
    }

    // Create a copy of gameList (the list displayed in the recyclerView)
    // that is not a clone (so that any changes in gameList aren't reflected in this).
    // This is useful for the search bar functionality so we have
    // a list that corresponds to the search result, and another for
    // the whole game list
    val initialGameList = ArrayList<Game>().apply {
        gameList?.let { addAll(it) }
    }

    // Returns the filter for the SearchBar
    fun getFilter(): Filter {
        return gameFilter
    }

    // A custom filter
    private val gameFilter = object : Filter() {

        // Performs the filtering of the initialGameList and returns it
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            var filteredList: List<Game> = ArrayList()

            if (constraint == null || constraint.isEmpty()) {
                filteredList=initialGameList
            } else {
                val query = constraint.toString().trim().lowercase(Locale.ROOT)
                filteredList=initialGameList.filter { item ->
                    item.title.lowercase(Locale.ROOT).contains(query)
                }
            }

            val results = FilterResults()
            results.values = filteredList
            return results
        }

        // Adds all the values from the filtering to the gameList (the one displayed in
        // the recyclerView) so it can be shown
        override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
            if (results?.values is ArrayList<*>) {
                gameList.clear()
                gameList.addAll(results.values as ArrayList<Game>)
                notifyDataSetChanged()
            }
        }
    }
}