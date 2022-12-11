package com.example.matala2_java_the8;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link recycler_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class recycler_fragment extends Fragment implements recyclerViewInterface{

    View view;

    private ArrayList<DataModel> dataSet;

    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private MyAdapter adapter;






    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    //private String mParam1;
    //private String mParam2;

    public recycler_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment recycler_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static recycler_fragment newInstance(String param1, String param2) {
        recycler_fragment fragment = new recycler_fragment();
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
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_recycler_fragment, container, false);

        recyclerView=view.findViewById(R.id.recyclerView);

        layoutManager=new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setItemAnimator(new DefaultItemAnimator());

        dataSet=new ArrayList<DataModel>();

        for(int i =0;i<MyData.nameArray.length;i++){

            dataSet.add(new DataModel(
                    MyData.nameArray[i],
                    MyData.descriptionArray[i],
                    MyData.imagesArray[i],
                    MyData.morDescription[i]

            ));
        }
        adapter=new MyAdapter(dataSet,this);
        recyclerView.setAdapter(adapter);




    return view;
    }
    @Override
    public void onItemClick(int position) {

        Bundle bundle =new Bundle();
        bundle.putString("Name",dataSet.get(position).getName().toString());
        bundle.putInt("Image",dataSet.get(position).getImage());
        bundle.putString("Description",dataSet.get(position).getMorDescription().toString());

        Navigation.findNavController(view).navigate(R.id.action_recycler_fragment_to_fragment_details,bundle);
    }



}