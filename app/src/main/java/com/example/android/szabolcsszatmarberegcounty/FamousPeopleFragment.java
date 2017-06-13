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
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.places_list, container, false);

        // list of Eating locations
        final ArrayList<place> places = new ArrayList<place>();
        places.add(new place("Vay Ádám (1657 – 1719)", "General in Revolution and War of Independence of II. Rákóczi Ferenc", "https://hu.wikipedia.org/wiki/Vay_%C3%81d%C3%A1m_%28f%C5%91kapit%C3%A1ny%29",  R.drawable.vay ));
        places.add(new place("Bessenyei György (1746 – 1811)", "Poet, one of the major personalities of the Hungarian Enlightenment Movement.", "https://hu.wikipedia.org/wiki/Bessenyei_Gy%C3%B6rgy",  R.drawable.bessenyei ));
        places.add(new place("Lónyay Menyhért (1822 – 1884)", "Politician, prime minister, publicist, president of the Hungarian Academy of Sciences.", "https://hu.wikipedia.org/wiki/L%C3%B3nyay_Menyh%C3%A9rt",  R.drawable.lonyay ));
        places.add(new place("Vasvári Pál (1826 – 1849)", "Writer, historian, philosopher, politician, revolutionist.", "https://hu.wikipedia.org/wiki/Vasv%C3%A1ri_P%C3%A1l_%28t%C3%B6rt%C3%A9n%C3%A9sz%29",  R.drawable.vasvari ));
        places.add(new place("Korányi Frigyes (1828 – 1913)", "Doctor, university professor, one of the determinants in Hungarian Medicine.", "https://hu.wikipedia.org/wiki/Kor%C3%A1nyi_Frigyes_(orvos)",  R.drawable.koranyi ));
        places.add(new place("Benczúr Gyula (1844 – 1920)", "Famous painter, honorary member of the Hungarian Academy of Sciences.", "https://hu.wikipedia.org/wiki/Bencz%C3%BAr_Gyula_%28fest%C5%91m%C5%B1v%C3%A9sz%29",  R.drawable.benczur ));
        places.add(new place("Krúdy Gyula (1878 – 1933)", "Writer, an excellent master of modern Hungarian prose writings.", "https://hu.wikipedia.org/wiki/Kr%C3%BAdy_Gyula",  R.drawable.krudy ));
        places.add(new place("Móricz Zsigmond (1879 – 1942)", "), Hungarian writer, journalist, editor, the most famous figure of the realistic prose literature of the 20th century.", "https://hu.wikipedia.org/wiki/M%C3%B3ricz_Zsigmond",  R.drawable.moricz ));

        // Create a new {@link ArrayAdapter} for eating category
        final placesAdapter adapter = new placesAdapter(getActivity(), places, R.color.category_eating);

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
