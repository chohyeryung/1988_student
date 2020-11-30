package kr.hs.emirim.cho.pj_student

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_input.*

class InputActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        btn_done.setOnClickListener {
            var id = inId.text.toString()
            var name = inName.text.toString()
            var dept = inDept.text.toString()
            var hakbun=inHakbun.text.toString()
            var image = "s"+id
            var hdong1 = inHdong1.text.toString()
            var hdong2 = inHdong2.text.toString()

            var studentDB : MyDBHelper = MyDBHelper(this)
            var sqlDB = studentDB.writableDatabase
            var insertSql = "insert into studentTBL values ('" + hakbun + "', '" + name + "', '" + dept + "', '" + image + "', '" + hdong1 + "', '" + hdong2 + "')"
            sqlDB.execSQL(insertSql)
            Toast.makeText(applicationContext, "insert ok " + name, Toast.LENGTH_SHORT).show()
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