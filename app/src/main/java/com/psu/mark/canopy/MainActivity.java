package com.psu.mark.canopy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements Runnable{

    //private List<Contact> contacts = null;
    private List<Contact> Contacts;

    public MainActivity(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //call to function which pulls xml data holding contacts
        run();
        ListView listview = (ListView) findViewById(R.id.listview);


        listview.setAdapter(new ContactsAdapter(this, Contacts));

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Log.i("HQposition ", "p " + position);
                String contact_number= Contacts.get(position).getID();//


                //call TreeDisplayActivity -- pass the contact number as that is used to parse
                //Tree Structure XML for the Tree Display Activity
                Log.i("HQcontact ", contact_number);
                Intent i = new Intent(MainActivity.this, TreeDisplayActivity.class);
                i.putExtra("id_key", contact_number);

               startActivity(i);
            }
        });





        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //This button adds a new contact. This feature doesnt actually do anything because we cannot
        //query an external database for a tree structure yet, as we dont have a server
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = AddContactActivity.newIntent(MainActivity.this);
               startActivity(i);


            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    //prepare contact XML for display
    public void run() {
        try {
            Contacts = Contact.createContactsListXML(this);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
