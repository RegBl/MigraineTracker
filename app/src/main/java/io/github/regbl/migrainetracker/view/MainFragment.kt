package io.github.regbl.migrainetracker.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.github.regbl.migrainetracker.databinding.FragmentMainBinding
import io.github.regbl.migrainetracker.viewmodel.MainFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    val mainFragmentViewModel: MainFragmentViewModel by viewModel()

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.mainFragmentViewModel = mainFragmentViewModel

        mainFragmentViewModel.navigateToDailyRecordEntry.observe(viewLifecycleOwner) {
            if (it == true) {
                this.findNavController()
                    .navigate(MainFragmentDirections.actionMainFragmentToDailyRecordFragment())
                mainFragmentViewModel.doneNavigating()
            }
        }

        mainFragmentViewModel.navigateToPastRecords.observe(viewLifecycleOwner) {
            if (it == true) {
                this.findNavController()
                    .navigate(MainFragmentDirections.actionMainFragmentToPastRecordsFragment())
                mainFragmentViewModel.doneNavigating()
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()

        const val TAG = "MainFragment"
    }
}