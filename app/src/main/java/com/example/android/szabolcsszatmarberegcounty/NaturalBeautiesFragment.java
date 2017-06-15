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
public class NaturalBeautiesFragment extends Fragment {

    public NaturalBeautiesFragment() {
        // This is the empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // This is the list of the most beautiful natural formations in the county.
        final ArrayList<place> places = new ArrayList<place>();
        places.add(new place(getString(R.string.balsa), getString(R.string.balsa_description), getString(R.string.balsa_url), R.drawable.balsa));
        places.add(new place(getString(R.string.luby), getString(R.string.luby_description), getString(R.string.luby_url), R.drawable.luby));
        places.add(new place(getString(R.string.botanical), getString(R.string.botanical_description), getString(R.string.botanical_url), R.drawable.garden));
        places.add(new place(getString(R.string.szatmarcseke), getString(R.string.szatmarcseke_description), getString(R.string.szatmarcseke_url), R.drawable.tajhaz));
        places.add(new place(getString(R.string.turistvandi), getString(R.string.turistvandi_description), getString(R.string.turistvandi_url), R.drawable.vizimalom));
        places.add(new place(getString(R.string.tiszatelek), getString(R.string.tiszatelek_description), getString(R.string.tiszatelek_url), R.drawable.tiszabercel));
        places.add(new place(getString(R.string.vajalake), getString(R.string.vajalake_description), getString(R.string.vajalake_url), R.drawable.vajaito));
        places.add(new place(getString(R.string.kaszony), getString(R.string.kaszony_description), getString(R.string.kaszony_url), R.drawable.kaszony));

        // Create a new {@link ArrayAdapter} for natural beauties category
        final placesAdapter adapter = new placesAdapter(getActivity(), places, R.color.tab_naturalBeauties);

        // Find a reference to the {@link ListView} in the layout
        final ListView placesListView = (ListView) rootView.findViewById(R.id.list);
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        placesListView.setAdapter(adapter);

        //Setting up OnItemClickListener in order to start a new intent (open a website) when the user click on an item.
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
