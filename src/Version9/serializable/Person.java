package Version9.serializable;

import java.io.Serializable;
//If not impl serial you get NotSerializableException
public class Person implements Serializable {

    //If you add transient to any field it wont be written to file.
    private transient String name;
    private int age;
    private double height;
    private boolean married;

    public Person(String name, int age, double height, boolean married) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.married = married;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public boolean isMarried() {
        return married;
    }
}
