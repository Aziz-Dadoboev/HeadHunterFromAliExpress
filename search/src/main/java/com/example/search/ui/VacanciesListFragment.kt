package com.example.search.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.search.R
import com.example.search.databinding.FragmentVacanciesBinding
import com.example.search.viewmodel.SearchViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.launch
import javax.inject.Inject

class VacanciesListFragment : Fragment() {
    private var _binding: FragmentVacanciesBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var searchViewModel: SearchViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
        searchViewModel = ViewModelProvider(this, viewModelFactory)[SearchViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVacanciesBinding.inflate(inflater,  container, false)
        val root: View = binding.root

        searchViewModel.vacancies.observe(viewLifecycleOwner) { vacancies ->
            val vacAdapter = VacanciesAdapter(vacancies)
            binding.vacanciesRecycler.layoutManager = LinearLayoutManager(context)
            binding.vacanciesRecycler.adapter = vacAdapter
            binding.vacCount.text = resources.getQuantityString(
                R.plurals.vacancies_count, vacancies.size, vacancies.size
            )
        }

        lifecycleScope.launch {
            searchViewModel.loadVacancies()
        }

        return root
    }
}