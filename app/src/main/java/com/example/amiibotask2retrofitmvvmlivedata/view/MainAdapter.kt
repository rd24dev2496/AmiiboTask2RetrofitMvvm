package com.example.amiibotask2retrofitmvvmlivedata.view
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.amiibotask2retrofitmvvmlivedata.databinding.AdapterAmiiboBinding
import com.example.amiibotask2retrofitmvvmlivedata.model.Amiibo
import com.example.amiibotask2retrofitmvvmlivedata.model.JSONResponse

class MainAdapter: RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    var amiiboLists= mutableListOf<Amiibo>()

    fun setAmiiboList(amiiboLists: JSONResponse)
    {
        this.amiiboLists= amiiboLists.amiibo as MutableList<Amiibo>
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterAmiiboBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val amiibo=amiiboLists[position]
        holder.binding.amiiboSeries.text = amiibo.amiiboSeries
        holder.binding.character.text = amiibo.character
        holder.binding.gameSeries.text = amiibo.gameSeries
        holder.binding.head.text = amiibo.head
        holder.binding.name.text = amiibo.name
        Glide.with(holder.itemView.context).load(amiibo.image).into(holder.binding.imageview)
    }
    override fun getItemCount(): Int {
        return amiiboLists.size
    }
    class MainViewHolder(val binding: AdapterAmiiboBinding): RecyclerView.ViewHolder(binding.root){
    }
}
