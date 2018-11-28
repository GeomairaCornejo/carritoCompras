package com.geomi.carritocompras.actividades;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.geomi.carritocompras.R;
import com.geomi.carritocompras.fragments.CarritoFragment;
import com.geomi.carritocompras.fragments.CocinaFragment;
import com.geomi.carritocompras.fragments.ComedorFragment;
import com.geomi.carritocompras.fragments.DormitorioFragment;

public class MainNavigation extends AppCompatActivity
        implements NavigationView.
        OnNavigationItemSelectedListener
        , CocinaFragment.OnFragmentInteractionListener
        , ComedorFragment.OnFragmentInteractionListener
        , DormitorioFragment.OnFragmentInteractionListener
        ,CarritoFragment.OnFragmentInteractionListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action",null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        /*Fragment fragment = new CocinaFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.nav_cocina,fragment).commit();*/

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);
        //showFragment(CocinaFragment.class);
    }

    private void showFragment(Class fragmentClass) {
        Fragment fragment = null;
        try{
            fragment=(Fragment) fragmentClass.newInstance();
        }catch (InstantiationException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }
        FragmentManager fragmentManager= getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.nav_cocina, fragment)
                .commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Class fragment = null;


        if (id == R.id.nav_carrito) {
            fragment = CarritoFragment.class;
            showFragment(fragment);
            // Handle the camera action
        } else if (id == R.id.nav_cocina) {
            fragment = CocinaFragment.class;
            showFragment(fragment);
        } else if (id == R.id.nav_comedor) {
            fragment = ComedorFragment.class;
            showFragment(fragment);
        } else if (id == R.id.nav_dormitorio) {
            fragment = DormitorioFragment.class;
            showFragment(fragment);
        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {


        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
