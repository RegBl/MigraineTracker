package io.github.regbl.migrainetracker.view

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import io.github.regbl.migrainetracker.databinding.FragmentDailyRecordBinding
import io.github.regbl.migrainetracker.viewmodel.DailyRecordViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DailyRecordFragment : Fragment() {

    private var _binding: FragmentDailyRecordBinding? = null
    private val binding get() = _binding!!

    private val dailyRecordViewModel: DailyRecordViewModel by viewModel()
    private val args: DailyRecordFragmentArgs by navArgs()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDailyRecordBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.dailyRecordViewModel = dailyRecordViewModel.apply {
            setupQuestionnaire(args.questionnaireId)
            navigateToMainFragment.observe(viewLifecycleOwner) {
                if (it == true) {
                    findNavController()
                        .navigate(DailyRecordFragmentDirections.actionDailyRecordFragmentToMainFragment())
                    dailyRecordViewModel.doneNavigating()
                }
            }
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}