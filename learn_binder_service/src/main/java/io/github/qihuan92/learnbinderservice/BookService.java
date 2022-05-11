package io.github.qihuan92.learnbinderservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import io.github.qihuan92.learnbinder.Book;
import io.github.qihuan92.learnbinder.BookManger;

/**
 * BookService
 *
 * @author qi
 * @since 2022/5/11
 */
public class BookService extends Service {

    private static final String TAG = "BookService";

    private List<Book> mBookList;
    private final BookManger.Stub mBookMangerStub = new BookManger.Stub() {
        @Override
        public List<Book> getBookList() throws RemoteException {
            Log.i(TAG, "getBookList: ");
            return mBookList;
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            Log.i(TAG, "addBook: " + book.toString());
            mBookList.add(book);
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "onCreate: ");
        mBookList = new CopyOnWriteArrayList<>();
        mBookList.add(new Book("1", "《西游记》"));
        mBookList.add(new Book("2", "《水浒传》"));
        mBookList.add(new Book("3", "《三国演义》"));
        mBookList.add(new Book("4", "《红楼梦》"));
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: ");
        return mBookMangerStub;
    }
}
