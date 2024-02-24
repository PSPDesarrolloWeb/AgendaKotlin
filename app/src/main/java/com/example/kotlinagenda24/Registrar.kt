package com.example.kotlinagenda24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class Registrar : AppCompatActivity() {
    var txtCedula:EditText?= null
    var txtnombre:EditText?= null
    var txtapellido:EditText?= null
    var txtemail:EditText?= null
    var txtUsuario:EditText?= null
    var txtpassword:EditText?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar)
        txtCedula=findViewById(R.id.txtCedula)
        txtnombre=findViewById(R.id.txtNombre)
        txtapellido=findViewById(R.id.txtApellido)
        txtemail=findViewById(R.id.txtCorreo)
        txtUsuario=findViewById(R.id.txtUsuario)
        txtpassword=findViewById(R.id.txtPassword)

    }

    fun registrarUsuario(view: View) {
        val url = "http://192.168.1.249:8080/AgendaKotlin/api.php"
        val queue: RequestQueue = Volley.newRequestQueue(this)

        val parametros = JSONObject()
        parametros.put("accion", "registrarPersona")
        parametros.put("cedula", txtCedula?.text.toString())
        parametros.put("email", txtemail?.text.toString())
        parametros.put("nombre", txtnombre?.text.toString())
        parametros.put("apellido", txtapellido?.text.toString())
        parametros.put("usuario", txtUsuario?.text.toString())
        parametros.put("clave", txtpassword?.text.toString())

        val resultadoPost = JsonObjectRequest(Request.Method.POST, url, parametros,
            { response ->
                Toast.makeText(
                    this, "Usuario registrado con éxito", Toast.LENGTH_LONG
                ).show()
            },
            { error ->
                Toast.makeText(
                    this, "Error al registrar: ${error.message}", Toast.LENGTH_LONG
                ).show()
            }
        )

        queue.add(resultadoPost)
    }

}
