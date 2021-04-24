package com.dicoding.mysubmission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.w3c.dom.Text

class AboutMe : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)
        val actionbar = supportActionBar
        actionbar!!.title = "About"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val txtName : TextView = findViewById(R.id.creator_name)
        val txtEmail : TextView = findViewById(R.id.creator_email)

        val image: ImageView = findViewById(R.id.img_item_photo)

        val Img = R.drawable.me
        Glide.with(this)
            .load(Img)
            .apply(RequestOptions())
            .into(image)

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}