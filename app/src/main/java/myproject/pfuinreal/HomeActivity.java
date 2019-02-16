package myproject.pfuinreal;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    ImageButton ibMateri,ibLatihan,ibPembuat;
    String urlSiakad = "https://aplikasi.radenintan.ac.id/fd";
    DialogInterface.OnClickListener listener;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ibMateri = (ImageButton) findViewById(R.id.ibMateri);
        ibLatihan = findViewById(R.id.ibLatihan);
        ibPembuat = findViewById(R.id.ibPembuat);

        ibMateri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedVariable.pilih = "A";
                Intent intent = new Intent(HomeActivity.this,ListMateriUtama.class);
                startActivity(intent);
            }
        });
        ibPembuat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,ProfilActivity.class);
                startActivity(intent);
            }
        });
        ibLatihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(getApplicationContext(),"nama : "+SharedVariable.nama,Toast.LENGTH_SHORT).show();
                SharedVariable.pilih = "B";
                Intent intent = new Intent(HomeActivity.this,ListMateriUtama.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Apakan anda ingin keluar dari aplikasi ?");
        builder.setCancelable(false);

        listener = new DialogInterface.OnClickListener()
        {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which == DialogInterface.BUTTON_POSITIVE){
                    finishAffinity();
                    System.exit(0);
                }

                if(which == DialogInterface.BUTTON_NEGATIVE){
                    dialog.cancel();
                }
            }
        };
        builder.setPositiveButton("Ya",listener);
        builder.setNegativeButton("Tidak", listener);
        builder.show();
    }
}
