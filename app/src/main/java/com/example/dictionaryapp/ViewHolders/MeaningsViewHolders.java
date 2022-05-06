package com.example.dictionaryapp.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapp.R;

public class MeaningsViewHolders extends RecyclerView.ViewHolder {
    public TextView textview_partofSpeech;
    public RecyclerView recycle_defintions;
    public MeaningsViewHolders(@NonNull View itemView) {
        super(itemView);

        textview_partofSpeech = itemView.findViewById(R.id.textview_partofSpeech);
        recycle_defintions = itemView.findViewById(R.id.recycle_defintions);

    }
}
