package com.example.android.szabolcsszatmarberegcounty;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EntertainmentFacilitiesFragment extends Fragment {

    public EntertainmentFacilitiesFragment() {
        // This is the empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // This is the list of Entertainment Facilities
        final ArrayList<place> places = new ArrayList<place>();
        places.add(new place(getString(R.string.sostovillage), getString(R.string.sostovillage_description), getString(R.string.sostovillage_url),  R.drawable.sostovillage ));
        places.add(new place(getString(R.string.sostozoo), getString(R.string.sostozoo_description), getString(R.string.sostozoo_url),  R.drawable.sostozoo ));
        places.add(new place(getString(R.string.sostospa), getString(R.string.sostospa_description), getString(R.string.sostospa_url),  R.drawable.sostofurdo ));
        places.add(new place(getString(R.string.rabocsiring), getString(R.string.rabocsiring_description), getString(R.string.rabocsiring_url),  R.drawable.rabocsiring ));
        places.add(new place(getString(R.string.fedeles), getString(R.string.fedeles_description), getString(R.string.fedeles_url),  R.drawable.fedeleslovarda ));
        places.add(new place(getString(R.string.waterski), getString(R.string.waterski_description), getString(R.string.waterski_url),  R.drawable.waterski ));
        places.add(new place(getString(R.string.albatros), getString(R.string.albatros_description), getString(R.string.albatros_url), R.drawable.albatros ));
        places.add(new place(getString(R.string.tyukod), getString(R.string.tyukod_description), getString(R.string.tyukod_url),  R.drawable.tyukod ));


        // Create a new {@link ArrayAdapter} for shopping category
        final placesAdapter adapter = new placesAdapter(getActivity(), places, R.color.category_shopping);

        // Find a reference to the {@link ListView} in the layout
        final ListView placesListView = (ListView) rootView.findViewById(R.id.list);
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        placesListView.setAdapter(adapter);
        placesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                place currentPlace = adapter.getItem(position);
                Uri placeUri = Uri.parse(currentPlace.getUrl());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, placeUri);
                startActivity(websiteIntent);
            }
        });
        return rootView;
    }
}
