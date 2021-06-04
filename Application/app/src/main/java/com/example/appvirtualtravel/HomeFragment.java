package com.example.appvirtualtravel;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import androidx.fragment.app.Fragment;

import com.example.appvirtualtravel.R;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class HomeFragment extends Fragment {
    ViewFlipper viewFlipper;
    Animation in, out;
    @Nullable
    @Override
    public View onCreateView(@Nonnull LayoutInflater inflater, @Nonnull ViewGroup container, @Nullable Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.fragment_home, container,false);

        viewFlipper = (ViewFlipper) view.findViewById(R.id.viewflipper);
        in = AnimationUtils.loadAnimation(view.getContext(), R.anim.fade_in);
        out = AnimationUtils.loadAnimation(view.getContext(), R.anim.fade_out);
        viewFlipper.setInAnimation(in);
        viewFlipper.setOutAnimation(out);
        viewFlipper.setFlipInterval(2500);
        viewFlipper.setAutoStart(true);
        return view;
    }
}
