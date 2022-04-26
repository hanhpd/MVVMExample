package com.example.mvvmexample.adapters

//for Context
import android.content.Context
//for RecyclerView
import androidx.recyclerview.widget.RecyclerView
//For view
import android.view.View
//For ViewGroup
import android.view.ViewGroup
//For LayoutInflater
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
//For Toast popup
import android.widget.Toast
//For TextView
import android.widget.TextView

//For Resource
import com.example.mvvmexample.R
import com.example.mvvmexample.viewmodels.MainViewModel
import com.example.mvvmexample.models.NicePlace

class RecyclerAdapter(val viewModel: MainViewModel, val arrayList: ArrayList<NicePlace>, val context: Context): RecyclerView.Adapter<RecyclerAdapter.NotesViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecyclerAdapter.NotesViewHolder {
        var root = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return NotesViewHolder(root)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.NotesViewHolder, position: Int) {
        holder.bind(arrayList.get(position))
    }

    override fun getItemCount(): Int {
        if(arrayList.size==0){
            Toast.makeText(context,"List is empty",Toast.LENGTH_LONG).show()
        }else{

        }
        return arrayList.size
    }


    inner  class NotesViewHolder(private val binding: View) : RecyclerView.ViewHolder(binding) {
        fun bind(blog: NicePlace){
            binding.findViewById<TextView>(R.id.title).text = blog.title
            binding.findViewById<ImageButton>(R.id.delete).setOnClickListener {
                viewModel.remove(blog)
                notifyItemRemoved(arrayList.indexOf(blog))
            }
        }

    }

}