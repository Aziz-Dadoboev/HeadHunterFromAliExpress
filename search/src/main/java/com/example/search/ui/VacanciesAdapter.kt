package com.example.search.ui

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.search.R
import com.example.search.data.Vacancy
import com.google.android.material.button.MaterialButton
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class VacanciesAdapter(
    private val dataSet: List<Vacancy>
): RecyclerView.Adapter<VacanciesAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.vac_title)
        val town: TextView = view.findViewById(R.id.vac_town)
        val company: TextView = view.findViewById(R.id.vac_company)
        val looking: TextView = view.findViewById(R.id.looking_now)
        val experience: TextView = view.findViewById(R.id.vac_experience)
        val published: TextView = view.findViewById(R.id.vac_date)
        val favBtn: MaterialButton = view.findViewById(R.id.is_fav_btn)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.vacancies_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = dataSet[position].title
        holder.town.text = dataSet[position].address.town
        holder.company.text = dataSet[position].company
        holder.looking.text = holder.itemView
            .context
            .resources
            .getQuantityString(
                R.plurals.looking_now,
                dataSet[position].appliedNumber,
                dataSet[position].appliedNumber
            )
        holder.experience.text = dataSet[position].experience.previewText
        holder.published.text = formatPublishedDate(dataSet[position].publishedDate)
        setupButtonIcon(holder.favBtn, position)
    }

    private fun setupButtonIcon(button: MaterialButton, position: Int) {
        val favIcon = ContextCompat.getDrawable(button.context, R.drawable.ic_fav)
        val notFavIcon = ContextCompat.getDrawable(button.context, R.drawable.ic_not_fav)
        button.icon = if (dataSet[position].isFavorite) favIcon else notFavIcon

        button.setOnClickListener {
            if (button.icon == favIcon) button.icon = notFavIcon
            else button.icon = favIcon
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun formatPublishedDate(dateString: String): String {
        val inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.getDefault())
        val outputFormatter = DateTimeFormatter.ofPattern("d MMMM", Locale("ru"))

        val date = LocalDate.parse(dateString, inputFormatter)
        return "Опубликовано ${date.format(outputFormatter)}"
    }
}