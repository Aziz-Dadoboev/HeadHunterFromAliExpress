package com.example.search.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.search.R
import com.example.search.data.Offer

class OffersAdapter(
    private val dataSet: List<Offer>
): RecyclerView.Adapter<OffersAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.offers_icon)
        val iconBg: ImageView = view.findViewById(R.id.offers_icon_bg)
        val title: TextView = view.findViewById(R.id.offers_text)
        val actionText: TextView = view.findViewById(R.id.offers_action)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_offers, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = dataSet[position].title
        val buttonInfo = dataSet[position].button
        holder.actionText.text = buttonInfo?.text ?: ""
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}