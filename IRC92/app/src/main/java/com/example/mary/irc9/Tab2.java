package com.example.mary.irc9;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Mary on 10/28/17.
 */
import java.util.UUID;

public class Tab2 extends Fragment {

    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("personell");

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab2, container, false);

        String[] notifs = {"[local place] Police: 123-456-7890",
                "[local place] Hospital: 123-456-7890", "IRC [place] Office Contact: 123-456-7890",
                "IRC Address: 123 easy street"};

        ListView lView = (ListView) rootView.findViewById(R.id.notifs);

        ArrayAdapter<String> lViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, notifs);

        lView.setAdapter(lViewAdapter);

        return rootView;

       // myRef.setValue("Jersey City");







    }








}

