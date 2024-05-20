package com.example.kantiorganizer.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kantiorganizer.R
import com.example.kantiorganizer.ui.dashboard.DashboardFragment

class GradeAdapter(private val gradeList: List<Grade>) : RecyclerView.Adapter<GradeAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grade, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val grade = gradeList[position]
        holder.bind(grade)
    }

    override fun getItemCount(): Int {
        return gradeList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val examTextView: TextView = itemView.findViewById(R.id.textViewExam)
        private val subjectTextView: TextView = itemView.findViewById(R.id.textViewSubject)
        private val gradeTextView: TextView = itemView.findViewById(R.id.textViewGrade)

        fun bind(grade: Grade) {
            examTextView.text = grade.exam
            subjectTextView.text = grade.subject
            gradeTextView.text = grade.grade.toString()
        }
    }
}