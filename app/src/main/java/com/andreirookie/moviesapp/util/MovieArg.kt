package com.andreirookie.moviesapp.util


import android.os.Bundle
import com.andreirookie.moviesapp.data.Movie
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

object MovieArg  : ReadWriteProperty<Bundle, Movie> {

    override fun getValue(thisRef: Bundle, property: KProperty<*>): Movie {
//        return thisRef.customGetSerializable<Movie>(property.name) as Movie
        return thisRef.getSerializable(property.name) as Movie

    }

    override fun setValue(thisRef: Bundle, property: KProperty<*>, value: Movie) {
       thisRef.putSerializable(property.name, value)
    }

//    @Suppress("DEPRECATION")
//    inline fun <reified T : Serializable> Bundle.customGetSerializable(key: String): T? {
//        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            getSerializable(key, T::class.java)
//        } else {
//            getSerializable(key) as? T
//        }
//    }
}