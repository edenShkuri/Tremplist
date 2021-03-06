package com.myapp.tremplist_update.viewModel;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.myapp.tremplist_update.R;
import com.myapp.tremplist_update.fireBase.FireBaseDBActivity;

public class DriverFirstPage extends AppCompatActivity {
    Button publish_rideBtn;
    Button myRidesBtn;
    Button Mywaiting_list;
    TextView rate;

    FirebaseAuth mauth;
    FireBaseDBActivity fb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_first_page);
        mauth = FirebaseAuth.getInstance();
        String user_id = mauth.getCurrentUser().getUid();
        fb = new FireBaseDBActivity();
        fb.setContext(DriverFirstPage.this);


        publish_rideBtn = (Button)findViewById(R.id.publish_ride);
        myRidesBtn = (Button)findViewById(R.id.driver_my_rides);
        Mywaiting_list = (Button)findViewById(R.id.waiting_to_approve);

        rate = findViewById(R.id.rate);
        fb.showRate(rate);

        publish_rideBtn.setOnClickListener(view -> {
            startActivity(new Intent(DriverFirstPage.this, Publish_activity.class));
        });

        myRidesBtn.setOnClickListener(view -> {
            startActivity(new Intent(DriverFirstPage.this, My_rides_Driver_Activity.class));
        });

        Mywaiting_list.setOnClickListener(view -> {
            startActivity(new Intent(DriverFirstPage.this, driver_waiting_listActivity.class));
        });


    }

}
