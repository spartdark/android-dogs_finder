package com.vsaldivarm.dogsdex.doglist

import android.view.LayoutInflater
import androidx.recyclerview.widget.ListAdapter
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.vsaldivarm.dogsdex.Dog
import com.vsaldivarm.dogsdex.databinding.DogListItemBinding

class DogAdapter : ListAdapter<Dog, DogAdapter.DogViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Dog>() {
        override fun areItemsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Dog, newItem: Dog): Boolean {
            return oldItem.id == newItem.id
        }
    }

    private var onItemClickListeneer:((Dog) -> Unit) ?= null
    fun setOnItemClickListener(onItemClickListeneer:(Dog)->Unit){
        this.onItemClickListeneer= onItemClickListeneer
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val binding = DogListItemBinding.inflate(LayoutInflater.from(parent.context))
// retornamos el viewHolder (crear el viewHolder)
        return DogViewHolder(binding)
    }

    override fun onBindViewHolder(dogViewHolder: DogViewHolder, position: Int) {
        val dog = getItem(position)
        //para cada perro va a crear un viewholder
        dogViewHolder.bind(dog)
    }

    inner class DogViewHolder(val bindingDogViewHolder: DogListItemBinding) :
        RecyclerView.ViewHolder(bindingDogViewHolder.root) {
        //pinta la vista
        fun bind(dog: Dog) {
            bindingDogViewHolder.textViewDogName.text = dog.name_es
            bindingDogViewHolder.textViewDogName.setOnClickListener{
                //Si no es null lo invocamos (invoke)
                onItemClickListeneer?.invoke(dog)
            }
        }
    }
}

