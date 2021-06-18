package com.example.appvirtualtravel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import java.util.List;

public class TravelLocationAdapter extends RecyclerView.Adapter<TravelLocationAdapter.TravelLocationViewHolder>{

    List<TravelLocation> travelLocations;

    public TravelLocationAdapter(List<TravelLocation> travelLocations) {
        this.travelLocations = travelLocations;
    }

    @NonNull
    @Override
    public TravelLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_container_location, parent, false);
        return new TravelLocationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TravelLocationAdapter.TravelLocationViewHolder holder, int position) {
        holder.locationID = travelLocations.get(position).getLocation_id();
        holder.textLocationName.setText(travelLocations.get(position).getLocation_name());
        holder.textProvince.setText(travelLocations.get(position).getProvince());
        holder.imageLink = travelLocations.get(position).getImage_link();
        holder.textStarRating.setText(String.valueOf(travelLocations.get(position).getStarrating()));

    }

    @Override
    public int getItemCount() {
        return travelLocations.size();
    }

    public class TravelLocationViewHolder extends RecyclerView.ViewHolder{

        KenBurnsView kbvLocation;
        TextView textProvince, textLocationName, textStarRating;
        String locationID, imageLink;

        public TravelLocationViewHolder(View itemView) {
            super(itemView);
            kbvLocation = itemView.findViewById(R.id.kbvLocation);
            textLocationName = itemView.findViewById(R.id.textLocationName);
            textProvince = itemView.findViewById(R.id.textProvince);
            textStarRating = itemView.findViewById(R.id.textStarRating);

        }
        void setLocationData(TravelLocation travelLocation){
            Picasso.get().load(imageLink).into(kbvLocation);
            textLocationName.setText(travelLocation.location_name);
            textProvince.setText(travelLocation.province);
            textStarRating.setText(String.valueOf(travelLocation.starrating));
            locationID = travelLocation.location_id;
        }
    }
}
