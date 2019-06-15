/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.hust.soict.objects;

/**
 *Constructor, getter, setter Object User(define properties, methods of User).
 * @author BKHN
 */
public class AddUser {

    private int id;
    private String user_name;
    private String password;
    private String is_admin;

    /**
     *
     */
    public AddUser() {
    }

    /**
     *
     * @param user_name
     * @param password
     * @param is_admin
     * 
     */
    public AddUser(String user_name, String password, String is_admin) {
        this.user_name = user_name;
        this.password = password;
        this.is_admin = is_admin;
    }

    /**
     *
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param user_name
     * @param password
     * @param is_admin
     */
    public AddUser(int id, String user_name, String password,  String is_admin) {
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.is_admin = is_admin;
    }

    /**
     *
     * @return
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     *
     * @param user_name
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     *
     * @return
     */
    public String getIs_admin() {
        return is_admin;
    }

    /**
     *
     * @param is_admin
     */
    public void setIs_admin(String is_admin) {
        this.is_admin = is_admin;
    }
    

}
