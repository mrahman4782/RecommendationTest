package com.example.recommendationapp.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recommendationapp.Diary;
import com.example.recommendationapp.DiaryAdapter;
import com.example.recommendationapp.Post;
import com.example.recommendationapp.R;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class ViewDiary extends Fragment {

    public static final String TAG = "ViewDiary";

    private RecyclerView rvDiary;
    private DiaryAdapter adapter;
    private List<Diary> allPosts;

    public ViewDiary(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post_diary, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvDiary = view.findViewById(R.id.rvDiary);
        allPosts = new ArrayList<>();

        adapter = new DiaryAdapter(getContext(),allPosts);

        rvDiary.setAdapter(adapter);
        rvDiary.setLayoutManager(new LinearLayoutManager(getContext()));

        queryPosts();
    }

    protected void queryPosts() {
        ParseQuery<Diary> query = ParseQuery.getQuery(Diary.class);
        query.include(Diary.KEY_USER);
        query.whereEqualTo(Diary.KEY_USER, ParseUser.getCurrentUser());
        query.addDescendingOrder(Diary.KEY_CREATED_KEY);

        query.findInBackground(new FindCallback<Diary>() {
            @Override
            public void done(List<Diary> diaries, ParseException e) {
                if( e != null){
                    Log.e(TAG,"Issue with getting posts");
                    return;
                }

                for(Diary diary : diaries){
                    Log.i(TAG,"Diary: " + diary.getContent());
                }

                allPosts.addAll(diaries);
                adapter.notifyDataSetChanged();

            }
        });
    }
}
