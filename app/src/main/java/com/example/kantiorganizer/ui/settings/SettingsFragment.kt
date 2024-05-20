package com.example.kantiorganizer.ui.settings

import android.app.AlertDialog
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.kantiorganizer.databinding.FragmentSettingsBinding
import com.example.kantiorganizer.R
import com.example.kantiorganizer.ui.data.DataManager
import com.example.kantiorganizer.ui.home.HomeFragment
import com.example.kantiorganizer.MainActivity

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        sharedPreferences = requireActivity().getSharedPreferences(
            "com.example.kantiorganizer.PREFERENCE_FILE_KEY",
            Context.MODE_PRIVATE
        )

        val isDarkMode = sharedPreferences.getBoolean("dark_mode", false)
        binding.switchDarkMode.isChecked = isDarkMode

        binding.switchDarkMode.setOnCheckedChangeListener { _, isChecked ->
            toggleTheme(isChecked)
        }

        binding.buttonDeleteData.setOnClickListener {
            showConfirmationDialog()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun saveDarkModePreference(isDarkMode: Boolean) {
        val sharedPreferences = requireActivity().getSharedPreferences(
            "com.example.kantiorganizer.PREFERENCE_FILE_KEY",
            Context.MODE_PRIVATE
        )
        sharedPreferences.edit().putBoolean("dark_mode", isDarkMode).apply()
    }

    private fun toggleTheme(isDarkMode: Boolean) {
        saveDarkModePreference(isDarkMode)

        val nightMode = if (isDarkMode) AppCompatDelegate.MODE_NIGHT_YES else AppCompatDelegate.MODE_NIGHT_NO
        AppCompatDelegate.setDefaultNightMode(nightMode)

        requireActivity().recreate()
    }

    private fun showConfirmationDialog() {
        val dialogView = LayoutInflater.from(requireContext()).inflate(R.layout.dialog_confirm, null)
        val dialogBuilder = AlertDialog.Builder(requireContext())
            .setView(dialogView)
            .setCancelable(false)
            .create()

        dialogView.findViewById<Button>(R.id.button_delete).setOnClickListener {
            deleteAllData()
            dialogBuilder.dismiss()
        }

        dialogView.findViewById<Button>(R.id.button_cancel).setOnClickListener {
            dialogBuilder.dismiss()
        }

        dialogBuilder.show()
    }

    private fun deleteAllData() {
        val dataManager = DataManager(requireContext())

        dataManager.clearGrades()

        dataManager.clearEvents()

    }

}
