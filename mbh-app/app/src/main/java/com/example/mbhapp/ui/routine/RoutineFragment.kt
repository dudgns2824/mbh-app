package com.example.mbhapp.ui.routine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mbhapp.databinding.FragmentRoutineBinding

class RoutineFragment : Fragment() {

    private var _binding: FragmentRoutineBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val routineViewModel =
            ViewModelProvider(this).get(RoutineViewModel::class.java)

        _binding = FragmentRoutineBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textRoutine
        routineViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}