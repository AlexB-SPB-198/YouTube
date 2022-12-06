package com.example.youtube

import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.example.youtube.adapter.PlaylistsAdapter
import com.example.youtube.base.BaseActivity
import com.example.youtube.databinding.ActivityMainBinding
import com.example.youtube.ui.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private lateinit var viewModel: MainViewModel
    private val adapter = PlaylistsAdapter()

    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun   initAdapter(){
        binding.rvPlaylists.adapter = adapter
    }

    override fun initListener() {

    }
    override fun setUI() {
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun setupLiveData() {
        viewModel.getPlayList().observe(this){PlayList->
            adapter.setList(PlayList.items)
            Toast.makeText(this, PlayList.kind.toString(),Toast.LENGTH_SHORT).show()
        }
    }

    override fun checkInternet() {

    }


}


