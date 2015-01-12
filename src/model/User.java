package model;

/**
 * Created by Pulkit.singh on 1/9/2015.
 */

public class User {
    private String username;
    private String password;

    public void setValues(String username,String password){
        this.username=username;
        this.password=password;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }
}
