package com.psu.mark.canopy;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Mark on 11/24/2015.
 */



// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class ContactsAdapter extends
        BaseAdapter{



    private Context mContext;
    private List<Contact> mContactIds;
    public ContactsAdapter(Context c, List<Contact> input_array) {

        //I am trying to migrate over to a passed in input array so I can retrieve it under the general method. Havent fixed main activity yet
        mContext = c;
        mContactIds=input_array;
        // mLeafIds =  mContext.getResources().getStringArray(R.array.PSU_leaf_strings);
    }

    public int getCount() {
        return mContactIds.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new contactView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView contactView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            contactView = new TextView(mContext);
            // leafView.setLayoutParams(new GridView.LayoutParams(185, 185));

            contactView.setPadding(8, 8, 8, 8);

        } else {
           contactView = (TextView) convertView;
        }

        contactView.setText(mContactIds.get(position).getName());

        return contactView;
    }

    // references to our images
    // public String[] mLeafIds =  mContext.getResources().getStringArray(R.array.contact1_leaf_strings);
}