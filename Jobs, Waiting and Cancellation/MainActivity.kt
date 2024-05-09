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
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlinx.coroutines.withTimeout
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

        // Jobs, Waiting and Cancellation
        // Note that we can save our coroutine in a job

        //  ********************************** JOBS JOIN ***********************************
        /*
        val job = GlobalScope.launch(Dispatchers.Default) {
            repeat(5){
                Log.d(TAG,"Coroutine is still working...")
                delay(1000)
            }


        }
        runBlocking {
            /*
            job.join() // Now we can use this suspend function since it is inside the runBlocking
            // What the join function does is that it blocks the thread until the function is finished
            // This then prints the log 5 times before printing any one that is in this block
             */

            Log.d(TAG, "Main Thread is continuing...")
        }
        //job.join() // Note that the ".join()" function is actually a suspend function so we cannot use it in The main thread
         */

        // JOB CANCEL
        /*
        val job = GlobalScope.launch(Dispatchers.Default) {
            //Log.d(TAG,"Starting long running calculation...")
            repeat(5){
                Log.d(TAG,"Coroutine is working...")
                delay(1000L)
            }

        }
        runBlocking {
            delay(3000L) // Since this runBlocking had been delayed for 3 seconds this will the allow the job that is the main thread to print out for about 3 seconds before it is ever cancelled
            job.cancel() // This cancels the jon after it had printed "Coroutine is working" 3 times due to the 1 second delay that it had in the main thread
            Log.d(TAG, "Main Thread is continuing")
        }
         */

        // Note that we have to be careful about cancelling because some functions are very fast to be cancelled and before we know it, they are done
        // Thats why we might want to us the "isActive" method
        val job = GlobalScope.launch(Dispatchers.Default) {
            Log.d(TAG, "Starting long running calculation...")
            for(i in 30..40){ //ince methods like this are very fast in executing, they seem to overtake the "cancel" method also
                if(isActive){ // Note that we usually use this in terms of cancellation
                    // Note that since the coroutine process is rellay fast we have to use this method "isActive" to stop is from overpowering the run blocking function
                    Log.d(TAG,"Result for i = $i : ${fib(i)}")
                }


            }
            Log.d(TAG, "Endng long running calculation...")
        }


        /*
         // ---------------------------------- withTimeout
        // We could also use the withTimeout method which is used to automatically control any kind of coroutine process.
        // The withTime out does not require any from of external runBlocking block because we can time the coroutine block right there directly
        val job = GlobalScope.launch(Dispatchers.Default) {
            Log.d(TAG, "Starting long running calculation...")
            withTimeout(3000L){ // This is used to automatically set at time for any function to be performed without the use of the runBlocking block
                // This "withTimeout" will then be used to allow the coroutine to perfrom all the possible functions that it can in just the set time
                for(i in 30..40){ //ince methods like this are very fast in executing, they seem to overtake the "cancel" method also
                    if(isActive){ // Note that we usually use this in terms of cancellation
                        // Note that since the coroutine process is rellay fast we have to use this method "isActive" to stop is from overpowering the run blocking function
                        Log.d(TAG,"Result for i = $i : ${fib(i)}")
                    }


                }

            }

            Log.d(TAG, "Endng long running calculation...")
        }

         */



        runBlocking {
            delay(2000L)
            job.cancel()
            Log.d(TAG,"Cancelled job")
        }




    }

    // This is a function for the fibonacci sequence
    fun fib(n : Int) : Long{
        return if(n==0) 0
        else if(n==1) 1
        else fib(n-1) + fib(n-2) // This is a recursive function as it call itself
    }


}
