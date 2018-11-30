package com.geomi.carritocompras.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.geomi.carritocompras.R;
import com.geomi.carritocompras.actividades.MainActivity;
import com.geomi.carritocompras.actividades.MainNavigation;
import com.geomi.carritocompras.modelo.Producto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ProductoRecyclerViewAdapter extends RecyclerView.Adapter<ProductoRecyclerViewAdapter.ViewHolder> {
    List<Producto> productos;
    Context acontext;


    public  ProductoRecyclerViewAdapter(Context context, List<Producto> productos){
        this.productos = productos;
        this.acontext= context;
    }

    private Context getContext(){
        return acontext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemproducto, null,false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //final Producto aproducto = productos.get(position);
       // Producto producto = productos.get(position);
        holder.txtViewTittle.setText(productos.get(position).getTitle());
        holder.txtViewDescr.setText(productos.get(position).getDetalle());
        holder.txtViewPre.setText(String.valueOf(productos.get(position).getPrecio()));
        holder.txtRating.setText(String.valueOf(productos.get(position).getRating()));
        holder.image.setImageResource(productos.get(position).getImage());



    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       // View rootView;
        ImageView image;
        TextView txtViewTittle;
        TextView txtViewDescr;
        TextView txtViewPre;
        TextView txtRating;

       ViewHolder( View view) {
            super(view);
            //rootView = view;
           image = view.findViewById(R.id.Imagen);
           txtViewTittle=  view.findViewById(R.id.txtTitulo);
           txtRating = view.findViewById(R.id.myRatingBar);
           txtViewDescr=  view.findViewById(R.id.txtDetalle);
           txtViewPre=  view.findViewById(R.id.txtPrecio);
           //view.setOnClickListener(this);

        }

       /* @Override
        public void onClick(View v) {
            Producto producto = productos.get(getAdapterPosition());
            Intent intent = new Intent(getContext(), Producto.class);
            //intent.putExtra("PRODUCTO", (Parcelable) producto);
            getContext().startActivity(intent);
        }*/
    }
}
