package model;
/**
* Main-method used to start the application.
* @param args
*/

class User {  
        public User(String pincode, String name, String birthDate, Address address);
        public void addBicycle(Bicycle bicycle);
        public void removeBicycle(Bicycle bicycle);
        
        public List<String> getBicycleIDs();
        public String getPincode();
        public String setPincode(String pincode);
        public String getName();
        public void setName(String name);
        public Address getAddress();
        public Address setAddress(Address address);
        public String getBirthDate();
        public void setBirthDate();
}
