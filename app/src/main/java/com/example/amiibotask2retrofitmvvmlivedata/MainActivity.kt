package com.example.amiibotask2retrofitmvvmlivedata
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.amiibotask2retrofitmvvmlivedata.databinding.ActivityMainBinding
import com.example.amiibotask2retrofitmvvmlivedata.util.RetrofitService
import com.example.amiibotask2retrofitmvvmlivedata.view.MainAdapter
import com.example.amiibotask2retrofitmvvmlivedata.view.MainRepository
import com.example.amiibotask2retrofitmvvmlivedata.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel =
                ViewModelProvider(this, MyViewModelFactory(MainRepository(retrofitService))).get(
                        MainViewModel::class.java
                )
        binding.recyclerview.adapter = adapter
        viewModel.amiiboList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setAmiiboList(it)
        })
        viewModel.errorMessage.observe(this, Observer {
        })
        viewModel.getAllAmiibo()
    }
}