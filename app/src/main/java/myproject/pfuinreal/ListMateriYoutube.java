package myproject.pfuinreal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ListMateriYoutube extends AppCompatActivity {

    Button btnGelCahaya,btnPembiasanLensa,btnInduksiElektro1,btnInduksiElektro2,btnMedMagKawat,btnKapasitor;
    String urlGelCahaya = "https://youtu.be/FaRl8MQncA4";
    String urlPembiasan = "https://youtu.be/-q55TY-MSSo";
    String urlInduksi1 = "https://youtu.be/mlGDghlFd7A";
    String urlInduksi2 = "https://youtu.be/2t37YfYa47w";
    String urlMagnet = "https://youtu.be/C2pb9Urion8";
    String urlKapasitor = "https://youtu.be/X-piU6i0DuU";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_materi_youtube);

        btnGelCahaya = findViewById(R.id.btnGelCahaya);
        btnPembiasanLensa = findViewById(R.id.btnPembiasanLensa);
        btnInduksiElektro1 = findViewById(R.id.btnInduksiElektro1);
        btnInduksiElektro2 = findViewById(R.id.btnInduksiElektro2);
        btnMedMagKawat = findViewById(R.id.btnMedMagKawat);
        btnKapasitor = findViewById(R.id.btnKapasitor);

        btnGelCahaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnPembiasanLensa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uriUrl = Uri.parse(urlPembiasan);
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });
        btnInduksiElektro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uriUrl = Uri.parse(urlInduksi1);
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });
        btnInduksiElektro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uriUrl = Uri.parse(urlInduksi2);
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });
        btnMedMagKawat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uriUrl = Uri.parse(urlMagnet);
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });
        btnKapasitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uriUrl = Uri.parse(urlKapasitor);
                Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(launchBrowser);
            }
        });
    }
}
