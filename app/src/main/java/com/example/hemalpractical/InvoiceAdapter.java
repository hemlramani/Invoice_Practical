package com.example.hemalpractical;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class InvoiceAdapter extends RecyclerView.Adapter<InvoiceAdapter.MyViewHolder> {

    Context context;
    ArrayList<InvoiceModal> arrayList;

    public InvoiceAdapter(Context context, ArrayList<InvoiceModal> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_grandtotal,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        InvoiceModal modal = arrayList.get(position);
        holder.txtinvoicename.setText(modal.invocename);
        holder.txtinvoicetotal.setText(modal.invoicetotal);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {

        TextView txtinvoicename,txtinvoicetotal;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtinvoicename = itemView.findViewById(R.id.txtinvoicename);
            txtinvoicetotal = itemView.findViewById(R.id.txtinvoicetotal);
        }
    }
}
