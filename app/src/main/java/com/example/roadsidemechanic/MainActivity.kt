package com.example.roadsidemechanic

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import com.example.roadsidemechanic.databinding.ActivityMainBinding
import com.synnapps.carouselview.ImageListener


class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    lateinit var drawerToggle: ActionBarDrawerToggle
    private lateinit var toolbar : Toolbar
    val SampleImage = intArrayOf(
        R.drawable.image1,
        R.drawable.image6,
        R.drawable.image4,
        R.drawable.image5

    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


            toolbar = findViewById(R.id.mytoolbar)

            setSupportActionBar(toolbar)

        statuscolor()
        drawer()
       header()
        carousel()
        button_function()
    }

    override fun onBackPressed() {
        if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            this.binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (drawerToggle.onOptionsItemSelected(item)){
            true
        }
        return super.onOptionsItemSelected(item)
    }

    fun drawer() {

        drawerToggle =
            ActionBarDrawerToggle(this, binding.drawerLayout, R.string.Open, R.string.Close)
        binding.drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.toggle)
        // val headerview : View =   binding.navView.inflateHeaderView(R.layout.drawer_header)
        draweritem()

    }

    fun draweritem() {
        binding.navView.setNavigationItemSelectedListener { menuitem->
            when (menuitem.itemId) {
                R.id.home -> {
                    val intent = Intent(this@MainActivity,MainActivity::class.java)
                    startActivity(intent)
                    true

                }
                R.id.contact-> {
                    Toast.makeText(this@MainActivity, "Contact Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.appointment -> {
                    Toast.makeText(this@MainActivity, "Appointment Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.add_garage -> {
                    Toast.makeText(this@MainActivity, "Add Garage Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.sell_product -> {
                    Toast.makeText(this@MainActivity, "Sell your Product Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.store -> {
                    Toast.makeText(this@MainActivity, "Store Clicked", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.logout -> {
                    Toast.makeText(this@MainActivity, "Logout Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                else ->{

                    if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        this.binding.drawerLayout.closeDrawer(GravityCompat.START)
                    }
                    false
                }

            }



        }
    }

   fun header(){
       val hview : View = binding.navView.getHeaderView(0)
       val cross : ConstraintLayout = hview.findViewById(R.id.cross)
       cross.setOnClickListener {
           if (this.binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
               this.binding.drawerLayout.closeDrawer(GravityCompat.START)
           }
       }
   }

    fun statuscolor(){

        if (Build.VERSION.SDK_INT >= 21) {
            val window = this.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.setBackgroundDrawableResource(R.drawable.background_app_bar)
        }

    }
    fun carousel(){

       binding.carouselview.pageCount = SampleImage.size
        binding.carouselview.setImageListener(imageListener)

            }


    val imageListener : ImageListener = object : ImageListener{
        override fun setImageForPosition(position: Int, imageView: ImageView?) {
            imageView?.setImageResource(SampleImage[position])
        }
    }

    fun button_function(){
        binding.btnSellproduct.setOnClickListener {
            val intent = Intent(this@MainActivity,web_view::class.java)
            var link : String? = "https://keepmyrecipe.netlify.app/"
            intent.putExtra("Link",link)
            startActivity(intent)
        }
        binding.btnAddgarage.setOnClickListener {
            val intent = Intent(this@MainActivity,web_view::class.java)
            var link : String? = "https://curious-seahorse-e0cd07.netlify.app/"
            intent.putExtra("Link",link)
            startActivity(intent)
        }
    }

        }
