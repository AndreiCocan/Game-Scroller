package com.insa.gamelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.insa.gamelist.utils.DataManager
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment() {
    var games:ArrayList<Game> =ArrayList()

    // Parses the data from gamelist.json on fragment creation
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        fetchGameData();
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment (fragment_list)
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    // Sets up the recyclerView when the fragment View is created
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView();
    }

    // Parses the data from gamelist.json
    private fun fetchGameData(){
        DataManager.readFile(requireContext())
        games.addAll(DataManager.games)
    }

    private fun setUpView() {

        //Creates an adapter to bind the data for each game in the list
        var adap=Adapter(games, requireContext())

        //Sets up the search bar
        searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adap.getFilter().filter(newText);
                return true
            }

        })

        //Set up recyclerView
        recyclerView.layoutManager=GridLayoutManager(requireContext(),2)
        recyclerView.adapter=adap
    }

}