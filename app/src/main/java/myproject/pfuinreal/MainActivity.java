package myproject.pfuinreal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    DBAdapter mDB;
    private User mUser;
    private List<User> mlistUser;
    private String username,password,nama,userID;
    EditText etUsername,etPass;
    public static List<String> listUsername = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDB = DBAdapter.getInstance(getApplicationContext());
        mlistUser = mDB.getAllUser();

        btnLogin = (Button) findViewById(R.id.loginBtn);
        etUsername = findViewById(R.id.login_id);
        etPass = findViewById(R.id.login_password);

        listUsername.clear();
        for (int d=0;d<mlistUser.size();d++){
            mUser = mlistUser.get(d);
            listUsername.add(mUser.getUsername());
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String getUsername = etUsername.getText().toString();
                String getPassword = etPass.getText().toString();

                if (getUsername.equals("") || getUsername.length() == 0
                        || getPassword.equals("") || getPassword.length() == 0) {

                    customToast("NPM dan password harus diisi");
                }else {

                    for (int c=0;c<mlistUser.size();c++){
                        mUser = mlistUser.get(c);
                        username = mUser.getUsername();
                        password = mUser.getPassword();

                        if (listUsername.contains(getUsername)){
                            if (getUsername.equals(username)){
                                if (getUsername.equals(username) && getPassword.equals(password) ){

                                    SharedVariable.nama = mUser.getNama();
                                    SharedVariable.userID = mUser.getId();
                                    SharedVariable.username = mUser.getUsername();
                                    Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                                    startActivity(intent);
                                }else {
                                    customToast("Password salah !");
                                }
                            }
                        }else {
                            customToast("ID tidak ditemukan !");
                        }

                    }
                }
            }
        });
    }

    public  void customToast(String s){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.toast_root));

        TextView text = (TextView) layout.findViewById(R.id.toast_error);
        text.setText(s);
        Toast toast = new Toast(getApplicationContext());// Get Toast Context
        toast.setGravity(Gravity.TOP | Gravity.FILL_HORIZONTAL, 0, 0);// Set
        toast.setDuration(Toast.LENGTH_SHORT);// Set Duration
        toast.setView(layout); // Set Custom View over toast
        toast.show();// Finally show toast
    }
}
