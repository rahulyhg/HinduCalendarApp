package app.calendar.hindu.hinducalendarapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import utils.CustomDate;
import utils.DateGridAdapter;

public class CalenderGridView extends AppCompatActivity {

    ArrayList<CustomDate> customDateArrayList =new ArrayList<>() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender_grid_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        createDateDummyData();

        GridView gridView = (GridView) findViewById(R.id.calendarView_gridView);

        gridView.setAdapter(new DateGridAdapter(this,customDateArrayList));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CalenderGridView.this , DateFullDetailActivity.class);
                intent.putExtra("hinduMonth" , customDateArrayList.get(position).getHinduMonth());
                intent.putExtra("event",customDateArrayList.get(position).getEvent());

                startActivity(intent);
            }
        });
    }

    private void createDateDummyData() {
        for(int i =1; i<32 ; i++){
            CustomDate customDate =new CustomDate(i);
            customDate.setHinduMonth("Jyestha");

            if(i%4 == 0){
               customDate.setEvent("Durgasthmi\nRakhi");
            }
            customDateArrayList.add(customDate);
        }
    }

}
