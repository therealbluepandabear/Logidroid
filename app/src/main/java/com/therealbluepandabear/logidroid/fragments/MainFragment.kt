@file:SuppressLint("ClickableViewAccessibility")

package com.therealbluepandabear.logidroid.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import com.therealbluepandabear.logidroid.customviews.BinaryInputView
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

    private fun setTouchListener(view: View) {
        view.setOnTouchListener { _, event ->
            when (event.actionMasked) {
                MotionEvent.ACTION_DOWN -> {
                    dX = view.x - event.rawX
                    dY = view.y - event.rawY
                }

                MotionEvent.ACTION_MOVE -> {
                    view.y = event.rawY + dY
                    view.x = event.rawX + dX
                }
            }

            view.onTouchEvent(event)
            binding.root.invalidate()
            true
        }
    }

    private fun spawnLogicGate(logicGate: LogicGate) {
        binding.root.addView(LogicGateView(requireContext()).apply {
            setLogicGate(logicGate)
            setTouchListener(this)
        })
    }

    private fun spawnLogicGate(logicGate: UnaryGate) {
        binding.root.addView(LogicGateView(requireContext()).apply {
            setLogicGate(logicGate)
            setTouchListener(this)
        })
    }

    private fun spawnBinaryInput(binaryInput: Boolean) {
        binding.root.addView(BinaryInputView(requireContext()).apply {
            setBinaryInput(binaryInput)
            setTouchListener(this)
        })
    }

    private fun setEventListeners() {
        binding.fragmentMainLogicalANDSpawner.setOnClickListener {
            spawnLogicGate(LogicalAND())
        }

        binding.fragmentMainLogicalNANDSpawner.setOnClickListener {
            spawnLogicGate(LogicalNAND())
        }

        binding.fragmentMainLogicalNORSpawner.setOnClickListener {
            spawnLogicGate(LogicalNOR())
        }

        binding.fragmentMainLogicalNOTSpawner.setOnClickListener {
            spawnLogicGate(LogicalNOT())
        }

        binding.fragmentMainLogicalORSpawner.setOnClickListener {
            spawnLogicGate(LogicalOR())
        }

        binding.fragmentMainLogicalXNORSpawner.setOnClickListener {
            spawnLogicGate(LogicalXNOR())
        }

        binding.fragmentMainLogicalXORSpawner.setOnClickListener {
            spawnLogicGate(LogicalXOR())
        }

        binding.fragmentMainBinaryInputZeroSpawner.setOnClickListener {
            spawnBinaryInput(false)
        }

        binding.fragmentMainBinaryInputOneSpawner.setOnClickListener {
            spawnBinaryInput(true)
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