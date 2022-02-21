package com.example.cipher

import android.R
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cipher.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    private var keys: Int = 0
    private var u = 'a'

    var country = arrayOf("ROT1", "ROT2", "ROT3", "ROT4", "ROT5", "ROT6", "ROT7", "ROT8", "ROT9", "ROT10", "ROT11", "ROT12", "ROT13")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val aa: ArrayAdapter<*> = ArrayAdapter<Any?>(this, R.layout.simple_spinner_item, country)
        aa.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)

        binding.spinner.adapter = aa

        binding.spinner.onItemSelectedListener = this;

        binding.myEditText.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                caesarCipherROT(binding.myEditText.text.toString(), keys, u)
            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int, count: Int,
                after: Int
            ) {
            }

            override fun afterTextChanged(s: Editable) {}
        })

    }

    private fun caesarCipherROT(message: String, shifts: Int, u: Char) {
        val msg: String = message.toString()
        var s: String? = ""
        val len = msg.length
        for (x in 0 until len) {
            if (Character.isWhitespace(msg[x])) {
                s += " "
                continue
            }
            var c = (msg.elementAt(x) + shifts)
            if (c > 'z' || (c in '['..u)) {
                c -= 26
            }
            s += c
        }
        binding.myReceiveText.setText(s)
    }

    override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (val itemPosition = Integer.valueOf(position)) {
            0 -> {
                keys = itemPosition + 1
                u = 'a'
                caesarCipherROT(binding.myEditText.text.toString(), keys, u)
            }
            1 -> {
                keys = itemPosition + 1
                u = 'b'
                caesarCipherROT(binding.myEditText.text.toString(), keys, u)
            }
            2 -> {
                keys = itemPosition + 1
                u = 'c'
                caesarCipherROT(binding.myEditText.text.toString(), keys, u)
            }
            3 -> {
                keys = itemPosition + 1
                u = 'd'
                caesarCipherROT(binding.myEditText.text.toString(), keys, u)
            }
            4 -> {
                keys = itemPosition + 1
                u = 'e'
                caesarCipherROT(binding.myEditText.text.toString(), keys, u)
            }
            5 -> {
                keys = itemPosition + 1
                u = 'f'
                caesarCipherROT(binding.myEditText.text.toString(), keys, u)
            }
            6 -> {
                keys = itemPosition + 1
                u = 'g'
                caesarCipherROT(binding.myEditText.text.toString(), keys, u)
            }
            7 -> {
                keys = itemPosition + 1
                u = 'h'
                caesarCipherROT(binding.myEditText.text.toString(), keys, u)
            }
            8 -> {
                keys = itemPosition + 1
                u = 'i'
                caesarCipherROT(binding.myEditText.text.toString(), keys, u)
            }
            9 -> {
                keys = itemPosition + 1
                u = 'j'
                caesarCipherROT(binding.myEditText.text.toString(), keys, u)
            }
            10 -> {
                keys = itemPosition + 1
                u = 'k'
                caesarCipherROT(binding.myEditText.text.toString(), keys, u)
            }
            11 -> {
                keys = itemPosition + 1
                u = 'l'
                caesarCipherROT(binding.myEditText.text.toString(), keys, u)
            }
            12 -> {
                keys = itemPosition + 1
                u = 'm'
                caesarCipherROT(binding.myEditText.text.toString(), keys, u)
            }
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}