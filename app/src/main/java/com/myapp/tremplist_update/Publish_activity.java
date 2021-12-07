package com.myapp.tremplist_update;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Publish_activity extends AppCompatActivity {
    FireBaseDBActivity fb;

    Button publish_Btn;
    private String src_city;
    private String src_details;
    private String dst_city;
    private String dst_details;

    private Date date;
    private Hour hour;

    private String car_type;
    private String car_color;
    private int sits;
    private int free_sits;
    private int ride_cost;


    TextInputEditText txt_src_city;
    TextInputEditText txt_src_details;
    TextInputEditText txt_dst_city;
    TextInputEditText txt_dst_details;
    TextInputEditText txt_date;
    TextInputEditText txt_hour;
    TextInputEditText txt_car_type;
    TextInputEditText txt_car_color;
    TextInputEditText txt_sits;
    TextInputEditText txt_ride_cost;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_ride);
        publish_Btn = findViewById(R.id.publish);

        txt_src_city = findViewById(R.id.src_city);
        txt_src_details = findViewById(R.id.src_detail);
        txt_dst_city = findViewById(R.id.dest_city);
        txt_dst_details = findViewById(R.id.dest_detail);
        txt_date = findViewById(R.id.date);
        txt_hour = findViewById(R.id.hour);
        txt_car_type = findViewById(R.id.car_type);
        txt_car_color = findViewById(R.id.car_color);
        txt_sits = findViewById(R.id.sits);
        txt_ride_cost = findViewById(R.id.cost);

                 publish_Btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    src_city = Objects.requireNonNull(txt_src_city.getText()).toString();
                    src_details = Objects.requireNonNull(txt_src_details.getText()).toString();
                    dst_city = Objects.requireNonNull(txt_dst_city.getText()).toString();
                    dst_details = Objects.requireNonNull(txt_dst_details.getText()).toString();
                    String tmp_date = Objects.requireNonNull(txt_date.getText()).toString();
                    String tmp_hour = Objects.requireNonNull(txt_hour.getText()).toString();
                    car_type = Objects.requireNonNull(txt_car_type.getText()).toString();
                    car_color = Objects.requireNonNull(txt_car_color.getText()).toString();
                    String tmp_sits = Objects.requireNonNull(txt_sits.getText()).toString();
                    String tmp_ride_cost = Objects.requireNonNull(txt_ride_cost.getText()).toString();

                    if (TextUtils.isEmpty(src_city)) {
                        txt_src_city.setError("Src city cannot be empty");
                        txt_src_city.requestFocus();
                    } else if (TextUtils.isEmpty(dst_city)) {
                        txt_dst_city.setError("Dest city cannot be empty");
                        txt_dst_city.requestFocus();
                    } else if (TextUtils.isEmpty(tmp_date)) {
                        txt_date.setError("Date Name cannot be empty");
                        txt_date.requestFocus();
                    } else if (TextUtils.isEmpty(tmp_hour)) {
                        txt_hour.setError("Hour cannot be empty");
                        txt_hour.requestFocus();
                    } else if (TextUtils.isEmpty(tmp_sits)){
                        txt_sits.setError("Number of sits cannot be empty");
                        txt_sits.requestFocus();
                    } else if (TextUtils.isEmpty(tmp_ride_cost)){
                        txt_ride_cost.setError("Ride cost cannot be empty");
                        txt_ride_cost.requestFocus();
                    }
                    else {

                        String[] date_arr = tmp_date.split(".");
                        if (date_arr.length == 3) {
                            date = new Date(Integer.parseInt(date_arr[0]), Integer.parseInt(date_arr[1]), Integer.parseInt(date_arr[2]));
                            Log.d("DATE","day: "+date.getDay()+", month: "+date.getMonth()+", year: "+date.getYear());
                        }else{
                            Log.d("DATE","LEN= "+date_arr.length+", date= "+tmp_date);
                        }
                        String[] hour_arr = tmp_hour.split(":");
                        if (hour_arr.length == 2) {
                            hour = new Hour(Integer.parseInt(hour_arr[0]), Integer.parseInt(hour_arr[1]));
                        }
                        sits = Integer.parseInt(tmp_sits);
                        ride_cost = Integer.parseInt(tmp_ride_cost);

                        Ride ride = new Ride(src_city, dst_city, date, hour, sits, ride_cost);
                        fb = new FireBaseDBActivity();
                        fb.addRideToDB(ride);
                    }


                }
            });
    }
}
