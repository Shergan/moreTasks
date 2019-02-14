package com.divashchenko;

/*
3. Взаимная зависимость.
        Есть класс Student у которого есть имя и группу, и класс Group с полями имя и List<Student>.
        - Реализовать у класса Student метод setGroup(Group). Когда у студента прописывают группу он добавляется в соотв. группу.
        Если у студента задают группу null или заменяют группу то в группе должныпроизойти соотв. изменения.
        - Реализовать у класса Group методы addStudent(Student)/removeStudent(Student).
        При добавлении в группу у прописывается эта группа и при сдалении удаляется.
        - Реализовать метод toString() у классов.
*/

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("Alex");
        Student student2 = new Student("Oleg");

        Group group1 = new Group("A");
        Group group2 = new Group("B");


        student1.setGroup(group1);
        student2.setGroup(group1);
        System.out.println(student1);
        System.out.println(group1);

        System.out.println();

        student2.setGroup(group2);
        System.out.println(student2);
        System.out.println(group2);

        System.out.println();

        student2.setGroup(null);
        System.out.println(student2);
        System.out.println(group2);
    }
}
