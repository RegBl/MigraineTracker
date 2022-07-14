package io.github.regbl.migrainetracker.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.github.regbl.migrainetracker.data.model.Questionnaire
import io.github.regbl.migrainetracker.databinding.PastRecordListItemBinding
import io.github.regbl.migrainetracker.view.PastRecordsFragmentDirections
import io.github.regbl.migrainetracker.viewmodel.QuestionnaireViewModel

class PastRecordsAdapter :
    ListAdapter<Questionnaire, PastRecordsAdapter.PastRecordsViewHolder>(PastRecordsDiffCallback()) {

    class PastRecordsViewHolder(private val binding: PastRecordListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.setClickListener { view ->
                binding.viewModel?.id?.let { id ->
                    navigateToDailyRecord(id.toInt(), view)
                }
            }
        }

        private fun navigateToDailyRecord(id: Int, view: View) {
            val directions = PastRecordsFragmentDirections.actionPastRecordsFragmentToDailyRecordFragment(id)
            view.findNavController().navigate(directions)
        }

        fun bind(questionnaire: Questionnaire) {
            binding.apply {
                with(binding) {
                    viewModel = QuestionnaireViewModel(questionnaire)
                    executePendingBindings()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PastRecordsViewHolder {
        return PastRecordsViewHolder(
            PastRecordListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PastRecordsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PastRecordsDiffCallback : DiffUtil.ItemCallback<Questionnaire>() {
    override fun areItemsTheSame(oldItem: Questionnaire, newItem: Questionnaire) =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Questionnaire, newItem: Questionnaire) =
        oldItem.questionnaireId == newItem.questionnaireId

}
