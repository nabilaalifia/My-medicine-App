package com.dicoding.mysubmission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvMedicines: RecyclerView
    private var list: ArrayList<Medicine> = arrayListOf()
    private var title: String = "Daftar Obat"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setActionBarTitle(title)

        rvMedicines = findViewById(R.id.rv_medicines)
        rvMedicines.setHasFixedSize(true)
        list.addAll(medicineData.listData)
        showRecyclerCardView()
    }

    private fun showRecyclerCardView() {
        rvMedicines.layoutManager = LinearLayoutManager(this)
        val cardViewHeroAdapter = CardViewMedicineAdapter(list)
        rvMedicines.adapter = cardViewHeroAdapter
    }

//    private fun showRecyclerList() {
//        rvMedicines.layoutManager = LinearLayoutManager(this)
//        val listMedicineAdapter = ListMedicineAdapter(list)
//        rvMedicines.adapter = listMedicineAdapter
//
//    }

//    private fun showRecyclerGrid() {
//        rvMedicines.layoutManager = GridLayoutManager(this, 2)
//        val gridMedicineAdapter = GridMedicineAdapter(list)
//        rvMedicines.adapter = gridMedicineAdapter
//
//    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.miCompose -> {
                val iAbout = Intent(this@MainActivity, AboutMe::class.java)
                startActivity(iAbout)
            }

            }
//        when (selectedMode) {
//            R.id.action_cardview -> {
//                title = "Daftar Obat"
//                showRecyclerCardView()
//            }
//            R.id.action_grid -> {
//                title = "Daftar Obat Mode Grid"
////                showRecyclerGrid()
//            }
//            R.id.action_list -> {
//                title = "Daftar Obat Mode List"
////                showRecyclerList()
//            }
//
//        }
//        setActionBarTitle(title)
    }

}