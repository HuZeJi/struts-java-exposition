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
import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author vhjim
 */
@Action("/report")
@Result(name = "REPORT", location = "/Report.jsp")
public class Report extends ActionSupport {
    
    private static final long serialVersionUID = 6329394260276112660L;
    ResultSet rs = null;
    SuperheroeTo sh = null;
    List<SuperheroeTo> shList = null;
    Admin dao = new Admin();
    private boolean noData = false;

    @Override
    public String execute() throws Exception {
        try {
            shList = new ArrayList<SuperheroeTo>();
            rs = dao.getAll();
            int i = 0;
            if (rs != null) {
                while (rs.next()) {
                    i++;
                    sh = new SuperheroeTo();
                    sh.setId(rs.getString("id"));
                    sh.setS_name(rs.getString("s_name"));
                    sh.setSuperpower(rs.getString("superpower"));
                    sh.setR_name(rs.getString("r_name"));
                    sh.setEditorial(rs.getString("editorial"));
                    sh.setHistory(rs.getString("history"));
                    shList.add(sh);
                }
            }
            noData = i == 0;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "REPORT";
    }

    public List<SuperheroeTo> getShList() {
        return shList;
    }

    public void setShList(List<SuperheroeTo> shList) {
        this.shList = shList;
    }

    public boolean isNoData() {
        return noData;
    }

    public void setNoData(boolean noData) {
        this.noData = noData;
    }

}
