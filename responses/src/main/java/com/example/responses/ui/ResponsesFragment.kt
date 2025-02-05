package com.example.responses.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.responses.databinding.FragmentResponsesBinding

class ResponsesFragment : Fragment() {
    private var _binding: FragmentResponsesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val responsesViewModel =
            ViewModelProvider(this).get(ResponsesViewModel::class.java)

        _binding = FragmentResponsesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textResponses
        responsesViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}