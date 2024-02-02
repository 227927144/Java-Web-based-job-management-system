package entity;

/**
 * @auther lyh
 * @create 2023-07-07
 */
public class Teacher {
    public Integer tno;
    private String tname;
    private String tpassword;

    public Integer getTno()
    {
        return tno;
    }
    public void setTno(Integer tno)
    {
        this.tno=tno;
    }

    public String getTname()
    {
        return tname;
    }
    public void setTname(String tname)
    {
        this.tname=tname;
    }

    public String getTpassword() {
        return tpassword;
    }

    public Teacher setTpassword(String tpassword) {
        this.tpassword = tpassword;
        return this;
    }

    @Override
    public String toString()
    {
        return "Teacher{"+
                "tno="+tno+
                ",tname="+tname+
                ",tpassword="+tpassword+
                "}";
    }
}
