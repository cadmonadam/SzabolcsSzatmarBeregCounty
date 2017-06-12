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
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // list of Museum locations
        final ArrayList<place> places = new ArrayList<place>();
        places.add(new place(getString(R.string.nyiregyhaza_title), getString(R.string.nyiregyhaza_description), getString(R.string.nyiregyhaza_url), R.drawable.nyiregyhaza ));
        places.add(new place(getString(R.string.tiszadob_title), getString(R.string.tiszadob_description), getString(R.string.tiszadob_url), R.drawable.tiszadob ));
        places.add(new place(getString(R.string.bakta_title), "Explore the shiny Dregenfel Castle Museum.", "https://www.programturizmus.hu/telepules-baktaloranthaza.html", R.drawable.bakta ));
        places.add(new place("Tuzsér", "Discover the Lonyay Castle an its surroundings.", "https://www.programturizmus.hu/partner-lonyai-kastely-tuzser.html", R.drawable.tuzser ));
        places.add(new place("Kisvárda", "Find interesting artifacts in the Castle Museum", "https://www.programturizmus.hu/partner-retkozi-muzeum-kisvarda.html", R.drawable.kisvarda ));
        places.add(new place("Mátészalka", "You will love this unique Rail Historical Collection.", "https://www.programturizmus.hu/partner-vasuti-helytorteneti-gyujtemeny-mateszalka.html", R.drawable.mateszalka ));
        places.add(new place("Máriapócs", "The world famous catholic church where real miracles happened.", "http://mariapocskegyhely.hu/", R.drawable.mariapocs ));
        places.add(new place("Vaja", "The Castle of Vay Adam commemorates the Rakoczi War of Independence.", "https://www.programturizmus.hu/partner-vay-adam-muzeum-vaja.html", R.drawable.vaja ));


        // Create a new {@link ArrayAdapter} for museum category
        final placesAdapter adapter = new placesAdapter(getActivity(), places, R.color.category_museums);

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
