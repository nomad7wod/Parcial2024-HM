package dev.hernanHM.parcial2024_1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import dev.williamscg.parcial2024_1.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        title = "Sign In"

        val emailSuccess: String = "admin@smartapp.com"
        val passwordSuccess: String = "admin123"

        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val etClave = findViewById<EditText>(R.id.etClave)
        val btnIngresar = findViewById<Button>(R.id.btnIngresar)

        btnIngresar.setOnClickListener {
            val correo: String = etCorreo.text.trim().toString()
            val clave: String = etClave.text.trim().toString()

            if (correo == emailSuccess && clave == passwordSuccess) {
                // Credenciales correctas, inicia la MainActivity
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish() // Opcional: Cierra LoginActivity si no quieres volver a ella
            } else {
                // Credenciales incorrectas, muestra el Snackbar
                val rootView: View = findViewById(android.R.id.content)
                Snackbar.make(rootView, "Credenciales inválidas", Snackbar.LENGTH_LONG).show()
            }
        }
    }
}