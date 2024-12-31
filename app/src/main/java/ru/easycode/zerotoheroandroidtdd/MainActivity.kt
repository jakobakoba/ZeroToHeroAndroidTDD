package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var itemsList = mutableListOf<ItemData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val button = binding.actionButton
        val editText = binding.inputEditText
        val recyclerView = binding.recyclerView

        val adapter = RecyclerViewAdapter(itemsList)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        button.setOnClickListener {
            val text = editText.text.toString()
            val item = ItemData(text)
            itemsList.add(item)
            adapter.notifyItemInserted(itemsList.size - 1)
            editText.setText("")
        }
    }
}