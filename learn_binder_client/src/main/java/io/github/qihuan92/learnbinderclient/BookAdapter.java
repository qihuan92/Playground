package io.github.qihuan92.learnbinderclient;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import io.github.qihuan92.learnbinder.Book;

/**
 * BookAdapter
 *
 * @author qi
 * @since 2022/5/11
 */
public class BookAdapter extends ListAdapter<Book, BookAdapter.ViewHolder> {

    public BookAdapter() {
        super(new DiffCallback());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvBook;

        public ViewHolder(android.view.View itemView) {
            super(itemView);
            tvBook = itemView.findViewById(R.id.tv_book);
        }

        public void bind(Book book) {
            tvBook.setText(String.format("%s. %s", book.getBookId(), book.getBookName()));
        }
    }

    private static class DiffCallback extends DiffUtil.ItemCallback<Book> {

        @Override
        public boolean areItemsTheSame(@NonNull Book oldItem, @NonNull Book newItem) {
            return oldItem.getBookId().equals(newItem.getBookId());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Book oldItem, @NonNull Book newItem) {
            return oldItem.equals(newItem);
        }
    }
}
