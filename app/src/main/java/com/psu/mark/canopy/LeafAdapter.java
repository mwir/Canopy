package com.psu.mark.canopy;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;

/**
 * Created by Mark on 11/30/2015.
 */
public class LeafAdapter extends BaseAdapter {
    private final String minside_timing_parameter;
    private Context mContext;
   private String[] mLeafIds;
    private int[][] mleaf_branches;
    public String selectedBranch;
    public LeafAdapter(Context c, String[] input_array, int[][] leaf_branches, String inside_timing_parameter) {

        //I am trying to migrate over to a passed in input array so I can retrieve it under the general method. Havent fixed main activity yet
        mContext = c;
        mLeafIds=input_array;
        mleaf_branches=leaf_branches;
        minside_timing_parameter = inside_timing_parameter;


    }

    public int getCount() {
        return mLeafIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new leafView for each item referenced by the Adapter
    public View getView(final int position, View convertView, ViewGroup parent) {
        Button leafView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
           leafView = new Button(mContext);

            //leafView.setLayoutParams(new GridView.LayoutParams(100, 55));
            // leafView.setLayoutParams(new GridView.LayoutParams(185, 185));

            leafView.setPadding(8, 8, 8, 8);

        } else {
            leafView = (Button) convertView;
        }

        leafView.setText(mLeafIds[position]);
        leafView.setBackgroundColor(Color.GREEN);
       // leafView.setClickable(true);
        leafView.setId(position);

        leafView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int[] branch_path = mleaf_branches[position];//position is a value specific to grid view

                Toast.makeText(mContext, "tree path" + Arrays.toString(branch_path),
                        Toast.LENGTH_SHORT).show();


                String intermediaryselectedBranch = Arrays.toString(branch_path);
                selectedBranch = intermediaryselectedBranch.replaceAll(",", minside_timing_parameter);
                ((TreeDisplayActivity)mContext).setSelectedBranch(selectedBranch);


            }
        });

      //  leafView.setOnClickListener(new View.OnClickListener() {
       //     @Override
       //     public void onClick(View v) {

       //         mContext.itemClicked(position);
       //     }
      //  });


        return leafView;


    }

    // references to our images
   // public String[] mLeafIds =  mContext.getResources().getStringArray(R.array.contact1_leaf_strings);
}