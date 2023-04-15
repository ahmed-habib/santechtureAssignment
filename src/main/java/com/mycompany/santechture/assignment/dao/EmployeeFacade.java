/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.santechture.assignment.dao;

import com.mycompany.santechture.assignment.entities.Employee;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author Ahmed habib
 */
@Stateless
public class EmployeeFacade extends AbstractFacade<Employee> {

    private static final String PERSISTENCE_UNIT_NAME = "MainUnit";
    private static EntityManager em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
    private static EntityTransaction transactionObj = em.getTransaction();

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    protected EntityTransaction getTransaction() {
        return transactionObj;
    }

    public EmployeeFacade() {
        super(Employee.class);
    }
    
}
