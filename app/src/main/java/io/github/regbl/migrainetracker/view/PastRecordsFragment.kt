package io.github.regbl.migrainetracker.view

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import io.github.regbl.migrainetracker.R
import io.github.regbl.migrainetracker.adapters.PastRecordsAdapter
import io.github.regbl.migrainetracker.databinding.FragmentPastRecordsBinding
import io.github.regbl.migrainetracker.viewmodel.PastRecordsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PastRecordsFragment : Fragment(), SearchView.OnQueryTextListener {
    private var _binding: FragmentPastRecordsBinding? = null
    private val binding get() = _binding!!

    private val pastRecordsViewModel: PastRecordsViewModel by viewModel()
    private val adapter: PastRecordsAdapter by lazy { PastRecordsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPastRecordsBinding.inflate(inflater, container, false)
        val view = binding.root
        setHasOptionsMenu(true)

        binding.questionnaireList.adapter = adapter

        pastRecordsViewModel.questionnaires.observe(viewLifecycleOwner) { adapter.submitList(it) }

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.options_menu, menu)

        val search = menu.findItem(R.id.search)
        val searchView = search.actionView as SearchView
        searchView.isSubmitButtonEnabled = true
        searchView.setOnQueryTextListener(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onQueryTextSubmit(query: String?): Boolean = true

    override fun onQueryTextChange(query: String?): Boolean {
        if (query != null) {
            searchDatabase(query)
        }
        return true
    }

    private fun searchDatabase(query: String) {
        val searchQuery = "%$query%"

        pastRecordsViewModel.search(searchQuery).observe(this) { list ->
            list.let {
                adapter.submitList(it)
            }
        }
    }

}