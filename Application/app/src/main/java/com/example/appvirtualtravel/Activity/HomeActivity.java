package com.example.appvirtualtravel.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.example.appvirtualtravel.HomeFragment;
import com.example.appvirtualtravel.LocationFragment;
import com.example.appvirtualtravel.ProfileFragment;
import com.example.appvirtualtravel.R;
import com.example.appvirtualtravel.TravelLocation;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    String mFullName, mEmail, mPassword, mPhone, mGender;
    String profileFullname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();

        toolbar = findViewById(R.id.toolbarMenu);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        //load default fragment
        fragmentManager  = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment, new HomeFragment());
        fragmentTransaction.commit();

        DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                profileFullname = value.getString("fullname");
                mFullName = value.getString("fullname");
                mEmail = value.getString("email");
                mPassword = value.getString("password");
                mPhone = value.getString("phone");
                mGender = value.getString("gender");
            }
        });

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if(item.getItemId() == R.id.home){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_fragment, new HomeFragment());
            fragmentTransaction.commit();
        }
        if(item.getItemId() == R.id.profile){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            final ProfileFragment profileFragment = new ProfileFragment();

            Bundle profileFrag1 = new Bundle();
            profileFrag1.putString("fullname",mFullName);
            profileFrag1.putString("email",mEmail);
            profileFrag1.putString("password",mPassword);
            profileFrag1.putString("phone",mPhone);
            profileFrag1.putString("gender",mGender);

            profileFragment.setArguments(profileFrag1);

            fragmentTransaction.replace(R.id.container_fragment, profileFragment);
            fragmentTransaction.commit();
        }
        if(item.getItemId() == R.id.location){
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            final LocationFragment locationFragment = new LocationFragment();



            Bundle locationFrag = new Bundle();


            fragmentTransaction.replace(R.id.container_fragment, locationFragment);
            fragmentTransaction.commit();
        }
        if(item.getItemId() == R.id.search){

        }
        if(item.getItemId() == R.id.emailcontact){

        }
        if(item.getItemId() == R.id.phonecontact){

        }
        if(item.getItemId() == R.id.logout){
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            finish();
        }
        return true;
    }
}