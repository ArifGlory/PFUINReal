package Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import myproject.pfuinreal.DBAdapter;
import myproject.pfuinreal.HistoryNilai;
import myproject.pfuinreal.R;
import myproject.pfuinreal.ViewPanduanPraktikum;


/**
 * Created by Glory on 03/10/2016.
 */
public class RecycleAdapterGelCahaya extends RecyclerView.Adapter<RecycleViewHolderGelCahaya> {


    LayoutInflater inflater;
    Context context;
    Intent i;
    String[] namaAlat ={"Kotak Cahaya","Pemegang Kotak Cahaya","Rel Presisi","Kaki Rel","Penyambung Rel","Kisi Difraksi"
            ,"Diafragma Celah Tunggal","Filter Warna","Layar Putih","Tumpukan Berpenjepit","Lensa f= +100mm bertangkai"
            ,"Lensa f = +50mm bertangkai","Pemegang slaid difragma","Kabel Penghubung","Catu daya"};
    String[] kodeAlat ={"POG 460 01 ","POG 460 02","FPT 16.02/66","FPT 16.04/66","FPT 16.03/67","POF 180 01","FPT 16.09/79"
                        ,"POF 225"," POG 700","FPT 16.17/67","FPT 16.14/84","FPT 16.13/83","FPT 16.07/77","KAL 99","KAL 60/5A"};
    String[] jmlAlat ={"1","1","2","2","1","1","1","1","3","1","6","1","1","2","1"};

    int[] gambarAlat = {R.drawable.kotakcahaya,R.drawable.report,R.drawable.relpresisi,R.drawable.kakirel,R.drawable.penyambungrel,
            R.drawable.kisi_difraksi,R.drawable.report,R.drawable.filter_warna,R.drawable.layar_putih,R.drawable.tumpukan_berpenjeit,R.drawable.lensa_f100mm
            ,R.drawable.lensaf50mm,R.drawable.report,R.drawable.kabelpenghubung,R.drawable.catudaya};


    public RecycleAdapterGelCahaya(final Context context) {

        this.context = context;
        inflater = LayoutInflater.from(context);


    }




    @Override
    public RecycleViewHolderGelCahaya onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_percoban_gel_cahaya, parent, false);
        //View v = inflater.inflate(R.layout.item_list,parent,false);
        RecycleViewHolderGelCahaya viewHolderChat = new RecycleViewHolderGelCahaya(view);
        return viewHolderChat;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(RecycleViewHolderGelCahaya holder, final int position) {

        Resources res = context.getResources();


        holder.txtKodeAlat.setText(kodeAlat[position]);
        holder.txtNamaAlat.setText(namaAlat[position]);
        holder.txtJml.setText(jmlAlat[position]+" Unit");
        holder.imgIcon.setImageResource(gambarAlat[position]);


        holder.cardlist_item.setOnClickListener(clicklistener);

        holder.cardlist_item.setTag(holder);
        holder.txtJml.setTag(holder);
        holder.txtNamaAlat.setTag(holder);
        holder.txtKodeAlat.setTag(holder);
        holder.imgIcon.setTag(holder);


    }

    View.OnClickListener clicklistener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            RecycleViewHolderGelCahaya vHolder = (RecycleViewHolderGelCahaya) v.getTag();
            int position = vHolder.getPosition();

            LayoutInflater minlfater = LayoutInflater.from(context);
            View v2 = minlfater.inflate(R.layout.dialog_detail_gambar, null);
            final android.app.AlertDialog dialog = new android.app.AlertDialog.Builder(context).create();
            dialog.setView(v2);

            final ImageView imgDetail=  v2.findViewById(R.id.imgDetail);
            imgDetail.setImageResource(gambarAlat[position]);

            dialog.show();


        }
    };



    public int getItemCount() {

       return namaAlat.length;
       //return 1;

    }



}
