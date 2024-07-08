package com.example.embeddedf;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;



public class searchfragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

   DatabaseReference ref;
    ArrayList<Deal> list;

    RecyclerView recyclerView;
    SearchView searchView;


    public searchfragment() {

    }


    public static searchfragment newInstance(String param1, String param2) {
        searchfragment fragment = new searchfragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_searchfragment, container, false);

        ref = FirebaseDatabase.getInstance().getReference().child("teachers").child("t1");
        recyclerView= recyclerView.findViewById(R.id.rv);
        searchView = searchView.findViewById(R.id.searchView);



        return view;


    }

    @Override
    public void onStart() {
        super.onStart();
        if (ref != null)
        {
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if(dataSnapshot.exists())
                    {
                        list =new ArrayList<>();
                        for(DataSnapshot ds : dataSnapshot.getChildren())
                        {
                            list.add(ds.getValue(Deal.class));
                        }
                        AdapterClass adapterClass = new AdapterClass(list);
                        recyclerView.setAdapter(adapterClass);

                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError Error) {


                }
            });
        }
        if (searchView!=null)
        {
           searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
               @Override
               public boolean onQueryTextSubmit(String s) {
                   search(s);
                   return false;
               }

               @Override
               public boolean onQueryTextChange(String s) {
                   search(s);
                   return false;
               }
           });
        }
    }
    private void search(String str)
    {
        ArrayList<Deal> mylist= new ArrayList<>();
        for(Deal object : list)
        {
            if(object.getName().toLowerCase().contains(str.toLowerCase()))
            {
               mylist.add(object);
            }
        }
        AdapterClass adapterClass = new AdapterClass(mylist);
        recyclerView.setAdapter(adapterClass);
    }
}