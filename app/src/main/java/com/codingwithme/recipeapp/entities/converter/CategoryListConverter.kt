package com.codingwithme.recipeapp.entities.converter

import androidx.room.TypeConverter
import com.codingwithme.recipeapp.entities.CategoryItems
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CategoryListConverter {
    val type = object : TypeToken<CategoryItems>(){

}.type
    @TypeConverter
    fun fromCategoryList(category: List<CategoryItems>):String?{
        val gson = Gson()

        return gson.toJson(category,type)
    }

    @TypeConverter
    fun toCategoryList ( categoryString: String):List<CategoryItems>?{
        return run {
            val gson = Gson()

            gson.fromJson(categoryString,type)
        }
    }
}