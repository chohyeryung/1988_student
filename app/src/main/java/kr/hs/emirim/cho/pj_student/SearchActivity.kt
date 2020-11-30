package kr.hs.emirim.cho.pj_student

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_search.*
import kotlinx.android.synthetic.main.activity_show_info.*

class SearchActivity : AppCompatActivity() {
    private var stext:String=""
    private var sname:String=""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        btn_search.setOnClickListener{
            stext=search_input.text.toString()
            when(rg1.checkedRadioButtonId){
                R.id.search_name->searchName(stext)
                R.id.search_hb->searchHb(stext)
                R.id.search_act->searchAct(stext)
                else->Toast.makeText(applicationContext, "라디오 버튼을 선택하고, 검색을 해주세요.", Toast.LENGTH_SHORT).show()
            }

        }

    }

    private fun searchName(stext: String) {
        show_lay.visibility = View.VISIBLE
        var studentList : ArrayList<StudentE> = arrayListOf<StudentE>()
        var studentDB : MyDBHelper = MyDBHelper(this)
        var sqlDB = studentDB.readableDatabase

        var cursor = sqlDB.rawQuery("SELECT * FROM studentTBL WHERE name='"+stext+"';", null)
        while (cursor.moveToNext()) {
            studentList.add(StudentE(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)))
        }

        var adapter1 = ListViewAdapter(studentList)
        listView2.adapter = adapter1
        cursor.close()
        sqlDB.close()
    }

    private fun searchHb(stext: String) {
        show_lay.visibility = View.VISIBLE
        var studentList : ArrayList<StudentE> = arrayListOf<StudentE>()
        var studentDB : MyDBHelper = MyDBHelper(this)
        var sqlDB = studentDB.readableDatabase

        var cursor = sqlDB.rawQuery("SELECT * FROM studentTBL WHERE hb='"+stext+"';", null)
        while (cursor.moveToNext()) {
            studentList.add(StudentE(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)))
        }

        var adapter1 = ListViewAdapter(studentList)
        listView2.adapter = adapter1
        cursor.close()
        sqlDB.close()
    }
    private fun searchAct(stext: String) {
        show_lay.visibility = View.VISIBLE
        var studentList : ArrayList<StudentE> = arrayListOf<StudentE>()
        var studentDB : MyDBHelper = MyDBHelper(this)
        var sqlDB = studentDB.readableDatabase

        var cursor = sqlDB.rawQuery("SELECT * FROM studentTBL WHERE hdong1='"+stext+"';", null)
        while (cursor.moveToNext()) {
            studentList.add(StudentE(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)))
        }

        var adapter1 = ListViewAdapter(studentList)
        listView2.adapter = adapter1
        cursor.close()
        sqlDB.close()
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