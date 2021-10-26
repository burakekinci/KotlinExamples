package com.example.android_basics_affirmationsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android_basics_affirmationsapp.R
import com.example.android_basics_affirmationsapp.model.Affirmation

//adapters are takes datasets
class ItemAdapter(
    private val context: Context,
    private val dataset: List<Affirmation>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    /*
    * RecyclerView doesn't interact directly with item views, but deals with ViewHolders instead.
    * A ViewHolder represents a single list item view in RecyclerView, and can be reused when possible.
    * A ViewHolder instance holds references to the individual views within a list item layout
    * */

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    /**
     *  Method is called by the layout manager to create new view holders for the RecyclerView
     *  Remember that a view holder represents a single list item view
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    /**
     * This method is called by the layout manager in order to replace the contents of a list item view.
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    /**
     * Needs to return the size of dataset
     */
    override fun getItemCount(): Int {
        return dataset.size
    }
}