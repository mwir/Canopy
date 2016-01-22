package com.psu.mark.canopy;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mark on 12/26/2015.
 */

///Needs an overhaul. Tutorial found. Going to have an object, populate its values with json values. tutorial only
    //android thing open in browser.
public class TreeParser {

    //url for test json
    //https://api.myjson.com/bins/1xx03
   // public String address = "https://api.myjson.com/bins/1xx03";

   private String contact;


    public void setJSON(String str){
        contact= str; //" {\\n" + "    \"contact_number\": \"5032387433\",\\n" + "    \"number_of_leaves\": 17,\\n" + "    \"well_behaved\": true,\\n" + "    \"timing_parameter\": \",,,\",\\n" + "    \"leaves\": [{\\n" + "      \"text\": \"Transit Tracker\",\\n" + "      \"path\": \"1\"\\n" + "    }, {\\n" + "      \"text\": \"Bus Service Alert\",\\n" + "      \"path\": \"2\"\\n" + "    }, {\\n" + "      \"text\": \"Trip Planner\",\\n" + "      \"path\": \"3\"\\n" + "    }, {\\n" + "      \"text\": \"Fare Information\",\\n" + "      \"path\": \"4\"\\n" + "    }, {\\n" + "      \"text\": \"Comments and Concerns\",\\n" + "      \"path\": \"5\"\\n" + "    }, {\\n" + "      \"text\": \"Lost and Found\",\\n" + "      \"path\": \"6\"\\n" + "    }, {\\n" + "      \"text\": \"Admin. Office\",\\n" + "      \"path\": \"7\"\\n" + "    }, {\\n" + "      \"text\": \"Where to Buy Tickets\",\\n" + "      \"path\": \"4,3\"\\n" + "    }, {\\n" + "      \"text\": \"WES Train Service Alert\",\\n" + "      \"path\": \"2,3\"\\n" + "    }, {\\n" + "      \"text\": \"StreetCar Service Alert\",\\n" + "      \"path\": \"2,5\"\\n" + "    }, {\\n" + "      \"text\": \"Ticket and Pass Info\",\\n" + "      \"path\": \"4,1\"\\n" + "    }, {\\n" + "      \"text\": \"How to Pay Transfer\",\\n" + "      \"path\": \"4,2\"\\n" + "    }, {\\n" + "      \"text\": \"MAX Service Alert RED\",\\n" + "      \"path\": \"2,2,1\"\\n" + "    }, {\\n" + "      \"text\": \"MAX Service Alert BLUE\",\\n" + "      \"path\": \"2,2,2\"\\n" + "    }, {\\n" + "      \"text\": \"MAX Service Alert YELLOW\",\\n" + "      \"path\": \"2,2,3\"\\n" + "    }, {\\n" + "      \"text\": \"MAX Service Alert GREEN\",\\n" + "      \"path\": \"2,2,4\"\\n" + "    }, {\\n" + "      \"text\": \"MAX Service Alert ORANGE\",\\n" + "      \"path\": \"2,2,5\"\\n" + "    }]\\n" + "\\n" + "  }";
        ;
    }

    public String getJSON(){
        return contact;
    }
        //  private String contact = "{\\n" + "  \"tree\": {\\n" + "    \"contact_number\": \"5032387433\",\\n" + "    \"number_of_leaves\": 17,\\n" + "    \"well_behaved\": true,\\n" + "    \"timing_parameter\": \",,,\",\\n" + "    \"leaves\": [{\\n" + "      \"text\": \"Transit Tracker\",\\n" + "      \"path\": \"1\"\\n" + "    }, {\\n" + "      \"text\": \"Bus Service Alert\",\\n" + "      \"path\": \"2\"\\n" + "    }, {\\n" + "      \"text\": \"Trip Planner\",\\n" + "      \"path\": \"3\"\\n" + "    }, {\\n" + "      \"text\": \"Fare Information\",\\n" + "      \"path\": \"4\"\\n" + "    }, {\\n" + "      \"text\": \"Comments and Concerns\",\\n" + "      \"path\": \"5\"\\n" + "    }, {\\n" + "      \"text\": \"Lost and Found\",\\n" + "      \"path\": \"6\"\\n" + "    }, {\\n" + "      \"text\": \"Admin. Office\",\\n" + "      \"path\": \"7\"\\n" + "    }, {\\n" + "      \"text\": \"Where to Buy Tickets\",\\n" + "      \"path\": \"4,3\"\\n" + "    }, {\\n" + "      \"text\": \"WES Train Service Alert\",\\n" + "      \"path\": \"2,3\"\\n" + "    }, {\\n" + "      \"text\": \"StreetCar Service Alert\",\\n" + "      \"path\": \"2,5\"\\n" + "    }, {\\n" + "      \"text\": \"Ticket and Pass Info\",\\n" + "      \"path\": \"4,1\"\\n" + "    }, {\\n" + "      \"text\": \"How to Pay Transfer\",\\n" + "      \"path\": \"4,2\"\\n" + "    }, {\\n" + "      \"text\": \"MAX Service Alert RED\",\\n" + "      \"path\": \"2,2,1\"\\n" + "    }, {\\n" + "      \"text\": \"MAX Service Alert BLUE\",\\n" + "      \"path\": \"2,2,2\"\\n" + "    }, {\\n" + "      \"text\": \"MAX Service Alert YELLOW\",\\n" + "      \"path\": \"2,2,3\"\\n" + "    }, {\\n" + "      \"text\": \"MAX Service Alert GREEN\",\\n" + "      \"path\": \"2,2,4\"\\n" + "    }, {\\n" + "      \"text\": \"MAX Service Alert ORANGE\",\\n" + "      \"path\": \"2,2,5\"\\n" + "    }]\\n" + "\\n" + "  }\\n" + "}";


        private String contact_number () {
            try

            {
                JSONObject jObject = new JSONObject(contact);
                String this_contact_number = jObject.getString("contact_number");

                return this_contact_number;
            } catch (JSONException e) {
                e.printStackTrace();
                return "debug check";
            }

        }


    private int number_of_leaves() {

        try

        {
            JSONObject jObject = new JSONObject(contact);
            int number_of_leaves = jObject.getInt("number_of_leaves");

            return number_of_leaves;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }

    }



    private String timing_parameter() {

        try

        {
            JSONObject jObject = new JSONObject(contact);
            String timing_parameter = jObject.getString("timing_parameter");

            return timing_parameter;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Boolean well_behaved() {

        try

        {
            JSONObject jObject = new JSONObject(contact);
            Boolean well_behaved = jObject.getBoolean("well_behaved");

            return well_behaved;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }






    private JSONArray leaves() {
        try

        {
            JSONObject jObject = new JSONObject(contact);
            JSONArray leaves = jObject.getJSONArray("leaves");
            return leaves;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }




    private String[] leaf_text() {
        String[] leaf_text = new String[this.number_of_leaves()];
        for (int i = 0; i < (this.number_of_leaves()); i++)

        {
            JSONArray jsonarray = this.leaves();
            try {
                JSONObject jsonobject=jsonarray.getJSONObject(i);
                leaf_text[i] = jsonobject.getString("text");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return leaf_text;
    }

    private String[] leaf_branches() {
        final String[] leaf_branches = new String[this.number_of_leaves()];
        for (int i = 0; i < (this.number_of_leaves()); i++)

        {
            JSONArray jsonarray = this.leaves();
            try {
                JSONObject jsonobject=jsonarray.getJSONObject(i);
                leaf_branches[i] = jsonobject.getString("path");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return leaf_branches;
    }


    public String[] getLeaf_Text(){
        return leaf_text();
    }

    public String[] getBranches(){
        return leaf_branches();
    }

    public String getContactNumber(){
        return contact_number();
    }

    public Boolean getBehavior(){
       return well_behaved();
    }

    public String getTimingParameter(){
        return timing_parameter();
    }
}