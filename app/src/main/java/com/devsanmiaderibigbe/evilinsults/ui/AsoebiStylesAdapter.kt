package com.devsanmiaderibigbe.evilinsults.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.devsanmiaderibigbe.evilinsults.databinding.AsoebiListItemBinding
import com.devsanmiaderibigbe.evilinsults.remote.model.Asoebi

//
class AsoebiStylesAdapter(val context: Context) : RecyclerView.Adapter<AsoebiViewHolder>() {

    private val asoebiList = mutableListOf<Asoebi>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AsoebiViewHolder {
        val binding =
            AsoebiListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return AsoebiViewHolder(binding)
    }

    override fun getItemCount(): Int {  return asoebiList.size

    }

    override fun onBindViewHolder(holder: AsoebiViewHolder, position: Int) {
        val asoebi: Asoebi = asoebiList[position]
        holder.binding.asoebi = asoebi
    }

    fun setAsoebiList(data : List<Asoebi>){
        asoebiList.addAll(data)
        notifyDataSetChanged()
    }
}