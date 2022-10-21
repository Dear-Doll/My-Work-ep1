package com.example.myclass;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Fragment2 extends Fragment {

    private RecyclerView recyclerView;
    private Adapter myadapter;
    private List<String> list = new ArrayList<>();
    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        context=this.getActivity();
        view = inflater.inflate(R.layout.fragment_2, container, false);
        recyclerView = view.findViewById(R.id.recyclerView1);
        listdata();
        myadapter = new Adapter(context);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(myadapter);
        myadapter.list(list);
        return view;

    }

    private void listdata() {
        for(int i=0;i<=24;i++){
            list.add("the "+i+" of contacter");
        }
    }
}