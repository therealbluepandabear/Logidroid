package com.therealbluepandabear.logidroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.therealbluepandabear.logidroid.databinding.FragmentMainBinding
import com.therealbluepandabear.logidroid.models.LogicalAND
import com.therealbluepandabear.logidroid.models.LogicGate
import com.therealbluepandabear.logidroid.models.LogicalNOT
import com.therealbluepandabear.logidroid.models.UnaryGate

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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        val logicGate: UnaryGate = LogicalNOT()
        binding.message.text = logicGate.performOperation(false).toString()

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}