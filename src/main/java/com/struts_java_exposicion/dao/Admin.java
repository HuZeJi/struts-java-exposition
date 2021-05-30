/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.struts_java_exposicion.dao;

import com.struts_java_exposicion.bean.SuperheroeTo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vhjim
 */
public class Admin {

    public static Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/expo_java2", "root", "");
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public int registerSuperhero(SuperheroeTo superhero) throws Exception {
        int i = 0;
        try {
            String sql = "INSERT INTO superhero VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, superhero.getId());
            ps.setString(2, superhero.getS_name());
            ps.setString(3, superhero.getSuperpower());
            ps.setString(4, superhero.getR_name());
            ps.setString(5, superhero.getEditorial());
            ps.setString(6, superhero.getHistory());
            i = ps.executeUpdate();
            return i;
        } catch (Exception ex) {
            ex.printStackTrace();
            return i;
        } finally {
            if (getConnection() != null) {
                getConnection().close();
            }
        }
    }
    
    public ResultSet getAll() throws SQLException, Exception {
        ResultSet rs = null;
        try {
            String sql = "SELECT id, s_name, superpower, r_name, editorial, history FROM superhero";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (getConnection() != null) {
                getConnection().close();
            }
        }
    }
    
    public ResultSet getHeroById(String id) throws SQLException, Exception {
        ResultSet rs = null;
        try {
            String sql = "SELECT id, s_name, superpower, r_name, editorial, history FROM superhero WHERE id=?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (getConnection() != null) {
                getConnection().close();
            }
        }
    }
    
    public int updateSuperHero(SuperheroeTo superhero, String id) throws SQLException, Exception {
        getConnection().setAutoCommit(false);
        int i = 0;
        try {
            String sql = "UPDATE superhero SET id = ?, s_name=?, superpower=?, r_name=?, editorial=?, history=? WHERE id=?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, superhero.getId());
            ps.setString(2, superhero.getS_name());
            ps.setString(3, superhero.getSuperpower());
            ps.setString(4, superhero.getR_name());
            ps.setString(5, superhero.getEditorial());
            ps.setString(6, superhero.getHistory());
            ps.setString(7, id);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            getConnection().rollback();
            return 0;
        } finally {
            if (getConnection() != null) {
                getConnection().close();
            }
        }
    }
    
    public int deleteSuperHero(String id) throws SQLException, Exception {
        getConnection().setAutoCommit(false);
        int i = 0;
        try {
            String sql = "DELETE FROM superhero WHERE id=?";
            PreparedStatement ps = getConnection().prepareStatement(sql);
            ps.setString(1, id);
            i = ps.executeUpdate();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
            getConnection().rollback();
            return 0;
        } finally {
            if (getConnection() != null) {
                getConnection().close();
            }
        }
    }

}
