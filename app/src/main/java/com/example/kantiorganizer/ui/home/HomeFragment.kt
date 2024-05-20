package com.example.kantiorganizer.ui.home

import androidx.appcompat.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kantiorganizer.R
import com.example.kantiorganizer.databinding.FragmentHomeBinding
import com.example.kantiorganizer.ui.data.DataManager
import java.util.Calendar
import android.app.DatePickerDialog
import android.widget.Button

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var dataManager: DataManager
    private val eventList = mutableListOf<Event>()
    private lateinit var eventAdapter: EventAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        try {
            _binding = FragmentHomeBinding.inflate(inflater, container, false)
            val root: View = binding.root

            dataManager = DataManager(requireContext())
            eventList.addAll(dataManager.getEvents())

            eventAdapter = EventAdapter(eventList)
            binding.recyclerView.adapter = eventAdapter
            binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

            val fab = binding.floatingActionButton3
            fab.setOnClickListener {
                showCalendarDialog()
            }

            return root
        } catch (e: Exception) {
            Log.e("HomeFragment", "Error in onCreateView", e)
            throw e
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showCalendarDialog() {
        val dialogView = layoutInflater.inflate(R.layout.calendar_dialog, null)

        val builder = AlertDialog.Builder(requireContext())
        builder.setView(dialogView)

        val dateButton = dialogView.findViewById<Button>(R.id.buttonDate)
        var selectedDate = ""

        dateButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
                selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                dateButton.text = selectedDate
            }, year, month, day)

            datePickerDialog.show()
        }

        builder.setPositiveButton("Hinzufügen") { dialog, _ ->
            val nameTextView = dialogView.findViewById<EditText>(R.id.editTextName)
            val subjectTextView = dialogView.findViewById<EditText>(R.id.editTextSubject)

            val eventName = nameTextView.text.toString()
            val eventSubject = subjectTextView.text.toString()

            val event = Event(eventName, selectedDate, eventSubject)
            eventList.add(event)
            eventAdapter.notifyDataSetChanged()
            dataManager.saveEvents(eventList)

            dialog.dismiss()
        }

        builder.setNegativeButton("Abbrechen") { dialog, _ ->
            dialog.dismiss() // Dismiss the dialog
        }

        val dialog = builder.create()
        dialog.show()
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

data class Event(val name: String, val date: String, val subject: String)
