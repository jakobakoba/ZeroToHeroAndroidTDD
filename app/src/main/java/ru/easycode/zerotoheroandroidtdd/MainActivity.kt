package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val button = binding.actionButton
        val editText = binding.inputEditText
        textView = binding.titleTextView

        button.isEnabled = false

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s.toString().length >= 3) button.isEnabled = true else button.isEnabled = false
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        button.setOnClickListener {
            textView.text = editText.text
            editText.setText("")
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY, textView.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textView.text = savedInstanceState.getString(KEY)
    }

    companion object {
        private const val KEY = "KEY"
    }
}