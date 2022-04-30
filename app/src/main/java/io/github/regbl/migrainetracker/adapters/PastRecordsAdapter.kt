package io.github.regbl.migrainetracker.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.github.regbl.migrainetracker.data.model.Questionnaire

class PastRecordsAdapter : ListAdapter<Questionnaire, PastRecordsAdapter.PastRecordsViewHolder>(PastRecordsDiffCallback()) {

    class PastRecordsViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PastRecordsViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PastRecordsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}

class PastRecordsDiffCallback : DiffUtil.ItemCallback<Questionnaire>() {
    override fun areItemsTheSame(oldItem: Questionnaire, newItem: Questionnaire): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItem: Questionnaire, newItem: Questionnaire): Boolean {
        TODO("Not yet implemented")
    }

}
