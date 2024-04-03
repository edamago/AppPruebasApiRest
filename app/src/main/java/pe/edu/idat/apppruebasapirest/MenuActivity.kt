package pe.edu.idat.apppruebasapirest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.apppruebasapirest.databinding.ActivityMenuBinding
import pe.edu.idat.apppruebasapirest.retrofit.CitaAdapter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MenuActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnListadoCitas.setOnClickListener(this)
        binding.btnVerCita.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btnListadoCitas -> irListadoCitas()
            R.id.btnVerCita -> verCita()
        }
    }

    private fun verCita() {
        var intentCita = Intent(applicationContext,CitaActivity::class.java)
        startActivity(intentCita)
    }

    private fun irListadoCitas() {
        var intentListadoCitas = Intent(applicationContext,MainActivity::class.java)
        startActivity(intentListadoCitas)
    }
}