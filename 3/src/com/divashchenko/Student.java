package com.divashchenko;

public class Student {
    private String name;
    private Group group;

    public Student(String name) {
        this.name = name;
    }

    public void setGroup(Group newGroup) {
        if (newGroup == null) {
            group.removeStudent(this);
            group = null;
        } else if (group == null) {
            group = newGroup;
            newGroup.addStudent(this);
        } else {
            group.removeStudent(this);
            group = newGroup;
            newGroup.addStudent(this);
        }
    }

    @Override
    public String toString() {
        if (group == null) {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", group=" + "No group" +
                    '}';
        } else {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", group=" + group.getName() +
                    '}';
        }

    }
}