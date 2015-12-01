package com.psu.mark.canopy;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
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
    private String areacode=Integer.toString(503);
    private String baharsnumber = Integer.toString(7253000);
    private String fullnumber=areacode+baharsnumber;
   // Context.getSystemService(Context.TELEPHONY_SERVICE)
    public TreeDisplayActivity() {

    }

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tree_display);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            final int number_of_leaves = this.getResources().getInteger(R.integer.number_of_leaves);
            TypedArray ta = this.getResources().obtainTypedArray(R.array.contact_structure_array);
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