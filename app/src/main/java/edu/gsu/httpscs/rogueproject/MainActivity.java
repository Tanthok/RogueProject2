package edu.gsu.httpscs.rogueproject;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import edu.gsu.httpscs.rogueproject.fragment.DemoFragment;
import edu.gsu.httpscs.rogueproject.fragment.SubOverviewFragment;
import edu.gsu.httpscs.rogueproject.fragment.WorkFragment;

public class MainActivity extends AppCompatActivity {

    private TextView tv_demo;
    private TextView tv_work;
    private TextView tv_sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        setListener();
    }

    private void initialView() {
        tv_demo =(TextView)findViewById(R.id.activity_tool_demo);
        tv_work =(TextView)findViewById(R.id.activity_tool_work);
        tv_sub =(TextView)findViewById(R.id.activity_tool_sub);
    }

    private void setListener() {
        final WorkFragment workFragment = new WorkFragment();
        final DemoFragment demoFragment = new DemoFragment();
        final SubOverviewFragment subFragment = new SubOverviewFragment();

        //Making Clickable Reaction
        tv_demo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tv_sub.setTextColor(Color.BLACK);
                tv_work.setTextColor(Color.BLACK);//Switch Color of Text Back and Forth
                tv_demo.setTextColor(Color.RED);
                   //Button "Work"
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.activity_main_fragment,demoFragment).commit();
            }
        });
        View.OnClickListener listener1 = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tv_demo.setTextColor(Color.BLACK);
                tv_work.setTextColor(Color.BLACK);
                tv_sub.setTextColor(Color.RED);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.activity_main_fragment,subFragment).commit();
            }
        };
        tv_sub.setOnClickListener(listener1);
            View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    /*Toast is used for a Pop-up
                    Toast.makeText(MainActivity.this,"You clicked demo",Toast.LENGTH_SHORT).show();*/
                tv_sub.setTextColor(Color.BLACK);
                tv_demo.setTextColor(Color.BLACK);
                tv_work.setTextColor(Color.RED);//Setting the ColorText of Buttons
                //Button "Demo"
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.activity_main_fragment,workFragment).commit();
            }
        };
        tv_work.setOnClickListener(listener);

    }
    public void login(View v){
        Toast.makeText(MainActivity.this,"You have Clicked Login",Toast.LENGTH_SHORT).show();
        Intent startNewActivity = new Intent(this, SharedPreferenceActivity.class);
        startActivity(startNewActivity);
    }
}
