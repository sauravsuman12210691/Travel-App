package com.example.tripmate

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tripmate.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", 0)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val beforeLoginLayout = binding.beforeLogin
        val afterLoginLayout = binding.afterLogin

        if (UserManager.accessToken.isEmpty()) {
            // Show before-login UI
            beforeLoginLayout.visibility = View.VISIBLE
            afterLoginLayout.visibility = View.GONE

            binding.symbolImageView.setOnClickListener {
                startActivity(Intent(activity, SignUp::class.java))
            }

            binding.symbolImageView2.setOnClickListener {
                startActivity(Intent(activity, Login::class.java))
            }
        } else {
            // Show after-login UI
            beforeLoginLayout.visibility = View.GONE
            afterLoginLayout.visibility = View.VISIBLE

            val user = UserManager.userData.find { it.email == UserManager.accessToken }

            if (user != null) {
                // Clear old stored data (important when switching users)
                sharedPreferences.edit().clear().apply()

                // Save new user's data
                sharedPreferences.edit().apply {
                    putString("name", user.name)
                    putString("email", user.email)
                    putString("phone", user.phoneNumber?.toString() ?: "")
                    putString("house", user.house ?: "")
                    putString("street", user.street ?: "")
                    putString("city", user.city ?: "")
                    putString("state", user.state ?: "")
                    putString("country", user.country ?: "")
                    putString("pincode", user.pincode?.toString() ?: "")
                    apply()
                }

                // Load the new user's data
                binding.variableName.setText(user.name)
                binding.variableEmail.setText(user.email)
                binding.variablepNumber.setText(user.phoneNumber?.toString() ?: "")
                binding.variableHouse.setText(user.house ?: "")
                binding.variableStreet.setText(user.street ?: "")
                binding.variableCity.setText(user.city ?: "")
                binding.variableState.setText(user.state ?: "")
                binding.variableCountry.setText(user.country ?: "")
                binding.variablePincode.setText(user.pincode?.toString() ?: "")
            }

            // Update button click listener
            binding.update.setOnClickListener {
                user?.name = binding.variableName.text.toString()
                user?.phoneNumber = binding.variablepNumber.text.toString().toLongOrNull()
                user?.house = binding.variableHouse.text.toString()
                user?.street = binding.variableStreet.text.toString()
                user?.city = binding.variableCity.text.toString()
                user?.state = binding.variableState.text.toString()
                user?.country = binding.variableCountry.text.toString()
                user?.pincode = binding.variablePincode.text.toString().toLongOrNull()

                // Update SharedPreferences with new values
                sharedPreferences.edit().apply {
                    putString("name", user?.name)
                    putString("phone", user?.phoneNumber?.toString())
                    putString("house", user?.house)
                    putString("street", user?.street)
                    putString("city", user?.city)
                    putString("state", user?.state)
                    putString("country", user?.country)
                    putString("pincode", user?.pincode?.toString())
                    apply()
                }

                Toast.makeText(requireContext(), "Profile Updated", Toast.LENGTH_LONG).show()
            }

            binding.logout.setOnClickListener {
                UserManager.accessToken = ""
                startActivity(Intent(activity, MainActivity::class.java))
                requireActivity().finish()
            }
        }
    }
}