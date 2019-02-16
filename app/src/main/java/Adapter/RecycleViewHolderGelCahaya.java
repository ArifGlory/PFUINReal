package Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;
import myproject.pfuinreal.R;

/**
 * Created by Glory on 03/10/2016.
 */
public class RecycleViewHolderGelCahaya extends RecyclerView.ViewHolder {

    public TextView txtKodeAlat,txtNamaAlat,txtJml;
    public CircleImageView imgIcon;
    public CardView cardlist_item;


    public RecycleViewHolderGelCahaya(View itemView) {
        super(itemView);

        txtKodeAlat = (TextView) itemView.findViewById(R.id.txtKodeAlat);
        txtNamaAlat = (TextView) itemView.findViewById(R.id.txtNamaAlat);
        txtJml = (TextView) itemView.findViewById(R.id.txtJumlah);
        imgIcon = itemView.findViewById(R.id.img_iconlist);
        cardlist_item = (CardView) itemView.findViewById(R.id.cardlist_item);


    }
}
