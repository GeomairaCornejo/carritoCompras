package com.geomi.carritocompras.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.geomi.carritocompras.R;
import com.geomi.carritocompras.adapter.ProductoRecyclerViewAdapter;
import com.geomi.carritocompras.modelo.Producto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CocinaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;
    RecyclerView rvCocina;
   //RecyclerView rvCocina;

    List<Producto> productos;

    public CocinaFragment() {
        // Required empty public constructor
    }

    public static CocinaFragment newInstance(String param1, String param2) {
        CocinaFragment fragment = new CocinaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cocina, container, false);
        //productos = new ArrayList<>();
        //ButterKnife.bind(this,view);
        LinearLayoutManager lm= new LinearLayoutManager(this.getContext());
        rvCocina.setHasFixedSize(true);
        rvCocina.setLayoutManager(lm);
        rvCocina = (RecyclerView)view.findViewById(R.id.rvCocina);
        rvCocina.setLayoutManager(new LinearLayoutManager(getContext()));
        initializeData();
        ProductoRecyclerViewAdapter adapter = new ProductoRecyclerViewAdapter(getContext(),productos);
        rvCocina.setAdapter(adapter);
        
        //Picasso.get().load("https://images-na.ssl-images-amazon.com/images/I/41cVtobFMBL._AC_US160_.jpg")

        return view;
    }

   private void initializeData(){
       

        /*productos.add(new Producto("1", "Forro", "Forro navideño para botella de vino","$3.00", "4.3",
                "https://img.ltwebstatic.com/origin/images2_pi/2018/09/28/15381070421547207879_im_405x552.jpg" ));
        productos.add(new Producto("2", "Forros", "Forros de navidad para cubiertos","$2.00", "5.0",
                "https://img.ltwebstatic.com/origin/images2_pi/2018/09/28/15381070481435011005_im_405x552.jpg" ));
        productos.add(new Producto("3", "Pegatinas", "pegatinas decorativas para cocina","$5.00", "3.3",
                "https://img.ltwebstatic.com/origin/images2_pi/2018/09/26/15379542214115232479_im_405x552.jpg" ));*/
        productos.add(new Producto(1, "Cafetera", "Keurig k55 Cafetera color negro",85.50, 4.3,
                R.drawable.cafetera ));
        productos.add(new Producto(2, "Wafflera", "Presto 03510 Ceramic",27.99, 4.3,
             R.drawable.wafflera));
        productos.add(new Producto(3, "NutriBullet Pro", "13-Piece High- Speed Blender",79.99, 5.0,
                 R.drawable.magicbuller));
       //  productos.add(new Producto("7", "Plato de piña 8pcs", "Plato desechable en forma de piña","$5.00", "1.3",
           //     "https://img.ltwebstatic.com/origin/images2_pi/2018/08/11/15339552932007217440_im_405x552.jpg" ));

    }
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
