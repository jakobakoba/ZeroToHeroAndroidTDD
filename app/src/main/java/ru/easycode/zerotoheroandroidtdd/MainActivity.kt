package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val button = binding.actionButton
        val editText = binding.inputEditText

        button.setOnClickListener{
            addTextView(editText.text.toString())
            editText.setText("")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val textList = binding.contentLayout.children.map { (it as TextView).text.toString() }.toList()
        outState.putStringArrayList(KEY, ArrayList(textList))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val list = savedInstanceState.getStringArrayList(KEY) ?: ArrayList()
        list.forEach {inputText ->
            addTextView(inputText)
        }

    }

    private fun addTextView(inputText: String) {
        val textView = TextView(this).apply {
            text = inputText
        }
        binding.contentLayout.addView(textView)
    }

    companion object {
        private const val KEY = "KEY"
    }
}