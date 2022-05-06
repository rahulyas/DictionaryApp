package com.example.dictionaryapp.ViewHolders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapp.R;

public class DefinitionViewHolder extends RecyclerView.ViewHolder {
    public TextView text_defintion,text_example,text_synonyms,text_antonyms;;

    public DefinitionViewHolder(@NonNull View itemView) {
        super(itemView);
        text_defintion = itemView.findViewById(R.id.text_defintion);
        text_example = itemView.findViewById(R.id.text_example);
        text_synonyms = itemView.findViewById(R.id.text_synonyms);
        text_antonyms = itemView.findViewById(R.id.text_antonyms);

    }
}
