package com.dicoding.mysubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Medicine"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val tvMedicineName: TextView = findViewById(R.id.tv_item_name)
        val setImgMedicine: ImageView = findViewById(R.id.img_item_photo)
        val tvMedicineDescription: TextView = findViewById(R.id.tv_item_detail)

//        val bundle: Bundle? = intent.extras
//        val tName  = intent.getStringExtra(EXTRA_NAME)
//        val tImg = bundle?.getInt(EXTRA_PHOTO)
//        val tDesc = intent.getStringExtra(EXTRA_DETAIL)

        val medicine = intent.getParcelableExtra<Medicine>(EXTRA_DETAIL)
        tvMedicineName.text = medicine.name
        Glide.with(this)
            .load(medicine.photo)
            .apply(RequestOptions())
            .into(setImgMedicine)
        tvMedicineDescription.text = medicine.detail

    }

    companion object {
        //        const val EXTRA_NAME = "extra_name"
        //        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}