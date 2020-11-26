package kr.hs.emirim.cho.pj_student

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.listitem.view.*

class ListViewAdapter(var studentList : ArrayList<StudentE>) : BaseAdapter() {
    override fun getCount(): Int {
        return studentList.size
    }

    override fun getItem(p0: Int): Any {
        return studentList[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        var rowItemView = view
        if (rowItemView == null) {
            rowItemView = View.inflate(parent?.context, R.layout.listitem, null)
        }
        val student = studentList[position]
        var imageResId =  parent!!.resources.getIdentifier("kr.hs.emirim.cho.pj_student:" + "drawable/" + student.sajin, null, null)
        rowItemView!!.itemImage.setImageResource(imageResId)
        rowItemView!!.itemTitle.text = student.name
        rowItemView!!.major.text = student.dept
        rowItemView!!.hakbun.text = student.hb
        return rowItemView
    }

}