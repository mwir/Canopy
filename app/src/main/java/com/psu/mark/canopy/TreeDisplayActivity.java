package com.psu.mark.canopy;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Mark on 11/30/2015.
 * Tree display activity parses XML to display buttons for each terminal leaf node in our directory
 * tree. It also reads and stores all functional variables, such as timing parameters and branch paths
 * It also places the phone call with the press of its floating action button
 */


public class TreeDisplayActivity extends AppCompatActivity {

    Context mContext;




    //stores the user selected tree branch in string form
    private String mselectedBranch ="";
    //string array of leaf titles from xml



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
            mContext=getApplicationContext();
          final TreeParser mTreeParser = new TreeParser();
            mTreeParser.setJSON(loadJSONFromAsset(mContext));







          final String[] leaf_strings=mTreeParser.getLeaf_Text();
         final   String [] leaf_branches=mTreeParser.getBranches();


            //timing parameter is how long this contact takes to answer a phone call
            final String timing_parameter = mTreeParser.getTimingParameter();

            //this is a fudge - "inside_timing_parameter" is the time to delay DTMF tones. This number is often
            //shorter than the timing parameter, but not always.
            final String inside_timing_parameter=  ",,";//timing_parameter.substring(timing_parameter.length()/2);

           final  Boolean behavior_parameter =Boolean.TRUE;//mTreeParser.getBehavior();


            final String fullnumber = mTreeParser.getContactNumber();
            //this is the final storage for the branch paths for each leaf


            if (loadJSONFromAsset(mContext) != null) {

                GridView gridview = (GridView) findViewById(R.id.gridview);
                //set adapter: pass in parsed variable leaf string, leaf branches and inside timing parameter (
                //this determines how much time is needed between DTMF tones in the attendant behind the number)
                gridview.setAdapter(new LeafAdapter(this, leaf_strings, leaf_branches, inside_timing_parameter, behavior_parameter));


            }

            else{

            }





            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //this sends out the actual call. This function is the reason the api needs to be set so high.
                    //it gives a security warning, which I am ignoring. It still seems to work.
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel://" + fullnumber + timing_parameter + mselectedBranch));
                   // Toast.makeText(mContext, fullnumber,
                   //         Toast.LENGTH_LONG).show();
                     startActivity(intent);



                }
            });




        }

    private String loadJSONFromAsset(Context context) {
        {
            String json = null;
           Context mctx=context;
            try {
                InputStream is = mctx.getAssets().open("tree-5032387433.json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                json = new String(buffer, "UTF-8");
            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
            return json;
        }
    }

    //this function sets the selected branch. The selection will be briefly displayed to the user
    public void setSelectedBranch(String selectedBranch) {mselectedBranch=selectedBranch;
    }






}