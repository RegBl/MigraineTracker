package io.github.regbl.migrainetracker.view

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import io.github.regbl.migrainetracker.data.model.Questionnaire
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

//        binding.buttonSubmitDailyRecord.setOnClickListener {
//            val questionnaire = Questionnaire(
//                questionOne = binding.editTextQuestion1.toString(),
//                questionTwo = binding.sliderQuestion2.toString(),
//                questionThree = binding.toggleQuestion3.toString(),
//                questionFour = binding.editTextQuestion4.toString(),
//                questionFive = binding.toggleQuestion5.toString(),
//                questionSix = binding.toggleQuestion6.toString(),
//                questionSeven = binding.toggleQuestion7.toString(),
//                questionEight = binding.editTextQuestion8.toString(),
//                questionNine = binding.toggleQuestion9.toString(),
//                dateTime = getDateTimeString(OffsetDateTime.now()),
//                userId = 0
//            )
//
//            dailyRecordViewModel.insert(questionnaire)
//        }

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