package com.rajdeep.blesender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button service,mSendButton;
    EditText edt_send_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_send_text=(EditText)findViewById(R.id.edt_send_text);
        mSendButton=(Button) findViewById(R.id.mSendButton);

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BleSenderApplicationClass mBleSenderApplicationClass = (BleSenderApplicationClass) getApplicationContext();
                mBleSenderApplicationClass.setSomeString(edt_send_text.getText().toString().trim());
            }
        });

        service= (Button)findViewById(R.id.service);
        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent serviceIntent = new Intent(getApplicationContext(), BleTestService.class);
                serviceIntent.putExtra("bluetooth_device", "80:6C:1B:84:C8:DC");
                ContextCompat.startForegroundService(MainActivity.this, serviceIntent);
            }
        });
    }
}
