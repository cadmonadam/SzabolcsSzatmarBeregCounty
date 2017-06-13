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
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // list of Drinking locations
        final ArrayList<place> places = new ArrayList<place>();
        places.add(new place("Balsa Ecotourism Visitor Center", " Situated on the banks of the river Tisza in a unique natural environment.", "https://www.programturizmus.hu/partner-balsai-okoturisztikai-latogatokozpont.html",  R.drawable.balsa ));
        places.add(new place("Luby Castle Museum and Garden of Ancient Roses", "In Kincses Island of Szatmár, the Luby Castle is located in Nagyar. The unusual mansion is surrounded by Hungary's largest musician's rose garden.", "https://www.programturizmus.hu/partner-luby-kastelymuzeum.html",  R.drawable.luby ));
        places.add(new place("János Tuzson Botanical Garden", "Situated in the vicinity of the beautiful Sóstó forest, in the embrace of College of Nyíregyháza.", "https://www.programturizmus.hu/partner-tuzson-janos-botanikus-kert-nyiregyhaza.html",  R.drawable.garden ));
        places.add(new place("Country House in Szatmárcseke", "The country house was built in the 18th century, with straw roof, furnished with folk furniture.", "https://www.programturizmus.hu/partner-szatmarcsekei-tajhaz-szatmarcseke.html",  R.drawable.tajhaz ));
        places.add(new place("Water Mill in Turistvándi", "The Water mill was built at the end of the 18th century. It offers a spectacular view with its protected monumental surroundings.", "https://www.programturizmus.hu/partner-vizimalom-turistvandi.html//",  R.drawable.vizimalom ));
        places.add(new place("Dovas", "Beer 50cl from 35sek", "https://www.tripadvisor.se/Restaurant_Review-g189852-d7211992-Reviews-Dovas_Hornsgatan_90-Stockholm.html//" ));
        places.add(new place("Lasse i Parken", "Bands play outside most nights for free in the summer months", "https://www.lasseiparken.se/",  R.drawable.lasseiparken ));
        places.add(new place("Viking Bar", "50cl Beer 39sek", "https://foursquare.com/v/viking-bar/51a12a8b498eeb0fb7ba2a13/",  R.drawable.vikingbar ));

        // Create a new {@link ArrayAdapter} for drinking category
        final placesAdapter adapter = new placesAdapter(getActivity(), places, R.color.category_drinking);

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
