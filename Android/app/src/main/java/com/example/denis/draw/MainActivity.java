package com.example.denis.draw;

import android.content.pm.ActivityInfo;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Data data = Data.getInstance();
    DDraw dr;
    Toast toast;
//    LinearLayout toastView;
//    ImageView imgcurve;
//    ImageView imgline;
//    ImageView imgcircle;
//    ImageView imgrect;

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
        dr = new DDraw(data, this);
        LinearLayoutCompat ln = (LinearLayoutCompat)findViewById(R.id.linear);
        ln.addView(dr);

        toast = Toast.makeText(this,"",Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);



//        toastView = (LinearLayout) toast.getView();
//        imgcurve = new ImageView(this);
//        imgline = new ImageView(this);
//        imgrect = new ImageView(this);
//        imgcircle = new ImageView(this);
//
//        imgline.setImageResource(R.drawable.line);
//        imgcircle.setImageResource(R.drawable.circle);
//        imgrect.setImageResource(R.drawable.rectangle);
//        imgcurve.setImageResource(R.drawable.curve);


        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.black) {
            data.setColor(Color.BLACK);
            toast.setText("Selected: color black");
            toast.show();
        }
        else if (id == R.id.red) {

            data.setColor(Color.RED);
            toast.setText("Selected: color red");
            toast.show();
        }
        else if (id == R.id.green) {
            data.setColor(Color.GREEN);
            toast.setText("Selected: color green");
            toast.show();
        }
        else if (id == R.id.thin) {
            data.setWidth(5);
            toast.setText("Selected: width thin");
            toast.show();
        }
        else if (id == R.id.mid) {
            data.setWidth(10);
            toast.setText("Selected: width middle");
            toast.show();
        }
        else if (id == R.id.fat) {
            data.setWidth(15);
            toast.setText("Selected: width fat");
            toast.show();
        }
        else if (id == R.id.rectangle) {
            data.setType("rectangle");
            toast.setText("Selected figure rectangle");
            toast.show();
        }
        else if (id == R.id.oval) {
            data.setType("oval");
            toast.setText("Selected figure circle");
            toast.show();
        }
        else if (id == R.id.line) {
            data.setType("line");
            toast.setText("Selected figure line");
            toast.show();
        }
        else if (id == R.id.curve) {
            data.setType("curves");
            toast.setText("Selected figure curve");
            toast.show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
       // drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
