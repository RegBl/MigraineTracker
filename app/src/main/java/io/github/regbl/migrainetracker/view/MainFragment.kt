package io.github.regbl.migrainetracker.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import io.github.regbl.migrainetracker.databinding.FragmentMainBinding
import io.github.regbl.migrainetracker.viewmodel.DailyRecordViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment() {

    val dailyRecordViewModel: DailyRecordViewModel by viewModel()

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root

        dailyRecordViewModel.allQuestionnairesByDate.observe(viewLifecycleOwner, {
            it?.let {
                Log.d(TAG, it.toString())
            }
        })

        binding.buttonDailyRecord.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToDailyRecordFragment())
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