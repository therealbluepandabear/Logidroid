@file:SuppressLint("ClickableViewAccessibility")

package com.therealbluepandabear.logidroid.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.therealbluepandabear.logidroid.customviews.LogicGateView
import com.therealbluepandabear.logidroid.databinding.FragmentMainBinding
import com.therealbluepandabear.logidroid.models.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance(): MainFragment {
            return MainFragment()
        }
    }

    private var _binding: FragmentMainBinding? = null

    private val binding get(): FragmentMainBinding {
        return _binding!!
    }

    private var dX = 0f
    private var dY = 0f

    private fun setTouchListener(logicGateView: LogicGateView) {
        logicGateView.setOnTouchListener { _, event ->
            when (event.actionMasked) {
                MotionEvent.ACTION_DOWN -> {
                    dX = logicGateView.x - event.rawX
                    dY = logicGateView.y - event.rawY
                }

                MotionEvent.ACTION_MOVE -> {
                    logicGateView.y = event.rawY + dY
                    logicGateView.x = event.rawX + dX
                }
            }

            binding.root.invalidate()
            true
        }
    }

    private fun setEventListeners() {
        binding.fragmentMainLogicalANDSpawner.setOnClickListener {
            val view = LogicGateView(requireContext()).apply {
                setLogicGate(LogicalAND())
                setTouchListener(this)
            }

            binding.root.addView(view)
        }

        binding.fragmentMainLogicalNANDSpawner.setOnClickListener {
            val view = LogicGateView(requireContext()).apply {
                setLogicGate(LogicalNAND())
                setTouchListener(this)
            }

            binding.root.addView(view)
        }

        binding.fragmentMainLogicalNORSpawner.setOnClickListener {
            val view = LogicGateView(requireContext()).apply {
                setLogicGate(LogicalNOR())
                setTouchListener(this)
            }

            binding.root.addView(view)
        }

        binding.fragmentMainLogicalNOTSpawner.setOnClickListener {
            val view = LogicGateView(requireContext()).apply {
                setLogicGate(LogicalNOT())
                setTouchListener(this)
            }

            binding.root.addView(view)
        }

        binding.fragmentMainLogicalORSpawner.setOnClickListener {
            val view = LogicGateView(requireContext()).apply {
                setLogicGate(LogicalOR())
                setTouchListener(this)
            }

            binding.root.addView(view)
        }

        binding.fragmentMainLogicalXNORSpawner.setOnClickListener {
            val view = LogicGateView(requireContext()).apply {
                setLogicGate(LogicalXNOR())
                setTouchListener(this)
            }

            binding.root.addView(view)
        }

        binding.fragmentMainLogicalXORSpawner.setOnClickListener {
            val view = LogicGateView(requireContext()).apply {
                setLogicGate(LogicalXOR())
                setTouchListener(this)
            }

            binding.root.addView(view)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        setEventListeners()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}