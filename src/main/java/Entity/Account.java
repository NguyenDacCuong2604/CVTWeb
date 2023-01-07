package Entity;

public class Account
{
    private String username;
    private String password;
    private String fullName;
    private String phoneNumber;
    private int sex;
    private int newsletter;
    
    public Account(final String username, final String password, final String fullName, final String phoneNumber, final int sex, final int newsletter) {
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
    
    public void setUsername(final String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(final String password) {
        this.password = password;
    }
    
    public String getFullName() {
        return this.fullName;
    }
    
    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }
    
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
    public int getNewsletter() {
        return this.newsletter;
    }
    
    public void setNewsletter(final int newsletter) {
        this.newsletter = newsletter;
    }
    
    public int getSex() {
        return this.sex;
    }
    
    public void setSex(final int sex) {
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