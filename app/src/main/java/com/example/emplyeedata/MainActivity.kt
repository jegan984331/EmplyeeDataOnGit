package com.example.emplyeedata

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), Emplyeeclickinterface, EmplyeeclickDeleteinterface {
    lateinit var RvEmplyee: RecyclerView
    lateinit var Addbtn: FloatingActionButton
    lateinit var viewmodel: EmplyeeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RvEmplyee = findViewById(R.id.RecyclerEmplyee)
        Addbtn = findViewById(R.id.addbtn)
        //Create RecyclerView
        RvEmplyee.layoutManager = LinearLayoutManager(this)
        val emplyeeRvAdapter = EmplyeeRvAdapter(this, this, this)
        RvEmplyee.adapter = emplyeeRvAdapter
        //Create ViewMOdel
        viewmodel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(EmplyeeViewModel::class.java)

        viewmodel.allEmplyees.observe(this, Observer { list ->
            list?.let {
                emplyeeRvAdapter.updateEmplyee(list)
            }
        })
        Addbtn.setOnClickListener {
            val intent = Intent(this, updateActivity::class.java)
            startActivity(intent)
//            this.finish()

        }
    }

    override fun onemplyeeclick(emplyee: Emplyee) {
        val intent = Intent(this, updateActivity::class.java)
        intent.putExtra("emplyeeType", "Edit")
        intent.putExtra("emplyeename", emplyee.emplyeeName)
        intent.putExtra("emplyeeage", emplyee.emplyeeAge)
        intent.putExtra("emplyeecode", emplyee.emplyeeCode)
        intent.putExtra("emplyeedesignation", emplyee.emplyeeDesignation)
        intent.putExtra("emplyeeid", emplyee.id)
        startActivity(intent)
        this.finish()

    }

    override fun onDeleteiconclick(emplyee: Emplyee) {
        viewmodel.deleteEmplyee(emplyee)
        Toast.makeText(this, "${emplyee.emplyeeName} Deleted", Toast.LENGTH_SHORT).show()
    }
}
