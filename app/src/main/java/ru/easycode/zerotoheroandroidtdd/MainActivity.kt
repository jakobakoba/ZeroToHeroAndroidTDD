package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBar.LayoutParams
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val textViews = mutableListOf<String>()
    private lateinit var layout : LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val button = binding.actionButton
        val editText = binding.inputEditText
        layout = binding.contentLayout

        button.setOnClickListener{
            val textView = TextView(this)
            textView.text = editText.text
            editText.setText("")
            layout.addView(textView)
            textViews.add(textView.text.toString())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArray(KEY, textViews.toTypedArray())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        savedInstanceState.getStringArray(KEY)?.let { textViews.addAll(it) }
        for (i in 0 until textViews.size){
            val textView = TextView(this)
            textView.text = textViews[i]
            layout.addView(textView)
        }
    }

    companion object {
        private const val KEY = "KEY"
    }
}