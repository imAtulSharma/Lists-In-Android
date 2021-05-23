package com.example.listsinandroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listsinandroid.databinding.ListItemBinding;
import com.example.listsinandroid.models.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents adapter for courses data list
 */
public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.CourseViewHolder> {
    /**
     * For the context
     */
    private final Context mContext;

    /**
     * List of all courses
     */
    private final List<Course> mCourses;

    /**
     * List of the visible courses
     */
    private List<Course> visibleCourses;

    /**
     * To initiate the object with
     * @param context context for inflating purpose
     * @param courses list of courses data
     */
    public CoursesAdapter(Context context, List<Course> courses) {
        this.mContext = context;
        this.mCourses = courses;
        this.visibleCourses = new ArrayList<>(courses);
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout
        ListItemBinding binding = ListItemBinding.inflate(LayoutInflater.from(mContext), parent, false);

        // Create and return view holder
        return new CourseViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        // Bind the name
        holder.binding.checkbox.setText(visibleCourses.get(position).name);

        // Restore previous checked state
        holder.binding.checkbox.setChecked(visibleCourses.get(position).isChecked);

        // Handle checked changes
        holder.binding.checkbox.setOnCheckedChangeListener((buttonView, isChecked) -> visibleCourses.get(position).isChecked = isChecked);
    }

    @Override
    public int getItemCount() {
        // Return the length of the list
        return visibleCourses.size();
    }

    /**
     * To filter the visible list
     * @param query query for the search
     */
    public void filter(String query) {
        // Clear the list
        visibleCourses.clear();

        // Check for query given
        if (query.trim().isEmpty()) {
            visibleCourses.addAll(mCourses);
        } else {
            // Filter according to the query
            for (Course course :
                    mCourses) {
                if (course.name.toLowerCase().contains(query.toLowerCase())) {
                    visibleCourses.add(course);
                }
            }
        }

        // Refreshing the list
        notifyDataSetChanged();
    }

    /**
     * Represents view holder for the recycler view
     */
    static class CourseViewHolder extends RecyclerView.ViewHolder{
        // Declare view binding object
        ListItemBinding binding;

        /**
         * To give binding to the holder
         * @param listItemBinding binding of the view
         */
        public CourseViewHolder(ListItemBinding listItemBinding) {
            super(listItemBinding.getRoot());
            this.binding = listItemBinding;
        }
    }
}
