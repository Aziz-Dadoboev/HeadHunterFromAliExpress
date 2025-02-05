package com.example.search.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.search.databinding.FragmentSearchBinding
import com.example.search.viewmodel.SearchViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var searchViewModel: SearchViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        searchViewModel = ViewModelProvider(this, viewModelFactory)[SearchViewModel::class.java]
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        println(searchViewModel.text)

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val dataSet = arrayOf("Вакансии рядом с вами", "Поднять резюме в поиске", "Временные работы и подработки")
        val offersAdapter = OffersAdapter(dataSet)
        val recyclerView = binding.offersRecycler
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = offersAdapter

        val vacSet = arrayOf("UI/UX Designer", "Дизайнер для маркетплейсов Wildberries, Ozon")
        val vacAdapter = VacanciesAdapter(vacSet)
        val vacRecycler = binding.vacanciesRecycler
        vacRecycler.layoutManager = LinearLayoutManager(context)
        vacRecycler.adapter = vacAdapter

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}