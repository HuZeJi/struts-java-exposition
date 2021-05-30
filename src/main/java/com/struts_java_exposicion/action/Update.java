/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.struts_java_exposicion.action;

import com.opensymphony.xwork2.ActionSupport;
import com.struts_java_exposicion.bean.SuperheroeTo;
import com.struts_java_exposicion.dao.Admin;
import java.sql.ResultSet;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author vhjim
 */
@Action("/update")
@Result(name = "UPDATE", location = "/Update.jsp")
public class Update extends ActionSupport {

    private static final long serialVersionUID = -1905974197186620917L;
    private String id = "", s_name = "", superpower = "", r_name = "", editorial = "", history = "";
    private String msg = "";
    ResultSet rs = null;
    Admin dao = new Admin();
    String submitType;    

    @Override
    public String execute() throws Exception {
        try {
            if (submitType != null && submitType.equals("updateData")) {
                rs = dao.getHeroById(id.trim());
                if (rs != null) {
                    while (rs.next()) {
                        id = rs.getString("id");
                        s_name = rs.getString("s_name");
                        superpower = rs.getString("superpower");
                        r_name = rs.getString("r_name");
                        editorial = rs.getString("editorial");
                        history = rs.getString("history");
                    }
                }
            } else {
                SuperheroeTo sh = new SuperheroeTo();
                sh.setId(id);
                sh.setS_name(s_name);
                sh.setSuperpower(superpower);
                sh.setR_name(r_name);
                sh.setEditorial(editorial);
                sh.setHistory(history);
                int i = dao.updateSuperHero(sh, id);
                if (i > 0){
                    msg = "Registro actualizado correctamente";
                } else {
                    msg = "Error";
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "UPDATE";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getSuperpower() {
        return superpower;
    }

    public void setSuperpower(String superpower) {
        this.superpower = superpower;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSubmitType() {
        return submitType;
    }

    public void setSubmitType(String submitType) {
        this.submitType = submitType;
    }

}
