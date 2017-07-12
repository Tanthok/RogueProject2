package edu.gsu.httpscs.rogueproject;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import edu.gsu.httpscs.rogueproject.adapter.BaseViewPagerAdapter;
import edu.gsu.httpscs.rogueproject.fragment.BlueFragment;
import edu.gsu.httpscs.rogueproject.fragment.GreenFragment;
import edu.gsu.httpscs.rogueproject.fragment.OrangeFragment;
import edu.gsu.httpscs.rogueproject.fragment.RedFragment;

public class ViewPagerActivity extends BaseActivity {

    private ViewPager viewPager;
    private ArrayList<Fragment> list = new ArrayList<Fragment>() ;//don't pick Fragment app one only for android 5 up

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        Toast.makeText(this,"onCreate",Toast.LENGTH_SHORT).show();
        Log.d("LifeCycle","onCreate");
        viewPager = (ViewPager)findViewById(R.id.activity_view_pager);
        //This is the Create of a Fragment Having Three Pages Green,Red,Blue
        list.add(new RedFragment());
        list.add(new GreenFragment());
        list.add(new BlueFragment());
        list.add(new OrangeFragment());
        BaseViewPagerAdapter pagerAdapter = new BaseViewPagerAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setNestedScrollingEnabled(true);
        viewPager.setCurrentItem(0); //Is a way to set what page you want the user to see first with in a fragment


    }
    public ViewPagerActivity() {
        super();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle","OnStart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle","onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle","onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle","onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle","onDestroy");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LifeCycle","onRestart");
    }
}
