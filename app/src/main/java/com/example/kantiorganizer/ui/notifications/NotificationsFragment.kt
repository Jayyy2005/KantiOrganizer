package com.example.kantiorganizer.ui.notifications
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kantiorganizer.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {

    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.button7.setOnClickListener {
            openExternalBrowser("http://ticket.kanti-baden.ch/")
        }

        binding.button2.setOnClickListener {
            openExternalBrowser("https://www.schul-netz.com/baden/loginto.php")
        }

        binding.button6.setOnClickListener {
            openExternalBrowser("https://web.kanti-baden.ch/goto/print")
        }

        binding.button3.setOnClickListener {
            openExternalBrowser("https://www.kanti-baden.ch/intern/")
        }

        binding.button4.setOnClickListener {
            openExternalBrowser("https://www.kanti-baden.ch/")
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun openExternalBrowser(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
