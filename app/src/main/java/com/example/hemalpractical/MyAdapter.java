package com.example.hemalpractical;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    int var1=1;
    int var2=1;
    ArrayList<Model> arrayList;
    OnEditTextChanged onEditTextChanged;
    private static RecyclerViewClickListener itemListener;

    public MyAdapter(Context context, ArrayList<Model> arrayList,OnEditTextChanged onEditTextChanged, RecyclerViewClickListener itemListener) {
        this.context = context;
        this.arrayList = arrayList;
        this.onEditTextChanged= onEditTextChanged;
        this.itemListener = itemListener;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_addnewitem, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Model model = arrayList.get(position);
        holder.edtitemname.setText(model.getItemname());
        holder.edtitemprice.setText(String.valueOf(model.getItemprice()));
        holder.edtitemcount.setText(String.valueOf(model.getItemcount()));

        var1=model.getItemprice();
        var2=model.getItemcount();

        holder.edtitempricetotal.setText(String.valueOf(var1*var2));
        holder.imgitemremove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.remove(position);
                notifyDataSetChanged();
            }
        });

        holder.edtitemname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                onEditTextChanged.onTextChanged(R.id.edtitemname,position, holder.edtitemname.getText().toString());

            }
        });
        holder.edtitemprice.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.length()>0)
                {
                    if (charSequence=="")
                    {
                        var1=0;
                        holder.edtitempricetotal.setText(String.valueOf(var1*var2));
                    }
                    else {
                        var1=Integer.parseInt(charSequence.toString());
                        holder.edtitempricetotal.setText(String.valueOf(var1*var2));
                    }

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

                onEditTextChanged.onTextChanged(R.id.edtitemprice,position, holder.edtitemprice.getText().toString());

            }
        });
        holder.edtitemcount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {


                if (charSequence.length()>0)
                {
                    if (charSequence=="")
                    {
                        var2=0;
                        holder.edtitempricetotal.setText(String.valueOf(var1*var2));
                    }
                    else
                    {
                        var2=Integer.parseInt(charSequence.toString());
                        holder.edtitempricetotal.setText(String.valueOf(var1*var2));
                    }

                }


            }

            @Override
            public void afterTextChanged(Editable editable) {
                onEditTextChanged.onTextChanged(R.id.edtitemcount,position, holder.edtitemcount.getText().toString());

            }
        });
        holder.edtitempricetotal.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                onEditTextChanged.onTextChanged(R.id.edtitempricetotal,position, holder.edtitempricetotal.getText().toString());


            }
        });


        holder.constraintLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                itemListener.onItemClick(position);
                return false;
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {


        EditText edtitemname,edtitemprice,edtitemcount,edtitempricetotal;
        ImageView imgitemremove;
        ConstraintLayout constraintLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

                    edtitemname=itemView.findViewById(R.id.edtitemname);
                    edtitemprice=itemView.findViewById(R.id.edtitemprice);
                    edtitemcount=itemView.findViewById(R.id.edtitemcount);
                    edtitempricetotal=itemView.findViewById(R.id.edtitempricetotal);
                    imgitemremove = itemView.findViewById(R.id.imgitemremove);
                    constraintLayout = itemView.findViewById(R.id.cnslayout  );

                    /*itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            itemListener.onItemClick(getAdapterPosition());
                        }
                    });*/

                    itemView.setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View view, MotionEvent motionEvent) {
                            itemListener.onItemClick(getAdapterPosition());
                            return false;
                        }
                    });
        }




    }
}
