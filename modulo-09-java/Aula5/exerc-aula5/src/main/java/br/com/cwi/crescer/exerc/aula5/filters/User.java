package br.com.cwi.crescer.exerc.aula5.filters;

import br.com.cwi.crescer.exerc.aula5.utils.UserDetails;

/**
 * @author Carlos H. Nonnemacher
 */
public class User implements UserDetails {

    private String username;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    private String password;

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

}