package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ItemLayoutBinding

class RecyclerViewAdapter() : RecyclerView.Adapter<MyItemViewHolder>() {

    private val itemsList = ArrayList<CharSequence>()

    fun add(source: CharSequence) {
        itemsList.add(source)
        notifyItemInserted(itemsList.size - 1)
    }

    fun save(bundle: Bundle) {
        bundle.putCharSequenceArrayList(KEY, itemsList)
    }

    fun restore(bundle: Bundle) {
        itemsList.addAll(bundle.getCharSequenceArrayList(KEY) ?: ArrayList())
        notifyItemRangeInserted(0, itemsList.size)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyItemViewHolder {
        return MyItemViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MyItemViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    override fun getItemCount(): Int = itemsList.size

    companion object {
        private const val KEY = "RecyclerViewAdapterKey"
    }

}


class MyItemViewHolder(private val binding: ItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(source: CharSequence) {
        binding.elementTextView.text = source
    }
}
