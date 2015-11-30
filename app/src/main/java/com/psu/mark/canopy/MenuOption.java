package com.psu.mark.canopy;

/**
 * Created by Mark on 11/29/2015.
 */
public class MenuOption {

    private int SelctionNumber;
    private int OptionText; //a single letter

    public MenuOption(int selctionNumber, int optionText){
        SelctionNumber=selctionNumber;
        OptionText=optionText;
    }




    public int getSelctionNumber() {
        return SelctionNumber;
    }

    public void setSelctionNumber(int q) {
        SelctionNumber = q;
    }

    public int geOptionText() {
        return OptionText;
    }

    public void setOptionText(int a) {
        OptionText = a;

    }
}
