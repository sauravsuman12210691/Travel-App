package com.example.tripmate

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import com.example.tripmate.databinding.ActivityMainBinding

data class User(var name: String,
                var email: String,
                var password: String,
                var phoneNumber: Number?,
                var house: String?,
                var street: String?,
                var city: String?,
                var state: String?,
                var country: String?,
                var pincode: Number?
)

object UserManager {
    val userData: MutableList<User> = mutableListOf()
    var accessToken: String = ""
    fun getUserByEmail(email: String): User? {
        return userData.find { it.email == email }
    }
}

//Data Added{
//    user1["email" => "aditya@gmail.com", "password" => "asdfgh"]
//}

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as? NavHostFragment
        val navController = navHostFragment?.navController
        navController?.let {
            val popupMenu = PopupMenu(this, binding.bottomBar)
            popupMenu.inflate(R.menu.bottom_menu)
            binding.bottomBar.setupWithNavController(popupMenu.menu, it)
        }
    }
}