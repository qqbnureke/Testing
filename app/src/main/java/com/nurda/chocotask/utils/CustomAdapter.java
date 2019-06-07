package com.nurda.chocotask.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nurda.chocotask.R;
import com.nurda.chocotask.model.Book;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    ArrayList<Book> list;
    Context context;

    public CustomAdapter(Context context, ArrayList<Book> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.layout_books, viewGroup,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.name.setText(list.get(i).getName());
        viewHolder.price.setText(list.get(i).getPrice()+"$");
        viewHolder.pageCount.setText(list.get(i).getPagesCount()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name, price, pageCount;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.tv_book_name);
            price = (TextView) itemView.findViewById(R.id.tv_book_price);
            pageCount = (TextView) itemView.findViewById(R.id.tv_page_count);
        }
    }
}
