package com.insa.gamelist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    //Main activity start
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //using the layout where the FragmentContainer is
        setContentView(R.layout.main_activity)

        // Questions from the practical work
        /*
        Log.d("MainActivity",""+games.size)
        Log.d("MainActivity",""+games[0])
        Log.d("MainActivity",""+games[games.size-1])

        Log.d("MainActivity",""+DataManager.getGame(12))

        // TODO : display the game list in alphabetic order
        var OrGames= games.sortedBy { it.title }
        Log.d("MainActivity",""+OrGames.toString())

        // TODO : find and display all "Action-Aventure" game
        var AAgames=OrGames.filter { game -> game.type== "Action-Aventure"}
        Log.d("MainActivity",""+AAgames.toString())

        // TODO : find and display the games launched the 14/05/2021 and the 26/10/2021
        val df=SimpleDateFormat("dd/MM/yyyy")
        var Dgames=OrGames.filter { game -> df.format(Date( game.timestamp * 1000)) == "14/05/2021" || df.format(Date( game.timestamp * 1000)) == "26/10/2021"  }
        Log.d("MainActivity",""+Dgames.size+" : "+Dgames.toString())
        // TODO : display the oldest game launched in the list
        val OlderGame:Game? = OrGames.maxByOrNull { it.timestamp}
        Log.d("MainActivity",""+OlderGame)
        // TODO : display the list of editor
        val editors:List<String> = OrGames.map { it.editor}
        // TODO : display the last game launched in 2020
        var df1=SimpleDateFormat("yyyy")
        val Last2020Game:Game? = OrGames
            .filter { game -> df1.format(Date( game.timestamp * 1000)) == "2022"}
            .maxByOrNull { it.timestamp }
        // TODO : display the average year launch for the game list

        // TODO : display the number of game launch on all platforms
        */
    }

    // Allows to go back to the fragment_list when the default android back button is pressed when
    // on the fragment_game. Otherwise it closes the application.
    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount
        if (count == 0) {
            super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

}