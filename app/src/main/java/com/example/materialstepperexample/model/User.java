package com.example.materialstepperexample.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.File;
import java.util.Objects;

public class User implements Parcelable {
    private String first_name;
    private String last_name;
    private String phone;
    private String password;
    private String password_confirmation;
    private String address;
    private String service;
    private String state;
    private File  image;
    private String lga;
    private String email;
    private String description;
    private String price;
    private String availability;
    private String location;
    private String duration;
    private String nin;
    private String skill_description;
    private String gender;
    private String company_type;
    private String portfolio_link;

    public User(String first_name, String last_name, String phone, String password, String password_confirmation, String address, String service, String state, File image, String lga, String email, String description, String price, String availability, String location, String duration, String nin, String skill_description, String gender, String company_type, String portfolio_link) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
        this.password = password;
        this.password_confirmation = password_confirmation;
        this.address = address;
        this.service = service;
        this.state = state;
        this.image = image;
        this.lga = lga;
        this.email = email;
        this.description = description;
        this.price = price;
        this.availability = availability;
        this.location = location;
        this.duration = duration;
        this.nin = nin;
        this.skill_description = skill_description;
        this.gender = gender;
        this.company_type = company_type;
        this.portfolio_link = portfolio_link;
    }

    protected User(Parcel in) {
        first_name = in.readString();
        last_name = in.readString();
        phone = in.readString();
        password = in.readString();
        password_confirmation = in.readString();
        address = in.readString();
        service = in.readString();
        state = in.readString();
        lga = in.readString();
        email = in.readString();
        description = in.readString();
        price = in.readString();
        availability = in.readString();
        location = in.readString();
        duration = in.readString();
        nin = in.readString();
        skill_description = in.readString();
        gender = in.readString();
        company_type = in.readString();
        portfolio_link = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_confirmation() {
        return password_confirmation;
    }

    public void setPassword_confirmation(String password_confirmation) {
        this.password_confirmation = password_confirmation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getLga() {
        return lga;
    }

    public void setLga(String lga) {
        this.lga = lga;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getNin() {
        return nin;
    }

    public void setNin(String nin) {
        this.nin = nin;
    }

    public String getSkill_description() {
        return skill_description;
    }

    public void setSkill_description(String skill_description) {
        this.skill_description = skill_description;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCompany_type() {
        return company_type;
    }

    public void setCompany_type(String company_type) {
        this.company_type = company_type;
    }

    public String getPortfolio_link() {
        return portfolio_link;
    }

    public void setPortfolio_link(String portfolio_link) {
        this.portfolio_link = portfolio_link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getFirst_name(), user.getFirst_name()) &&
                Objects.equals(getLast_name(), user.getLast_name()) &&
                Objects.equals(getPhone(), user.getPhone()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getPassword_confirmation(), user.getPassword_confirmation()) &&
                Objects.equals(getAddress(), user.getAddress()) &&
                Objects.equals(getService(), user.getService()) &&
                Objects.equals(getState(), user.getState()) &&
                Objects.equals(getImage(), user.getImage()) &&
                Objects.equals(getLga(), user.getLga()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getDescription(), user.getDescription()) &&
                Objects.equals(getPrice(), user.getPrice()) &&
                Objects.equals(getAvailability(), user.getAvailability()) &&
                Objects.equals(getLocation(), user.getLocation()) &&
                Objects.equals(getDuration(), user.getDuration()) &&
                Objects.equals(getNin(), user.getNin()) &&
                Objects.equals(getSkill_description(), user.getSkill_description()) &&
                Objects.equals(getGender(), user.getGender()) &&
                Objects.equals(getCompany_type(), user.getCompany_type()) &&
                Objects.equals(getPortfolio_link(), user.getPortfolio_link());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst_name(), getLast_name(), getPhone(), getPassword(), getPassword_confirmation(), getAddress(), getService(), getState(), getImage(), getLga(), getEmail(), getDescription(), getPrice(), getAvailability(), getLocation(), getDuration(), getNin(), getSkill_description(), getGender(), getCompany_type(), getPortfolio_link());
    }

    @Override
    public String toString() {
        return "User{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", password_confirmation='" + password_confirmation + '\'' +
                ", address='" + address + '\'' +
                ", service='" + service + '\'' +
                ", state='" + state + '\'' +
                ", image=" + image +
                ", lga='" + lga + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", availability='" + availability + '\'' +
                ", location='" + location + '\'' +
                ", duration='" + duration + '\'' +
                ", nin='" + nin + '\'' +
                ", skill_description='" + skill_description + '\'' +
                ", gender='" + gender + '\'' +
                ", company_type='" + company_type + '\'' +
                ", portfolio_link='" + portfolio_link + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(first_name);
        parcel.writeString(last_name);
        parcel.writeString(phone);
        parcel.writeString(password);
        parcel.writeString(password_confirmation);
        parcel.writeString(address);
        parcel.writeString(service);
        parcel.writeString(state);
        parcel.writeString(lga);
        parcel.writeString(email);
        parcel.writeString(description);
        parcel.writeString(price);
        parcel.writeString(availability);
        parcel.writeString(location);
        parcel.writeString(duration);
        parcel.writeString(nin);
        parcel.writeString(skill_description);
        parcel.writeString(gender);
        parcel.writeString(company_type);
        parcel.writeString(portfolio_link);
    }
}
