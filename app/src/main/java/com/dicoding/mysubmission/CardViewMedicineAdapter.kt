package com.dicoding.mysubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewMedicineAdapter(private val listMedicine: ArrayList<Medicine>) :
    RecyclerView.Adapter<CardViewMedicineAdapter.CardViewViewHolder>() {
    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var btnFavorite: Button = itemView.findViewById(R.id.btn_set_favorite)
        var btnShare: Button = itemView.findViewById(R.id.btn_set_share)

//        init {
//            itemView.setOnClickListener {
//
//                val intent = Intent(itemView.context , detailMedicineActivity::class.java)
//                itemView.context.startActivity(intent)
//
//            }
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cardview_medicine, parent, false)
        return CardViewViewHolder(view)
    }


    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val medicine = listMedicine[position]
        Glide.with(holder.itemView.context)
            .load(listMedicine[position].photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvName.text = medicine.name
        holder.tvDetail.text = medicine.detail
        holder.btnFavorite.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Favorite " + listMedicine[holder.adapterPosition].name,
                Toast.LENGTH_SHORT
            ).show()
        }
        holder.btnShare.setOnClickListener {
            Toast.makeText(
                holder.itemView.context,
                "Share " + listMedicine[holder.adapterPosition].name,
                Toast.LENGTH_SHORT
            ).show()
        }

        val mContext = holder.itemView.context
        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, DetailActivity::class.java)
            moveDetail.putExtra(DetailActivity.EXTRA_DETAIL, medicine)
//            moveDetail.putExtra(DetailActivity.EXTRA_NAME, medicine.name)
//            moveDetail.putExtra(DetailActivity.EXTRA_PHOTO, listMedicine[position].photo)
            mContext.startActivity(moveDetail)

        }


    }

    override fun getItemCount(): Int {
        return listMedicine.size
    }
}