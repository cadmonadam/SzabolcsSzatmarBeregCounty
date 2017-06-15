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
public class MustSeeTownsFragment extends Fragment {

    public MustSeeTownsFragment() {
        // This is the empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // This is the list of the towns which are worth wisiting for tourists.
        final ArrayList<place> places = new ArrayList<place>();
        places.add(new place(getString(R.string.nyiregyhaza_title), getString(R.string.nyiregyhaza_description), getString(R.string.nyiregyhaza_url), R.drawable.nyiregyhaza));
        places.add(new place(getString(R.string.tiszadob_title), getString(R.string.tiszadob_description), getString(R.string.tiszadob_url), R.drawable.tiszadob));
        places.add(new place(getString(R.string.bakta_title), getString(R.string.bakta_description), getString(R.string.bakta_url), R.drawable.bakta));
        places.add(new place(getString(R.string.tuzser), getString(R.string.tuzser_description), getString(R.string.tuzser_url), R.drawable.tuzser));
        places.add(new place(getString(R.string.kisvarda), getString(R.string.kisvarda_description), getString(R.string.kisvarda_url), R.drawable.kisvarda));
        places.add(new place(getString(R.string.mateszalka), getString(R.string.mateszalka_description), getString(R.string.mateszalka_url), R.drawable.mateszalka));
        places.add(new place(getString(R.string.mariapocs), getString(R.string.mariapocs_description), getString(R.string.mariapocs_url), R.drawable.mariapocs));
        places.add(new place(getString(R.string.vajamuseum), getString(R.string.vajamuseum_description), getString(R.string.vajamuseum_url), R.drawable.vaja));


        // Create a new {@link ArrayAdapter} for Must-See Towns category
        final placesAdapter adapter = new placesAdapter(getActivity(), places, R.color.tab_mustSeeTowns);

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
