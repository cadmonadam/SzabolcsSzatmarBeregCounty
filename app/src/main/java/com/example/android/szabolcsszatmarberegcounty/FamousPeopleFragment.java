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
public class FamousPeopleFragment extends Fragment {

    public FamousPeopleFragment() {
        // This is the empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // This is the list of famous people who were born in the County.
        final ArrayList<place> places = new ArrayList<place>();
        places.add(new place(getString(R.string.vay), getString(R.string.vay_description), getString(R.string.vay_url), R.drawable.vay));
        places.add(new place(getString(R.string.bessenyei), getString(R.string.bessenyei_description), getString(R.string.bessenyei_url), R.drawable.bessenyei));
        places.add(new place(getString(R.string.lonyay), getString(R.string.lonyay_description), getString(R.string.lonyay_url), R.drawable.lonyay));
        places.add(new place(getString(R.string.vasvari), getString(R.string.vasvari_description), getString(R.string.vasvari_url), R.drawable.vasvari));
        places.add(new place(getString(R.string.koranyi), getString(R.string.koranyi_description), getString(R.string.koranyi_url), R.drawable.koranyi));
        places.add(new place(getString(R.string.benczur), getString(R.string.benczur_description), getString(R.string.benczur_url), R.drawable.benczur));
        places.add(new place(getString(R.string.krudy), getString(R.string.krudy_description), getString(R.string.krudy_url), R.drawable.krudy));
        places.add(new place(getString(R.string.moricz), getString(R.string.moricz_description), getString(R.string.moricz_url), R.drawable.moricz));

        // Create a new {@link ArrayAdapter} for Famous People category.
        final PlaceAdapter adapter = new PlaceAdapter(getActivity(), places, R.color.tab_famousPeople);

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
