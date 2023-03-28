package com.codingwithme.recipeapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

open class BaseActivity : AppCompatActivity(),CoroutineScope {
    private lateinit var job: Job
    override val coroutineContext:CoroutineContext
    get() = job +Dispatchers.Main


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        job = Job()

        // Получение представления панели уведомлений
        val decorView = window.decorView
        val uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN

// Скрытие панели уведомлений
        decorView.systemUiVisibility = uiOptions
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

}