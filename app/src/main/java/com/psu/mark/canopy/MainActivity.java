package com.psu.mark.canopy;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.Pair;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
//        Contacts = MainActivity.this.getResources().getStringArray(R.array.ContactsArray);
        run();
        ListView listview = (ListView) findViewById(R.id.listview);


        listview.setAdapter(new ContactsAdapter(this, Contacts));

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Log.i("HQposition ", "p " + position);
                String contact_number= Contacts.get(position).getID();//position is a value specific to grid view
           // String[] parts=fullcontact.split("-");
           //  String   contact_number = parts[1] ;
              //  Toast.makeText(MainActivity.this, "contact number" + contact_number, //<< get the contact # following treesdisplay method
              //          Toast.LENGTH_SHORT).show();

                Toast.makeText(MainActivity.this, "CLICK", Toast.LENGTH_SHORT).show();

                Log.i("HQcontact ", contact_number);
                Intent i = new Intent(MainActivity.this, TreeDisplayActivity.class);
                i.putExtra("id_key", contact_number);

               startActivity(i);
            }
        });




        //Default Stuff, dont know if we want it
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
