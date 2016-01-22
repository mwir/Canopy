package com.psu.mark.canopy;

/**
 * Created by Mark on 1/1/2016.
 * just holds all the values read out of the parser. Defaults to null or 0 if no values present
 */
public class TreeObject {

    //defaut values

    String[] leaf_text = new String[0];
    String[] leaf_branches = new String[0];
    String contact_number= null;
    String timing_parameter = null;
    Boolean well_behaved = null;




    public void setLeaf_Text(String[] leaf_text){
        this.leaf_text=leaf_text;
    }

    public void setBranches(String[] leaf_branches){
        this.leaf_branches=leaf_branches;
    }

    public void setContactNumber(String contact_number){
        this.contact_number=contact_number;
    }

    public void setBehavior(Boolean well_behaved){
        this.well_behaved=well_behaved;
    }

    public void setTimingParameter(String timing_parameter){
        this.timing_parameter = timing_parameter;
    }

    public String[] getLeaf_Text(){
        return leaf_text;
    }

    public String[] getBranches(){
        return leaf_branches;
    }

    public String getContactNumber(){
        return contact_number;
    }

    public Boolean getBehavior(){
        return well_behaved;
    }

    public String getTimingParameter(){
        return timing_parameter;
    }


}
