package com.gzeinnumer.mylibdialogsearchviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.gzeinnumer.mylibdialogsearchviewexample.databinding.ActivityMainBinding;
import com.gzeinnumer.mylibsearchviewdialog.dialog.searchViewDialogNew.SearchViewDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initOnClick();
    }

    private void initOnClick() {
        binding.btnSingle.setOnClickListener(view -> {
            single();
        });
        binding.btnMulti.setOnClickListener(view -> {
            multi();
        });
    }

    private void single() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Lorem ipsum dolor");
        list.add("sit amet, consectetur");
        list.add("adipiscing elit sed do");

        new SearchViewDialog<String>(getSupportFragmentManager())
                .setItems(list)
                .setTitle("ini title")
                .setContent("ini content")
                .onOkPressedCallBackSingle(new SearchViewDialog.OnOkPressedSingle<String>() {
                    @Override
                    public void onOkSingle(String data) {
                        String temp = "Single Select : "+ data;
                        Toast.makeText(MainActivity.this, temp, Toast.LENGTH_SHORT).show();
                    }
                })
                .onCancelPressedCallBack(new SearchViewDialog.OnCancelPressed() {
                    @Override
                    public void onCancelPressed() {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }

    private void multi() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Lorem ipsum dolor");
        list.add("sit amet, consectetur");
        list.add("adipiscing elit sed do");

        new SearchViewDialog<String>(getSupportFragmentManager())
                .setItems(list)
                .setTitle("ini title")
                .setContent("ini content")
                .onOkPressedCallBackMulti(new SearchViewDialog.OnOkPressedMulti<String>() {
                    @Override
                    public void onOkMulti(List<String> data) {
                        String temp = "Multi Select :\n";
                        temp = temp + "Total Data => "+data.size()+"\n\n";
                        for (String d: data){
                            temp = temp + "Value => "+ d +"\n";
                        }
                        Toast.makeText(MainActivity.this, temp, Toast.LENGTH_SHORT).show();
                    }
                })
                .onCancelPressedCallBack(new SearchViewDialog.OnCancelPressed() {
                    @Override
                    public void onCancelPressed() {
                        Toast.makeText(MainActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();
    }
}