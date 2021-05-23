package com.example.listsinandroid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listsinandroid.databinding.ListItemBinding;

import java.util.List;

/**
 *
 */
public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.ProductViewHolder> {
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
     * @param courses list of courses data
     */
    public CoursesAdapter(Context context, List<String> courses) {
        this.mContext = context;
        this.mCourses = courses;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout
        ListItemBinding binding = ListItemBinding.inflate(LayoutInflater.from(mContext), parent, false);

        // Create and return view holder
        return new ProductViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CoursesAdapter.ProductViewHolder holder, int position) {
        holder.binding.textView.setText(mCourses.get(position));
    }

    @Override
    public int getItemCount() {
        // Return the length of the list
        return mCourses.size();
    }

    /**
     * Represents view holder for the recycler view
     */
    static class ProductViewHolder extends RecyclerView.ViewHolder{
        // Declare view binding object
        ListItemBinding binding;

        /**
         * To give binding to the holder
         * @param listItemBinding binding of the view
         */
        public ProductViewHolder(ListItemBinding listItemBinding) {
            super(listItemBinding.getRoot());
            this.binding = listItemBinding;
        }
    }
}
