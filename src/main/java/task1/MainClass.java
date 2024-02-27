package task1;

public class MainClass {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        System.out.println(phoneBook.getPersonData(new PhoneBook.Person("Krzysztof", "Duszyński")));

    }
}
