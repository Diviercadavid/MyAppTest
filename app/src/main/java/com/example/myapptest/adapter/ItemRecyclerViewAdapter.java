package com.example.myapptest.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapptest.R;
import com.example.myapptest.model.Exhibit;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.GroupViewHolder> implements View.OnClickListener {

    private List<Exhibit> mExhibits;
    private Context mContext;
    private OnItemClickListener itemClickListener;

    public ItemRecyclerViewAdapter(List<Exhibit> exhibits, Context context, OnItemClickListener onClickListener) {
        this.mExhibits = exhibits;
        this.mContext = context;
        this.itemClickListener = onClickListener;

    }

    @NonNull
    @Override
    public ItemRecyclerViewAdapter.GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_template, null);
        GroupViewHolder groupViewHolder = new GroupViewHolder(view);
        view.setOnClickListener(this);

        return groupViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemRecyclerViewAdapter.GroupViewHolder holder, int position) {
        Exhibit exhibit = mExhibits.get(position);
        holder.nameTextView.setText(exhibit.getName());
        holder.starsTextView.setText(String.valueOf(exhibit.getStars()));
        holder.descriptionTextView.setText(exhibit.getDescription());
        Picasso.with(mContext).load(exhibit.getImage()).into(holder.exhibitImageView);
        holder.bind(exhibit, itemClickListener);
    }

    @Override
    public int getItemCount() {
        return mExhibits.size();
    }

    @Override
    public void onClick(View v) {
    }

    public interface OnItemClickListener {
        void onItemClick(Exhibit exhibit, int adapterPosition);
    }

    public class GroupViewHolder extends RecyclerView.ViewHolder {
        ImageView exhibitImageView;
        TextView starsTextView;
        TextView nameTextView;
        TextView descriptionTextView;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            exhibitImageView = itemView.findViewById(R.id.exhibit_template_imageview);
            starsTextView = itemView.findViewById(R.id.stars_template_textview);
            nameTextView = itemView.findViewById(R.id.name_template_text_view);
            descriptionTextView = itemView.findViewById(R.id.description_template_text_view);
        }

        public void bind(final Exhibit exhibit, final OnItemClickListener listener) {

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(exhibit, getAdapterPosition());
                }
            });

        }
    }
}
