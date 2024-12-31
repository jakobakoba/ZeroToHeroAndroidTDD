package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var itemsList = ArrayList<String>()

    private var adapter: RecyclerViewAdapter? = null

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
            val item = text
            itemsList.add(item)
            adapter.notifyItemInserted(itemsList.size - 1)
            editText.setText("")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArrayList(KEY, itemsList)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val items = savedInstanceState.getStringArrayList(KEY)
        items?.let {
            itemsList.addAll(it)
            adapter?.notifyDataSetChanged()
        }
    }

    companion object {
        private const val KEY = "KEY"
    }
}