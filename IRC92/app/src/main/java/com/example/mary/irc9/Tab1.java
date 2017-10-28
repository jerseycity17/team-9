package com.example.mary.irc9;

/**
 * Created by Mary on 10/28/17.
 */

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import static com.example.mary.irc9.R.id.notifs;

public class Tab1 extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1, container, false);
        String[] customsList = {"Women should not go out alone at night past 9PM",
                "Custom 2", "Custom 3"};

        ListView customsListView = (ListView) rootView.findViewById(R.id.customs);

        ArrayAdapter<String> customsViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, customsList);

        customsListView.setAdapter(customsViewAdapter);

        String[] healthList = {"Women should not go out alone at night past 9PM",
                "Custom 2", "Custom 3"};

        ListView healthListView = (ListView) rootView.findViewById(R.id.healthAdvisories);

        ArrayAdapter<String> healthViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, healthList);

        healthListView.setAdapter(healthViewAdapter);

        return rootView;
    }
}
