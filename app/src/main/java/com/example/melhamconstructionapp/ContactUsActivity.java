package com.example.melhamconstructionapp;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.widget.ImageButton;

import android.util.Patterns;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;


import com.example.melhamconstructionapp.databinding.ActivityContactUsBinding;

public class ContactUsActivity extends DrawerBaseActivity {

    public String mEmailSender, mName, mMessage, mSubject;
    private EditText _editTextNameContactUs, _editTextEmailContactUs, _editTextSubjectContactUs, _editTextTextPersonName4;
    private Button _btnSubmitContactUs;


    ImageButton myImageButton;

    ActivityContactUsBinding activityContactUsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityContactUsBinding = ActivityContactUsBinding.inflate(getLayoutInflater());
        setContentView(activityContactUsBinding.getRoot());
        allocateActivityTitle("Contact Us");



        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        //Hide navigation bar
        //getSupportActionBar().hide();
    //map activity
        myImageButton = findViewById(R.id.map_button);
        myImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(ContactUsActivity.this, MapsActivity2.class);
                startActivity(intentLoadNewActivity);



            }
        });

        _editTextNameContactUs = findViewById(R.id.editTextNameContactUs);
        _editTextEmailContactUs = findViewById(R.id.editTextEmailContactUs);
        _editTextSubjectContactUs = findViewById(R.id.editTextSubjectContactUs);
        _editTextTextPersonName4 = findViewById(R.id.editTextTextPersonName4);
        _btnSubmitContactUs = findViewById(R.id.btnSubmitContactUs);



//Email sender button
        _btnSubmitContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    if (validator(_editTextNameContactUs, _editTextEmailContactUs, _editTextSubjectContactUs, _editTextTextPersonName4)) {
                        senEmail();

                        Toast.makeText(ContactUsActivity.this, "EMAIL SENT", Toast.LENGTH_SHORT).show();


                        _editTextNameContactUs.setText("");
                        _editTextEmailContactUs.setText("");
                        _editTextSubjectContactUs.setText("");
                        _editTextTextPersonName4.setText("");

                        _btnSubmitContactUs.setEnabled(false);

                    } else {


                    }

            }

//Contact Us Validation
            public boolean validator(EditText _editTextNameContactUs, EditText _editTextEmailContactUs, EditText _editTextSubjectContactUs, EditText  _editTextTextPersonName4){

                mEmailSender = _editTextNameContactUs.getText().toString().trim().replaceAll(" +", " ");
                mName =  _editTextEmailContactUs.getText().toString().trim().replaceAll(" +", " ");
                mSubject =  _editTextSubjectContactUs.getText().toString();
                mMessage = _editTextTextPersonName4.getText().toString();


                if( mEmailSender.isEmpty() || mSubject.isEmpty() || mMessage.isEmpty() || mName.isEmpty()){
                    Toast.makeText(ContactUsActivity.this, "Please fill up the credentials above", Toast.LENGTH_SHORT).show();
                    return false;
                }
                else if(!mName.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(mName).matches()){
                    return true;
                }
                else{
                    Toast.makeText(ContactUsActivity.this, "Invalid Email Address", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }

//Email composition
            private void senEmail() {
                String mEmail = "dhiejay021@gmail.com";


                String mMessage2 = "\n\n\n Contact Details \nGmail Account: " + mName + "\nName: " + mEmailSender;
                String mMessage3 = mMessage + mMessage2;


                JavaMailAPI javaMailAPI = new JavaMailAPI(ContactUsActivity.this, mEmail, mSubject, mMessage3);

                javaMailAPI.execute();


            }

        });


    }

    //Facebook activity
    public void fbClick(View view) {
        startActivity(getOpenFacebookIntent());
    }
    public Intent getOpenFacebookIntent() {
        try {
            getPackageManager().getPackageInfo("com.facebook.katana", 0);
            return new Intent(Intent.ACTION_VIEW, Uri.parse("fb://page/287670423497705"));
        } catch (Exception e) {
            return new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/melhamconstruction"));
        }
    }

    //LinkedIn activity
    public void liClick(View view){
        openUrl("https://www.linkedin.com/in/melhamconstructioncorporation/");
    }
    public void openUrl(String url){
        Uri uri = Uri.parse(url);
        Intent launchWeb = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(launchWeb);
    }

    private void allocateActivityTitle(String contact_us) {
    }

    }





