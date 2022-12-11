package com.example.matala2_java_the8;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/*
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_details#newInstance} factory method to
 * create an instance of this fragment.
 */

public class fragment_details extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    //private static final String ARG_PARAM1 = "param1";
   // private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
   // private String mParam1;
    //private String mParam2;

    public fragment_details() {
        // Required empty public constructor
    }
/*
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_details.
     */
    // TODO: Rename and change types and number of parameters

    /*  public static fragment_details newInstance(String param1, String param2) {
        fragment_details fragment = new fragment_details();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //if (getArguments() != null) {
            //mParam1 = getArguments().getString(ARG_PARAM1);
            //mParam2 = getArguments().getString(ARG_PARAM2);
        //}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_details, container, false);

        ImageView item_image=view.findViewById(R.id.imageView);
        TextView item_name = view.findViewById(R.id.item_name);
        TextView item_morDescription=view.findViewById(R.id.item_morDescription);
        item_name.setText(getArguments().getString("Name"));
        item_image.setImageResource(getArguments().getInt("Image"));
        item_morDescription.setText(getArguments().getString("Description"));


        return view;
    }
}