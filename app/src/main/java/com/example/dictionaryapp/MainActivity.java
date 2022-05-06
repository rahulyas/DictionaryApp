package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.location.GnssAntennaInfo;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dictionaryapp.Adapters.MeaningAdapter;
import com.example.dictionaryapp.Adapters.PhoneticsAdapter;
import com.example.dictionaryapp.Models.APIResponse;

public class MainActivity extends AppCompatActivity {
    SearchView search_view;
    TextView textView_word;
    RecyclerView recycle_phonetics,recycle_meaning;
    ProgressDialog progressDialog;
    PhoneticsAdapter phoneticsAdapter;
    MeaningAdapter meaningAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_view = findViewById(R.id.search_view);
        textView_word = findViewById(R.id.textView_word);
        recycle_phonetics= findViewById(R.id.recycle_phonetics);
        recycle_meaning = findViewById(R.id.recycle_meaning);
        progressDialog = new ProgressDialog(this);

        progressDialog.setTitle("Loading.....");
        progressDialog.show();
        RequestManger manger = new RequestManger(MainActivity.this);
        manger.getWordMeaning(listener, "Hello");

        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                progressDialog.setTitle("Fetching response for " + query);
                progressDialog.show();
                RequestManger manger = new RequestManger(MainActivity.this);
                manger.getWordMeaning(listener, query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private  final OnFetchDataListener listener = new OnFetchDataListener() {
        @Override
        public void onFetchData(APIResponse apiResponse, String message) {
            progressDialog.dismiss();
            if(apiResponse==null){
                Toast.makeText(MainActivity.this, "No data found", Toast.LENGTH_SHORT).show();
            return;
            }
            showData(apiResponse);
        }

        @Override
        public void onError(String message) {

            progressDialog.dismiss();
            Toast.makeText(MainActivity.this,message, Toast.LENGTH_SHORT).show();

        }
    };

    private void showData(APIResponse apiResponse) {
        textView_word.setText("Word" + apiResponse.getWord());
        recycle_phonetics.setHasFixedSize(true);
        recycle_phonetics.setLayoutManager(new GridLayoutManager(this,1));
        phoneticsAdapter = new PhoneticsAdapter(this,apiResponse.getPhonetics());
        recycle_phonetics.setAdapter(phoneticsAdapter);

        recycle_meaning.setHasFixedSize(true);
        recycle_meaning.setLayoutManager(new GridLayoutManager(this,1));
        meaningAdapter = new MeaningAdapter(this,apiResponse.getMeanings());
        recycle_meaning.setAdapter(meaningAdapter);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}