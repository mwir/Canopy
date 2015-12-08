package com.psu.mark.canopy;

import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.GridView;

/**
 * Created by Mark on 11/30/2015.
 * Tree display activity parses XML to display buttons for each terminal leaf node in our directory
 * tree. It also reads and stores all functional variables, such as timing parameters and branch paths
 * It also places the phone call with the press of its floating action button
 */


public class TreeDisplayActivity extends AppCompatActivity {

    //stores the user selected tree branch in string form
    private String mselectedBranch;
    //string array of leaf titles from xml
    private String[] leaf_strings;

    // Context.getSystemService(Context.TELEPHONY_SERVICE)
    public TreeDisplayActivity() {

    }

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tree_display);
          //retrieve the id key from the main activity intent
            String identifier = getIntent().getExtras().getString("id_key");
            String packageName = getPackageName();


            //this pulls the contact number from resources by its unique ID (this is necessary for hardcoding xml contacts)
            //ideally we would be parsing an xml file from a directory here
            int this_contact_number = getResources().getIdentifier("contact_number" +identifier, "string", packageName);
            Log.i("identifier", "id " + identifier);

            //get the number of leaves
            int this_number_of_leaves = getResources().getIdentifier("number_of_leaves"+identifier, "integer", packageName);

            //get contact structure array

            int this_contact_structure_array =  getResources().getIdentifier("contact_structure_array"+identifier, "array", packageName);

            //get leaf descriptions

            int this_leaf_strings =  getResources().getIdentifier("leaf_strings"+identifier, "array", packageName);


            //get timing parameter

            int this_timing_parameter= getResources().getIdentifier("timing_parameter"+identifier, "string", packageName);


            //get behavior 0 is bad behavior, 1 is goodd (ie, does this tree have consistent timing metrics, messages etc

            int this_behavior_parameter= getResources().getIdentifier("behavior"+identifier, "integer", packageName);

            leaf_strings=this.getResources().getStringArray(this_leaf_strings);


            //timing parameter is how long this contact takes to answer a phone call
            final String timing_parameter = getResources().getString(this_timing_parameter);

            //this is a fudge - "inside_timing_parameter" is the time to delay DTMF tones. This number is often
            //shorter than the timing parameter, but not always.
            final String inside_timing_parameter=timing_parameter.substring(timing_parameter.length()/2);

            //knowing the number of leaves is neccessary for iterating over the typed array which
            //contains the branch paths for each leaf
           final int number_of_leaves = this.getResources().getInteger(this_number_of_leaves);

           final  int behavior_parameter = this.getResources().getInteger(this_behavior_parameter);

            //getting the typed array which is an array of ordered integer array names
            TypedArray ta = this.getResources().obtainTypedArray(this_contact_structure_array);

            final String fullnumber = this.getResources().getString(this_contact_number);
            //this is the final storage for the branche paths for each leaf
            final int[][] leaf_branches = new int[number_of_leaves][];

            //this populates the branch paths from the name indicators from the typed array.
            //this entire workaround is only neccessary because all these preprogrammed contacts exist
            //in resources and so must be uniquely named. If we were opening up seperate files  for each
            //contact parsing would be much simpler
            for (int i = 0; i <= number_of_leaves-1; i++){
                int id = ta.getResourceId(i, 0);
                 leaf_branches[i]=getResources().getIntArray(id);
            }
            ta.recycle(); //I read this was important


            GridView gridview = (GridView) findViewById(R.id.gridview);
            //set adapter: pass in parsed variable leaf string, leaf branches and inside timing parameter (
            //this determines how much time is needed between DTMF tones in the attendant behind the number)
            gridview.setAdapter(new LeafAdapter(this, leaf_strings, leaf_branches, inside_timing_parameter, behavior_parameter));






            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //this sends out the actual call. This function is the reason the api needs to be set so high.
                    //it gives a security warning, which I am ignoring. It still seems to work.
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel://" + fullnumber + timing_parameter + mselectedBranch));
                    //     intent.setData(Uri.parse("tel:7148651560"));
                    startActivity(intent);



                }
            });




        }

//this function sets the selected branch. The selection will be briefly displayed to the user
    public void setSelectedBranch(String selectedBranch) {mselectedBranch=selectedBranch;
    }
}