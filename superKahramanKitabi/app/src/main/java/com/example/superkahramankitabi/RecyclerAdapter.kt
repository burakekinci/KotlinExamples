package com.example.superkahramankitabi

import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_row.view.*
                                                                                        //verimsizde bitmap
class RecyclerAdapter(val kahramanListesi : ArrayList<String>, val kahramanGorselleri : ArrayList<Int>)
        : RecyclerView.Adapter<RecyclerAdapter.SuperKahramanVH>()
{
    class SuperKahramanVH(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperKahramanVH {
        /*Inflater denilen yapılar ile xml dosyalarını bağlayabiliyoruz, recycler_row ile üretilen
        * "tek, bir tane" olan viewlerin düzenli üretilmesini sağlıyoruz
        */
        val oneItemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return SuperKahramanVH(oneItemView)
    }

    override fun onBindViewHolder(holder: SuperKahramanVH, position: Int) {
        holder.itemView.recyclerViewTextView.text = kahramanListesi.get(position)
        //iteme tıklayınca TanitimActivity'yi açmasını istiyoruz, bunu da Intent() ile yapıyoruz
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context,TanitimActivity::class.java)
            intent.putExtra("superKahramanIsmi",kahramanListesi.get(position))
            intent.putExtra("superKahramanGorseli",kahramanGorselleri.get(position))

            /*
            val singleton = SingletonClass.SecilenKahraman
            singleton.gorsel = kahramanGorselleri.get(position)
            */
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return kahramanListesi.size
    }

}