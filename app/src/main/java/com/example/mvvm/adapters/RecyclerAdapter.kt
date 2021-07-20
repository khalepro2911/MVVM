package com.example.mvvm.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.WebViewActivity
import com.example.mvvm.models.NicePlace



class RecyclerAdapter(private val _mNicePlaces: List<NicePlace>, private val context: Context) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {



    //private var mContext: Context = context


    @NonNull
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.layout_listitem, viewGroup, false)
        return ViewHolder(view, context,_mNicePlaces)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {

        // Set the name of the 'NicePlace'
        viewHolder.mName.text = _mNicePlaces[i].title

    }

    override fun getItemCount(): Int {
        return _mNicePlaces.size
    }


    class ViewHolder(itemView: View, private val context: Context,private val nicePlaces: List<NicePlace>) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val mName: TextView = itemView.findViewById(R.id.image_name)
        override fun onClick(v: View) {
            val intent = Intent(context, WebViewActivity::class.java)
            intent.putExtra("URL_NAME", nicePlaces[absoluteAdapterPosition].imageUrl)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
        init{
            itemView.setOnClickListener(this)
        }

    }




}