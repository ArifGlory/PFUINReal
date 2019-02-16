package myproject.pfuinreal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import Adapter.RecycleAdapterGelCahaya;
import Adapter.RecycleAdapterHistory;
import Adapter.RecycleAdapterInduksi1;
import Adapter.RecycleAdapterInduksi2;
import Adapter.RecycleAdapterKapasitor;
import Adapter.RecycleAdapterMagnet;
import Adapter.RecycleAdapterPembiasan;

public class ViewPanduanPraktikum extends AppCompatActivity implements OnPageChangeListener,OnLoadCompleteListener {

    private static final String TAG = ViewMateriActivity.class.getSimpleName();
    private final static int REQUEST_CODE = 42;
    public static final int PERMISSION_CODE = 42042;
    public static final String READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";
    private PDFView pdfView;
    private Uri uri;
    private Integer pageNumber = 0;
    private String pdfFileName;
    Intent intent;
    private String key;
    RecycleAdapterGelCahaya adapterGelCahaya;
    RecycleAdapterInduksi1 adapterInduksi1;
    RecycleAdapterInduksi2 adapterInduksi2;
    RecycleAdapterKapasitor adapterKapasitor;
    RecycleAdapterMagnet adapterMagnet;
    RecycleAdapterPembiasan adapterPembiasan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_panduan_praktikum);
        ViewPanduanPraktikum.this.setTitle(String.format("Panduan Praktikum"));

        intent = getIntent();
        key = intent.getStringExtra("key");

        adapterGelCahaya = new RecycleAdapterGelCahaya(this);
        adapterInduksi1 = new RecycleAdapterInduksi1(this);
        adapterInduksi2 = new RecycleAdapterInduksi2(this);
        adapterKapasitor = new RecycleAdapterKapasitor(this);
        adapterMagnet = new RecycleAdapterMagnet(this);
        adapterPembiasan = new RecycleAdapterPembiasan(this);


        pdfView = findViewById(R.id.pdfView);

        if (key.equals("gel_cahaya")){
            displayFromAsset("gelombang_cahaya.pdf");

        }else if (key.equals("pembiasan")){
            displayFromAsset("pembiasan_lensa.pdf");
        }else if (key.equals("induksi1")){
            displayFromAsset("induksi_elektro1.pdf");
        }else if (key.equals("induksi2")){
            displayFromAsset("induksi_elektro2.pdf");
        }else if (key.equals("medan_magnet")){
            displayFromAsset("medan_magnet.pdf");
        }else if (key.equals("kapasitor")){
            displayFromAsset("kapasitor.pdf");
        }

        pdfView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (key.equals("gel_cahaya")){

                    LayoutInflater minlfater = LayoutInflater.from(ViewPanduanPraktikum.this);
                    View v2 = minlfater.inflate(R.layout.dialog_list_gambar, null);
                    final android.app.AlertDialog dialog = new android.app.AlertDialog.Builder(ViewPanduanPraktikum.this).create();
                    dialog.setView(v2);

                    final RecyclerView recycler_view = (RecyclerView) v2.findViewById(R.id.recycler_view);
                    final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recycler_view.setLayoutManager(layoutManager);
                    recycler_view.setAdapter(adapterGelCahaya);
                    recycler_view.setLayoutManager(new LinearLayoutManager(ViewPanduanPraktikum.this));

                    dialog.show();

                }else if (key.equals("pembiasan")){
                    LayoutInflater minlfater = LayoutInflater.from(ViewPanduanPraktikum.this);
                    View v2 = minlfater.inflate(R.layout.dialog_list_gambar, null);
                    final android.app.AlertDialog dialog = new android.app.AlertDialog.Builder(ViewPanduanPraktikum.this).create();
                    dialog.setView(v2);

                    final RecyclerView recycler_view = (RecyclerView) v2.findViewById(R.id.recycler_view);
                    final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recycler_view.setLayoutManager(layoutManager);
                    recycler_view.setAdapter(adapterPembiasan);
                    recycler_view.setLayoutManager(new LinearLayoutManager(ViewPanduanPraktikum.this));

                    dialog.show();

                }else if (key.equals("induksi1")){
                    LayoutInflater minlfater = LayoutInflater.from(ViewPanduanPraktikum.this);
                    View v2 = minlfater.inflate(R.layout.dialog_list_gambar, null);
                    final android.app.AlertDialog dialog = new android.app.AlertDialog.Builder(ViewPanduanPraktikum.this).create();
                    dialog.setView(v2);

                    final RecyclerView recycler_view = (RecyclerView) v2.findViewById(R.id.recycler_view);
                    final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recycler_view.setLayoutManager(layoutManager);
                    recycler_view.setAdapter(adapterInduksi1);
                    recycler_view.setLayoutManager(new LinearLayoutManager(ViewPanduanPraktikum.this));

                    dialog.show();

                }else if (key.equals("induksi2")){
                    LayoutInflater minlfater = LayoutInflater.from(ViewPanduanPraktikum.this);
                    View v2 = minlfater.inflate(R.layout.dialog_list_gambar, null);
                    final android.app.AlertDialog dialog = new android.app.AlertDialog.Builder(ViewPanduanPraktikum.this).create();
                    dialog.setView(v2);

                    final RecyclerView recycler_view = (RecyclerView) v2.findViewById(R.id.recycler_view);
                    final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recycler_view.setLayoutManager(layoutManager);
                    recycler_view.setAdapter(adapterInduksi2);
                    recycler_view.setLayoutManager(new LinearLayoutManager(ViewPanduanPraktikum.this));

                    dialog.show();

                }else if (key.equals("medan_magnet")){
                    LayoutInflater minlfater = LayoutInflater.from(ViewPanduanPraktikum.this);
                    View v2 = minlfater.inflate(R.layout.dialog_list_gambar, null);
                    final android.app.AlertDialog dialog = new android.app.AlertDialog.Builder(ViewPanduanPraktikum.this).create();
                    dialog.setView(v2);

                    final RecyclerView recycler_view = (RecyclerView) v2.findViewById(R.id.recycler_view);
                    final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recycler_view.setLayoutManager(layoutManager);
                    recycler_view.setAdapter(adapterMagnet);
                    recycler_view.setLayoutManager(new LinearLayoutManager(ViewPanduanPraktikum.this));

                    dialog.show();

                }else if (key.equals("kapasitor")){
                    LayoutInflater minlfater = LayoutInflater.from(ViewPanduanPraktikum.this);
                    View v2 = minlfater.inflate(R.layout.dialog_list_gambar, null);
                    final android.app.AlertDialog dialog = new android.app.AlertDialog.Builder(ViewPanduanPraktikum.this).create();
                    dialog.setView(v2);

                    final RecyclerView recycler_view = (RecyclerView) v2.findViewById(R.id.recycler_view);
                    final LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                    recycler_view.setLayoutManager(layoutManager);
                    recycler_view.setAdapter(adapterKapasitor);
                    recycler_view.setLayoutManager(new LinearLayoutManager(ViewPanduanPraktikum.this));

                    dialog.show();

                }
            }
        });
    }

    private void displayFromAsset(String assetFileName) {
        pdfFileName = assetFileName;

        pdfView.fromAsset(assetFileName)
                .defaultPage(pageNumber)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(ViewPanduanPraktikum.this))
                .spacing(10) // in dp
                .load();
    }


    @Override
    public void loadComplete(int nbPages) {

    }

    @Override
    public void onPageChanged(int page, int pageCount) {
      /*  pageNumber = page;
        ViewPanduanPraktikum.this.setTitle(String.format("%s %s / %s", "Halaman : ", page + 1, pageCount));*/
    }
}
