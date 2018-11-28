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
     ArrayList<Producto> productos;
    Context acontext;


    public  ProductoRecyclerViewAdapter(Context context, ArrayList<Producto> productos){
        this.productos = productos;
        this.acontext= context;
    }

    public ProductoRecyclerViewAdapter(ArrayList<Producto> productos) {
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemproducto, null,false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Producto aproducto = productos.get(position);
        holder.txtViewTittle.setText(aproducto.getTitle());
        holder.txtViewDescr.setText(aproducto.getDetalle());
        holder.txtViewPre.setText(String.valueOf(aproducto.getPrecio()));
        holder.txtRating.setText(String.valueOf(aproducto.getRating()));

        if(aproducto.getImage().isEmpty()){
            Picasso.with(acontext)
                    .load(R.mipmap.ic_launcher)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(holder.image);
        }else{
            Picasso.with(acontext)
                    .load(aproducto.getImage())
                    .placeholder(R.drawable.notfound)
                    .error(R.drawable.notfound)
                    .into(holder.image);
        }

    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
       // View rootView;
        ImageView image;
        TextView txtViewTittle;
        TextView txtViewDescr;
        TextView txtViewPre;
        TextView txtRating;

       ViewHolder( View view) {
            super(view);
            //rootView = view;
            image = (ImageView) view.findViewById(R.id.Imagen);
           txtViewTittle= (TextView) view.findViewById(R.id.txtTitulo);
           txtRating = view.findViewById(R.id.myRatingBar);
           txtViewDescr= (TextView) view.findViewById(R.id.txtDetalle);
           txtViewPre= (TextView) view.findViewById(R.id.txtPrecio);

        }
    }
}
