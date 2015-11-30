package com.psu.mark.canopy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


public class TreeDisplayActivity extends AppCompatActivity {

    //collect XML data from specified contact
   // Resources res = getResources();
   // int number_of_leaves = res.getInteger(R.integer.number_of_leaves);

   // int[] leaft1_path =res.getIntArray(R.array.leaf_1_path);
    Button mTemplateButton = (Button)findViewById(R.id.leaf_diplay_button);
    ViewGroup.LayoutParams params = mTemplateButton.getLayoutParams();

    public TreeDisplayActivity() {

    }

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tree_display);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            final int number_of_leaves = this.getResources().getInteger(R.integer.number_of_leaves);



//test dynamic button creation
            Button btn;
            //LinearLayout layout=new LinearLayout(this);
            LinearLayout ll = new LinearLayout(this);
            for (int index = 1; index <= number_of_leaves; index++) {
              //  LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                //        LinearLayout.LayoutParams.MATCH_PARENT,
                  //      LinearLayout.LayoutParams.WRAP_CONTENT);
                btn = new Button(this);
              //  btn.setId(View.generateViewId());
              //  final int id_ = btn.getId();
                btn.setText("button " + index);
               // btn.setBackgroundColor(Color.rgb(70, 80, 90));
                btn.setLayoutParams(params);
                ll.addView(btn, params);
                //btn = ((Button) findViewById(id_));
               // btn.setOnClickListener(new View.OnClickListener() {
               //     public void onClick(View view) {
              //          Toast.makeText(view.getContext(),
              //                  "Button clicked index = " + id_, Toast.LENGTH_SHORT)
               //                 .show();
               //     }
               // });
            }





            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, String.format("%d",number_of_leaves), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }


//Create a Tree


    }