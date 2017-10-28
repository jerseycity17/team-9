package com.example.mary.irc9;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Mary on 10/28/17.
 */

public class Tab3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3, container, false);

        String[] notifs = {"There is an active shooter in Cairo, Egypt. Do not leave your place of residence",
                "Alert 2", "Alert 3"};

        ListView lView = (ListView) rootView.findViewById(R.id.notifs);

        ArrayAdapter<String> lViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, notifs);

        lView.setAdapter(lViewAdapter);

        return rootView;
    }
}
