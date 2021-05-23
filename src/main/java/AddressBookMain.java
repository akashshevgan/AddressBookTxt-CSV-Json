import java.util.Scanner;

public class AddressBookMain {

    public static void main(String[] args) {
        System.out.println("Welcome to AddressBook");
        Scanner sc = new Scanner(System.in);
        Contacts contacts = new Contacts();
        int input;
        do {
            System.out.println("1: Add contacts details ");
            System.out.println("2: Display Contact");
            System.out.println("3: Edit contact");
            System.out.println("4: Delete Contact");
            System.out.println("5: view Contact");
            System.out.println("6: Search person in city");
            System.out.println("7: view person in state");
            System.out.println("8: sort person names ");
            System.out.println("9: sort zip Entries ");
            System.out.println("10: sort city Entries ");
            System.out.println("0: exit the system");
            input = sc.nextInt();
            switch (input) {
                case 1:
                    contacts.addContact();
                    break;
                case 2:
                    contacts.displayContact();
                    break;
                case 3:
                    contacts.editContact();
                    break;

                case 4:
                    contacts.deleteContact();
                    break;

                case 5:
                    contacts.viewContact();
                    break;

                case 6:
                    contacts.searchPerson();
                    break;

                case 7:
                    contacts.viewPerson();
                    break;

                case 8:
                    contacts.sortPerson();
                    break;

                case 9:
                    contacts.sortZipEntries();
                    break;

                case 10:
                    contacts.sortCityEntries();
                    break;

                case 0:
                    break;
            }
        } while (input != 0) ;
        System.out.println("Thank you!");
    }
}

