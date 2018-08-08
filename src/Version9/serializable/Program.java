package Version9.serializable;

import java.io.*;
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {

        writePersonToFile();
        getPersonFromFile();
        addPeopleToFileAndPrintThem();

    }

    private static void writePersonToFile() {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"))) {
            Person p = new Person("Sam", 33, 178, true);
            System.out.println("Before file: ");
            printPerson(p);
            oos.writeObject(p);
        } catch (IOException ex) {

            System.out.println(ex.getMessage());

        }

    }

    private static void getPersonFromFile() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"))) {
            printPerson((Person) ois.readObject());
        } catch (IOException | ClassNotFoundException ex) {

            System.out.println(ex.getMessage());

        }
    }

    @SuppressWarnings("unchecked")
    private static void addPeopleToFileAndPrintThem() {
        String fileName = "people.txt";
//         создадим список объектов, которые будем записывать
        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Tom", 30, 175, false));
        people.add(new Person("Sam", 33, 178, true));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(people);
            System.out.println("File has been written");
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }

        // десериализация в новый список unchecked
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            ((ArrayList<Person>) ois.readObject()).forEach(Program::printPerson);
        } catch (IOException | ClassNotFoundException ex) {

            System.out.println(ex.getMessage());
        }

    }

    private static void printPerson(Person p) {
        System.out.printf("Name: %s \t Age: %d \t Height: %.2f \t Married: %s \n",
                p.getName(), p.getAge(), p.getHeight(), p.isMarried());
    }
}
