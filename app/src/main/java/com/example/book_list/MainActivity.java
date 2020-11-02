package com.example.book_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    EditText title, author, year, genre;
    LinkedList<HashMap<String, String>> library= new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = findViewById(R.id.title);
        author = findViewById(R.id.author);
        year = findViewById(R.id.year);
        genre = findViewById(R.id.genre);
        ArrayList<Book> booklist = new ArrayList<>();
        booklist.add(new Book("Моби Дик", "Герман Мелвилл", "Приключение", 1981));
        booklist.add(new Book("451 по Фаренгейту", "Рэй Бредбери", "Фантастика", 1996));
        booklist.add(new Book("Дивный новый мир", "Хаксли", "Антиутопия", 2016));
        booklist.add(new Book("Конец детства", "Артур Кларк", "Фантастика", 2000));
        booklist.add(new Book("Мы", "Замятин", "Антиутопия", 1984));

        listView = findViewById(R.id.myList);
        //подготовка данных для simpleAdapter

        for(int i=0; i<booklist.size(); i++) {
            HashMap<String, String> book = new HashMap<>();
            book.put("author", booklist.get(i).author);
            book.put("title", booklist.get(i).title);
            book.put("year", Integer.valueOf(booklist.get(i).year).toString());
            book.put("genre", booklist.get(i).genre);
            library.add(book);
        }
        String [] from = {"author", "title", "year", "genre"};
        int [] to = {R.id.author, R.id.title, R.id.year, R.id.genre};
        SimpleAdapter adapter = new SimpleAdapter(this, library, R.layout.list_item, from, to);
        listView.setAdapter(adapter);
    }
    public void add(View v) {
        //year.setText("text");
        HashMap<String, String> book = new HashMap<>();
        book.put("author", author.getText().toString());
        book.put("title", title.getText().toString());
        book.put("year", year.getText().toString());
        book.put("genre", genre.getText().toString());
        library.add(book);
        listView.invalidateViews();
    }
}
