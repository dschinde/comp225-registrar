package edu.macalester.registrar;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class Student {
    private String name;
    private Set<Course> courses = new HashSet<Course>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Course> getCourses() {
        return Collections.unmodifiableSet(courses);
    }

    /**
     * Add this student to the given course's roster.
     * Has no effect if the student is already registered.
     * Equivalent to course.enroll(student).
     * @return true if the enrollment was successful,
     *         false if the student was waitlisted
     */
    public boolean enrollIn(Course course) {
        courses.add(course);
        if (!course.enroll(this)) {
            courses.remove(course);
            return false;
        }
        return true;
    }
    
    public void drop(Course course) {
        courses.remove(course);
        course.drop(this);
    }
}
