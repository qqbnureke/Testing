package com.nurda.chocotask;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.nurda.chocotask.model.Book;
import com.nurda.chocotask.utils.CustomAdapter;
import com.nurda.chocotask.utils.NetworkException;
import com.nurda.chocotask.utils.ProgressDialogUtil;

import java.util.ArrayList;
import java.util.HashSet;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_getList;
    ProgressDialog dialog;
    RecyclerView recyclerView;

    ArrayList<Book> booksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        booksList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        btn_getList = (Button) findViewById(R.id.btn_getBookList);
        btn_getList.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_getBookList){
            getBooks();
        }
    }

   private void getBooks() {
       showProgressDialog(getResources().getString(R.string.getting_data));

       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               hideProgressDialog();

               booksList.clear();

               try {
                   getFromInternet();
               } catch (NetworkException e) {
                   getFromLocalDB();
                   Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
               }
               finally {
                   setBooksToList();
               }
           }
       }, 1000);
   }


   private void getFromInternet() throws NetworkException {

       int rand_num = (int) (Math.random()*2);

       if (rand_num == 0){
           throw new NetworkException();
       }else{
           Toast.makeText(this, "Книги с интернета", Toast.LENGTH_SHORT).show();
           booksList.add(new Book("Гарри Поттер", 561, 23));
           booksList.add(new Book("Война и Мир", 445, 16));
           booksList.add(new Book("Анна Каренина  ", 775, 18));

       }

   }

   private void getFromLocalDB() {
       Toast.makeText(this, "Книги с локальной базы", Toast.LENGTH_SHORT).show();

       booksList.add(new Book("Игра престолов", 465, 30));
       booksList.add(new Book("Чужак", 651, 24));
       booksList.add(new Book("Шантарам", 505, 17));
       booksList.add(new Book("Богатый папа, бедный папа", 561, 23));
       booksList.add(new Book("Побег из Шоушенка", 445, 31));

   }

   private void setBooksToList() {
       recyclerView.setAdapter(new CustomAdapter(MainActivity.this, booksList));
       recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
   }


   public void showProgressDialog(String message){
       dialog = ProgressDialogUtil.showDialog(MainActivity.this, message);
   }

   public void hideProgressDialog(){
       dialog.dismiss();
   }
}
