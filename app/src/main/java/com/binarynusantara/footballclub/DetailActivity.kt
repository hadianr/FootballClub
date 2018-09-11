package com.binarynusantara.footballclub

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    private var clubName: String = ""
    private var clubDetail: String = ""
    private var clubImg: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent

        verticalLayout {
            padding = dip(16)

            clubImg = intent.getIntExtra("club_img",0)

            imageView(clubImg).
                    lparams(width = dip(120), height = dip(120)){
                        gravity = Gravity.CENTER
                    }
            textView{
                clubName = intent.getStringExtra("club_name")
                text = clubName
                textAlignment = View.TEXT_ALIGNMENT_CENTER
                typeface = Typeface.DEFAULT_BOLD
                textSize = 16f
            }.lparams(width = matchParent){
                topMargin = dip(8)
            }

            textView{
                clubDetail = intent.getStringExtra("club_detail")

                text = clubDetail
            }.lparams(width = matchParent){
                topMargin = dip(32)
            }
        }

    }

}


