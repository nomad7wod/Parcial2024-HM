package dev.williamscg.parcial2024_1.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import dev.williamscg.parcial2024_1.R


class ImcFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_imc, container, false)
        val btnCalcular = rootView.findViewById<Button>(R.id.btnCalcular)
        val etPeso = rootView.findViewById<EditText>(R.id.etPeso)
        val etEstatura = rootView.findViewById<EditText>(R.id.etEstatura)
        val tvResultado = rootView.findViewById<TextView>(R.id.tvResultado)
        val tvCategoria = rootView.findViewById<TextView>(R.id.tvCategoria)
        val btnMenuPrincipal = rootView.findViewById<Button>(R.id.btnMenuPrincipal)
        val navController = findNavController()

        btnCalcular.setOnClickListener {
            val pesoStr = etPeso.text.toString()
            val estaturaStr = etEstatura.text.toString()


            if (pesoStr.isNotEmpty() && estaturaStr.isNotEmpty()) {
                val peso = pesoStr.toDouble()
                val estatura = estaturaStr.toDouble()

                if (peso > 0 && estatura > 0) {
                    val imc = peso / (estatura * estatura)
                    tvResultado.text = String.format("%.2f", imc)
                    if (imc < 18.5) {
                        tvCategoria.text = "Bajo Peso"
                    }else if (imc < 24.9) {
                        tvCategoria.text = "Peso Saludable"
                    }else if (imc < 29.9) {
                        tvCategoria.text = "Sobrepeso"
                    }else{
                        tvCategoria.text = "Obesidad"
                    }
                }else{
                    tvResultado.text = "Peso o Estatura debe ser mayor a 0"
                }
            }else{
                tvResultado.text = "Por favor ingrese valores válidos para Peso y Estatura"
            }

        }
        btnMenuPrincipal.setOnClickListener {
            findNavController().navigate(R.id.nav_opciones)
        }
        return rootView

    }

}