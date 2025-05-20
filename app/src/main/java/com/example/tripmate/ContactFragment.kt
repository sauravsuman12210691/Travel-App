package com.example.tripmate

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val phoneDetail = view.findViewById<TextView>(R.id.phoneDetail)
        val emailDetail = view.findViewById<TextView>(R.id.emailDetail)
        val facebookLogo = view.findViewById<ImageView>(R.id.facebookLogo)
        val instaLogo = view.findViewById<ImageView>(R.id.instaLogo)
        val youtubeLogo = view.findViewById<ImageView>(R.id.youtubeLogo)
        val shareLogo = view.findViewById<ImageView>(R.id.shareLogo)

        phoneDetail.setOnClickListener{
            val phoneNumber = phoneDetail.text.toString()
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel: $phoneNumber")
            startActivity(intent)
        }

        emailDetail.setOnClickListener{
            val email = emailDetail.text.toString()
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto: $email")
            startActivity(intent)
        }
    }
}