package com.example.emplyeedata

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class EmplyeeRvAdapter(val context:Context,
                       val emplyeeclickinterface:Emplyeeclickinterface,
                       val emplyeeclickDeleteinterface: EmplyeeclickDeleteinterface)
    :RecyclerView.Adapter<EmplyeeRvAdapter.ViewHolder>(){

    val allEmplyee = ArrayList<Emplyee>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val itemView = LayoutInflater.from(parent.context).inflate(R.layout.emplyee_rv_item,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.emname.setText(allEmplyee.get(position).emplyeeName)
        holder.emage.setText(allEmplyee.get(position).emplyeeAge)
        holder.emcode.setText(allEmplyee.get(position).emplyeeCode)
        holder.emdesigtion.setText(allEmplyee.get(position).emplyeeDesignation)

        holder.delete.setOnClickListener {
            emplyeeclickDeleteinterface.onDeleteiconclick(allEmplyee.get(position))
        }
        holder.itemView.setOnClickListener {
            emplyeeclickinterface.onemplyeeclick(allEmplyee.get(position))
        }
    }

    override fun getItemCount(): Int {
        return allEmplyee.size
    }

    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val emname =itemView.findViewById<TextView>(R.id.ename)
        val emage =itemView.findViewById<TextView>(R.id.eage)
        val emcode =itemView.findViewById<TextView>(R.id.ecode)
        val emdesigtion =itemView.findViewById<TextView>(R.id.edesigination)
        val delete =itemView.findViewById<ImageButton>(R.id.deleteicon)
    }
   fun updateEmplyee(newlist:List<Emplyee>){
      allEmplyee.clear()
       allEmplyee.addAll(newlist)
      notifyDataSetChanged()
  }

}
   interface EmplyeeclickDeleteinterface{
           fun onDeleteiconclick(emplyee: Emplyee)
}
    interface Emplyeeclickinterface{
      fun onemplyeeclick(emplyee: Emplyee)
}