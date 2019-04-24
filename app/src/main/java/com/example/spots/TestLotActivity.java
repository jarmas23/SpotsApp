package com.example.spots;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TestLotActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference spot1Ref;
    DatabaseReference spot2Ref;
    DatabaseReference spot3Ref;
    TextView text;
    TextView spot1;
    TextView spot2;
    TextView spot3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_lot);

        /**creates firebase read test**/
        text = findViewById(R.id.mytext);
        /**creates spot boxes**/
        spot1 = findViewById(R.id.spot1box);
        spot2 = findViewById(R.id.spot2box);
        spot3 = findViewById(R.id.spot3box);

        database = FirebaseDatabase.getInstance();
        spot1Ref = database.getReference("Test Lot/Spot1");
        spot2Ref = database.getReference("Test Lot/Spot2");
        spot3Ref = database.getReference("Test Lot/Spot3");
        //readFromDatabase();
        updateSpot1();
        updateSpot2();
        updateSpot3();

    }

    public void updateSpot1() {
        spot1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Long value = (Long) dataSnapshot.getValue();
                if (value == 0) {
                    GradientDrawable gradientDrawable = (GradientDrawable) spot1.getBackground().mutate();
                    gradientDrawable.setColor(Color.GREEN);
                }

                else {
                    GradientDrawable gradientDrawable = (GradientDrawable) spot1.getBackground().mutate();
                    gradientDrawable.setColor(Color.RED);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void updateSpot2() {
        spot2Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Long value = (Long) dataSnapshot.getValue();
                if (value == 0) {
                    GradientDrawable gradientDrawable = (GradientDrawable) spot2.getBackground().mutate();
                    gradientDrawable.setColor(Color.GREEN);
                }

                else {
                    GradientDrawable gradientDrawable = (GradientDrawable) spot2.getBackground().mutate();
                    gradientDrawable.setColor(Color.RED);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void updateSpot3() {
        spot3Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                Long value = (Long) dataSnapshot.getValue();
                if (value == 0) {
                    GradientDrawable gradientDrawable = (GradientDrawable) spot3.getBackground().mutate();
                    gradientDrawable.setColor(Color.GREEN);
                }

                else {
                    GradientDrawable gradientDrawable = (GradientDrawable) spot3.getBackground().mutate();
                    gradientDrawable.setColor(Color.RED);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    /** Function readFromDatabase is a test function that reads and outputs value spot1
     * public void readFromDatabase() {

        spot1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = dataSnapshot.getValue(String.class);

                text.setText(value);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }**/

}
