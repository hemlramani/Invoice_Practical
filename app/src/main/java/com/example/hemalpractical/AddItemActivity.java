package com.example.hemalpractical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.hemalpractical.databinding.ActivityAddItemBinding;
import com.example.hemalpractical.databinding.ActivityMainBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.function.UnaryOperator;

public class AddItemActivity extends AppCompatActivity implements RecyclerViewClickListener {


    int recylerviewposition;
    static int grandtotal;
    int var1;
    int var2;
    String itemname="";
    int itemprice=0;
     int itemcount=0;
     int itempricetotal=0;
    ActivityAddItemBinding binding;

    ArrayList<Model> arrayList;
    ArrayList<Model> arrayList2;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddItemBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportActionBar().hide();

        arrayList = new ArrayList<>();


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(AddItemActivity.this);
        binding.additemrecycler.setLayoutManager(linearLayoutManager);

        myAdapter = new MyAdapter(AddItemActivity.this, arrayList, new OnEditTextChanged() {
            @Override
            public void onTextChanged(int component_id, int position, String charSeq) {


                Log.d("HEMLRAMANI", "" + component_id);
                Log.d("HEMLRAMANI", "" + position);
                Log.d("HEMLRAMANI", "" + charSeq);

                switch (component_id) {
                    case 2131231217:
                        itemname = charSeq;
                        break;
                    case 2131231218:
                        if (charSeq.length()>0)
                        {
                            var1=Integer.parseInt(charSeq.toString());
                            itempricetotal=var1*var2;
                            itemprice = Integer.parseInt(charSeq);
                        }

                        break;
                    case 2131231216:
                        if (charSeq.length()>0)
                        {
                            var2=Integer.parseInt(charSeq.toString());
                            itempricetotal=var1*var2;
                            itemcount = Integer.parseInt(charSeq);
                        }

                        break;
                    case 2131231219:
                        //itempricetotal= Integer.parseInt(itemprice)* Integer.parseInt(itemcount);
                        break;
                }

            }
        }, this);

        binding.btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!arrayList.isEmpty())
                {

                    arrayList.set(recylerviewposition,new Model(itemname,itemprice,itemcount,itempricetotal));

                    //arrayList.add(new Model(itemname,"","",""));
                    binding.additemrecycler.setAdapter(myAdapter);
                    grandtotal+=itempricetotal;
                    binding.txtgrandtotal.setText("Grand Total : $"+String.valueOf(grandtotal));
                    arrayList.add(new Model("",0,0,0));

                    binding.additemrecycler.setAdapter(myAdapter);
                }
                else {
                    arrayList.add(new Model("",0,0,0));

                    binding.additemrecycler.setAdapter(myAdapter);
                }




            }
        });

        binding.btnsaveitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("HEML",""+itemname);
                Log.d("HEML",""+itemprice);
                Log.d("HEML",""+itemcount);
                Log.d("HEML",""+itempricetotal);

                Log.d("HEMLPTL",""+recylerviewposition);
                binding.txtgrandtotal.setText("Grand Total : $"+String.valueOf(grandtotal+=itempricetotal));
                Intent intent = new Intent(AddItemActivity.this,MainActivity.class);
                intent.putExtra("heml",grandtotal);
                startActivity(intent);


            }
        });


    }




    @Override
    public void onItemClick(int position) {
        recylerviewposition = position;
        Log.d("HEMLRRR",""+position);

    }
}