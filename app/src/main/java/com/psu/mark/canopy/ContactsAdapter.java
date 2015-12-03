package com.psu.mark.canopy;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Mark on 11/24/2015.
 */



// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class ContactsAdapter extends
        RecyclerView.Adapter<ContactsAdapter.ViewHolder> {



    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private Context context;
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
      //  public Button messageButton;
        private TreeDisplayActivity mTreeDisplayActivity;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.contact_name);
            //going to make the button clickable. Arguably cleaner to have the text clickable,
            //but not sure if that would cause accidental clicks
            context = itemView.getContext();
        //    messageButton = (Button) itemView.findViewById(R.id.message_button);
            itemView.setOnClickListener(this);


        }

        // Handles the row being being clicked -- finding conflicting info, maybe dont have to refer
        //to position at all

        @Override
        public void onClick(View view) {

             Intent i = new Intent(context, TreeDisplayActivity.class);
            i.putExtra("id_key", "5037253000");

            context.startActivity(i);
        }



    }

    private List<Contact> mContacts;
    public ContactsAdapter(List<Contact> contacts) {
        mContacts = contacts;
    }
    public ContactsAdapter(){}

    public void setContacts (List<Contact> contacts) {
        mContacts = contacts;
    }

    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_contact, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(ContactsAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Contact contact = mContacts.get(position);

        // Set item views based on the data model
        TextView textView = viewHolder.nameTextView;
        textView.setText(contact.getName());

     //   Button button = viewHolder.messageButton;



    }

    // Return the total count of items
    @Override
    public int getItemCount() {
        if (mContacts != null) {
            return mContacts.size();
        }
        else
            return 0;
    }


}