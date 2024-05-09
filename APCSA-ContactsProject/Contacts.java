public class Contacts{
    private static ArrayList<Contacts> contacts = new ArrayList<Contacts>();
    private static ArrayList<Contacts> favorites = new ArrayList<Contacts>();
    private static ArrayList<Contacts> emergency = new ArrayList<Contacts>();
    private String firstName;
    private String lastName;
    private int phoneNumber;
    private String email = "";
    private String address = "";
    private boolean isFavorite = false;
    private boolean isEmergency = false;
    private String company = "";
    
    public Contacts(String firstName, String lastName, int phoneNumber){
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        contacts.add(this);
    }

    public Contacts(String fn, String ln, int pn, String email, Boolean fav, Boolean emg, String company){
        firstName = fn;
        lastName = ln;
        phoneNumber = pn;
        this.email = email;
        favorite = fav;
        emergency = emg;
        this.company = company;
        contacts.add(this);
    }
    
    public Contacts(){
        this.firstName = "";
        this.lastName = "";
        this.phoneNumber = "";
        contacts.add(this);
    }
    // returns a list of at most 5 people 
    // create a sub list that contains the ocharacters typed in by the user
    public ArrayList<Contacts> searchContact(String name){
        ArrayList<Contacts> possibleContacts = new ArrayList<Contacts>();
        for(int i = 0; i < contacts.size(); i++){
            if(contacts.get(i).getName().contains(name)){
                possibleContacts.add(contacts.get(i));
            }
        }
        return possibleContacts;
    }

    
    public void addToFavorites(){
        this.isFavorite = true;
        if (!favorites.contains(this))
            favorites.add(this);
    }

    public void addToEmergency(){
        this.isEmergency = true;
        if (!emergency.contains(this))
            emergency.add(this);
    }

    public void removeFavorites(){
        this.isFavorite = false;
        if (emergency.contains(this))
            emergency.remove(emergency.indexOf(this));
    }

    public void removeEmergency(){
        this.isEmergency = false;
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
    public void setFirstName(String temp){
        return firstName = temp;
    }
    public void setLastName(String temp){
        return lastName = temp;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String temp){
        return email = temp;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String temp){
        return email = temp;
    }
    

    
}