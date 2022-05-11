// BookManger.aidl
package io.github.qihuan92.learnbinder;

import io.github.qihuan92.learnbinder.Book;

interface BookManger {
    List<Book> getBookList();
    void addBook(in Book book);
}