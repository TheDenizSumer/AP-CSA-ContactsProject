import java.util.*;

public class Contacts{
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
       favorites(isFavorite);
       emergency(isEmergency);

   }
  
   // returns a list of contacts that contains the name
   public static ArrayList<Contacts> searchContact(String name){
       ArrayList<Contacts> contactResults = new ArrayList<Contacts>();
       ArrayList<Contacts> sortedContacts = sortContacts(contacts);
       for(int i = 0; i < sortedContacts.size(); i++){
           if(sortedContacts.get(i).getName().toLowerCase().contains(name.toLowerCase())){
               contactResults.add(sortedContacts.get(i));
           }
       }
       return contactResults;
   }
  
   public static ArrayList<Contacts> sortContacts(ArrayList<Contacts> unsorted){
       ArrayList<String> sortedNames = new ArrayList<String>();
       ArrayList<Contacts> sortedContacts = new ArrayList<Contacts>();
       for(int i = 0; i < unsorted.size(); i++){
           sortedNames.add(unsorted.get(i).getName());
       }
       Collections.sort(sortedNames);
        for(int i = 0; i < sortedNames.size(); i++){
            for(int j = 0; j < unsorted.size(); j++){
                if(sortedNames.get(i).equals(unsorted.get(j).getName())){
                    sortedContacts.add(unsorted.get(j));
                }
            }
        }
       return sortedContacts;
   }

   public void favorites(boolean isFavorite){
        if(isFavorite){
            addToFavorites();
        }
   }

   public void emergency(boolean isEmergency){
        if(isEmergency){
            addToEmergency();
        }
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

   public String getCompany(){
    return company;
}

   public void setFirstName(String newFirstName){
        if (!newFirstName.equals(""))
       firstName = newFirstName;
   }
   public void setLastName(String newLastName){
    if (!newLastName.equals(""))
       lastName = newLastName;
   }
  
   public void setPhoneNumber(String newPhoneNumber){
    if (!newPhoneNumber.equals(""))
       phoneNumber = newPhoneNumber;
   }

   public void setEmail(String newEmail){
    if (!newEmail.equals(""))
       email = newEmail;
   }

   public void setAddress(String newAddress){
    if (!newAddress.equals(""))
       address = newAddress;
   }

   public void setCompany(String newCompany){
    if (!newCompany.equals(""))
       company = newCompany;
   }

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
   
    public String toString(){
        return getName();
    }
}