import java.util.*;

class UI{
    public static void main(String[] args) {
        boolean exitStatus = false;
        Scanner scan = new Scanner(System.in);
        int contactNum;
        int choice;
        System.out.println("Welcome to your Contacts!\n\n");
        while (!exitStatus){
            System.out.println("\n___________________________________________________\n\n");
            System.out.println("Would you like to:\n1. Create a Contact\n2. Search your Contacts\n3. Look at all Favorites\n4. Look at all Emergency Contacts\nAnything other num to quit\n");
            choice = scan.nextInt();
            if(choice == 2){
                System.out.println("Enter the name of the contact you would like to search for:");
                String search = scan.next();
                System.out.println("Pick the contact by typing associated number");
                System.out.println("Here are the Search Results:");
                ArrayList<Contacts> result = Contacts.searchContact(search);
                int max;
                if (result.size() > 5) {
                    max = 5;
                }
                else {
                    max = result.size();
                }
                for (int i = 0; i < max; i++) {
                    System.out.println((i+1) + ". " + result.get(i));
                }
                System.out.println();
                contactNum = scan.nextInt();
                Contacts lookedAt = result.get(contactNum-1);
                lookedAt.printInfo();
                System.out.println("\nWould you like to change this contact? (y/n) ");
                String yn = scan.next();
                if (yn.equals("y")) {
                    System.out.println("If you want to change a section, type the updated info, if not just hit enter.");
                    System.out.println("Enter the new first name of the contact:");
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
                    lookedAt.setFirstName(firstName);
                    lookedAt.setLastName(lastName);
                    lookedAt.setEmail(email);
                    lookedAt.setPhoneNumber(phone);
                    lookedAt.setAddress(address);
                    lookedAt.setCompany(company);
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
            else if(choice == 1){
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
                System.out.println("Contact Created: "+ contact);
            }
            else if(choice == 3){
                System.out.println("Here are all of your favorite contacts:");
                for(int i = 0; i < Contacts.getFavorites().size(); i++){
                    System.out.println((i+1)+". "+Contacts.getFavorites().get(i));
                }
            }
            else if(choice == 4){
                System.out.println("Here are all of your emergency contacts:");
                for(int i = 0; i < Contacts.getEmergency().size(); i++){
                    System.out.println((i+1)+". "+Contacts.getEmergency().get(i));
                }
            }
            else{
                System.out.println("Quitting Contacts!");
                break;
            }
        }
        
        // System.out.println("All Contacts:"+contact1.getContacts());
        // System.out.println("Favorites:"+contact1.getFavorites());
        // System.out.println("Emergency Contacts:"+contact1.getEmergency());
        // ArrayList<Contacts> sortCont = contact1.sortContacts(contact1.getContacts());
        // System.out.println("Search for 'Adam':"+contact1.searchContact("Adam"));
    }
}