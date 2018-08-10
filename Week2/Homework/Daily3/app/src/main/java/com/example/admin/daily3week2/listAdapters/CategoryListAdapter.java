package com.example.admin.daily3week2.listAdapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.example.admin.daily3week2.R;
import com.example.admin.daily3week2.models.Category;

public class CategoryListAdapter extends ArrayAdapter<Category> {

    List<Category> categoryList = new ArrayList<>();

    public static class ViewHolder{
        TextView tvCategoryName;
    }

    public CategoryListAdapter(@NonNull Context context, int resource, @NonNull List<Category> categoryList) {
        super(context, resource, categoryList);
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Category category = categoryList.get(position);
        ViewHolder viewHolder;

        if(convertView == null){
            viewHolder = new ViewHolder();

            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.catergories_list_item, parent, false);
            viewHolder.tvCategoryName = convertView.findViewById(R.id.tvCategoryName);
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvCategoryName.setText(category.getCategoryName());

        return convertView;
    }
}