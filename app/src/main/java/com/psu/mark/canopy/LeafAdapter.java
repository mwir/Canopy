package com.psu.mark.canopy;

import android.content.Context;
import android.graphics.PorterDuff;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Mark on 11/30/2015.
 * leaf adapter handles all the display and action of each leaf node on the tree displayed by TreeDisplayActivity
 */
public class LeafAdapter extends BaseAdapter {
    //non-standard naming convension. this is just the local copy of 'inside_timing_parameter'
    private final String minside_timing_parameter;
    private Context mContext;
   private String[] mLeafIds;
    private String[] mleaf_branches;
    public String selectedBranch;
    private boolean mbehavior_parameter;


    public LeafAdapter(Context c, String[] input_array, String[] leaf_branches, String inside_timing_parameter, boolean behavior_parameter) {

        //read all data passed in from main activity
        mContext = c;
        mLeafIds=input_array;
        mleaf_branches=leaf_branches;
        minside_timing_parameter = inside_timing_parameter;
        mbehavior_parameter = behavior_parameter;



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


        //make each view a Button. This automatically sets varying row heights in the gridview, allowing staggered
        //views of the leaf texts based on their length and preventing overlap. Unfortunately using a button for the
        //view requires the onClick to be set here, otherwise functionality breaks.
        Button leafView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
           leafView = new Button(mContext);




           // leafView.setPadding(28, 28, 28, 48);
          //  leafView.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, GridView.AUTO_FIT));

        } else {
            leafView = (Button) convertView;
        }

        leafView.setText(mLeafIds[position]);
        //make a kinda greenish color, like leaves
       leafView.getBackground().setColorFilter(0xFF32FF4F, PorterDuff.Mode.MULTIPLY);

        leafView.setId(position);

        leafView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mbehavior_parameter) {
                    String branch_path = mleaf_branches[position];//position is a value specific to grid view

                    Toast.makeText(mContext, "tree path" + branch_path,
                            Toast.LENGTH_SHORT).show();


                    String intermediaryselectedBranch = branch_path;
                    selectedBranch = intermediaryselectedBranch.replaceAll(",", minside_timing_parameter);
                    ((TreeDisplayActivity) mContext).setSelectedBranch(selectedBranch);
                } else if (!mbehavior_parameter) {
                    String branch_path = mleaf_branches[position];//position is a value specific to grid view

                    Toast.makeText(mContext, "tree path" + branch_path + "\nTiming cannot be garaunteed. You must enter the path manually",
                            Toast.LENGTH_LONG).show();


                    selectedBranch = "";
                    ((TreeDisplayActivity) mContext).setSelectedBranch(selectedBranch);
                }

            }


        });




        return leafView;


    }


}