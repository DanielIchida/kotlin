package com.example.daniel.layoutpersonalizado

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.example.daniel.layoutpersonalizado.adapter.AdaptadorProductos
import com.example.daniel.layoutpersonalizado.adapter.AdaptadorViewPager
import com.example.daniel.layoutpersonalizado.entities.Producto
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var rcListado: RecyclerView
    lateinit var viewPager: ViewPager
    lateinit var productos: MutableList<Producto>
    lateinit var adapter: AdaptadorProductos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rcListado = findViewById(R.id.rc_listado) as RecyclerView
        viewPager = findViewById(R.id.view_pager) as ViewPager

        dataProductos()

        listadoLineal()


    }

    fun dataProductos() {
        productos = ArrayList<Producto>()
        productos.add(Producto("Banano", R.drawable.banano))
        productos.add(Producto("Durazno", R.drawable.durazno))
        productos.add(Producto("Fresa", R.drawable.fresas))
        productos.add(Producto("Kiwi", R.drawable.kiwi))
        productos.add(Producto("Mandarina", R.drawable.mandarina))
        productos.add(Producto("Manzana", R.drawable.manzana))
        productos.add(Producto("Naranja", R.drawable.naranja))
        productos.add(Producto("Sandia", R.drawable.sandia))
    }

    fun listadoLineal() {
        adapter = AdaptadorProductos(this, productos, R.layout.item_linear_layout)
        rcListado.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rcListado.adapter = adapter
    }

    fun listadoGrilla() {
        adapter = AdaptadorProductos(this, productos, R.layout.item_grid_layout)
        rcListado.layoutManager = GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false)
        rcListado.adapter = adapter
    }

    fun listadoSlider() {
        val adaptadorViewPager = AdaptadorViewPager(this, productos)
        viewPager.adapter = adaptadorViewPager
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                viewPager.visibility = View.GONE
                rcListado.visibility = View.VISIBLE
                listadoLineal()
                return true
            }
            R.id.action_grilla -> {
                viewPager.visibility = View.GONE
                rcListado.visibility = View.VISIBLE
                listadoGrilla()
                return true
            }
            R.id.action_pager -> {
                viewPager.visibility = View.VISIBLE
                rcListado.visibility = View.GONE
                listadoSlider()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
