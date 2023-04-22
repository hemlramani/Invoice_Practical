package com.example.hemalpractical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.hemalpractical.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<InvoiceModal> arrayList;
    static int num = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportActionBar().hide();



        arrayList = new ArrayList<>();
        if (arrayList.isEmpty())

        {

            Intent intent = getIntent();
            String heml = String.valueOf(intent.getIntExtra("heml",0));

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
            binding.mainreclcler.setLayoutManager(linearLayoutManager);

            InvoiceAdapter adapter = new InvoiceAdapter(MainActivity.this,arrayList);
            arrayList.add(new InvoiceModal("#INVOICE"+num+1,heml));


            binding.mainreclcler.setAdapter(adapter);
        }



        binding.btnaddinvioce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AddItemActivity.class));

            }
        });








    }
}