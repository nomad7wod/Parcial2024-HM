package dev.williamscg.parcial2024_1.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.williamscg.parcial2024_1.R
import dev.williamscg.parcial2024_1.ui.adapter.GenerAdapter
import dev.williamscg.parcial2024_1.ui.model.GenerModel


class GenerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_gener, container, false)
        val navController = findNavController()

        // RecyclerView setup
        val rvGener = view.findViewById<RecyclerView>(R.id.rvGener)
        rvGener.layoutManager = LinearLayoutManager(requireContext())
        rvGener.adapter = GenerAdapter(getGeners())

        // Setup button listener
        val btnRegreso = view.findViewById<Button>(R.id.btnRegreso)
        btnRegreso.setOnClickListener {
            navController.navigate(R.id.nav_opciones)
        }
        return view
    }

    private fun getGeners(): List<GenerModel> {
        val lstGener: ArrayList<GenerModel> = ArrayList()
        lstGener.add(GenerModel(1, R.drawable.zeta, "Generación Z", "2001-2023"))
        lstGener.add(GenerModel(2, R.drawable.milen, "Millenials", "1981-2000"))
        lstGener.add(GenerModel(3, R.drawable.genx, "Generación X", "1965-1980"))
        lstGener.add(GenerModel(4, R.drawable.babyboomers, "Baby Boomers", "1946-1964"))
        return lstGener
    }
}