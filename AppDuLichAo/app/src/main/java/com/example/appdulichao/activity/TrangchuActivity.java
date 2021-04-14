package com.example.appdulichao.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ViewFlipper;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.appdulichao.R;
import com.example.appdulichao.adapter.TypeaccessAdapter;
import com.example.appdulichao.model.Typeaccess;
import com.example.appdulichao.ultil.CheckConnection;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class TrangchuActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    RecyclerView recyclerViewTrangChu;
    NavigationView navigationView;
    ListView listViewTrangChu;
    DrawerLayout drawerLayout;
    ArrayList<Typeaccess> mangtypeaccess;
    TypeaccessAdapter typeaccessAdapter;
    DatabaseReference mDatabase;

    int gallery_grid_images[]={R.drawable.viewflipper1, R.drawable.viewflipper2, R.drawable.viewflipper3, R.drawable.viewflipper4,
            R.drawable.viewflipper5, R.drawable.viewflipper6, R.drawable.viewflipper7, R.drawable.viewflipper8};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        Anhxa();
        if(CheckConnection.haveNetworkConnection(getApplicationContext())){
            mDatabase = FirebaseDatabase.getInstance().getReference();
            ActionBar();
            ActionMenuViewFlipper();
            GetDuLieuTypeaccess();
        }else {
            CheckConnection.ShowToast_Short(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối");
            finish();
        }

    }



    private void GetDuLieuTypeaccess() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        // mDatabase.child("TypeAccess")
    }

    private void setFlipperImage(int res) {
        ImageView image = new ImageView(getApplicationContext());
        image.setBackgroundResource(res);
        image.setScaleType(ImageView.ScaleType.FIT_XY);
        viewFlipper.addView(image);
    }

    private void ActionMenuViewFlipper() {
        for(int i=0; i<gallery_grid_images.length; i++)
        {
            setFlipperImage(gallery_grid_images[i]);
        }
        viewFlipper.setFlipInterval(5000);
        viewFlipper.setAutoStart(true);
        Animation animation_Slide_in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_in_right);
        Animation animation_Slide_out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_out_right);
        viewFlipper.setInAnimation(animation_Slide_in);
        viewFlipper.setOutAnimation(animation_Slide_out);
    }

    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    private void Anhxa() {
        toolbar = (Toolbar) findViewById(R.id.toolbarTrangChu);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
        recyclerViewTrangChu = (RecyclerView) findViewById(R.id.recyclerviewTrangChu);
        navigationView = (NavigationView) findViewById(R.id.navigationview);
        listViewTrangChu = (ListView) findViewById(R.id.listviewTrangChu);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        mangtypeaccess = new ArrayList<>();
        typeaccessAdapter = new TypeaccessAdapter(mangtypeaccess, getApplicationContext());
        listViewTrangChu.setAdapter(typeaccessAdapter);
    }


}