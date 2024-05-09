package com.example.myapplication1

import android.Manifest
import android.Manifest.permission
import android.app.Activity
import android.app.AlertDialog
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ClipData
import android.content.ClipDescription
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.graphics.Color
import android.media.audiofx.BassBoost
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.DragEvent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
//import com.example.myapplication1.databinding.ResultProfileBinding

import android.widget.Button
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication1.databinding.ActivityMainBinding
import com.example.myapplication1.ui.theme.MyApplication1Theme
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
//import kotlinx.android.synthetic.main.activity_main.btnApply
//import kotlinx.android.synthetic.main.activity_main.btnApply
//import kotlinx.android.synthetic.main.activity_main.etBirthDate
//import kotlinx.android.synthetic.main.activity_main.etCountry
//import kotlinx.android.synthetic.main.activity_main.etFirstName
//import kotlinx.android.synthetic.main.activity_main.etLastName
import java.util.Collections
@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    /* private var customToastView: View? = null // This is the start of creating a custom toast view */

    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //val view = binding.root
        setContentView(binding.root)

        // RUN BLOCKING
        // Note that run blocking is very powerful in threading in such a way that under the normal coroutine function, we can still be able to
        // control the UI even if we had "delay" but the run block will delay it perfectly

        // This run block is useful if we do not need the coroutine behaviour but we need to delay
        // Whatever is on the runblock code is in sync with the main thread

        Log.d(TAG, "Before runBlocking")
        runBlocking { // Note that run blocking will only affect the main thread
            launch (Dispatchers.IO){  // Note that this coroutine here will run asynchronously to the one in the "Global Launch" main thread
                delay(3000L)
                Log.d(TAG, "Finished IO Coroutine 1")
            }
            launch (Dispatchers.IO){  // Note that these two launch function will print at the same time becasue they are not affected by run blocking
                delay(3000L)
                Log.d(TAG, "Finished IO Coroutine 1")
            }
            Log.d(TAG, "Start of runBlocking")
            delay(5000L)
            Log.d(TAG, "End of runBlocking")
        }
        Log.d(TAG, "After runBlocking")

        /*
        Order of output
        Before runBlocking
        Start of runBlocking
        Delay for  3 seconds then both IO coroutines are printed out. (That is, both IO coroutines delay is treated like one)
        End of runBlocking
        After runBlocking
         */

        // Note that runBlocking could also work like "Thread.sleep"
        /*
        Log.d(TAG, "Before runBlocking")
        Log.d(TAG, "Start of runBlocking")
        Thread.sleep(5000L)
        Log.d(TAG, "End of runBlocking")
        Log.d(TAG, "After runBlocking")
         */

        // The difference is that the runBlocking can accept the suspend function it while others cannot
        // We can also add a coroutine scope in the runBlocking block by using "launch{}" instead of using the global launch
    }

}
