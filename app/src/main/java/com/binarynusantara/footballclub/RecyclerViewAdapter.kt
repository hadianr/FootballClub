package com.binarynusantara.footballclub

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class RecyclerViewAdapter(private val context: Context, private val items: List<Item>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder =
    ViewHolder(ItemList().createView(AnkoContext.create(parent.context, parent)))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val name: TextView = view.find(R.id.name_club)
        private val image: ImageView = view.find(R.id.img_club)

        fun bindItem(items: Item){
            name.text = items.name
            Glide.with(itemView.context).load(items.image).into(image)
            itemView.setOnClickListener {
                itemView.context.startActivity<DetailActivity>("club_name" to items.name, "club_img" to items.image, "club_detail" to items.detail)

            }
        }
    }

    class ItemList : AnkoComponent<ViewGroup>{

        override fun createView(ui: AnkoContext<ViewGroup>): View {
            return with(ui){
                linearLayout {
                    lparams(width = matchParent, height = wrapContent)
                    padding = dip(16)
                    orientation = LinearLayout.HORIZONTAL

                    imageView {
                        id = R.id.img_club
                    }.lparams{
                        height = dip(50)
                        width = dip(50)
                    }

                    textView {
                        id = R.id.name_club
                        textSize = 16f
                    }.lparams{
                        margin = dip(15)
                    }

                }
            }
        }


    }

}