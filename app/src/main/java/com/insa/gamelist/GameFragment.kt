package com.insa.gamelist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.insa.gamelist.extentions.load
import kotlinx.android.synthetic.main.fragment_game.*
import java.text.SimpleDateFormat
import java.util.*

class GameFragment : Fragment() {
    // Fragment navigation arguments
    private val args : GameFragmentArgs by navArgs()

    // Date formatter to show the date in a pretty way
    val df= SimpleDateFormat("dd/MM/yyyy")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment (fragment_game)
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    // Binds all the data from the game in args (the game passed as argument in
    // actionListFragmentToGameFragment() )
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Console.text=args.game.console.joinToString(", ")
        GameTitle.text=args.game.title
        GameImage.load(args.game.image)
        GameDate.text="Date de sortie: "+df.format(Date( args.game.timestamp * 1000)).toString()
        GameGenre.text="Genre: "+args.game.type
        GameEd.text="Editeur: "+args.game.editor
        GameDev.text="Developpeur: "+args.game.developer
        GameDet.text=args.game.description

        // Sets the top back button to go back to ListFragment when clicked
        BackButton.setOnClickListener {
            findNavController()
            .navigate(GameFragmentDirections.actionGameFragmentToListFragment())
        }
    }


}