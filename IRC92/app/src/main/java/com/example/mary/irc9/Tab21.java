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
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Mary on 10/28/17.
 */
import java.util.ArrayList;
import java.util.UUID;

import static android.R.id.list;

public class Tab21 extends Fragment {

    ArrayList<String> list = new ArrayList<>();

    final FirebaseDatabase db = FirebaseDatabase.getInstance();
    DatabaseReference dbRef = db.getReference();
    DatabaseReference mNotifReference = dbRef.child("testUser");


    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab21, container, false);


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

        ListView lView = (ListView) rootView.findViewById(R.id.dummy);

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list);

        lView.setAdapter(adapter);

        return rootView;

    }


    @Override
    public void onResume(){
        super.onResume();

    }






}

