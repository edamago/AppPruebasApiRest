package pe.edu.idat.apppruebasapirest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager

import pe.edu.idat.apppruebasapirest.databinding.ActivityMainBinding
import pe.edu.idat.apppruebasapirest.retrofit.ApiCita
import pe.edu.idat.apppruebasapirest.retrofit.CitaAdapter
import pe.edu.idat.apppruebasapirest.retrofit.response.CitaResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var apiRetrofit: Retrofit
    private lateinit var citaAdapter: CitaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        citaAdapter = CitaAdapter()
        apiRetrofit = Retrofit.Builder()
                                .baseUrl("https://nodejs-mysql-restapi-test-production-895d.up.railway.app/api/")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build()
        binding.rvCitas.layoutManager = GridLayoutManager(applicationContext,3)
        binding.rvCitas.adapter = citaAdapter
        setContentView(binding.root)

        obtenerCitas()
    }

    fun obtenerCitas(){
        val service = apiRetrofit.create(ApiCita::class.java)
        val citaApiResult =service.listarCitas()

        citaApiResult.enqueue(object : Callback<CitaResult> {
            override fun onResponse(call: Call<CitaResult>, response: Response<CitaResult>) {
                citaAdapter.cargarCitas(response.body()!!.results)
            }

            override fun onFailure(call: Call<CitaResult>, t: Throwable) {

            }

        })
    }
}