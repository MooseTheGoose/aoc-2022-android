package com.binaryquackers.aoc2022

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.binaryquackers.aoc2022.databinding.FragmentPuzzleBinding
import java.nio.charset.StandardCharsets

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class PuzzleFragment: Fragment() {

    private var _binding: FragmentPuzzleBinding? = null
    private var daySolver = Day3PuzzleSolver()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentPuzzleBinding.inflate(inflater, container, false)
        daySolver.activity = requireActivity()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.Part1TestButton.setOnClickListener {
            daySolver.onPart1Test()
            binding.AnswerText.text = daySolver.message
        }
        binding.Part1SolutionButton.setOnClickListener {
            daySolver.onPart1Solution()
            binding.AnswerText.text = daySolver.message
        }
        binding.Part2TestButton.setOnClickListener {
            daySolver.onPart2Test()
            binding.AnswerText.text = daySolver.message
        }
        binding.Part2SolutionButton.setOnClickListener {
            daySolver.onPart2Solution()
            binding.AnswerText.text = daySolver.message
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}