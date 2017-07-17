package edu.gsu.httpscs.rogueproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpscs.rogueproject.dialog.CustomDialog2;

public class RegisterActivity extends BaseActivity {

    @OnClick(R.id.activity_register_create)
    public void create(View v){
        shortToast("You have Registered your Account!");
        gotoActivity(SharedPreferenceActivity.class);
    }
    @OnClick(R.id.activity_register_gender)
    public void register(View v) {

        CustomDialog2 customDialog =
                new CustomDialog2(this, new CustomDialog2.ICustomDialongListener() {
                    @Override
                    public void onOKClicked(String msg) {
                        shortToast(msg);
                    }
                });
        //This ables the user to touch the empty space to go back
        customDialog.setCanceledOnTouchOutside(true);
        customDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
    }
}
