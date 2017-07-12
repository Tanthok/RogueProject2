package edu.gsu.httpscs.rogueproject.adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import edu.gsu.httpscs.rogueproject.R;

public class ListNormalAdapter extends BaseAdapter {

    private final Context context;
    private final LayoutInflater inflater;
    private final ArrayList<String> list;

    public ListNormalAdapter(Context context, ArrayList<String> list){
        this.context = context;
        this.list = list;
        //Reason4 inflater.. helps on Convert a Layout to a View
        inflater = (LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.list_normal_item);
//    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.list_normal_item, parent,false);
        TextView tv=(TextView) convertView.findViewById(R.id.item_normal_tv);
        tv.setText(list.get(position)); //Used for a Dynamic set of items
        //tv.setText("Text"); used for a Static set of items
        return tv;
    }
}
