/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.santechture.assignment;

import com.mycompany.santechture.assignment.dao.DepartmentFacade;
import com.mycompany.santechture.assignment.dao.EmployeeFacade;
import com.mycompany.santechture.assignment.entities.Department;
import com.mycompany.santechture.assignment.entities.Employee;
import com.mycompany.santechture.assignment.util.JsfUtil;
import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/**
 *
 * @author Ahmed habib
 */
@Named("mainCtrl")
@SessionScoped
@ManagedBean
public class MainCtrl implements Serializable {

    @EJB
    private EmployeeFacade employeeFacad;
    @EJB
    private DepartmentFacade departmentFacade;
    
    private Employee currentEmp;
    private List<Department> allDepts;
    private List<Employee> allEmps;


    @PostConstruct
    public void init() {
        currentEmp = new Employee();
        allDepts = departmentFacade.findAll();
        allEmps = employeeFacad.findAll();
    }

    public String save() {
        try {
            allEmps = employeeFacad.findAll();
            Employee emp = employeeFacad.create(currentEmp);
            emp.setDepartment(departmentFacade.find(emp.getDeptId()));
            allEmps.add(emp);
            currentEmp = new Employee();
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("EmployeeCreated"));
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
        return "";
    }
    public String getGender(int genderId){
        if(genderId==1){
            return ResourceBundle.getBundle("/Bundle").getString("gender_male");
        }else{
            return ResourceBundle.getBundle("/Bundle").getString("gender_female");
        }
    }

    public Employee getCurrentEmp() {
        return currentEmp;
    }

    public void setCurrentEmp(Employee currentEmp) {
        this.currentEmp = currentEmp;
    }

    public List<Department> getAllDepts() {
        return allDepts;
    }

    public void setAllDepts(List<Department> allDepts) {
        this.allDepts = allDepts;
    }

    public List<Employee> getAllEmps() {
        return allEmps;
    }

    public void setAllEmps(List<Employee> allEmps) {
        this.allEmps = allEmps;
    }

}
