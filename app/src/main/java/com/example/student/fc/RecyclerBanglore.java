package com.example.student.fc;

/**
 * Created by Student on 6/17/2017.
 */

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerBanglore extends RecyclerView.Adapter<RecyclerBanglore.ViewHolder> {

    private String[] titles = {"Chapter Banglore One",
            "Chapter Banglore Two",
            "Chapter Banglore Three",
            "Chapter Banglore  Four",
            "Chapter Banglore Five",
            "Chapter Banglore Six",
            "Chapter Banglore Seven",
            "Chapter Banglore Eight"};

    private String[] details = {"a",
            "b", "b",
            "d", "e",
            "f", "g",
            "h"};

    private String[] images = {"100","200","300","400","500","600","700","800"};
    class ViewHolder extends RecyclerView.ViewHolder{

        public int currentItem;
        public TextView itemImage;
        public TextView itemTitle;
        public TextView itemDetail;
        public TextView itemDuration;

        public ViewHolder(View itemView) {
            super(itemView);
            itemImage = (TextView)itemView.findViewById(R.id.item_image);
            itemTitle = (TextView)itemView.findViewById(R.id.item_title);
            itemDetail = (TextView)itemView.findViewById(R.id.item_detail);
            itemDuration = (TextView)itemView.findViewById(R.id.item_duration);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();
// oncluck on cardd view i want intent
                    Snackbar.make(v, "Click detected on item " + position,
                            Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }
            });
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.itemTitle.setText(titles[i]);
        viewHolder.itemDetail.setText(details[i]);
        viewHolder.itemImage.setText(images[i]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
