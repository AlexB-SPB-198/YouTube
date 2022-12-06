package com.example.youtube.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    protected lateinit var binding: VB
    protected abstract fun inflateViewBinding(): VB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateViewBinding()
        setContentView(binding.root)

        checkInternet()
        setUI()
        initAdapter()
        setupLiveData()
        initListener()
    }

    open fun setupLiveData(){}

    open fun setUI(){}

    open fun  initAdapter(){}

    open fun checkInternet(){}

    open fun initListener(){}
}