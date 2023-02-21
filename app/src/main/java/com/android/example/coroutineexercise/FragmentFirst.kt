package com.android.example.coroutineexercise

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.example.coroutineexercise.databinding.FragmentFirstBinding
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


class FragmentFirst : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private var currentNumber = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFirstBinding.bind(view)

        binding.BTN1.setOnClickListener {

            runBlocking {
                valueFirst()
            }
        }
    }

    suspend fun valueFirst() {
        delay(2000)
        val number = binding.ET1.text.toString().toInt()
        val result = number + 1 + currentNumber
        currentNumber++
        binding.TV1.text = result.toString()
    }
}


