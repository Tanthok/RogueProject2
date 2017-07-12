package edu.gsu.httpscs.rogueproject.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import edu.gsu.httpscs.rogueproject.AdvanceViewPagerActivity;
import edu.gsu.httpscs.rogueproject.GestureActivity;
import edu.gsu.httpscs.rogueproject.R;
import edu.gsu.httpscs.rogueproject.ViewPagerActivity;
import edu.gsu.httpscs.rogueproject.adapter.ListNormalAdapter;


public class DemoFragment extends Fragment {
    private final ArrayList<String> contentList;
    private final Context context;
    private ListView listView;

    public DemoFragment() {
        context = getContext();
        contentList = new ArrayList<String>();
        contentList.add("ViewPager-Stat Weights");
        contentList.add("AdvanceViewPagerActivity-Spec Overview");
        contentList.add("GestureActivity-Rotation");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        listView = (ListView) view.findViewById(R.id.fragment_demo_lv);//Getting ID number of specific page of this ListView
        ListNormalAdapter adapter = new ListNormalAdapter(this.getContext(), contentList);//Pulling Content from specific View ID
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(getActivity(),ViewPagerActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity(),AdvanceViewPagerActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(getActivity(),GestureActivity.class);
                        startActivity(intent2);
                        break;
                    default:

                }
            }
        });
        return view;
    }
}
