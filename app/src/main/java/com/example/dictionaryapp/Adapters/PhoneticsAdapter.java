package com.example.dictionaryapp.Adapters;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionaryapp.Models.Phonetics;
import com.example.dictionaryapp.R;
import com.example.dictionaryapp.ViewHolders.phoneticsViewholder;

import java.util.List;

public class PhoneticsAdapter extends RecyclerView.Adapter<phoneticsViewholder> {
    private Context context;
    private List<Phonetics> phoneticsList;

    public PhoneticsAdapter(Context context, List<Phonetics> phoneticsList) {
        this.context = context;
        this.phoneticsList = phoneticsList;
    }

    @NonNull
    @Override
    public phoneticsViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new phoneticsViewholder(LayoutInflater.from(context).inflate(R.layout.phonetic_list_items,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull phoneticsViewholder holder, int position) {
      holder.textview_phonetic.setText(phoneticsList.get(position).getText());
      holder.imageButton_audio.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              MediaPlayer player = new MediaPlayer();
              try{
                  player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                  player.setDataSource("https:" + phoneticsList.get(position).getAudio());
                  player.prepare();
                  player.start();
              }catch ( Exception e){
                  e.printStackTrace();
                  Toast.makeText(context, "Couldn't play audio", Toast.LENGTH_SHORT).show();
              }
          }
      });
    }

    @Override
    public int getItemCount() {
        return phoneticsList.size();
    }
}
