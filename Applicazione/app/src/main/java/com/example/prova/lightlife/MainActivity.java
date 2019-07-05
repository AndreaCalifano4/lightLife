package com.example.prova.lightlife;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        i = getIntent();
        sqliteHelper = new SqliteHelper(this);
        User u = sqliteHelper.getUtente(i.getStringExtra("email"));
        if(u.soul.equals("Cliente")){
            HomePageClienteFragment homePageClienteFragment = new HomePageClienteFragment();
            Bundle arg = new Bundle();
            arg.putBoolean("flag", i.getBooleanExtra("flag", false));
            homePageClienteFragment.setArguments(arg);
            getSupportFragmentManager().beginTransaction().replace(R.id.container, homePageClienteFragment).addToBackStack("tag").commit();
        }
    }
    /*
        public void onDeleteClick(View v){
        int position = Integer.parseInt(v.getTag().toString());
        CarrelloFragment c = (CarrelloFragment) getSupportFragmentManager().findFragmentByTag("carrello");
        Bundle b = new Bundle();
        b.putInt("position", position);
        c.setArguments(b);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, c, "carrello").addToBackStack("carrello").commit();
    }
     */
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
        getMenuInflater().inflate(R.menu.main, menu);

        final MenuItem menuItem = menu.findItem(R.id.action_cart);
        View actionView = MenuItemCompat.getActionView(menuItem);
        textCartItemCount = actionView.findViewById(R.id.cart_badge);
        setupBadge();
        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);
            }
        });
        return true;
    }

    private void setupBadge() {

        if (textCartItemCount != null) {
            if (mCartItemCount == 0) {
                if (textCartItemCount.getVisibility() != View.GONE) {
                    textCartItemCount.setVisibility(View.GONE);
                }
            } else {
                textCartItemCount.setText(String.valueOf(Math.min(mCartItemCount, 99)));
                if (textCartItemCount.getVisibility() != View.VISIBLE) {
                    textCartItemCount.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cart) {
            getSupportActionBar().setTitle("Carrello");
            if(getSupportFragmentManager().findFragmentByTag("carrello") == null){
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new CarrelloVuotoFragment()).addToBackStack("carrelloVuoto").commit();
            } else{
                getSupportFragmentManager().beginTransaction().replace(R.id.container, getSupportFragmentManager().findFragmentByTag("carrello"), "carrello").addToBackStack("carrello").commit();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home) {
            getSupportActionBar().setTitle(item.getTitle());
            i = getIntent();
            sqliteHelper = new SqliteHelper(this);
            User u = sqliteHelper.getUtente(i.getStringExtra("email"));
            if(u.soul.equals("Cliente")){
                getSupportFragmentManager().beginTransaction().replace(R.id.container,  new HomePageClienteFragment()).addToBackStack("tag").commit();
            }
        } else if (id == R.id.problemi) {
            getSupportActionBar().setTitle(item.getTitle());
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new ProblemiFragment()).addToBackStack("tag").commit();
        } else if (id == R.id.rimedi) {
            getSupportActionBar().setTitle(item.getTitle());
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new RimediFragment()).addToBackStack("tag").commit();
        } else if (id == R.id.puntiVendita) {
            getSupportActionBar().setTitle(item.getTitle());
            Intent geoIntent = new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=" + "Erboristeria"));
            startActivity(geoIntent);
        } else if (id == R.id.negozio) {
            getSupportActionBar().setTitle(item.getTitle());
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new NegozioFragment()).addToBackStack("negozio").commit();
        } else if (id == R.id.carrello) {
            getSupportActionBar().setTitle(item.getTitle());
            if(getSupportFragmentManager().findFragmentByTag("carrello") == null){
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new CarrelloVuotoFragment()).addToBackStack("carrelloVuoto").commit();
            } else{
                getSupportFragmentManager().beginTransaction().replace(R.id.container, getSupportFragmentManager().findFragmentByTag("carrello"), "carrello").addToBackStack("carrello").commit();
            }
        } else if (id == R.id.areaUtente) {
            getSupportActionBar().setTitle(item.getTitle());
            Bundle arg = new Bundle();
            arg.putString("email", i.getStringExtra("email"));
            if(getSupportFragmentManager().findFragmentByTag("areaUtente") == null){
                AreaUtenteFragment areaUtente = new AreaUtenteFragment();
                arg.putBoolean("ultimoOrd", false);
                areaUtente.setArguments(arg);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, areaUtente).addToBackStack("areaUtente").commit();
            } else{
                AreaUtenteFragment areaUtente = (AreaUtenteFragment) getSupportFragmentManager().findFragmentByTag("areaUtente");
                arg.putBoolean("ultimoOrd", true);
                areaUtente.setArguments(arg);
                getSupportFragmentManager().beginTransaction().replace(R.id.container, areaUtente, "areaUtente").addToBackStack("areaUtente").commit();
            }
        }else if (id == R.id.logout) {
            Intent login = new Intent();
            login.setClass(getApplicationContext(), LoginActivity.class);
            startActivity(login);
            finish();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    SqliteHelper sqliteHelper;
    TextView textCartItemCount;
    int mCartItemCount = 0;
    Intent i;
}
