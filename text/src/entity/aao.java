package entity;

/**
 * @auther lyh
 * @create 2023-07-06
 */
public class aao
{
    private Integer id;
    private String name;
    private String password;
    public Integer getId()
    {
        return id;
    }
    public void setId(Integer id)
    {
        this.id=id;
    }

    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }

    public String getPassword()
    {
        return password;
    }
    public void setPassword(String name)
    {
        this.password=password;
    }

    @Override
    public String toString()
    {
        return "AAO{"+
                "id="+id+
                ",name="+name+
                ",password="+password+
                "}";
    }
}
