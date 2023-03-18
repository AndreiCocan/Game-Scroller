package com.insa.gamelist
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

// Game data class. It is Parceled to allow to pass it as an argument when changing to GameFragment.
// Like that, it passes all the data the fragment needs without parsing the gamelist.json all over
// again
@Parcelize
data class Game(var id:Int,var title:String,var type:String,var console:List<String>,var editor:String,var developer:String,var timestamp: Long,var image:String,var description:String):Parcelable{}