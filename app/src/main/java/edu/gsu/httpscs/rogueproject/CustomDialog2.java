package edu.gsu.httpscs.rogueproject;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.view.View;
import android.app.Dialog;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.gsu.httpscs.rogueproject.R;




//*Inorder to do a Custom Dialog you must,
// create your style in the style folder, so you can make the call "R.style.dialog"*/
public class CustomDialog2 extends Dialog{

    private final ICustomDialongListener listener;

    public interface ICustomDialongListener{
        public void onOKClicked(String msg);
//        public void onCancleCLicked();
    }

    private int checkedID = 0;
    @BindView(R.id.dialog_quiz3_rdg)
    RadioGroup radioGroup;

    @OnClick(R.id.dialog_quiz3_cancel)
    public void cancel(View v) {
        cancel();
    }

    @OnClick(R.id.dialog_quiz3_ok)
    public void ok(View v) {
        switch (checkedID) {
            case R.id.dialog_custom_rb1:
                listener.onOKClicked("You clicked yes");
                cancel();
                break;
            case R.id.dialog_custom_rb2:
                listener.onOKClicked("You clicked no");
                cancel();
                break;
            case R.id.dialog_custom_rb3:
                dismiss();
                System.exit(0);
                break;

            default:

        }
    }

    public void showToastYes(){
        Toast.makeText(getContext(), "you clicked Yes", Toast.LENGTH_SHORT).show();
    }



    public CustomDialog2(@NonNull Context context, ICustomDialongListener listener){
        super(context, R.style.dialog);
        setContentView(R.layout.activity_custom_dialog2);
        ButterKnife.bind(this);
        this.listener = listener;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                checkedID = checkedId;
            }
        });
    }
}
