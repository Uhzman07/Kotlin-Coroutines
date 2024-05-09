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
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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
    //private var customToastView: View? = null // This is the start of creating a custom toast view

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //val view = binding.root
        setContentView(binding.root)

        val TAG = "MainActivity"
        GlobalScope.launch {
            // Suspending coroutine // This is just like "thread.sleep()" for the normal thread
            delay(3000) // Now the normal thread is able to print out the statement before this coroutie thread duennto

            Log.d(TAG, "Coroutine says hello from thread ${Thread.currentThread().name}")
            // Note that this shows up quite different as it is a coroutine thread

        }
        Log.d(TAG, "Hello from thread ${Thread.currentThread().name}")

        // Note the the two print statements are running on different threads


    }
}
