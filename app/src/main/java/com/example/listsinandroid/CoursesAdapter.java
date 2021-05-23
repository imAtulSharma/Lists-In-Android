package com.example.listsinandroid;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listsinandroid.databinding.ListItemBinding;

import java.util.List;

public class CoursesAdapter extends ArrayAdapter<String> {
    /**
     * For the context
     */
    private final Context mContext;

    /**
     * For the list of courses data
     */
    private final List<String> mCourses;

    /**
     * To initiate the object with
     * @param context context for inflating purpose
     * @param resource list item resource
     * @param courses list of courses data
     */
    public CoursesAdapter(@NonNull Context context, int resource, @NonNull  List<String> courses) {
        super(context, resource, courses);
        this.mContext = context;
        this.mCourses = courses;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Declare the binding object
        ListItemBinding listItemBinding;

        // Check for the view availability for reuse
        if (convertView == null) {
            listItemBinding = ListItemBinding.inflate(LayoutInflater.from(mContext));
            convertView = listItemBinding.getRoot();
        } else {
            listItemBinding = ListItemBinding.bind(convertView);
        }

        // Bind the data
        listItemBinding.textView.setText(mCourses.get(position));

        return convertView;
    }
}
