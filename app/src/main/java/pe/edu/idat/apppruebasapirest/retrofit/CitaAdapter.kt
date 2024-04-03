package pe.edu.idat.apppruebasapirest.retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.edu.idat.apppruebasapirest.databinding.ItemCitaBinding
import pe.edu.idat.apppruebasapirest.retrofit.response.Cita
import pe.edu.idat.apppruebasapirest.retrofit.response.CitaResult

class CitaAdapter : RecyclerView.Adapter<CitaAdapter.ViewHolder>() {

    private var listaCita=ArrayList<Cita>()

    inner class ViewHolder(val binding:ItemCitaBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCitaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = listaCita.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(listaCita[position]){
                binding.tvCita.text=nombre
                //Glide.with(itemView.context).load("").into(binding.ivCita)
            }
        }
    }

    fun cargarCitas(lista: List<Cita>){
        listaCita.addAll(lista)
        notifyDataSetChanged()
    }


}