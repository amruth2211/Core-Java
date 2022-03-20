class Address {
    Location location;
    String state;
    String country;

    public Address(Location location, String state, String country) {
        this.location = location;
        this.state = state;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address [country=" + country + ", location=" + location + ", state=" + state + "]";
    }

}

class Location {
    String street;
    String city;

    public Location(String street, String city) {
        this.street = street;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location [city=" + city + ", street=" + street + "]";
    }

}

class UPIPaymentApps implements Cloneable {
    String name;
    String country;
    int dailyLimit;
    double maxDailyAmount;
    Address headOfficeLocation;

    public UPIPaymentApps() {
    }

    public UPIPaymentApps(String name, String country, int dailyLimit, double maxDailyAmount,
            Address headOfficeLocation) {
        this.name = name;
        this.country = country;
        this.dailyLimit = dailyLimit;
        this.maxDailyAmount = maxDailyAmount;
        this.headOfficeLocation = headOfficeLocation;
    }

    protected Object clone() throws CloneNotSupportedException {
        Location l = new Location(headOfficeLocation.location.street, headOfficeLocation.location.city);
        Address a = new Address(headOfficeLocation.location, headOfficeLocation.state, headOfficeLocation.country);
        return new UPIPaymentApps(name, country, dailyLimit, maxDailyAmount, a);
    }

    @Override
    public String toString() {
        return "UPIPaymentApps [country=" + country + ", dailyLimit=" + dailyLimit + ", headOfficeLocation="
                + headOfficeLocation + ", maxDailyAmount=" + maxDailyAmount + ", name=" + name + "]";
    }
}

// implements the clone method
class UPIDriver {
    public static void main(String[] args) throws Exception {
        Location location = new Location("Miyapur", "Hyderabad");
        Address address = new Address(location, "Telangana", "India");
        UPIPaymentApps bhim = new UPIPaymentApps("BHIM", "India", 10, 100000, address);
        System.out.println(bhim);

        UPIPaymentApps paytm = (UPIPaymentApps) bhim.clone();
        paytm.name = "Paytm";
        System.out.println(paytm);
    }
}
