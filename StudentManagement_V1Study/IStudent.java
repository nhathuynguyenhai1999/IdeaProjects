import java.util.Date;

public interface IStudent {
    int getID();
    void setID(int id);

    String getFullName();
    void setFullName(String fullName);

    Date getDateofBirth();
    void setDateofBirth(Date dateofBirth);

    String getNative();
    void setNative(String nativePlace);

    String getClass(String className);
    void setClass(String className);

    String getPhoneNo();
    void setPhoneNo(String phoneNo);

    int getMobile();
    void setMobile(int mobile);

    void display();
}
