package com.example.kantiorganizer.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kantiorganizer.R

class EventAdapter(private val eventList: List<Event>) : RecyclerView.Adapter<EventAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = eventList[position]
        holder.bind(event)
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.textViewName)
        private val dateTextView: TextView = itemView.findViewById(R.id.textViewDate)
        private val subjectTextView: TextView = itemView.findViewById(R.id.textViewSubject)

        fun bind(event: Event) {
            nameTextView.text = event.name
            dateTextView.text = event.date
            subjectTextView.text = event.subject
        }
    }
}
