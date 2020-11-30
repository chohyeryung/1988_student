package kr.hs.emirim.cho.pj_student

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_delete.*
import kotlinx.android.synthetic.main.activity_search.*

class DeleteActivity : AppCompatActivity() {
    private var dname:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)

        btn_del.setOnClickListener{
            dname=del_name.text.toString()
            var studentDB : MyDBHelper = MyDBHelper(this)
            var sqlDB = studentDB.writableDatabase

            sqlDB.execSQL("DELETE FROM studentTBL WHERE name='"+dname+"';")
            sqlDB.close()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menu!!.add(0, 1, 0, "학생 입력")
        menu!!.add(0, 2, 0, "학생 수정")
        menu!!.add(0, 3, 0, "학생 삭제")
        menu!!.add(0, 4, 0, "학생 검색")
        menu!!.add(0, 5, 0, "메인")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            1 -> {
                var inIntent = Intent(applicationContext, InputActivity::class.java)
                startActivity(inIntent)
                return true
            }
            2 -> {
                var upIntent = Intent(applicationContext, UpdateActivity::class.java)
                startActivity(upIntent)
                return true
            }
            3 -> {
                var deIntent = Intent(applicationContext, DeleteActivity::class.java)
                startActivity(deIntent)
                return true
            }
            4->{
                var seIntent = Intent(applicationContext, SearchActivity::class.java)
                startActivity(seIntent)
                return true
            }
            5->{
                var mainIntent = Intent(applicationContext, MainActivity::class.java)
                startActivity(mainIntent)
                return true
            }
        }

        return false
    }
}