package Version9.autoCloseable;

public class Main {

    public static void main(String[] args) {
        AutoCleaningRoom autoCleaningRoom = new AutoCleaningRoom(99);
        autoCleaningRoom.close();
        System.out.println("Peace out");
    }
}
