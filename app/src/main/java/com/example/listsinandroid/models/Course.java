package com.example.listsinandroid.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a course with name and checked state
 */
public class Course {
    /**
     * Name of the course
     */
    public String name;

    /**
     * For checked state
     */
    public boolean isChecked;

    /**
     * To initialize the object
     * @param name name of the course
     */
    public Course(String name) {
        this.name = name;
    }

    /**
     * Get List of course from the list of courses names
     * @param coursesString list of courses name
     * @return list of courses
     */
    public static List<Course> listFromCoursesStrings(List<String> coursesString) {
        List<Course> courses = new ArrayList<>();

        // Add the courses in the list
        for (String courseName: coursesString) {
            courses.add(new Course(courseName));
        }

        return courses;
    }
}
