package com.vsaldivarm.dogsdex.doglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.vsaldivarm.dogsdex.Dog
import com.vsaldivarm.dogsdex.R
import com.vsaldivarm.dogsdex.api.ApiResponseStatus
import com.vsaldivarm.dogsdex.databinding.ActivityDogListBinding
import com.vsaldivarm.dogsdex.dogdetail.DogDetailActivity
import com.vsaldivarm.dogsdex.dogdetail.DogDetailActivity.Companion.DOG_KEY

class DogListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDogListBinding
    private val dogListViewModel: DogListViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val progressbar = binding.progressBarDogList

        val recycler = binding.dogsRecycler
        recycler.layoutManager = LinearLayoutManager(this)

        val adapter = DogAdapter()
        //agregar onclick listener al adapter
        adapter.setOnItemClickListener {
            //pasar el dog a Dogdetail Activity
            //para pasar objetos entre activities debe de ser parceable (agregar el plugin en gradle)
            val intent = Intent(this, DogDetailActivity::class.java)
            intent.putExtra(DOG_KEY, it)
            startActivity(intent)
        }
        recycler.adapter = adapter

        dogListViewModel.dogList.observe(this) {
            adapter.submitList(it)
        }
        //observar el estatus de la peticion
        dogListViewModel.networkStatus.observe(this) { status ->
            when (status) {
                is ApiResponseStatus.Error -> {//Mostrar error con un toast
                    Toast.makeText(this, status.message, Toast.LENGTH_LONG).show()
                    //dismiss progressbar
                    progressbar.visibility = View.GONE
                }
                is ApiResponseStatus.Loading -> {// show progressbar
                    progressbar.visibility = View.VISIBLE
                }
                is ApiResponseStatus.Sucess -> {//dismiss progressbar
                    progressbar.visibility = View.GONE
                }
            }
        }
    }


}