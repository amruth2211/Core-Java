package Week4;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.text.ParseException;

class PhoneNumber {
    String countryCode;
    String phNo;

    PhoneNumber(String countryCode, String phNo) {
        this.countryCode = countryCode;
        this.phNo = phNo;
    }

    @Override
    public String toString() {
        return countryCode + "-" + phNo;
    }
}

class IndianPhoneNumber extends PhoneNumber {

    public IndianPhoneNumber(String phNo) {
        super("+91", phNo);
    }

}

class Inputuser {
    String email;
    String password;
    String firstName;
    String lastName;
    String dateofbirth;

    String s = "ss";

    public Inputuser(String firstName, String lastName, String email, String password,
            IndianPhoneNumber[] phoneNumbers, String dateofbirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumbers = phoneNumbers;
        this.dateofbirth = dateofbirth;
    }

    IndianPhoneNumber[] phoneNumbers;

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public IndianPhoneNumber[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(IndianPhoneNumber[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Inputuser [dateofbirth=" + dateofbirth + ", email=" + email + ", firstName=" + firstName
                + ", Date of birth=" + dateofbirth + ", lastName=" + lastName + ", password="
                + password
                + ", phoneNumbers="
                + Arrays.toString(phoneNumbers) + "]";
    }

}

class Validation {
    static boolean isAlphabet(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!(Character.isLetter(s.charAt(i))))
                return false;
        }
        return true;
    }

    static boolean isValidPhoneNumber(String phone) {
        if (phone.length() != 10)
            return false;
        for (int i = 0; i < phone.length(); i++) {
            if (!(Character.isDigit(phone.charAt(i))))
                return false;
        }
        return true;
    }

    static boolean isValidEmail(String email) {
        int dot = 0;
        int at = 0;
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == ' ')
                return false;
            if (email.charAt(i) == '@')
                at++;
            if (email.charAt(i) == '.')
                dot++;
        }
        return (dot > 0 && at == 1);
    }

    static boolean isValidPassword(String password) {
        if (password.length() < 8 || password.length() > 16)
            return false;
        int digits = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i)))
                digits++;
        }
        return digits > 0;

    }

    boolean isValidDob(String Dob) {
        int date = Integer.parseInt(Dob.substring(0, 2));
        int month = Integer.parseInt(Dob.substring(3, 5));
        int year = Integer.parseInt(Dob.substring(6, 10));
        if (date > 0 && date < 31) {
            if (month > 0 && month < 13) {
                return (year > 1900 && year <= 2019);
            } else
                return false;
        }
        return false;

    }

    void validate(Inputuser p) throws IllegalArgumentException {
        if (!isAlphabet(p.getFirstName()))
            throw new IllegalArgumentException("First name can only contain alphabets.");
        if (!isAlphabet(p.getLastName()))
            throw new IllegalArgumentException("Last name can only have alphabets.");
        if (!isValidDob(p.dateofbirth)) {
            throw new IllegalArgumentException("The date of birth is invalid.");
        }
        if (!isValidEmail(p.getEmail()))
            throw new IllegalArgumentException(
                    "Email should contain an (.) and an (@) and should not have any spaces in between");
        if (!isValidPassword(p.getPassword()))
            throw new IllegalArgumentException(
                    "Password should be between 8 an 16 characters and should contain atleast one digit");

        IndianPhoneNumber[] phoneNumbers = p.getPhoneNumbers();
        for (int i = 0; i < phoneNumbers.length; i++) {
            if (!isValidPhoneNumber(phoneNumbers[i].phNo))
                throw new IllegalArgumentException("Phone numbers should be 10 digits");
        }

    }
}

public class ExceptionHandling {
    public static void main(String[] args) throws IllegalArgumentException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name: ");
        String firstName = sc.next();
        System.out.println("Enter Last name: ");
        String lastName = sc.next();
        System.out.println("Enter email : ");
        String email = sc.next();
        System.out.println("Enter Password : ");
        String password = sc.next();
        System.out.println("Enter the date of birth : ");
        String date = sc.next();
        System.out.println("Enter total phone numbers");
        int n = sc.nextInt();
        sc.nextLine();
        IndianPhoneNumber[] phoneNumbers = new IndianPhoneNumber[n];
        System.out.println("Enter " + n + " phone numbers");
        for (int i = 0; i < n; i++) {
            phoneNumbers[i] = new IndianPhoneNumber(sc.next());
        }
        Validation v = new Validation();
        Inputuser person = new Inputuser(firstName, lastName, email, password, phoneNumbers, date);
        try {
            v.validate(person);
            String fullName = person.getFullName();
            System.out.println("Full name: " + fullName);
            System.out.println(person);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        sc.close();
    }
}
