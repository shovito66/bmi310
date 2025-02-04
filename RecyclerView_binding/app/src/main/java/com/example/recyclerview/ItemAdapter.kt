package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


data class Item(
    val itemNo: String,
    val itemName: String,
    val price: String,
    val id: String
)

class ItemAdapter(private val itemList: List<Item>, private val onItemClick: (String) -> Unit) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvItemNo: TextView = itemView.findViewById(R.id.tvItemNo)
        val tvItemName: TextView = itemView.findViewById(R.id.tvItemName)
        val tvPrice: TextView = itemView.findViewById(R.id.tvPrice)
        val tvId: TextView = itemView.findViewById(R.id.tvId)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        holder.tvItemNo.text = item.itemNo
        holder.tvItemName.text = item.itemName
        holder.tvPrice.text = item.price
        holder.tvId.text = item.id


        holder.itemView.setOnClickListener {
            onItemClick(item.id)
        }
    }

    override fun getItemCount(): Int = itemList.size
}
