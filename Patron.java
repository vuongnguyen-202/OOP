package a1_2001040230;

import common.PatronType;

import java.util.Date;

public class Patron {

    private int id;
    private String patronId;
    private String name;
    private Date dob;
    private String email;
    private String phone;
    private PatronType type;

    public static int currentId = 0;

    public Patron(String name, Date dob, String email, String phone, PatronType type) {
        currentId += 1;
        this.id = currentId;
        if (id < 10) {
            this.patronId = "P00" + id;
        } else if (id < 100) {
            this.patronId = "P0" + id;
        } else {
            this.patronId = "P" + id;
        }
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getPatronId() {
        return patronId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public PatronType getType() {
        return type;
    }

    public void setType(PatronType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Patron Details:" +
                "\n    Patron ID: " + patronId +
                "\n    Name: " + name +
                "\n    Date of Birth: " + dob +
                "\n    Email: " + email +
                "\n    Phone: " + phone +
                "\n    Patron Type: " + type +
                "\n";
    }
}
