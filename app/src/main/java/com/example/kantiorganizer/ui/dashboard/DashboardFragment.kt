package com.example.kantiorganizer.ui.dashboard
import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kantiorganizer.R
import com.example.kantiorganizer.databinding.FragmentDashboardBinding
import com.example.kantiorganizer.ui.data.DataManager
import com.example.kantiorganizer.ui.dashboard.GradeAdapter

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private lateinit var dataManager: DataManager
    private val gradeList = mutableListOf<Grade>()
    private lateinit var gradeAdapter: GradeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        try {
            _binding = FragmentDashboardBinding.inflate(inflater, container, false)
            val root: View = binding.root

            dataManager = DataManager(requireContext())
            gradeList.addAll(dataManager.getGrades())

            gradeAdapter = GradeAdapter(gradeList)
            binding.recyclerView.adapter = gradeAdapter
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

            val fab = binding.floatingActionButton
            fab.setOnClickListener {
                showGradeDialog()
            }

            calculateAndDisplayAverageGrade()

            return root
        } catch (e: Exception) {
            Log.e("DashboardFragment", "Error in onCreateView", e)
            throw e
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showGradeDialog() {
        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.grade_dialog, null)
        val dialogBuilder = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .setTitle(getString(R.string.add_grade))
            .setPositiveButton(getString(R.string.add)) { _, _ ->
                val examEditText = dialogView.findViewById<EditText>(R.id.editTextExam)
                val subjectEditText = dialogView.findViewById<EditText>(R.id.editTextSubject)
                val gradeEditText = dialogView.findViewById<EditText>(R.id.editTextGrade)
                val exam = examEditText.text.toString()
                val subject = subjectEditText.text.toString()
                val grade = gradeEditText.text.toString().toDoubleOrNull()

                if (grade != null && grade in 1.0..6.0) {
                    val newGrade = Grade(exam, subject, grade)
                    gradeList.add(newGrade)
                    gradeAdapter.notifyDataSetChanged()

                    dataManager.saveGrades(gradeList)

                    calculateAndDisplayAverageGrade()
                } else {
                    showErrorDialog(getString(R.string.invalid_grade))
                }
            }
            .setNegativeButton(getString(R.string.cancel)) { dialog, _ ->
                dialog.dismiss()
            }
            .create()

        dialogBuilder.show()
    }

    private fun calculateAndDisplayAverageGrade() {
        val averageGrade = calculateAverageGrade()
        binding.averageGrade.text = getString(R.string.average_grade, averageGrade)
    }

    private fun calculateAverageGrade(): Double {
        if (gradeList.isEmpty()) {
            return 0.0
        }
        var totalGrade = 0.0
        for (grade in gradeList) {
            totalGrade += grade.grade
        }
        return totalGrade / gradeList.size
    }

    private fun showErrorDialog(message: String) {
        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.error))
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok)) { dialog, _ ->
                dialog.dismiss()
            }
            .create()
            .show()
    }
}

data class Grade(val exam: String, val subject: String, val grade: Double)
