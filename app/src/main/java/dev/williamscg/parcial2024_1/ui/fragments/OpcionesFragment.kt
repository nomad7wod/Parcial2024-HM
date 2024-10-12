package dev.williamscg.parcial2024_1.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import dev.williamscg.parcial2024_1.LoginActivity
import dev.williamscg.parcial2024_1.R

class OpcionesFragment : Fragment() {

    // Inflar el layout del fragmento
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout XML del fragmento
        return inflater.inflate(R.layout.fragment_opciones, container, false)
    }

    // Configurar los botones en onViewCreated
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar el NavController
        val navController = findNavController()

        // Configurar los botones para navegar a los fragmentos
        view.findViewById<Button>(R.id.btnImc)?.setOnClickListener {
            navController.navigate(R.id.nav_imc) // Asegúrate de que el ID del gráfico de navegación sea correcto
        }

        view.findViewById<Button>(R.id.btnSignoz)?.setOnClickListener {
            navController.navigate(R.id.nav_signoz)
        }

        view.findViewById<Button>(R.id.btnGener)?.setOnClickListener {
            navController.navigate(R.id.nav_gener)
        }

        // Botón Regresar, para volver al LoginActivity
        view.findViewById<Button>(R.id.btnRegresar)?.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish() // Cierra la actividad actual si deseas que no se pueda regresar con el botón de atrás
        }
    }
}