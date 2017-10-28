package com.example.mary.irc9;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static com.example.mary.irc9.R.id.notifs;

/**
 * Created by Mary on 10/28/17.
 */


public class Tab3 extends Fragment {

    ArrayList<String> list = new ArrayList<>();

    final FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbRef = db.getReference();
    DatabaseReference mNotifReference = dbRef.child("alerts");


    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3, container, false);

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

        /*
        String[] notifs = {"There is an active shooter in Cairo, Egypt. Do not leave your place of residence",
                "Alert 2", "Alert 3"};
        */
        ListView lView = (ListView) rootView.findViewById(R.id.notifs);

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list);

        lView.setAdapter(adapter);

        return rootView;
    }


}
