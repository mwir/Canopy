package com.psu.mark.canopy;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


public class TreeDisplayActivity extends AppCompatActivity {
    private MenuOption mMenuOption1;
    private MenuOption mMenuOption2;
   // private Tree<MenuOption> mContactTree;

    public TreeDisplayActivity() {
        mMenuOption1 = new MenuOption(1, 2);
        mMenuOption2 = new MenuOption(3, 4);
        Tree<MenuOption> mContactRoot = new Tree<MenuOption>(mMenuOption1);
        Tree<MenuOption> mContactLeaf = mContactRoot.addLeaf(mMenuOption2);
        mContactLeaf.getParent();
    }

        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_tree_display);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }


//Create a Tree


    }