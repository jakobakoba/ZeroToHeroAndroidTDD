package ru.easycode.zerotoheroandroidtdd

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import ru.easycode.zerotoheroandroidtdd.databinding.ItemLayoutBinding

class RecyclerViewAdapter: RecyclerView.Adapter<MyViewHolder>() {
    private val list = ArrayList<CharSequence>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    fun update(newList: List<CharSequence>) {
        val diffUtil = DiffUtilCallback(list, newList)
        val diff = DiffUtil.calculateDiff(diffUtil)

        list.clear()
        list.addAll(newList)
        diff.dispatchUpdatesTo(this)
    }
}

class MyViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(text: CharSequence) {
        binding.elementTextView.text = text
     }
}

private class DiffUtilCallback(
    private val old: List<CharSequence>,
    private val new: List<CharSequence>
): DiffUtil.Callback() {
    override fun getOldListSize(): Int = old.size

    override fun getNewListSize(): Int = new.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[newItemPosition]
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] == new[newItemPosition]
    }

}