package kr.hs.emirim.cho.pj_student

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var studentList:ArrayList<StudentE> = arrayListOf<StudentE>()
        var myHelper:MyDBHelper=MyDBHelper(this)

        var sqlDB=myHelper.readableDatabase
        var cursor=sqlDB.rawQuery("select * from studentTBL", null)
        while(cursor.moveToNext()){
            studentList.add(StudentE(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5)))
        }
        cursor.close()
        sqlDB.close()

        var adapter1=ListViewAdapter(studentList)
        listView1.adapter=adapter1
        listView1.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(applicationContext, "선택"+ studentList.get(position).name, Toast.LENGTH_LONG).show()
            var intent= Intent(applicationContext, ShowInfoActivity::class.java)
            intent.putExtra("name", studentList.get(position).name)
            intent.putExtra("hdong1", studentList.get(position).hdong1)
            intent.putExtra("hdong2", studentList.get(position).hdong2)
            startActivity(intent)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)

        menu!!.add(0,1,0,"학생 입력")
        menu!!.add(0,2,0,"학생 수정")
        menu!!.add(0,3,0,"학생 삭제")

        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1->{
                var inIntent=Intent(applicationContext, InputActivity::class.java)
                startActivity(inIntent)
                return true
            }
            2->{
                var upIntent=Intent(applicationContext, UpdateActivity::class.java)
                startActivity(upIntent)
                return true
            }
            3->{
                var deIntent=Intent(applicationContext, DeleteActivity::class.java)
                startActivity(deIntent)
                return true
            }
        }
        return false
    }
}