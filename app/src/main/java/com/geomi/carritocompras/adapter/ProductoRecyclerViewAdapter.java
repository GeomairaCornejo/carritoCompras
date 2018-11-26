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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductoRecyclerViewAdapter extends RecyclerView.Adapter<ProductoRecyclerViewAdapter.ViewHolder> {
    List<Producto> productos;
    Context context;

    public interface ProductoRecyclerViewAdapterListener{
        void OnItemClicked(Producto producto);
    }
    public  ProductoRecyclerViewAdapter(Context context, List<Producto> productos){
        this.productos = productos;
        this.context= context;
    }
    private Context getContext(){
        return context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemproducto,parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Producto producto = productos.get(position);
        holder.txtTitulo.setText(producto.getTitle());
        holder.txtDetalle.setText(producto.getDetalle());
        holder.txtPrecio.setText((int) producto.getPrecio());

        holder.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(context instanceof ProductoRecyclerViewAdapterListener ){
                    ((ProductoRecyclerViewAdapterListener)context).OnItemClicked(producto);
                }

            }
        });

        /*Picasso.with(getContext())
                .load(producto.getPosterPath())
                .into(holder.Imagen);*/
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        View rootView;
        @BindView(R.id.Imagen)
        ImageView Imagen;
        @BindView(R.id.txtTitulo)
        TextView txtTitulo;
        @BindView(R.id.txtDetalle)
        TextView txtDetalle;
        @BindView(R.id.txtPrecio)
        TextView txtPrecio;

       ViewHolder( View view) {
            super(view);
            rootView = view;
           ButterKnife.bind(this,view);

        }



    }
}
