package com.psu.mark.canopy;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;

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
    private boolean mOnline;

    public Contact(String name, boolean online) {
        mName = name;

    }

    public String getName() {
        return mName;
    }

    public boolean isOnline() {
        return mOnline;
    }

    private static int lastContactId = 0;

    public static List<Contact> createContactsList(int numContacts) {
        List<Contact> contacts = new ArrayList<Contact>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Contact("Person " + ++lastContactId, i <= numContacts / 2));
        }

        return contacts;
    }

    private String getEventsFromAnXML(Activity activity)
            throws XmlPullParserException, IOException
    {
        String stringBuffer= "";
        Resources res = activity.getResources();
        XmlResourceParser xpp = res.getXml(R.xml.contacts_name);
        xpp.next();
        int eventType = xpp.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT)
        {
            if(eventType == XmlPullParser.TEXT)
            {
                stringBuffer = "\nTEXT: " + xpp.getText();
            }
            eventType = xpp.next();
        }
        return stringBuffer;
    }
}