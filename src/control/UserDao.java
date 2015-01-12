package control;

/**
 * Created by Pulkit.singh on 1/9/2015.
 */

import model.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean authenticate(User user){
        String query="select * from users where uname='"+user.getUsername()+"' and pwd='"+user.getPassword()+"'";
        List<User> ulist = jdbcTemplate.query(query,new BeanPropertyRowMapper(User.class));
        if(ulist.isEmpty()){
            return false;
        }
        return true;
    }

    public boolean authenticateUser(User user){
        String query="select * from users where uname='"+user.getUsername()+"'";
        List<User> ulist = jdbcTemplate.query(query,new BeanPropertyRowMapper(User.class));
        if(ulist.isEmpty()){
            return false;
        }
        return true;
    }


    public void makeEntry(User user){
        String query="Insert into users values('"+user.getUsername()+"','"+user.getPassword()+"')";
        jdbcTemplate.update(query);
    }
}
