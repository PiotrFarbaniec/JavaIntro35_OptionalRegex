package task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PhoneBook {
    private static String pathName = "contacts.txt";
    private Person person;
    private Address address;
    private List<Person> personList;
    private List<Address> addressList;
    private List<String> contacts;


    public PhoneBook() {
        this.contacts = SourceReader.readContactsAsList(pathName);
        this.personList = setPersonsList();
        this.addressList = setAddressesList();
    }

    private List setPersonsList() {
        List<Person> listP = new ArrayList<>();
        for (int i = 0; i <contacts.size(); i++) {
            String[] line = (contacts.get(i)).split("(\\s|\\,\\s)");
            listP.add(new Person(line[0], line[1]));
        }
        return listP;
    }

    private List setAddressesList() {
        List<Address> listA = new ArrayList<>();
        for (int i = 0; i < contacts.size(); i++) {
            String[] line = (contacts.get(i)).split("(\\,\\s)");
            String postCode = line[1].split("\\s")[0];
            String town = line[1].split("\\s")[1];
            String street = line[1].split("\\s")[2];
            String number = line[1].split("\\s")[3];
            String phoneNumber;
            if (line.length == 3) {
                phoneNumber = line[2];
            }
            else {
                Optional<String> phone = Optional.ofNullable(null);
                phoneNumber = phone.orElse("-no phone-");
            }
            listA.add(new Address(postCode, town, street, number,phoneNumber));
        }
        return listA;
    }


    public List getPersonData(Person person) {
        var list = new ArrayList<>();
        if (!personList.contains(person)) {
            throw new RuntimeException("No such person found " + person.toString());
        }
        for (int i = 0; i < personList.size(); i++) {
            if(personList.get(i).equals(person)) {
                list.add(addressList.get(i));
            }
        }
        return list;
    }

    @Override
    public String toString() {
        return person.toString() + address.toString();
    }


    static class Person {
        private String name;
        private String surname;

        public Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        @Override
        public String toString() {
            return '{' + name + " " + surname +'}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person p)) return false;
            return Objects.equals(name, p.name) &&
                    Objects.equals(surname, p.surname);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, surname);
        }
    }


    static class Address {
        private String postalCode;
        private String townName;
        private String street;
        private String streetNumber;
        private String phone;
        public Address(String postalCode, String townName, String street, String streetNumber, String phone) {
            this.postalCode = postalCode;
            this.townName = townName;
            this.street = street;
            this.streetNumber = streetNumber;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return '{' + postalCode + " " + townName + " " + street + " " + streetNumber + " " + phone +'}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Address a)) return false;
            return Objects.equals(postalCode, a.postalCode) &&
                    Objects.equals(townName, a.townName) &&
                    Objects.equals(street, a.street) &&
                    Objects.equals(streetNumber, a.streetNumber) &&
                    Objects.equals(phone, a.phone);
        }

        @Override
        public int hashCode() {
            return Objects.hash(postalCode, townName, street, streetNumber, phone);
        }
    }


    class SourceReader {
        private static List readContactsAsList(String pathName) {
            List<String> contacts = new ArrayList<>();
            String lineText;
            if (pathName == null || pathName.isBlank()) {
                throw new IllegalArgumentException("Empty path name");
            }
            File file = new File(pathName);
            if (!file.exists()) {
                throw new IllegalArgumentException("File: " + " " + pathName + " does not exist");
            }
            else if (file.canRead()) {
                try(BufferedReader reader = new BufferedReader(new FileReader(pathName))) {
                    while((lineText = reader.readLine()) != null) {
                        contacts.add(lineText);
                    }
                }catch (IOException e){
                    System.out.println(e.getMessage());
                }
            }
            return contacts;
        }
    }
}