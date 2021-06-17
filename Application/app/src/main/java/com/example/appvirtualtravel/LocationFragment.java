package com.example.appvirtualtravel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import com.example.appvirtualtravel.Activity.TravelLocationAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class LocationFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@Nonnull LayoutInflater inflater, @Nonnull ViewGroup container, @Nullable Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location, container, false);

        ViewPager2 locationViewPager = view.findViewById(R.id.locationViewPager);

        List<TravelLocation> travelLocations = new ArrayList<>();

        TravelLocation travelLocation1 = new TravelLocation();
        travelLocation1.imageUrl = "https://i.ibb.co/FqyCvY5/eiffeltower.jpg";
        travelLocation1.title = "France";
        travelLocation1.location = "Eiffel Tower";
        travelLocation1.starRating = 4.8f;
        travelLocations.add(travelLocation1);

        TravelLocation travelLocation2 = new TravelLocation();
        travelLocation2.imageUrl = "https://i.ibb.co/Gngdtw2/indonesia-mountain.jpg";
        travelLocation2.title = "Indonesia";
        travelLocation2.location = "Mountain View";
        travelLocation2.starRating = 4.5f;
        travelLocations.add(travelLocation2);

        TravelLocation travelLocation3 = new TravelLocation();
        travelLocation3.imageUrl = "https://i.ibb.co/4pBKBGw/cotco-hanoi.jpg";
        travelLocation3.title = "Hà Nội";
        travelLocation3.location = "Cột Cờ Hà Nội";
        travelLocation3.starRating = 5.0f;
        travelLocations.add(travelLocation3);

        TravelLocation travelLocation4 = new TravelLocation();
        travelLocation4.imageUrl = "https://i.ibb.co/TYQkxsj/taj-mahal.jpg";
        travelLocation4.title = "Ấn Độ";
        travelLocation4.location = "Taj Mahal";
        travelLocation4.starRating = 3.6f;
        travelLocations.add(travelLocation4);

        locationViewPager.setAdapter(new TravelLocationAdapter(travelLocations));
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
}
