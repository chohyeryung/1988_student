package kr.hs.emirim.cho.pj_student

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show_info.*

class ShowInfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_info)

        val intent=intent

        name.text=intent.getStringExtra("name")
        hdong1.text=intent.getStringExtra("hdong1")
        hdong2.text=intent.getStringExtra("hdong2")
    }
}