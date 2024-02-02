package entity;

/**
 * @auther lyh
 * @create 2023-07-06
 */
public class Student {
    public Integer sno;
    private String sname;
    private String spassword;
    private String email;

    public Integer getSno() {
        return sno;
    }

    public Student setSno(Integer sno) {
        this.sno = sno;
        return this;
    }

    public String getSname() {
        return sname;
    }

    public Student setSname(String sname) {
        this.sname = sname;
        return this;
    }

    public String getSpassword() {
        return spassword;
    }

    public Student setSpassword(String spassword) {
        this.spassword = spassword;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Student setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "student{" +
                "sno=" + sno +
                ", sname='" + sname +
                ", spassword='" + spassword +
                ", email='" + email +
                '}';
    }
}
