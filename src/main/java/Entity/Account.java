package Entity;

public class Account
{
    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;
    private int sex;
    private int newsletter;
    
    public Account(String username, String password, String fullName, String phoneNumber, int sex, int newsletter) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
        this.newsletter = newsletter;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getFullName() {
        return this.fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public int getNewsletter() {
        return this.newsletter;
    }
    
    public void setNewsletter(int newsletter) {
        this.newsletter = newsletter;
    }
    
    public int getSex() {
        return this.sex;
    }
    
    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", sex=" + sex +
                ", newsletter=" + newsletter +
                '}';
    }
}