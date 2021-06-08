package com.example.mvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvm.R
import com.example.mvvm.data.model.Users
import com.example.mvvm.data.model.UsersItem
import com.example.mvvm.ui.adapter.UsersAdapter
import com.example.mvvm.ui.viewmodel.GithubViewmodel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val vm by lazy {
        ViewModelProvider(this).get(GithubViewmodel::class.java)
    }

    val list = arrayListOf<UsersItem>()
    val adapter = UsersAdapter(list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        users_rv.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }

        vm.fetchUsers()
        println("Hello from your friend")
    }
}