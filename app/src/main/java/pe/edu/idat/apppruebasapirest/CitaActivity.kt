package pe.edu.idat.apppruebasapirest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import pe.edu.idat.apppruebasapirest.databinding.ActivityCitaBinding
import pe.edu.idat.apppruebasapirest.databinding.ActivityMainBinding
import pe.edu.idat.apppruebasapirest.retrofit.ApiCita
import pe.edu.idat.apppruebasapirest.retrofit.CitaAdapter
import pe.edu.idat.apppruebasapirest.retrofit.response.CitaResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CitaActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityCitaBinding
    private lateinit var apiRetrofit: Retrofit
    private lateinit var citaAdapter: CitaAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCitaBinding.inflate(layoutInflater)
        citaAdapter = CitaAdapter()
        apiRetrofit = Retrofit.Builder()
            .baseUrl("https://nodejs-mysql-restapi-test-production-895d.up.railway.app/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        binding.btnGrabarCita.setOnClickListener(this)

        //binding.tvId.text="hola mundo"
        obtenerCita()
        setContentView(binding.root)


    }

    fun obtenerCita(){
        val service = apiRetrofit.create(ApiCita::class.java)
        val citaApiResult =service.listarCitas()

        citaApiResult.enqueue(object : Callback<CitaResult> {
            override fun onResponse(call: Call<CitaResult>, response: Response<CitaResult>) {
                citaAdapter.cargarCitas(response.body()!!.results)

                val cita = response.body()!!.results[0]
                //val salario = response.body()!!.results[2].salario.toString()

                binding.tvId.text=cita.id.toString()
                binding.etNombre.setText(cita.nombre.toString())
                binding.etSalario.setText(cita.salario.toString())
            }

            override fun onFailure(call: Call<CitaResult>, t: Throwable) {

            }

        })
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}