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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.mary.irc9.R.id.notifs;

public class Tab1 extends Fragment{

    ArrayList<String> list = new ArrayList<>();

    final FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbRef = db.getReference();
    DatabaseReference mNotifReference = dbRef.child("contact");


    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1, container, false);
        ValueEventListener postListenter = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot snap : dataSnapshot.getChildren()){
                    String a = snap.getValue(String.class);
                    //System.out.println(a);
                    list.add(a);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        mNotifReference.addValueEventListener(postListenter);

        ListView lView = (ListView) rootView.findViewById(R.id.customs);

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list);

        lView.setAdapter(adapter);


        /*
        String[] customsList = {"Women should not go out alone at night past 9PM",
                "Custom 2", "Custom 3"};

        ListView customsListView = (ListView) rootView.findViewById(R.id.customs);

        ArrayAdapter<String> customsViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, customsList);

        customsListView.setAdapter(customsViewAdapter);

        String[] healthList = {"Zika virus is active here",
                "Health Advisory 2", "Health Advisory 3"};

        ListView healthListView = (ListView) rootView.findViewById(R.id.healthAdvisories);

        ArrayAdapter<String> healthViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, healthList);

        healthListView.setAdapter(healthViewAdapter);
        */
        return rootView;
    }
}
