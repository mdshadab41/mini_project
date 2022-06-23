package com.example.reblissprofile;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int pic_id = 123;



    ImageButton camera_open_id;
    ImageView click_image_id;

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camera_open_id = (ImageButton)  findViewById(R.id.camera_button);
        click_image_id = (ImageView) findViewById(R.id.click_image);


        //Section -- Spinner
        spinner = (Spinner)findViewById(R.id.spinner);

        String[] country = new String[]{
                "India", "USA", "China", "Japan", "Other"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, country);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);


        //Radio Button

        RadioGroup radioGroup;
        Button submit, clear;

        submit = (Button)findViewById(R.id.submit);
        clear = (Button)findViewById(R.id.clear);
        radioGroup = (RadioGroup)findViewById(R.id.groupradio);

        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override

            public void onCheckedChanged(RadioGroup group, int checkedId)
            {

                RadioButton radioButton = (RadioButton)group.findViewById(checkedId);
            }
        });
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {


                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(MainActivity.this, "No answer has been selected", Toast.LENGTH_SHORT).show();
                }
                else {

                    RadioButton radioButton = (RadioButton)radioGroup.findViewById(selectedId);

                    Toast.makeText(MainActivity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {

                radioGroup.clearCheck();
            }
        });












         // Start here | Camera with Button Section
        camera_open_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camera_intent, pic_id);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == pic_id) {

            Bitmap photo = (Bitmap) data.getExtras()
                    .get("data");

            click_image_id.setImageBitmap(photo);

        }

    }
        public void pressTxtBtn(View view)
        {
            Toast.makeText(this, "Welcome to rebliss", Toast.LENGTH_SHORT).show();

        }



    }