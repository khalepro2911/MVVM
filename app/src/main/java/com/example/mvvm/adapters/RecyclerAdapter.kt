package com.example.mvvm.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.bumptech.glide.request.RequestOptions
import com.example.mvvm.R
import com.example.mvvm.models.NicePlace

import de.hdodenhof.circleimageview.CircleImageView


class RecyclerAdapter(context: Context, nicePlaces: List<NicePlace>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var mNicePlaces: List<NicePlace> = nicePlaces
    private var mContext: Context = context


    @NonNull
    override fun onCreateViewHolder(@NonNull viewGroup: ViewGroup, i: Int): RecyclerView.ViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.layout_listitem, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(@NonNull viewHolder: RecyclerView.ViewHolder, i: Int) {

        // Set the name of the 'NicePlace'

        val viewHolderTemp = viewHolder as ViewHolder
        viewHolderTemp.mName.text = mNicePlaces[i].title


        // Set the image
        val defaultOptions: RequestOptions = RequestOptions()
            .error(R.drawable.ic_launcher_background)
        Glide.with(mContext)
            .setDefaultRequestOptions(defaultOptions)
            .load(mNicePlaces[i].imageUrl)
            .into((viewHolderTemp).mImage)

    }

    override fun getItemCount(): Int {
        return mNicePlaces.size
    }

    class ViewHolder(@NonNull itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val mImage: CircleImageView = itemView.findViewById(R.id.image)
        val mName: TextView = itemView.findViewById(R.id.image_name)    }


}