package com.example.dictionaryapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapp.Models.Meaning;
import com.example.dictionaryapp.R;
import com.example.dictionaryapp.ViewHolders.MeaningsViewHolders;

import java.util.List;

public class MeaningAdapter extends RecyclerView.Adapter<MeaningsViewHolders> {
    private Context context;
    private List<Meaning> meaningList;

    public MeaningAdapter(Context context, List<Meaning> meaningList) {
        this.context = context;
        this.meaningList = meaningList;
    }

    @NonNull
    @Override
    public MeaningsViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MeaningsViewHolders(LayoutInflater.from(context).inflate(R.layout.meaning_list_items,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MeaningsViewHolders holder, int position) {
       holder.textview_partofSpeech.setText("Parts Of Speech" + meaningList.get(position).getPartOfSpeech());
       holder.recycle_defintions.setHasFixedSize(true);
       holder.recycle_defintions.setLayoutManager(new GridLayoutManager(context,1));
       DefintionAdapter defintionAdapter = new DefintionAdapter(context,meaningList.get(position).getDefinitions());
       holder.recycle_defintions.setAdapter(defintionAdapter);
    }

    @Override
    public int getItemCount() {
        return meaningList.size();
    }
}
