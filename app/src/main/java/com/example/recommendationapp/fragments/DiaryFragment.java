package com.example.recommendationapp.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.recommendationapp.Diary;
import com.example.recommendationapp.R;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class DiaryFragment extends Fragment {

    private EditText etDiary;
    private Button btnSubmit1;
    public static final String TAG = "DiaryFragment";

    public DiaryFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_diary, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etDiary = view.findViewById(R.id.etDiary);
        btnSubmit1 = view.findViewById(R.id.btnSubmit1);





        btnSubmit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String diary = etDiary.getText().toString();

                if(diary.isEmpty()){
                    Toast.makeText(getContext(), "You need to write something !", Toast.LENGTH_SHORT).show();
                    return;
                }


                ParseUser currentUser = ParseUser.getCurrentUser();
                savePost(diary,currentUser);

            }
        });

    }

    private void savePost(String content, ParseUser currentUser) {
        Diary diary = new Diary();

        diary.setContent(content);
        diary.setUser(currentUser);

        diary.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if( e != null){
                    Log.e(TAG,"Error when saving",e);
                    Toast.makeText(getContext(),"Error while saving", Toast.LENGTH_SHORT).show();

                }
                Log.i(TAG, "diary save is good");
                Toast.makeText(getContext(),"Posted Diary!", Toast.LENGTH_SHORT).show();
                etDiary.setText(" ");
            }
        });
    }


}
