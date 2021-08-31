package io.github.regbl.migrainetracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import io.github.regbl.migrainetracker.databinding.FragmentDailyRecordBinding
import io.github.regbl.migrainetracker.viewmodels.DailyRecordViewModel
import io.github.regbl.migrainetracker.viewmodels.DailyRecordViewModelFactory
import org.koin.androidx.viewmodel.ext.android.viewModel

class DailyRecordFragment : Fragment() {

    private var _binding: FragmentDailyRecordBinding? = null
    private val binding get() = _binding!!

    private val dailyRecordViewModel: DailyRecordViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDailyRecordBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}