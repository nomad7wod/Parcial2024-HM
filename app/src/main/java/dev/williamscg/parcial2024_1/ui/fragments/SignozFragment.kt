package dev.williamscg.parcial2024_1.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import dev.williamscg.parcial2024_1.R
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class SignozFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_signoz, container, false)

        val etFecha = view.findViewById<EditText>(R.id.etFecha)
        val btnBack = view.findViewById<Button>(R.id.btnBack)
        val tvEdad = view.findViewById<TextView>(R.id.tvEdad)
        val tvSigno = view.findViewById<TextView>(R.id.tvSigno)
        val btnConsultar = view.findViewById<Button>(R.id.btnConsultar)

        btnConsultar.setOnClickListener {
            val fechaNacimiento = etFecha.text.toString()

            if (fechaNacimiento.isNotEmpty()) {
                try {
                    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                    sdf.isLenient = false  // Esto asegura que la fecha sea estrictamente válida
                    val fecha = sdf.parse(fechaNacimiento)

                    fecha?.let {
                        val edad = calcularEdad(fecha)
                        val signo = obtenerSignoZodiacal(fecha)

                        tvEdad.text = "$edad"
                        tvSigno.text = signo
                    }

                } catch (e: ParseException) {
                    // Mostrar un mensaje de error si la fecha no es válida
                    Toast.makeText(requireContext(), "Fecha no válida. Ingrese una fecha correcta.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(requireContext(), "Por favor, ingrese una fecha.", Toast.LENGTH_SHORT).show()
            }
        }

        btnBack.setOnClickListener {
            findNavController().navigate(R.id.nav_opciones)
        }

        return view
    }

    private fun calcularEdad(fechaNacimiento: Date): Int {
        val hoy = Calendar.getInstance()
        val fechaNac = Calendar.getInstance()
        fechaNac.time = fechaNacimiento

        var edad = hoy.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR)
        if (hoy.get(Calendar.DAY_OF_YEAR) < fechaNac.get(Calendar.DAY_OF_YEAR)) {
            edad--
        }
        return edad
    }

    private fun obtenerSignoZodiacal(fechaNacimiento: Date): String {
        val cal = Calendar.getInstance()
        cal.time = fechaNacimiento
        val dia = cal.get(Calendar.DAY_OF_MONTH)
        val mes = cal.get(Calendar.MONTH) + 1

        return when {
            (mes == 12 && dia >= 22) || (mes == 1 && dia <= 20) -> "Capricornio"
            (mes == 1 && dia >= 21) || (mes == 2 && dia <= 19) -> "Acuario"
            (mes == 2 && dia >= 20) || (mes == 3 && dia <= 20) -> "Piscis"
            (mes == 3 && dia >= 21) || (mes == 4 && dia <= 20) -> "Aries"
            (mes == 4 && dia >= 21) || (mes == 5 && dia <= 21) -> "Tauro"
            (mes == 5 && dia >= 22) || (mes == 6 && dia <= 21) -> "Géminis"
            (mes == 6 && dia >= 22) || (mes == 7 && dia <= 22) -> "Cáncer"
            (mes == 7 && dia >= 23) || (mes == 8 && dia <= 22) -> "Leo"
            (mes == 8 && dia >= 23) || (mes == 9 && dia <= 22) -> "Virgo"
            (mes == 9 && dia >= 23) || (mes == 10 && dia <= 22) -> "Libra"
            (mes == 10 && dia >= 23) || (mes == 11 && dia <= 22) -> "Escorpio"
            (mes == 11 && dia >= 23) || (mes == 12 && dia <= 21) -> "Sagitario"
            else -> "Desconocido"
        }
    }
}