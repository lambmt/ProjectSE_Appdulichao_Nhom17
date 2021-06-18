package com.example.appvirtualtravel;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.appvirtualtravel.Activity.HomeActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class LocationFragment extends Fragment {

    TextView mFullName;
    List<TravelLocation> travelLocations;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    TravelLocationAdapter travelLocationAdapter;
    @Nullable
    @Override
    public View onCreateView(@Nonnull LayoutInflater inflater, @Nonnull ViewGroup container, @Nullable Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location, container, false);

        mFullName = view.findViewById(R.id.textHello);
        ViewPager2 locationViewPager = view.findViewById(R.id.locationViewPager);

        Bundle locationFrag2 = getArguments();
        String fullname = locationFrag2.getString("fullname");
        mFullName.setText("Hello, "+fullname);

        travelLocations= new ArrayList<>();
        travelLocationAdapter = new TravelLocationAdapter(travelLocations);
        locationViewPager.setAdapter(travelLocationAdapter);

        fStore = FirebaseFirestore.getInstance();

        GetDataLoation();

        locationViewPager.setClipToPadding(false);
        locationViewPager.setClipChildren(false);
        locationViewPager.setOffscreenPageLimit(3);
        locationViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.95f + r*0.05f);
            }
        });

        locationViewPager.setPageTransformer(compositePageTransformer);



        return view;
    }

    private void GetDataLoation() {
        fStore.collection("location_list").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
                        for (DocumentSnapshot d:list){
                            TravelLocation obj = d.toObject(TravelLocation.class);
                            travelLocations.add(obj);

                        }
                        //update adapter
                        travelLocationAdapter.notifyDataSetChanged();
                    }
                });
    }
}
