import java.util.*;
import java.util.stream.Collectors;

public class Contacts {

    Map<String, List<PersonDetails>> addressBookMap = new HashMap<String, List<PersonDetails>>();
    List<PersonDetails> list = new ArrayList<PersonDetails>();
    Scanner scan = new Scanner(System.in);

    public void addContact() {
        for(int i=0; i<2; i++) {
            System.out.println("Enter the address book name");
            String key = scan.nextLine();
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter Name");
            String name = scan.nextLine();
            System.out.println("Enter Address");
            String address = scan.nextLine();
            System.out.println("Enter City");
            String city = scan.nextLine();
            System.out.println("Enter State");
            String state = scan.nextLine();
            System.out.println("Enter Zip");
            String zip = scan.nextLine();
            System.out.println("Enter PhoneNo");
            String phoneNo = scan.nextLine();
            System.out.println("Enter Email");
            String email = scan.nextLine();
            PersonDetails person = new PersonDetails(name, address, city, state, zip, phoneNo, email);
            list.add(person);
            addressBookMap.put(key, list);
            System.out.println(addressBookMap);
        }
    }

    public void displayContact() {
        System.out.println("List of addressbook");
        for (Map.Entry<String, List<PersonDetails>> entry : addressBookMap.entrySet()) {
            String key = entry.getKey();
            System.out.println("Key = " + key);
        }
        System.out.println("which address book you want to display");
        String addressbook = scan.nextLine();
        if (addressBookMap.containsKey(addressbook)) {
            addressBookMap.get(addressbook).stream()
                    .forEach(data ->System.out.println(data));
        }
    }

    public void editContact() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the name for which you want to edit information");
        String editname = scan.nextLine();
        PersonDetails details = null;
        //boolean detailsfound = false;
        for (int i = 0; i < list.size(); i++) {
            details = list.get(i);
            if (details.getName().equals(editname)) {
                System.out.println("Enter the new address which you want to set");
                String newAdd = scan.nextLine();
                details.setAddress(newAdd);
                System.out.println("Enter the new city which you want to set");
                String newCity = scan.nextLine();
                details.setCity(newCity);
                System.out.println("Enter the new state which you want to set");
                String newState = scan.nextLine();
                details.setState(newState);
                System.out.println("Enter the new zip which you want to set");
                String newZip = scan.nextLine();
                details.setZip(newZip);
                System.out.println("Enter the new phoneNo which you want to set");
                String newphoneNo = scan.nextLine();
                details.setPhoneNo(newphoneNo);
                System.out.println("Enter the new email which you want to set");
                String newemail = scan.nextLine();
                details.setEmail(newemail);
                break;
            }
        }
        System.out.println(list);
    }

    public void deleteContact() {
        System.out.println("Enter the name");
        String name = scan.nextLine();

        PersonDetails details = null;
        for (int i = 0; i < list.size(); i++) {
            details = list.get(i);
            if (details.getName().equals(name)) {
                list.remove(i);
            }
        }
        System.out.println(list);
    }

    public void viewContact() {
        list.forEach(personDetails -> {
            System.out.println(personDetails);
        });
    }

    public void searchPerson() {
        System.out.println("Enter the city name in which you want search the person");
        String cityname = scan.nextLine();
        PersonDetails details = null;
        for (int i = 0; i < list.size(); i++) {
            details = list.get(i);
            if (details.getCity().equals(cityname)) {
                System.out.println(list.get(i));
            }
        }
    }

    public void viewPerson() {
        System.out.println("Enter the state name in which you want view the person");
        String statename = scan.nextLine();
        PersonDetails details = null;
        for (int i = 0; i < list.size(); i++) {
            details = list.get(i);
            if (details.getState().equals(statename)) {
                System.out.println(list.get(i));
            }
        }
    }

    public void sortPerson() {
        List<PersonDetails> sortedList = list.stream()
                .sorted(Comparator.comparing(PersonDetails::getName))
                .collect(Collectors.toList());
        System.out.println(sortedList);
    }

    public void sortZipEntries() {
        List<PersonDetails> sortedList = list.stream()
                .sorted(Comparator.comparing(PersonDetails::getZip))
                .collect(Collectors.toList());
        System.out.println(sortedList);
    }

    public void sortCityEntries() {
        List<PersonDetails> sortedList = list.stream()
                .sorted(Comparator.comparing(PersonDetails::getCity))
                .collect(Collectors.toList());
        System.out.println(sortedList);
    }
}

