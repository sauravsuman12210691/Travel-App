package com.example.tripmate

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var ToolBar = view.findViewById<Toolbar>(R.id.toolBar)

        var search = view.findViewById<ImageButton>(R.id.search)
        var rl = view.findViewById<RelativeLayout>(R.id.clOneRlOne)
        val cross = view.findViewById<ImageButton>(R.id.cross)

        search.setOnClickListener {
            rl.visibility = View.VISIBLE
            search.visibility = View.GONE
            cross.visibility = View.VISIBLE
        }

        cross.setOnClickListener {
            rl.visibility = View.GONE
            search.visibility = View.VISIBLE
            cross.visibility = View.GONE
        }

        val data1 = view.findViewById<ConstraintLayout>(R.id.svTwoLLOneCLOne)
        val data2 = view.findViewById<ConstraintLayout>(R.id.svTwoLLOneCLTwo)
        val data3 = view.findViewById<ConstraintLayout>(R.id.svTwoLLOneCLThree)
        val data4 = view.findViewById<ConstraintLayout>(R.id.svTwoLLOneCLFour)
        val data5 = view.findViewById<ConstraintLayout>(R.id.svTwoLLOneCLFive)

        data1.setOnClickListener {
            val name = "Amritsar"
            val image = intArrayOf(R.drawable.amritsar_one, R.drawable.amritsar_two, R.drawable.amritsar_three)
            val details = "Amritsar is renowned for its cultural and religious significance, particularly as the center of Sikhism and the location of the Golden Temple. The city also boasts a vibrant culinary scene, with delicious and diverse food offerings, and a rich history, including the site of the Jallianwala Bagh massacre."

            startActivity(Intent(activity, PlaceDetails::class.java).apply {
                putExtra("name", name)
                putExtra("image", image) // Now sending as IntArray
                putExtra("details", details)
            })
        }

        data2.setOnClickListener {
            val name = "Patna"
            val image = intArrayOf(R.drawable.patna_one, R.drawable.patna_two, R.drawable.patna_three)
            val details = "Patna, the capital of Bihar, is famous for its rich history as the ancient city of Pataliputra, a seat of power for empires like the Mauryan and Gupta, and for being the birthplace of the 10th Sikh Guru, Guru Gobind Singh."

            startActivity(Intent(activity, PlaceDetails::class.java).apply {
                putExtra("name", name)
                putExtra("image", image) // Now sending as IntArray
                putExtra("details", details)
            })
        }

        data3.setOnClickListener {
            val name = "Agra"
            val image = intArrayOf(R.drawable.agra_one, R.drawable.agra_two, R.drawable.agra_three)
            val details = "Agra is best known for the Taj Mahal (17th century), designated a UNESCO World Heritage site in 1983. A complex mausoleum, the Taj Mahal is often considered to be the world's best example of Mughal architecture. The Mughal emperor Shah Jahān built it for his favourite wife, Mumtāz Maḥal, in the mid-17th century."

            startActivity(Intent(activity, PlaceDetails::class.java).apply {
                putExtra("name", name)
                putExtra("image", image) // Now sending as IntArray
                putExtra("details", details)
            })
        }

        data4.setOnClickListener {
            val name = "Delhi"
            val image = intArrayOf(R.drawable.delhi_one, R.drawable.delhi_two, R.drawable.delhi_three)
            val details = "Delhi is famous for being the capital of India, a vibrant mix of cultures, its rich history and numerous historical monuments, and its bustling markets and diverse culinary scene. "

            startActivity(Intent(activity, PlaceDetails::class.java).apply {
                putExtra("name", name)
                putExtra("image", image) // Now sending as IntArray
                putExtra("details", details)
            })
        }

        data5.setOnClickListener {
            val name = "Jaipur"
            val image = intArrayOf(R.drawable.jaipur_one, R.drawable.jaipur_two, R.drawable.jaipur_three)
            val details = "Jaipur became known as “The Pink City” when, in 1876, Maharaja Ram Singh had most of the buildings painted pink—the color of hospitality—in preparation for a visit by Britain's Queen Victoria. Today, the city is known for its bazaars, forts, temples, palaces, and wildlife sanctuaries."

            startActivity(Intent(activity, PlaceDetails::class.java).apply {
                putExtra("name", name)
                putExtra("image", image) // Now sending as IntArray
                putExtra("details", details)
            })
        }
    }
}