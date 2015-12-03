package com.psu.mark.canopy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddContactActivity extends AppCompatActivity {

    public static final String EXTRA_NEW_NAME =
            "com.psu.mark.canopy.new_name";
    public static final String EXTRA_NEW_PHONE =
            "com.psu.mark.canopy.new_phone";

    private TextView mNameTextView;
    private TextView mPhoneTextView;
    private EditText mPhoneEditText;
    private EditText mNameEditText;
    private Button mDoneButton;
    private Button mCancelButton;
    private String mContactKey;
    public static final String MY_PREFS_NAME = "CanopyPrefsFile";


    private String mNameStr;
    private String mPhoneStr;

    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, AddContactActivity.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        mNameTextView = (TextView)findViewById(R.id.name_text_view);
        mNameTextView.setText(R.string.name_text_view);

        mPhoneTextView = (TextView)findViewById(R.id.phone_text_view);
        mPhoneTextView.setText(R.string.phone_text_view);

        mPhoneEditText = (EditText) findViewById(R.id.editPhone);
        mNameEditText = (EditText) findViewById(R.id.editName);

        mDoneButton = (Button)findViewById(R.id.done_button);
        mDoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mNameStr = mNameEditText.getText().toString();
                mPhoneStr = mPhoneEditText.getText().toString();

     //Deprecating Contact Storage For Demo Day, as it doesnt work yet
                //ALL contacts stored in dummy XML
               // mContactKey=mPhoneStr+mNameStr;
               // SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
              //  editor.putString("mPhoneStr", mContactKey);
             //   editor.commit();


                finish();
            }
        });

        mCancelButton = (Button)findViewById(R.id.cancel_button);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

    }

}


