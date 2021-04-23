package com.example.recommendationapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.ViewHolder> {

    private Context context;
    private List<Post> posts;

    public PostsAdapter(Context context, List<Post> posts) {
        this.context = context;
        this.posts = posts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post,parent,false);

        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Post post = posts.get(position);
        holder.bind(post);

    }


    @Override
    public int getItemCount() {
        return posts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvUsername ;
        private TextView tvDescription ;
        private  TextView tvCategory ;
        private  TextView tvTime ;
        private  TextView tvLike_number ;
        private ImageView ivImage ;
        private ImageButton bt_like ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvCategory = itemView.findViewById(R.id.tvCategory);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvTime = itemView.findViewById(R.id.tvTime) ;
            tvLike_number = itemView.findViewById(R.id.tvLike_number) ;
            ivImage = itemView.findViewById(R.id.ivImage)  ;

            bt_like = itemView.findViewById(R.id.bt_like) ;
        }

        public void bind(Post post) {
            tvDescription.setText(post.getDescription());
            tvUsername.setText(post.getUser().getUsername());
            tvCategory.setText(post.getCategory());
            tvLike_number.setText(post.getLike().toString());

            tvTime.setText(post.getFormattedTimestamp());

            ParseFile image = post.getImage();
            if(image != null){

                Glide.with(context).load(image.getUrl()).into(ivImage);
            }
        }


    }
}
