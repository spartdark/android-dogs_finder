package com.vsaldivarm.dogsdex.doglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.vsaldivarm.dogsdex.Dog
import com.vsaldivarm.dogsdex.R
import com.vsaldivarm.dogsdex.databinding.ActivityDogListBinding

class DogListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDogListBinding
    //instanciar viewmodel
    private val dogListViewModel: DogListViewModel  by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val recycler = binding.dogsRecycler
        recycler.layoutManager = LinearLayoutManager(this)

        val adapter = DogAdapter()
        recycler.adapter = adapter

        //observar desde esta activity
        dogListViewModel.dogList.observe(this){
            adapter.submitList(it)
        }
    }


}