package myproject.pfuinreal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MateriFisikaDasar2Activity extends AppCompatActivity {

    Button btnGelCahaya,btnPembiasanLensa,btnInduksiElektro1,btnInduksiElektro2,btnMedMagKawat,btnKapasitor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_fisika_dasar2);

        btnGelCahaya = findViewById(R.id.btnGelCahaya);
        btnPembiasanLensa = findViewById(R.id.btnPembiasanLensa);
        btnInduksiElektro1 = findViewById(R.id.btnInduksiElektro1);
        btnInduksiElektro2 = findViewById(R.id.btnInduksiElektro2);
        btnMedMagKawat = findViewById(R.id.btnMedMagKawat);
        btnKapasitor = findViewById(R.id.btnKapasitor);

        btnGelCahaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SharedVariable.pilih.equals("B")){
                    Intent i = new Intent(getApplicationContext(),MenuActivity.class);
                    i.putExtra("key","gel_cahaya");
                    startActivity(i);
                }else if (SharedVariable.pilih.equals("A")){
                    Intent i = new Intent(getApplicationContext(),ViewPanduanPraktikum.class);
                    i.putExtra("key","gel_cahaya");
                    startActivity(i);
                }
            }
        });
        btnPembiasanLensa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SharedVariable.pilih.equals("B")){
                    Intent i = new Intent(getApplicationContext(),MenuActivity.class);
                    i.putExtra("key","pembiasan");
                    startActivity(i);
                }else if (SharedVariable.pilih.equals("A")){
                    Intent i = new Intent(getApplicationContext(),ViewPanduanPraktikum.class);
                    i.putExtra("key","pembiasan");
                    startActivity(i);
                }
            }
        });
        btnInduksiElektro1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SharedVariable.pilih.equals("B")){
                    Intent i = new Intent(getApplicationContext(),MenuActivity.class);
                    i.putExtra("key","induksi1");
                    startActivity(i);
                }else if (SharedVariable.pilih.equals("A")){
                    Intent i = new Intent(getApplicationContext(),ViewPanduanPraktikum.class);
                    i.putExtra("key","induksi1");
                    startActivity(i);
                }
            }
        });
        btnInduksiElektro2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SharedVariable.pilih.equals("B")){
                    Intent i = new Intent(getApplicationContext(),MenuActivity.class);
                    i.putExtra("key","induksi2");
                    startActivity(i);
                }else if (SharedVariable.pilih.equals("A")){
                    Intent i = new Intent(getApplicationContext(),ViewPanduanPraktikum.class);
                    i.putExtra("key","induksi2");
                    startActivity(i);
                }
            }
        });
        btnMedMagKawat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SharedVariable.pilih.equals("B")){
                    Intent i = new Intent(getApplicationContext(),MenuActivity.class);
                    i.putExtra("key","medan_magnet");
                    startActivity(i);
                }else if (SharedVariable.pilih.equals("A")){
                    Intent i = new Intent(getApplicationContext(),ViewPanduanPraktikum.class);
                    i.putExtra("key","medan_magnet");
                    startActivity(i);
                }
            }
        });
        btnKapasitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SharedVariable.pilih.equals("B")){
                    Intent i = new Intent(getApplicationContext(),MenuActivity.class);
                    i.putExtra("key","kapasitor");
                    startActivity(i);
                }else if (SharedVariable.pilih.equals("A")){
                    Intent i = new Intent(getApplicationContext(),ViewPanduanPraktikum.class);
                    i.putExtra("key","kapasitor");
                    startActivity(i);
                }
            }
        });
    }
}
