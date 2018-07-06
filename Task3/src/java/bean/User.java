/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.Objects;

/**
 *
 * @author me
 */
public class User {

    private int id;
    private String login;
    private String password;
    private String email;

    public User(int id, String login, String password, String email) {
	this.id = id;
	this.login = login;
	this.password = password;
	this.email = email;
    }

    public User() {
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getLogin() {
	return login;
    }

    public void setLogin(String login) {
	this.login = login;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    @Override
    public int hashCode() {
	int hash = 7;
	hash = 97 * hash + this.id;
	hash = 97 * hash + Objects.hashCode(this.login);
	hash = 97 * hash + Objects.hashCode(this.password);
	hash = 97 * hash + Objects.hashCode(this.email);
	return hash;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (obj == null) {
	    return false;
	}
	if (getClass() != obj.getClass()) {
	    return false;
	}
	final User other = (User) obj;
	if (this.id != other.id) {
	    return false;
	}
	if (!Objects.equals(this.login, other.login)) {
	    return false;
	}
	if (!Objects.equals(this.password, other.password)) {
	    return false;
	}
	if (!Objects.equals(this.email, other.email)) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return "User{" + "id=" + id + ", login=" + login + ", password=" + password + ", email=" + email + '}';
    }

}
