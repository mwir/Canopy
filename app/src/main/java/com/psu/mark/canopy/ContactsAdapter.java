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

        //assign context and contact ids
        mContext = c;
        mContactIds=input_array;

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


            contactView.setPadding(8, 8, 8, 8);

        } else {
           contactView = (TextView) convertView;
        }
        //set text based on position in listview
        contactView.setText(mContactIds.get(position).getName());

        return contactView;
    }


}