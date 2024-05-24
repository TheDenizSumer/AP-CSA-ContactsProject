import java.util.*;

class UI{
    // In the UI class we only have one function, being the main function. All other methods are stored in Contacts.java.
    public static void main(String[] args) {
        // declaring and-or initaiting variables
        boolean exitStatus = false;
        int contactNum;
        int choice;
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to your Contacts!\n");
        String yn;
        // This loop runs until the user types a number that doesn't correspond with the initial options. Exitstatus must be true in order for the While loop to quit.
        while (!exitStatus){
            // Here we have the main menu where the user can choose to create a contact, search contacts, look at all favorite contacts, look at all emergency contacts, or exit the app. 
            // These choices are controlled by user terminal input and detected by a scanner object
            System.out.println("\n___________________________________________________\n\n");
            System.out.println("Would you like to:\n1. Create a Contact\n2. Search your Contacts\n3. Look at all Favorites\n4. Look at all Emergency Contacts\nAny other number to quit.\n");
            choice = scan.nextInt();
            // This if statement repersents choice 2 (Searching contacts)
            if(choice == 2){
                // Here the termianl asks for the user to type a name and calls the searchContact function with that name.
                System.out.println("\nEnter the name of the contact you would like to search for:");
                String search = scan.next();
                System.out.println("\nPick the contact by typing associated number");
                System.out.println("Here are the Search Results:");
                // An array is created here with all of the possible results for the searched string
                ArrayList<Contacts> result = Contacts.searchContact(search);
                // The variable "lookedAt" repersents the contacts that is chosen in the search (initially unknown)
                Contacts lookedAt;
                // The variable max repsersents the number of contacts that is shown to the user to pick from
                // The following if statements control the max variable by setting it to 5 if the number of results exceeds 5.
                int max;
                
                if (result.size() > 5) {
                    max = 5;
                }
                else {
                    max = result.size();
                }
                if (result.size()==0) { // Here the code makes sure that if there is no matching result to the searched name, it doesn't try to recive a user input.
                    System.out.println("Search Not Found!");
                }
                else {
                    // displays the top 5 search results for the searched item
                    System.out.println("");
                    for (int i = 0; i < max; i++) {
                        System.out.println((i+1) + ". " + result.get(i));
                    }
                    contactNum = scan.nextInt();
                    // chooses the contact repserented by the number that the user types
                    lookedAt = result.get(contactNum-1);
                    lookedAt.printInfo(); // uses the print info method from Contacts.java to print all info
                    System.out.println("\nWould you like to change this contact? (y/n) ");
                    yn = scan.next();
                    // If the user types y into the console, the if statement below becomes true and the changing process begins, if not the terminal displays the main menu again
                    if (yn.equals("y")) {
                        // Here the program gets all of the info from the user from the terminal
                        System.out.println("\nIf you want to change a section, type the updated info, if not just type -.");
                        System.out.println("Enter the new first name of the contact:");
                        scan.next();
                        String firstName = scan.nextLine();
                        System.out.println("Enter the new last name of the contact:");
                        String lastName = scan.nextLine();
                        System.out.println("Enter the new phone number of the contact:");
                        String phone = scan.nextLine();
                        System.out.println("Enter the new email of the contact:");
                        String email = scan.nextLine();
                        System.out.println("Enter the new address of the contact:");
                        String address = scan.nextLine();
                        System.out.println("Is this contact a favorite? (true/false)");
                        String strIsFavorite = scan.nextLine();
                        boolean isFavorite;
                        boolean isEmergency;
                        // here it makes sure that the string written in the terminal turns into a boolean for isFavorite
                        if (strIsFavorite.toLowerCase().equals("true")){
                            isFavorite = true;
                        }
                        else if(strIsFavorite.toLowerCase().equals("false")){
                            isFavorite = false;
                        }
                        else {
                            isFavorite = Contacts.getFavorites().contains(lookedAt);
                        }
                        System.out.println("Is this contact an emergency contact? (true/false)");
                        String strIsEmergency = scan.nextLine();
                        // here it makes sure that the string written in the terminal turns into a boolean for isEmergenc
                        if (strIsEmergency.toLowerCase().equals("true")){
                            isEmergency = true;
                        }
                        else if(strIsEmergency.toLowerCase().equals("false")){
                            isEmergency = false;
                        }
                        else {
                            isEmergency = Contacts.getEmergency().contains(lookedAt);
                        }
                        System.out.println("Enter new the company of the contact:");
                        String company = scan.nextLine();
                        // Here the values picked up in the terminal are reassigned to the variables in the "lookedAt" contact object as long as they are not hyphens
                        if (!firstName.equals("-")) lookedAt.setFirstName(firstName);
                        if (!lastName.equals("-")) lookedAt.setLastName(lastName);
                        if (!email.equals("-")) lookedAt.setEmail(email);
                        if (!phone.equals("-")) lookedAt.setPhoneNumber(phone);
                        if (!address.equals("-")) lookedAt.setAddress(address);
                        if (!company.equals("-")) lookedAt.setCompany(company);
                        if (isFavorite) {
                            lookedAt.addToFavorites();
                        }
                        else{
                            lookedAt.removeFavorites();
                        }
                        if (isEmergency) {
                            lookedAt.addToEmergency();
                        }
                        else{
                            lookedAt.removeEmergency();
                        }
                    }
                    else{
                        System.out.println();
                    }
                }
            }
            else if(choice == 1){
                // Here the program gets all of the info from the user from the terminal for a new Contact
                System.out.println("Enter the first name of the contact:");
                String firstName = scan.next();
                System.out.println("Enter the last name of the contact:");
                String lastName = scan.next();
                System.out.println("Enter the phone number of the contact:");
                String phone = scan.next();
                System.out.println("Enter the email of the contact:");
                String email = scan.next();
                System.out.println("Enter the address of the contact:");
                String address = scan.next();
                System.out.println("Is this contact a favorite? (true/false)");
                scan.nextLine();
                String strIsFavorite = scan.next();
                boolean isFavorite;
                boolean isEmergency;
                if (strIsFavorite.toLowerCase().equals("true")){
                    isFavorite = true;
                }
                else {
                    isFavorite = false;
                }
                System.out.println("Is this contact an emergency contact? (true/false)");
                String strIsEmergency = scan.next();
                if (strIsEmergency.toLowerCase().equals("true")){
                    isEmergency = true;
                }
                else {
                    isEmergency = false;
                }
                System.out.println("Enter the company of the contact:");
                String company = scan.next();
                Contacts contact = new Contacts(firstName, lastName, phone, email, address, isFavorite, isEmergency, company);
                System.out.println("\nContact Created: "+ contact);
            }
            else if(choice == 3){
                System.out.println("\nHere are all of your favorite contacts:");
                for(int i = 0; i < Contacts.getFavorites().size(); i++){
                    System.out.println((i+1)+". "+Contacts.getFavorites().get(i));
                }
            }
            else if(choice == 4){
                System.out.println("\nHere are all of your emergency contacts:");
                for(int i = 0; i < Contacts.getEmergency().size(); i++){
                    System.out.println((i+1)+". "+Contacts.getEmergency().get(i));
                }
            }
            else{
                System.out.println("Quitting Contacts!");
                break;
            }
        }
        scan.close();
    }
}
