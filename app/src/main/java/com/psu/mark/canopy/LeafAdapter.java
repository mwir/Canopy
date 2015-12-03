package com.psu.mark.canopy;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Mark on 11/30/2015.
 */
public class LeafAdapter extends BaseAdapter {
    private Context mContext;
   private String[] mLeafIds;
    public LeafAdapter(Context c) {
        mContext = c;
       mLeafIds =  mContext.getResources().getStringArray(R.array.PSU_leaf_strings);
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
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView leafView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            leafView = new TextView(mContext);
           // leafView.setLayoutParams(new GridView.LayoutParams(185, 185));

            leafView.setPadding(8, 8, 8, 8);

        } else {
            leafView = (TextView) convertView;
        }

        leafView.setText(mLeafIds[position]);
        leafView.setBackgroundColor(Color.GREEN);
        return leafView;
    }

    // references to our images
   // public String[] mLeafIds =  mContext.getResources().getStringArray(R.array.contact1_leaf_strings);
}