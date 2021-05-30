/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.struts_java_exposicion.action;

import com.opensymphony.xwork2.ActionSupport;
import com.struts_java_exposicion.dao.Admin;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author vhjim
 */
@Action("/delete")
@Result(name = "DELETE", location = "/Delete.jsp")
public class Delete extends ActionSupport{
    
    private static final long serialVersionUID = -146601914103585418L;
    String id, msg;
    Admin dao = new Admin();    
    
    @Override
    public String execute() throws Exception{
        try {
            int wasDeleted = dao.deleteSuperHero(id);
            if (wasDeleted > 0){
                msg = "Registro eliminado exitosamente";
            } else {
                msg = "Error";
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }        
        return "DELETE";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
