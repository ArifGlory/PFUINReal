package Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import myproject.pfuinreal.R;


/**
 * Created by Glory on 03/10/2016.
 */
public class RecycleAdapterMagnet extends RecyclerView.Adapter<RecycleViewHolderGelCahaya> {


    LayoutInflater inflater;
    Context context;
    Intent i;

    String[] namaAlat ={"Catu Daya","Saklar SPST","Penghantar Lurus","Kompas Perajah","Serbuk Besi","Kabel Penghubung"};
    String[] kodeAlat ={"KAL 60/50 A","PEO 502","PEF 290","PEF 320","FLS 20.30/125","KAL 99"};
    String[] jmlAlat ={"1","1","1","1","5","-"};

    int[] gambarAlat = {R.drawable.catudaya,R.drawable.saklar_spst,R.drawable.report,R.drawable.kompas,R.drawable.serbukbesi
            , R.drawable.kabelpenghubung,};



    public RecycleAdapterMagnet(final Context context) {

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
