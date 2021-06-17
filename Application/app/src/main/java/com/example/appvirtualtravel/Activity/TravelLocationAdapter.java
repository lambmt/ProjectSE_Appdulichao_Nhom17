package com.example.appvirtualtravel.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appvirtualtravel.R;
import com.example.appvirtualtravel.TravelLocation;
import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TravelLocationAdapter extends RecyclerView.Adapter<TravelLocationAdapter.TravelLocationViewHolder>{

    private List<TravelLocation> travelLocations;

    public TravelLocationAdapter(List<TravelLocation> travelLocations) {
        this.travelLocations = travelLocations;
    }

    @NonNull
    @Override
    public TravelLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TravelLocationViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_location,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull TravelLocationAdapter.TravelLocationViewHolder holder, int position) {
        holder.setLocationData(travelLocations.get(position));
    }

    @Override
    public int getItemCount() {
        return travelLocations.size();
    }

    public class TravelLocationViewHolder extends RecyclerView.ViewHolder{

        KenBurnsView kbvLocation;
        TextView textTitle, textLocation, textStarRating;

        public TravelLocationViewHolder(View itemView) {
            super(itemView);
            kbvLocation = itemView.findViewById(R.id.kbvLocation);
            textTitle = itemView.findViewById(R.id.textTitle);
            textLocation = itemView.findViewById(R.id.textLocation);
            textStarRating = itemView.findViewById(R.id.textStarRating);

        }
        void setLocationData(TravelLocation travelLocation){
            Picasso.get().load(travelLocation.imageUrl).into(kbvLocation);
            textTitle.setText(travelLocation.title);
            textLocation.setText(travelLocation.location);
            textStarRating.setText(String.valueOf(travelLocation.starRating));
        }
    }
}
