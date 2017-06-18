package com.example.android.szabolcsszatmarberegcounty;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<place> {

    private int mColorResourceID;

    public PlaceAdapter(Context context, ArrayList<place> pPlaces, int colorResourceID) {
        super(context, 0, pPlaces);
        mColorResourceID = colorResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listView = convertView;
        if (listView == null) {
            listView = LayoutInflater.from(getContext()).inflate(R.layout.display_activity, parent, false);
        }

        //get the object located at given position
        place currentPlace = getItem(position);

        // Find the TextView with ID name
        TextView name = (TextView) listView.findViewById(R.id.name);
        name.setText(currentPlace.getName());

        // Find the TextView with ID description
        TextView description = (TextView) listView.findViewById(R.id.description);
        description.setText(currentPlace.getDescription());

        // Find the background color
        View container = listView.findViewById(R.id.container);
        int color = ContextCompat.getColor(getContext(), mColorResourceID);
        container.setBackgroundColor(color);

        // Find the ImageView in the places_list.xml layout with the ID image.
        ImageView imageView = (ImageView) listView.findViewById(R.id.image);
        // Here we can check that there is an image provided or not
        if (currentPlace.hasImage()) {
            // If it is provided display it an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentPlace.getmImageResourceId());
            // and set it visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // If it is not provided hide the ImageView
            imageView.setVisibility(View.GONE);
        }
        //Setting up the background color for the imageView
        imageView.setImageResource(currentPlace.getmImageResourceId());
        imageView.setBackgroundColor(color);

        return listView;
    }
}
