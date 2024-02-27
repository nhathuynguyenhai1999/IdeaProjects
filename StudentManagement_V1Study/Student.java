import java.util.Date;

public class Student implements IStudent {
    private String className;
    private Date dateOfBirth;
    private String fullName;
    private int id;
    private int mobile;
    private String nativePlace;
    private String phoneNo;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public Date getDateofBirth() {
        return null;
    }

    @Override
    public void setDateofBirth(Date dateofBirth) {

    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getNative() {
        return nativePlace;
    }

    public void setNative(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    @Override
    public String getClass(String className) {
        return null;
    }

    @Override
    public void setClass(String className) {

    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void display() {
        System.out.println("Full Name: " + fullName);
        System.out.println("Date of Birth: " + formatDateOfBirth(dateOfBirth));
        System.out.println("Native: " + nativePlace);
        System.out.println("Class: " + className);
        System.out.println("Phone No: " + phoneNo);
        System.out.println("Mobile: " + mobile);
    }

    private String formatDateOfBirth(Date date) {
        // implement your date formatting logic here
        return ""; // return formatted date string
    }
}
