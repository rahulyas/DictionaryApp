package com.example.dictionaryapp.ViewHolders;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapp.R;

public class phoneticsViewholder extends RecyclerView.ViewHolder {
    public TextView textview_phonetic;
    public ImageButton imageButton_audio;

    public phoneticsViewholder(@NonNull View itemView) {
        super(itemView);
        textview_phonetic = itemView.findViewById(R.id.textview_phonetic);
        imageButton_audio = itemView.findViewById(R.id.imagebutton_audio);

    }
}
