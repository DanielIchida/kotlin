package com.example.daniel.layoutpersonalizado.adapter

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.example.daniel.layoutpersonalizado.R
import com.example.daniel.layoutpersonalizado.entities.Producto

class AdaptadorViewPager(private val context: Context, private val productos: List<Producto>) : PagerAdapter() {

    override fun getCount(): Int {
        return productos.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val p = productos[position]
        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater.inflate(R.layout.item_view_pager_layout, container, false)
        val textView = view.findViewById(R.id.textView2) as TextView
        val imageView = view.findViewById(R.id.imageView2) as ImageView
        textView.text = p.nombre
        imageView.setImageResource(p.imagen)
        container.addView(view)
        return view
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val view = `object` as View
        container.removeView(view)
    }
}
