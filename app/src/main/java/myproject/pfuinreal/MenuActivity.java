package myproject.pfuinreal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button btnMateri,btnVideo,btnLatihan;
    Intent intent;
    private String key;
    String urlGelCahaya = "https://youtu.be/FaRl8MQncA4";
    String urlPembiasan = "https://youtu.be/-q55TY-MSSo";
    String urlInduksi1 = "https://youtu.be/mlGDghlFd7A";
    String urlInduksi2 = "https://youtu.be/2t37YfYa47w";
    String urlMagnet = "https://youtu.be/C2pb9Urion8";
    String urlKapasitor = "https://youtu.be/X-piU6i0DuU";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        intent = getIntent();
        key = intent.getStringExtra("key");

        btnLatihan = findViewById(R.id.btnLatihan);
        btnMateri = findViewById(R.id.btnMateri);
        btnVideo = findViewById(R.id.btnVideo);

        btnMateri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ViewMateriActivity.class);
                i.putExtra("key",key);
                startActivity(i);
            }
        });
        btnLatihan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LatihanActivity.class);
                i.putExtra("key",key);
                startActivity(i);
            }
        });

        if (key.equals("gel_cahaya")){

            btnVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uriUrl = Uri.parse(urlGelCahaya);
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
            });

        }else if (key.equals("pembiasan")){
            btnVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uriUrl = Uri.parse(urlPembiasan);
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
            });

        }else if (key.equals("induksi1")){
            btnVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uriUrl = Uri.parse(urlInduksi1);
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
            });

        }else if (key.equals("induksi2")){
            btnVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uriUrl = Uri.parse(urlInduksi2);
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
            });

        }else if (key.equals("medan_magnet")){
            btnVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uriUrl = Uri.parse(urlMagnet);
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
            });

        }else if (key.equals("kapasitor")){
            btnVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri uriUrl = Uri.parse(urlKapasitor);
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }
            });

        }

    }
}
