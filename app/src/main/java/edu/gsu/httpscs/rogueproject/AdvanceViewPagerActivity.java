package edu.gsu.httpscs.rogueproject;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.gsu.httpscs.rogueproject.adapter.ViewFragmentStateAdapter;


import edu.gsu.httpscs.rogueproject.fragment.SubAbilitiesFragment;
import edu.gsu.httpscs.rogueproject.fragment.SubOverviewFragment;
import edu.gsu.httpscs.rogueproject.fragment.SubRotationFragment;
import edu.gsu.httpscs.rogueproject.fragment.SubTalentsFragment;

public class AdvanceViewPagerActivity extends BaseActivity {
    private ArrayList<Pair<String,Fragment>> list = new ArrayList<Pair<String,Fragment>>();

    @BindView(R.id.advance_view_pager_tablayout)
    TabLayout tabLayout;

    @BindView(R.id.activity_advance_view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_view_pager);
        ButterKnife.bind(this);
        list.add(new Pair<String, Fragment>("Overview",new SubOverviewFragment()));
        list.add(new Pair<String, Fragment>("Abilities",new SubAbilitiesFragment()));
        list.add(new Pair<String, Fragment>("Talents",new SubTalentsFragment()));

        ViewFragmentStateAdapter adapter =
                new ViewFragmentStateAdapter(this.getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

}
