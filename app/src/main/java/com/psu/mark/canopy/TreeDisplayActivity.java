package com.psu.mark.canopy;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.Arrays;


public class TreeDisplayActivity extends AppCompatActivity {

    private String selectedBranch;

   // Context.getSystemService(Context.TELEPHONY_SERVICE)
    public TreeDisplayActivity() {

    }

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tree_display);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            //Standard format names that need to be pre-pended with phone number

            //get primary contact number
            String packageName = getPackageName();
            int this_contact_number = getResources().getIdentifier("contact_number", "string", packageName);

            //get the number of leaves

            int this_number_of_leaves = getResources().getIdentifier("number_of_leaves", "integer", packageName);

            int this_contact_structure_array =  getResources().getIdentifier("contact_structure_array", "array", packageName);



           final int number_of_leaves = this.getResources().getInteger(this_number_of_leaves);
            TypedArray ta = this.getResources().obtainTypedArray(this_contact_structure_array);
          //  final String fullnumber = Integer.toString(this.getResources().getInteger(R.integer.contact_area_code))+
               //     Integer.toString(this.getResources().getInteger(R.integer.contact_number));
            final String fullnumber = this.getResources().getString(this_contact_number);
            final int[][] leaf_branches = new int[number_of_leaves][];
            for (int i = 0; i <= number_of_leaves-1; i++){
                int id = ta.getResourceId(i, 0);
                 leaf_branches[i]=getResources().getIntArray(id);
            }
            ta.recycle(); //I read this was important


                GridView gridview = (GridView) findViewById(R.id.gridview);

            gridview.setAdapter(new LeafAdapter(this));

            gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v,
                                        int position, long id) {
                    int[] branch_path=leaf_branches[position];//position is a value specific to grid view

                    Toast.makeText(TreeDisplayActivity.this, "tree path" + Arrays.toString(branch_path) ,
                            Toast.LENGTH_SHORT).show();



                    selectedBranch=Arrays.toString(branch_path);
                }
            });




            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel://"+fullnumber +","+","+","+selectedBranch));
               //     intent.setData(Uri.parse("tel:7148651560"));
                    startActivity(intent);
                   /* final Handler handler = new Handler();

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(Intent.ACTION_CALL);
                            // Do something after 5s = 5000ms
                            intent.setData(Uri.parse("tel://" + selectedBranch));
                        }
                    }, 2000);*/



                }
            });
        }





    }