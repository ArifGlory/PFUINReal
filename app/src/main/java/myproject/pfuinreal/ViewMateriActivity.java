package myproject.pfuinreal;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

public class ViewMateriActivity extends AppCompatActivity implements OnPageChangeListener,OnLoadCompleteListener {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_materi);

        intent = getIntent();
        key = intent.getStringExtra("key");

        pdfView = findViewById(R.id.pdfView);

        if (key.equals("gel_cahaya")){
            displayFromAsset("materi_cahaya.pdf");
        }else if (key.equals("pembiasan")){
            displayFromAsset("pembiasan_lensa.pdf");
        }else if (key.equals("induksi1")){
            displayFromAsset("materi_induksi1.pdf");
        }else if (key.equals("induksi2")){
            displayFromAsset("materi_induksi1.pdf");
        }else if (key.equals("medan_magnet")){
            displayFromAsset("materi_magnet.pdf");
        }else if (key.equals("kapasitor")){
            displayFromAsset("materi_kapasitor.pdf");
        }



    }

    private void displayFromAsset(String assetFileName) {
        pdfFileName = assetFileName;

        pdfView.fromAsset(assetFileName)
                .defaultPage(pageNumber)
                .onPageChange(this)
                .enableAnnotationRendering(true)
                .onLoad(this)
                .scrollHandle(new DefaultScrollHandle(ViewMateriActivity.this))
                .spacing(10) // in dp
                .load();
    }

    @Override
    public void loadComplete(int nbPages) {

    }

    @Override
    public void onPageChanged(int page, int pageCount) {
        pageNumber = page;
        ViewMateriActivity.this.setTitle(String.format("%s %s / %s", "Halaman : ", page + 1, pageCount));
    }
}
