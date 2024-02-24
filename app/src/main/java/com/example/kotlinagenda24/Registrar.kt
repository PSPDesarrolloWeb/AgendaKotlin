package com.example.kotlinagenda24

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

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

    fun registrarUsuario(view: View){
        val url = "http://192.168.1.251/Agenda24/api.php"
        val queue: RequestQueue = Volley.newRequestQueue(this)
        val resultadoPost = object : StringRequest(
            Request.Method.POST, url,
            Response.Listener<String> { response ->
                Toast.makeText(
                    this, "Usuario registrado con éxito", Toast.LENGTH_LONG
                ).show()
            },
            Response.ErrorListener { response ->
                Toast.makeText(
                    this, "Error al registrar", Toast.LENGTH_LONG
                ).show()

            }
        ) {
            override fun getParams(): MutableMap<String, String> {
                val parametros = HashMap<String, String>()
                parametros["accion"] = "registrarPersona"
                parametros["cedula"] = txtCedula?.text.toString()
                parametros["email"] = txtemail?.text.toString()
                parametros["nombre"] = txtnombre?.text.toString()
                parametros["apellido"] = txtapellido?.text.toString()
                parametros["usuario"] = txtUsuario?.text.toString()
                parametros["clave"] = txtpassword?.text.toString()
                return parametros
            }
        }
        queue.add(resultadoPost)
    }

}
