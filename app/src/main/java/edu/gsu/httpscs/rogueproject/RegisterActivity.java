package edu.gsu.httpscs.rogueproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.OnClick;

public class RegisterActivity extends BaseActivity {


    //@OnClick(R.id.activity_quiz3_quiz1bt)
    public void ok(View v) {

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
    }
}
