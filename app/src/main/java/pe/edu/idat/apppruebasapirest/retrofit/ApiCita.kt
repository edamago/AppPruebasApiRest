package pe.edu.idat.apppruebasapirest.retrofit

import pe.edu.idat.apppruebasapirest.retrofit.response.CitaResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiCita {
    @GET("employees")
    fun listarCitas():Call<CitaResult>
    /*fun listarCitas(@Query("limit") limit:Int,
                    @Query("offset") offset:Int):Call<CitaResult>*/

    @GET("employees/{id}")
    fun verCita(@Path("id") id:Int):Call<CitaResult>

}