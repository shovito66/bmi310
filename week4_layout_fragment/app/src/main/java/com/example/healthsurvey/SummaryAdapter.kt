package com.example.healthsurvey
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class SummaryAdapter(private val context: Context, private val data: List<String>) : BaseAdapter() {

    override fun getCount(): Int = data.size

    override fun getItem(position: Int): Any = data[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.summary_item, parent, false)
        val summaryTextView: TextView = view.findViewById(R.id.summaryItemTextView)
        summaryTextView.text = data[position]
        return view
    }
}
