package com.example.daniel.layoutpersonalizado.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import com.example.daniel.layoutpersonalizado.R
import com.example.daniel.layoutpersonalizado.entities.Producto


class AdaptadorProductos(private val context: Context, private val productos: List<Producto>, private val layout: Int) : RecyclerView.Adapter<AdaptadorProductos.ProductosViewHolder>() {

    class ProductosViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val txtProducto: TextView
        private val imgProducto: ImageView

        init {
            txtProducto = itemView.findViewById(R.id.textView) as TextView
            imgProducto = itemView.findViewById(R.id.imageView) as ImageView
        }

        fun bindProducto(p: Producto) {
            txtProducto.text = p.nombre
            imgProducto.setImageResource(p.imagen)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductosViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(layout, parent, false)
        val productosViewHolder = ProductosViewHolder(itemView)
        return productosViewHolder
    }

    override fun onBindViewHolder(holder: ProductosViewHolder, position: Int) {
        val p = productos[position]
        holder.bindProducto(p)
    }

    override fun getItemCount(): Int {
        return productos.size
    }

}
