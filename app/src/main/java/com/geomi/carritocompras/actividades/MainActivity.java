package com.geomi.carritocompras.actividades;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.geomi.carritocompras.R;
import com.geomi.carritocompras.modelo.Producto;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    Producto producto;


    CardView registrarse;
    CardView ir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        registrarse = (CardView) findViewById(R.id.view1);
        ir = (CardView)findViewById(R.id.view);

        ir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(MainActivity.this, MainNavigation.class);
                startActivity(ir);
            }
        });


        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrarse = new Intent(MainActivity.this, MainRegistrarse.class);
                startActivity(registrarse);

            }
        });
    }


}
