package com.example.admin.weekendweek3.listsNGrids;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.weekendweek3.R;
import com.example.admin.weekendweek3.models.Item;

import java.util.List;

public class RecyclerViewBooksAdapter extends RecyclerView.Adapter<RecyclerViewBooksAdapter.ViewHolder> {

    public static final String TAG = "RecyclerBooksView_LOG";
    private List<Item> itemList;

    public RecyclerViewBooksAdapter(List<Item> itemList){
        this.itemList = itemList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView tvBookName_RecyclerBooksView,
                               tvAuthorName_RecyclerBookView,
                               tvYear_RecyclerBookView;

        private ImageView ivBookCover_RecyclerBookView;

        public ViewHolder(View itemView){

            super(itemView);
            InitializeViews(itemView);
        }

        private void InitializeViews(View itemView){

            tvBookName_RecyclerBooksView = itemView.findViewById(R.id.tvBookName_RecyclerBooksView);
            tvAuthorName_RecyclerBookView = itemView.findViewById(R.id.tvAuthorName_RecyclerBooksView);
            tvYear_RecyclerBookView = itemView.findViewById(R.id.tvYear_RecyclerBooksView);
            ivBookCover_RecyclerBookView = itemView.findViewById(R.id.ivBookCover_RecyclerBooksView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_books, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");
        Item nextItem = itemList.get(position);
        if(nextItem != null){

            String bookName, authorName, bookYear, bookCoverImageUrl;

                bookName = nextItem.getVolumeInfo().getTitle();
                authorName = nextItem.getVolumeInfo().getAuthors().get(0);
                bookYear = nextItem.getVolumeInfo().getPublishedDate();

            holder.tvBookName_RecyclerBooksView.setText(bookName);
            holder.tvAuthorName_RecyclerBookView.setText(String.valueOf(authorName));
            holder.tvYear_RecyclerBookView.setText(String.valueOf(bookYear));
            holder.ivBookCover_RecyclerBookView.setImageDrawable(null);
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }
}