package io.github.regbl.migrainetracker.view

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.github.regbl.migrainetracker.databinding.FragmentDailyRecordBinding
import io.github.regbl.migrainetracker.viewmodel.DailyRecordViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

class DailyRecordFragment : Fragment() {

    private var _binding: FragmentDailyRecordBinding? = null
    private val binding get() = _binding!!

    private val dailyRecordViewModel: DailyRecordViewModel by viewModel()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDailyRecordBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.dailyRecordViewModel = dailyRecordViewModel

        dailyRecordViewModel.navigateToMainFragment.observe(viewLifecycleOwner) {
            if (it == true) {
                this.findNavController()
                    .navigate(DailyRecordFragmentDirections.actionDailyRecordFragmentToMainFragment())
                dailyRecordViewModel.doneNavigating()
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getDateTimeString(date: OffsetDateTime): String {
        val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
        return date.format(formatter)
    }
}