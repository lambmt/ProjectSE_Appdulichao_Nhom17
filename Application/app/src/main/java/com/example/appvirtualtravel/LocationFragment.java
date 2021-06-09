package com.example.appvirtualtravel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class LocationFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@Nonnull LayoutInflater inflater, @Nonnull ViewGroup container, @Nullable Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ViewPager2 locationViewPage = view.findViewById(R.id.locationViewPager);

        List<TravelLocation> travelLocations = new ArrayList<>();

        TravelLocation travelLocation1 = new TravelLocation();
        travelLocation1.imageUrl = "https://www.architecturaldigest.com/story/paris-eiffel-tower-reopens-major-restrictions";

        return view;
    }
}
