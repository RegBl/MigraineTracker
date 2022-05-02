package io.github.regbl.migrainetracker.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.regbl.migrainetracker.R
import io.github.regbl.migrainetracker.viewmodel.PastRecordsViewModel

class PastRecordsFragment : Fragment() {

    companion object {
        fun newInstance() = PastRecordsFragment()
    }

    private lateinit var viewModel: PastRecordsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_past_records, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PastRecordsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}