//package io.github.qihuan92.learnbinder;
//
//import android.os.Parcel;
//import android.os.Parcelable;
//
//import java.util.Objects;
//
///**
// * Book
// *
// * @author qi
// * @since 2022/5/11
// */
//public class Book implements Parcelable {
//    private String bookId;
//    private String bookName;
//
//    public Book() {
//    }
//
//    public Book(String bookId, String bookName) {
//        this.bookId = bookId;
//        this.bookName = bookName;
//    }
//
//    protected Book(Parcel in) {
//        bookId = in.readString();
//        bookName = in.readString();
//    }
//
//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(bookId);
//        dest.writeString(bookName);
//    }
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    public static final Creator<Book> CREATOR = new Creator<Book>() {
//        @Override
//        public Book createFromParcel(Parcel in) {
//            return new Book(in);
//        }
//
//        @Override
//        public Book[] newArray(int size) {
//            return new Book[size];
//        }
//    };
//
//    public String getBookId() {
//        return bookId;
//    }
//
//    public void setBookId(String bookId) {
//        this.bookId = bookId;
//    }
//
//    public String getBookName() {
//        return bookName;
//    }
//
//    public void setBookName(String bookName) {
//        this.bookName = bookName;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Book book = (Book) o;
//        return Objects.equals(bookId, book.bookId) && Objects.equals(bookName, book.bookName);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(bookId, bookName);
//    }
//}
