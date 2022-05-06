package com.example.dictionaryapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapp.Models.Definition;
import com.example.dictionaryapp.R;
import com.example.dictionaryapp.ViewHolders.DefinitionViewHolder;

import java.util.List;

public class DefintionAdapter extends RecyclerView.Adapter<DefinitionViewHolder> {
    private Context context;
    private List<Definition> definitionList;

    public DefintionAdapter(Context context, List<Definition> definitionList) {
        this.context = context;
        this.definitionList = definitionList;
    }

    @NonNull
    @Override
    public DefinitionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DefinitionViewHolder(LayoutInflater.from(context).inflate(R.layout.defintion_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DefinitionViewHolder holder, int position) {
       holder.text_defintion.setText("Defintion" + definitionList.get(position).getDefinition());
       holder.text_example.setText("Example" + definitionList.get(position).getExample());
       StringBuilder synonyms = new StringBuilder();
       StringBuilder antonyms = new StringBuilder();


       synonyms.append(definitionList.get(position).getSynonyms());
        antonyms.append(definitionList.get(position).getAntonyms());

        holder.text_synonyms.setText(synonyms);
        holder.text_antonyms.setText(antonyms);

        holder.text_synonyms.setSelected(true);
        holder.text_antonyms.setSelected(true);


    }

    @Override
    public int getItemCount() {
        return definitionList.size();
    }
}
