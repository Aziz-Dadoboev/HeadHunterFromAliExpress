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
import com.example.search.databinding.FragmentSearchListBinding
import com.example.search.viewmodel.SearchViewModel
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.launch
import javax.inject.Inject

class SearchListFragment : Fragment() {
    private var _binding: FragmentSearchListBinding? = null
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
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchListBinding.inflate(inflater,  container, false)
        val root: View = binding.root

        searchViewModel.offers.observe(viewLifecycleOwner) { offers ->
            val offersAdapter = OffersAdapter(offers)
            binding.offersRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            binding.offersRecycler.adapter = offersAdapter
        }

        searchViewModel.vacancies.observe(viewLifecycleOwner) { vacancies ->
            val vacAdapter = VacanciesAdapter(vacancies.take(2))
            binding.vacanciesRecycler.layoutManager = LinearLayoutManager(context)
            binding.vacanciesRecycler.adapter = vacAdapter
            binding.moreBtn.text = resources.getQuantityString(
                R.plurals.more_vacancies,
                vacancies.size,
                vacancies.size
            )
        }

        lifecycleScope.launch {
            searchViewModel.loadOffers()
            searchViewModel.loadVacancies()
        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.moreBtn.setOnClickListener {
            parentFragment?.childFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.fragment_container, VacanciesListFragment())
                ?.addToBackStack(null)
                ?.commit()
        }
    }
}