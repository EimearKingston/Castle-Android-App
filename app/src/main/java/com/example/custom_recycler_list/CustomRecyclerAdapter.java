package com.example.custom_recycler_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {

    private Context context;
    private int layout;
    private XMLCastles castles;
    RecycleViewInterface recycleViewInterface;
    private ArrayList<Castle> castleList;

    public CustomRecyclerAdapter(Context context, int layout, XMLCastles castles, RecycleViewInterface recycleViewInterface) {
        this.context = context;
        this.layout = layout;
        this.castles = castles;
        this.recycleViewInterface = recycleViewInterface;
        //this.castleList = castleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View row = LayoutInflater.from(this.context).inflate(layout, parent, false);
        return new CustomRecyclerAdapter.ViewHolder(row, recycleViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.label.setText(castles.getCastle(position).getName());
        String subProvince = castles.getCastle(position).getSubtitle()+ ", " + castles.getCastle(position).getProvince();
        holder.subtitle.setText(subProvince);

        String imageName = castles.getCastle(position).getImage();
        imageName = imageName.substring(0,imageName.indexOf("."));
        int imageId = this.context.getResources().getIdentifier(imageName, "drawable", this.context.getPackageName());


        holder.icon.setImageResource(imageId);

    }

    @Override
    public int getItemCount() {
        return this.castles.getCount();
    }


    // inner static ViewHolder
    public static class ViewHolder extends RecyclerView.ViewHolder{

        TextView label;
        ImageView icon;
        TextView subtitle;

        public ViewHolder(@NonNull View itemView, RecycleViewInterface recycleViewInterface) {
            super(itemView);

            label = itemView.findViewById(R.id.textView);
            icon = itemView.findViewById(R.id.imageView);
            subtitle = itemView.findViewById(R.id.subtitleView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    recycleViewInterface.onItemClick(position);
                }
            });
        }
    }
    public void updateList(ArrayList<Castle> newList) {
        castleList = new ArrayList<>(newList); // Update castleList with the new filtered data
        notifyDataSetChanged(); // Notify the adapter that the data set has changed
    }
}
