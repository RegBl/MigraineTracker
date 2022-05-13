package io.github.regbl.migrainetracker.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import io.github.regbl.migrainetracker.R
import io.github.regbl.migrainetracker.adapters.PastRecordsAdapter
import io.github.regbl.migrainetracker.databinding.FragmentPastRecordsBinding
import io.github.regbl.migrainetracker.viewmodel.PastRecordsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PastRecordsFragment : Fragment() {
    private var _binding: FragmentPastRecordsBinding? = null

    private val binding get() = _binding!!
    private val pastRecordsViewModel: PastRecordsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPastRecordsBinding.inflate(inflater, container, false)
        val view = binding.root

        val adapter = PastRecordsAdapter()
        binding.questionnaireList.adapter = adapter

        pastRecordsViewModel.questionnaires.observe(viewLifecycleOwner) { adapter.submitList(it) }

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}