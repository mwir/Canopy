package com.psu.mark.canopy;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Pair;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 11/24/2015.
 */
public class Contact {
    private String mName;
    private String mID;


    public Contact(String name, String id) {
        mName = name;
        mID = id;

    }
    public Contact(Contact aContact) {
        mName = aContact.getName();
        mID = aContact.getID();

    }

    public Contact() {
        mName = "";
        mID = "";

    }

    public String getName() {
        return mName;
    }

    public String getID() {
        return mID;
    }

    public void setName(String name) {
         mName = name;
    }

    public void setID(String id) {
        mID = id;
    }



    public static List<Contact> createContactsListXML (Activity activity)
            throws XmlPullParserException, IOException
    {
        List<Contact> contacts = new ArrayList<Contact>();
        String buffer= "";
//        String nameBuffer= "";
        Contact tempContact = new Contact ();

        Resources res = activity.getResources();
        XmlResourceParser xpp = res.getXml(R.xml.contacts_name);
        xpp.next();
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT)
        {
            if(eventType == XmlPullParser.START_TAG) {
                buffer = xpp.getName();
                if (!buffer.contains("item")) {
                    eventType = xpp.next();
                    continue;
                }
                buffer = xpp.getAttributeValue(0);
                tempContact.setName(buffer);
            }

            if(eventType == XmlPullParser.TEXT) {
                tempContact.setID(xpp.getText());
                contacts.add(new Contact(tempContact));
                System.out.println("Name " + tempContact.getName() + " ID " + tempContact.getID()) ;
            }
            eventType = xpp.next();
        }
        return contacts;
    }
}