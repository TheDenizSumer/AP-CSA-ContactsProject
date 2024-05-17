import java.util.*;

public class Contacts{
   private static ArrayList<Contacts> contacts = new ArrayList<Contacts>();
   private static ArrayList<Contacts> favorites = new ArrayList<Contacts>();
   private static ArrayList<Contacts> emergency = new ArrayList<Contacts>();
   private String firstName;
   private String lastName;
   private String phoneNumber;
   private String email;
   private String address;
   private boolean isFavorite;
   private boolean isEmergency;
   private String company;


   //constuctor
   public Contacts(String firstName, String lastName, String phoneNumber, String email, String address, boolean isFavorite, boolean isEmergency, String company){
       this.firstName = firstName;
       this.lastName = lastName;
       this.phoneNumber = phoneNumber;
       this.email = email;
       this.address = address;
       this.isFavorite = isFavorite;
       this.isEmergency = isEmergency;
       this.company = company;
       contacts.add(this);
   }
  
   // returns a list of contacts that contains the name
   public ArrayList<Contacts> searchContact(String name){
       ArrayList<Contacts> contactResults = new ArrayList<Contacts>();
       ArrayList<Contacts> sortedContacts = sortContacts(contacts);
       for(int i = 0; i < sortedContacts.size(); i++){
           if(sortedContacts.get(i).getName().toLowerCase().contains(name.toLowerCase())){
               contactResults.add(contacts.get(i));
           }
       }
       return contactResults;
   }
  
   public ArrayList<Contacts> sortContacts(ArrayList<Contact> unsorted){
       ArrayList<String> sortedNames = new ArrayList<String>();
       ArrayList<Contacts> sortedContacts = new ArrayList<Contacts>();
       for(int i = 0; i < unsorted.size(); i++){
           sortedNames.add(unsorted.get(i).getName());
       }
       Collections.sort(sortedNames);
       for (int i = 0; i < sortedNames.size(); i++) {
           sortedContacts.add(sortedNames.indexOf(i));
       }
       return sortedContacts;
   }


   public void addToFavorites(){
       isFavorite = true;
       if (!favorites.contains(this))
           favorites.add(this);
   }


   public void addToEmergency(){
       isEmergency = true;
       if (!emergency.contains(this))
           emergency.add(this);
   }


   public void removeFavorites(){
       isFavorite = false;
       if (emergency.contains(this))
           emergency.remove(emergency.indexOf(this));
   }


   public void removeEmergency(){
       isEmergency = false;
       if (emergency.contains(this))
           emergency.remove(emergency.indexOf(this));
   }


   public static ArrayList<Contacts> getContacts(){
       return contacts;
   }


   public static ArrayList<Contacts> getFavorites(){
       return favorites;
   }
  
   public static ArrayList<Contacts> getEmergency(){
       return emergency;
   }


   public String getFirstName(){
       return firstName;
   }
   public String getLastName(){
       return lastName;
   }
   public String getName(){
       return firstName + " " + lastName;
   }


   public String getPhoneNumber(){
       return phoneNumber;
   }


   public String getEmail(){
       return email;
   }


   public String getAddress(){
       return address;
   }


   public void setFirstName(String newFirstName){
       firstName = newFirstName;
   }
   public void setLastName(String newLastName){
       lastName = newLastName;
   }
  
   public void setPhoneNumber(String newPhoneNumber){
       phoneNumber = newPhoneNumber;
   }


   public void setEmail(String newEmail){
       email = newEmail;
   }


   public void setAddress(String newAddress){
       address = newAddress;
   }


   public static void main(String[] args) {
       Contacts contact1 = new Contacts("Adam", "Appleseed", "9168959021", "adamappleseed@gmail.com", "456 Dinglenut Way", true, true, "Google");
       Contacts contact2 = new Contacts("Billy", "Bobby", "9167248902", "billybobby@gmail.com", "123 Dinglenut Way", false, false, "Google");
       Contacts contact3 = new Contacts("Mark", "Cucumberg", "9162323451", "markbigcucumber@gmail.com", "78 Veggie Drive", false, true, "Facebook");
       Contacts contact4 = new Contacts("Tim", "Cooked", "9169509743", "buyapple@gmail.com", "52 Fruit Drive", true, false, "Apple");
       System.out.println("All Contacts:"+Contacts.getContacts());
       System.out.println("Favorites:"+Contacts.getFavorites());
       System.out.println("Emergency Contacts:"+Contacts.getEmergency());
   }
}

