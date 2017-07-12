package edu.gsu.httpscs.rogueproject;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SharedPreferenceActivity extends BaseActivity {
    @BindView(R.id.activity_sharedpreference_email)
    EditText emailEditText;
    @BindView(R.id.activity_sharedpreference_password)
    EditText passwordEditText;

    private final String EMAIL="email";
    private final String PASSWORD="password";
    private final String USER = "user";

    @OnClick(R.id.activity_sharedpreference_clear)
    public void clear(View v){
        SharedPreferences sp = getSharedPreferences(USER,MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
//        editor.remove(EMAIL);
//        editor.remove(PASSWORD);
        editor.commit();
        emailEditText.setText("");
        passwordEditText.setText("");
        shortToast("You cleared all the Content");
    }
    @OnClick(R.id.activity_sharedpreference_register)
    public void register(View v){
        shortToast("Please Register your account.");
        gotoActivity(RegisterActivity.class);

    }
    @OnClick(R.id.activity_sharedpreference_login)
    public void login(View v){
        String email = email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        if(check(email,password)){
            shortToast("Login Sucess");
        }
    }

    private boolean check(String email, String password) {
        //ingore the check;
        boolean passwordCorrect = true;
        if(passwordCorrect){
            SharedPreferences sp = getSharedPreferences(USER,MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("email",email);
            editor.putString("password",password);
            editor.commit();
            return true;
        }else{
            return false;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference);
        ButterKnife.bind(this);
        retriveLoginInfo();
    }
    private void retriveLoginInfo(){
        SharedPreferences sp = getSharedPreferences("user",MODE_PRIVATE);
        String email = sp.getString(EMAIL,"null");
        String password = sp.getString(PASSWORD,"null");
        if(!email.equals("null")){
            emailEditText.setText(email);
            passwordEditText.setText(password);
        }
    }
}
