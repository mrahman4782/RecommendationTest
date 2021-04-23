package com.example.recommendationapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.ViewHolder> {

    private Context context;
    private List<Diary> posts;

    public DiaryAdapter(Context context, List<Diary> posts){
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        
        View view = LayoutInflater.from(context).inflate(R.layout.item_diary,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Diary post = posts.get(position);

        holder.bind(post);

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvDiaryPost;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvDiaryPost = itemView.findViewById(R.id.tvDiaryPost);
        }

        public void bind(Diary post) {
            tvDiaryPost.setText(post.getContent());
        }
    }
}
