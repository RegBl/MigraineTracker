package io.github.regbl.migrainetracker.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.github.regbl.migrainetracker.data.model.Questionnaire
import io.github.regbl.migrainetracker.databinding.PastRecordListItemBinding

class PastRecordsAdapter :
    ListAdapter<Questionnaire, PastRecordsAdapter.PastRecordsViewHolder>(PastRecordsDiffCallback()) {

    class PastRecordsViewHolder(private val binding: PastRecordListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(questionnaire: Questionnaire) {
            binding.apply {
                questionnaireId.text = questionnaire.questionnaireId.toString()
                questionnaireDate.text = questionnaire.dateTime
                intensity.text = questionnaire.questionTwo.toString()
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
        val questionnaire = getItem(position)
        holder.bind(questionnaire)
    }
}

class PastRecordsDiffCallback : DiffUtil.ItemCallback<Questionnaire>() {
    override fun areItemsTheSame(oldItem: Questionnaire, newItem: Questionnaire) =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: Questionnaire, newItem: Questionnaire) =
        oldItem.questionnaireId == newItem.questionnaireId

}
