package LinkedList;

import java.util.Objects;

public class Employee {

    String name;
    Integer age;
    String position;

    Employee(String name, Integer age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        return Objects.equals(age, other.age) && Objects.equals(name, other.name)
                && Objects.equals(position, other.position);
    }


    public static void main(String[] args) {

        GenericDoublyLinkedList<Employee> list = new GenericDoublyLinkedList<Employee>();
        list.add(new Employee("Eployee_01", 28, "software developer"));
        list.add(new Employee("Eployee_02", 25, "designer"));
        list.add(new Employee("Eployee_03", 25, "product manager"));
        list.add(new Employee("Eployee_04", 25, "designer"), 1);
        list.addFirst(new Employee("Eployee_05", 26, "software developer"));

        System.out.println(list);
        list.deleteFirst();
        System.out.println(list);
        list.deleteLast();
        System.out.println(list);

        Employee employee = new Employee("Eployee_02", 25, "designer");
        list.delete(employee);
        System.out.println(list);

        list.delete(1);
        System.out.println(list);

        list.deleteFirst();
        System.out.println(list);
    }

}
