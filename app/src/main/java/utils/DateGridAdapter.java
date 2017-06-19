package utils;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.*;

import app.calendar.hindu.hinducalendarapp.R;

/**
 * Created by bunny on 19/06/17.
 */

public class DateGridAdapter extends BaseAdapter {
    private Activity mContext;
    ArrayList<CustomDate> customDateArrayList;
    public static int width , height ;

    // Constructor
    public DateGridAdapter(Activity c, ArrayList<CustomDate> customDates) {
        mContext = c;
        customDateArrayList = customDates;

        DisplayMetrics metrics = new DisplayMetrics();
        c.getWindowManager().getDefaultDisplay().getMetrics(metrics);

         width = metrics.widthPixels/6;
         height = metrics.heightPixels/6;
    }

    @Override
    public int getCount() {
        return customDateArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return customDateArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View cellView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.date_grid_adapter_cell, parent, false);

        cellView.setMinimumHeight(height);
        CustomDate customDate = customDateArrayList.get(position);

        TextView textView = (TextView) cellView.findViewById(R.id.dateGridAdapterCell_date_textView);
        textView.setText(String.valueOf(customDate.getDate()));

        textView = (TextView) cellView.findViewById(R.id.dateGridAdapterCell_event_textView);
        textView.setText(customDate.getEvent());

        CardView cardView = (CardView)cellView.findViewById(R.id.dateGridAdapterCell_backgroung_cardView);
        cardView.setMinimumHeight(height);




        return cellView;
    }

}