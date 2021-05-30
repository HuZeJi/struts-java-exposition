/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.struts_java_exposicion.action;

import com.opensymphony.xwork2.ActionSupport;
import com.struts_java_exposicion.bean.SuperheroeTo;
import com.struts_java_exposicion.dao.Admin;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author vhjim
 */
@Action("/crear")
@Result(name = "CREAR", location = "/Crear.jsp")
public class Crear extends ActionSupport{
    private static final long serialVersionUID = 2139116285823340125L;
    private String id, s_name, superpower, r_name, editorial, history;
    private String msg = "";
    Admin dao = null;
    int ctr = 0;
    
    @Override
    public String execute() throws Exception {
        dao = new Admin();
        try {
            SuperheroeTo superHero = new SuperheroeTo();
            superHero.setId(this.id);
            superHero.setS_name(this.s_name);
            superHero.setSuperpower(this.superpower);
            superHero.setR_name(this.r_name);
            superHero.setEditorial(this.editorial);
            superHero.setHistory(this.history);
            ctr = dao.registerSuperhero(superHero);
            if (ctr > 0) {
                msg = "Registro Exitoso";
            } else {
                msg = "Registro Fallido";
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "CREAR";
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

    public int getCtr() {
        return ctr;
    }

    public void setCtr(int ctr) {
        this.ctr = ctr;
    }
    
}
