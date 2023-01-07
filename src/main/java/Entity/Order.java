package Entity;

import java.sql.Time;
import java.sql.Date;

public class Order
{
    private String id;
    private String username;
    private String payment;
    private String ship;
    private String fullname;
    private String phone;
    private String address;
    private int total;
    private Date date;
    private Time time;
    private int totalship;
    private String comment;
    private String status;
    private int number;
    
    public Order(final String id, final String username, final String payment, final String ship, final String fullname, final String phone, final String address, final int total, final Date date, final int totalship, final String comment, final String status, final int number, final Time time) {
        this.id = id;
        this.username = username;
        this.payment = payment;
        this.ship = ship;
        this.fullname = fullname;
        this.phone = phone;
        this.address = address;
        this.total = total;
        this.date = date;
        this.totalship = totalship;
        this.comment = comment;
        this.status = status;
        this.number = number;
        this.time = time;
    }
    
    public Time getTime() {
        return this.time;
    }
    
    public void setTime(final Time time) {
        this.time = time;
    }
    
    public int getNumber() {
        return this.number;
    }
    
    public void setNumber(final int number) {
        this.number = number;
    }
    
    public int getTotalship() {
        return this.totalship;
    }
    
    public void setTotalship(final int totalship) {
        this.totalship = totalship;
    }
    
    public String getComment() {
        return this.comment;
    }
    
    public void setComment(final String comment) {
        this.comment = comment;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(final String status) {
        this.status = status;
    }
    
    public String getId() {
        return this.id;
    }
    
    public void setId(final String id) {
        this.id = id;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(final String username) {
        this.username = username;
    }
    
    public String getPayment() {
        return this.payment;
    }
    
    public void setPayment(final String payment) {
        this.payment = payment;
    }
    
    public String getShip() {
        return this.ship;
    }
    
    public void setShip(final String ship) {
        this.ship = ship;
    }
    
    public String getFullname() {
        return this.fullname;
    }
    
    public void setFullname(final String fullname) {
        this.fullname = fullname;
    }
    
    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(final String phone) {
        this.phone = phone;
    }
    
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(final String address) {
        this.address = address;
    }
    
    public int getTotal() {
        return this.total;
    }
    
    public void setTotal(final int total) {
        this.total = total;
    }
    
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(final Date date) {
        this.date = date;
    }
}