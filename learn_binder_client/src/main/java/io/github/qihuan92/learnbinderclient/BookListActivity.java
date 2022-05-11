package io.github.qihuan92.learnbinderclient;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.github.qihuan92.learnbinder.Book;
import io.github.qihuan92.learnbinder.BookManger;

public class BookListActivity extends AppCompatActivity {
    private static final String TAG = "BookListActivity";

    private RecyclerView rvList;
    private FloatingActionButton fabAdd;
    private BookAdapter mBookAdapter;
    private BookManger mBookManger;

    private final ServiceConnection mBookServiceConnection = new ServiceConnection() {
        private static final String TAG = "BookListActivity.mBookServiceConnection";

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "onServiceConnected: name" + name + " service" + service);
            mBookManger = BookManger.Stub.asInterface(service);
            refreshBookList();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected: name" + name);
            mBookAdapter.submitList(new ArrayList<>());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);

        rvList = findViewById(R.id.rv_list);
        fabAdd = findViewById(R.id.fab_add);

        initList();
        initListener();
        bindService();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mBookServiceConnection);
    }

    private void bindService() {
        Intent intent = new Intent();
        intent.setPackage(getPackageName());
        intent.setAction("io.github.qihuan92.learnbinderservice.BookService");
        bindService(intent, mBookServiceConnection, BIND_AUTO_CREATE);
    }

    private void initList() {
        mBookAdapter = new BookAdapter();
        rvList.setAdapter(mBookAdapter);
        rvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void initListener() {
        fabAdd.setOnClickListener(v -> {
            String id = new Random().nextInt() + "";
            String name = "book-" + id;
            Book book = new Book(id, name);
            addBook(book);
        });
    }

    private void addBook(Book book) {
        try {
            Log.i(TAG, "addBook: ");
            mBookManger.addBook(book);
            refreshBookList();
        } catch (RemoteException e) {
            e.printStackTrace();
            Toast.makeText(BookListActivity.this, "添加失败", Toast.LENGTH_SHORT).show();
        }
    }

    private void refreshBookList() {
        try {
            List<Book> bookList = mBookManger.getBookList();
            mBookAdapter.submitList(new ArrayList<>(bookList));
            Log.i(TAG, "refreshBookList: " + bookList);
        } catch (RemoteException e) {
            e.printStackTrace();
            Toast.makeText(BookListActivity.this, "获取数据失败", Toast.LENGTH_SHORT).show();
        }
    }
}