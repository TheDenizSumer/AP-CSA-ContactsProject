import java.util.*;

//Contact class
public class Contacts{
    //declaring private instance variables
   private static ArrayList<Contacts> contacts = new ArrayList<Contacts>();
   private static ArrayList<Contacts> favorites = new ArrayList<Contacts>();
   private static ArrayList<Contacts> emergency = new ArrayList<Contacts>();
   private String firstName = "";
   private String lastName = "";
   private String phoneNumber = "";
   private String email = "";
   private String address = "";
   private boolean isFavorite;
   private boolean isEmergency;
   private String company;


   //constructor with all parameters
   public Contacts(String firstName, String lastName, String phoneNumber, String email, String address, boolean isFavorite, boolean isEmergency, String company){
        //initializing private instance variables with parameters 
       this.firstName = firstName;
       this.lastName = lastName;
       this.phoneNumber = phoneNumber;
       this.email = email;
       this.address = address;
       this.isFavorite = isFavorite;
       this.isEmergency = isEmergency;
       this.company = company;
       contacts.add(this);
       favorites(isFavorite);
       emergency(isEmergency);

   }
  
   // returns a list of contacts that starts with the string name
   public static ArrayList<Contacts> searchContact(String name){
        //creating a results arraylist which will store the result
       ArrayList<Contacts> contactResults = new ArrayList<Contacts>();
       //sorting the contacts first before selecting contacts that have names which start with 'name'
       ArrayList<Contacts> sortedContacts = sortContacts(contacts);
       //for loop to iterate through each object in the sortedContacts arraylist
       for(int i = 0; i < sortedContacts.size(); i++){
            //checking if the start of the first name is the same as the parameter name
            if (name.length() <= sortedContacts.get(i).getFirstName().length() && sortedContacts.get(i).getFirstName().substring(0, name.length()).toLowerCase().equals(name)) {
                contactResults.add(sortedContacts.get(i));
            }
            //checking if the start of the last name is the same as the parameter name
            else if (name.length() <= sortedContacts.get(i).getLastName().length() && sortedContacts.get(i).getLastName().substring(0, name.length()).toLowerCase().equals(name)) {
                contactResults.add(sortedContacts.get(i));
            }
       }
       return contactResults;
   }
  
   //returns an arraylist of contacts that are sorted alphabetically by names
   public static ArrayList<Contacts> sortContacts(ArrayList<Contacts> unsorted){
       ArrayList<String> sortedNames = new ArrayList<String>();
       ArrayList<Contacts> sortedContacts = new ArrayList<Contacts>();
       //adding the name of the objects to an arraylist
       for(int i = 0; i < unsorted.size(); i++){
           sortedNames.add(unsorted.get(i).getName());
       }
       //sorting the arraylist alphabetically
       Collections.sort(sortedNames);
       //adding the contacts to an arraylist by order of the contact's name
        for(int i = 0; i < sortedNames.size(); i++){
            for(int j = 0; j < unsorted.size(); j++){
                if(sortedNames.get(i).equals(unsorted.get(j).getName())){
                    sortedContacts.add(unsorted.get(j));
                }
            }
        }
       return sortedContacts;
   }

   //a method to check if a contact is a favorite contact
   public void favorites(boolean isFavorite){
        if(isFavorite){
            addToFavorites();
        }
   }

   //a method to check if a contact is an emergency contact
   public void emergency(boolean isEmergency){
        if(isEmergency){
            addToEmergency();
        }
   }

   //a method to add the favorite contact to the favorites arraylist
   public void addToFavorites(){
       isFavorite = true;
       if (!favorites.contains(this))
           favorites.add(this);
   }

   //a method to add the emergency contact to the emergency arraylist
   public void addToEmergency(){
       isEmergency = true;
       if (!emergency.contains(this))
           emergency.add(this);
   }

   //a method to remove the favorite contact from the favorites arraylist
   public void removeFavorites(){
       isFavorite = false;
       if (favorites.contains(this))
           favorites.remove(favorites.indexOf(this));
   }

   //a method to remove the emergency contact from the emergency arraylist
   public void removeEmergency(){
       isEmergency = false;
       if (emergency.contains(this))
           emergency.remove(emergency.indexOf(this));
   }

   //returns the contacts arraylist
   public static ArrayList<Contacts> getContacts(){
       return contacts;
   }

   //returns the favorites arraylist
   public static ArrayList<Contacts> getFavorites(){
       return favorites;
   }

   //returns the emergency arraylist
   public static ArrayList<Contacts> getEmergency(){
       return emergency;
   }

   //returns the first name
   public String getFirstName(){
       return firstName;
   }

   //returns the last name
   public String getLastName(){
       return lastName;
   }

   //returns the full name
   public String getName(){
       return firstName + " " + lastName;
   }

   //returns the phone number
   public String getPhoneNumber(){
       return phoneNumber;
   }

   //returns the email
   public String getEmail(){
       return email;
   }

   //returns the address
   public String getAddress(){
       return address;
   }

   //returns the company
   public String getCompany(){
        return company;
    }

    //set method for first name
   public void setFirstName(String newFirstName){
        if (!newFirstName.equals(""))
       firstName = newFirstName;
   }

   //set method for last name
   public void setLastName(String newLastName){
    if (!newLastName.equals(""))
       lastName = newLastName;
   }
  
   //set method for phone number
   public void setPhoneNumber(String newPhoneNumber){
    if (!newPhoneNumber.equals(""))
       phoneNumber = newPhoneNumber;
   }

   //set method for email
   public void setEmail(String newEmail){
    if (!newEmail.equals(""))
       email = newEmail;
   }

   //set method for address
   public void setAddress(String newAddress){
    if (!newAddress.equals(""))
       address = newAddress;
   }

   //set method for company
   public void setCompany(String newCompany){
    if (!newCompany.equals(""))
       company = newCompany;
   }

   //method that prints the info of the contact object
   public void printInfo(){
        System.out.print("Name: " + getName() + " ");
        if (isFavorite) {
            System.out.print("\n(Favorite!) ");
        }
        if (isEmergency) {
            System.out.print("\n(Emergency Contact!) ");
        }
        System.out.println();
        System.out.println("Phone Number: " + getPhoneNumber());
        System.out.println("Email: " + getEmail());
        System.out.println("Address: " + getAddress());
        System.out.println("Company: " + getCompany());
        System.out.println();
   }

   //toString() method
    public String toString(){
        return getName();
    }
}