package com.expensetracker.dao;

import com.expensetracker.model.Employee;
import com.expensetracker.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class EmployeeDAO {

    // =========================
    // CREATE - ADD EMPLOYEE
    // =========================
    public void addEmployee(Employee employee) {

        Transaction transaction = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            session.persist(employee);

            transaction.commit();

            System.out.println("Employee added successfully!");

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            System.out.println("Error while adding employee:");
            e.printStackTrace();
        }
    }


    // =========================
    // READ - VIEW ALL EMPLOYEES
    // =========================
    public List<Employee> getAllEmployees() {

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            return session
                    .createQuery(
                            "FROM Employee",
                            Employee.class
                    )
                    .getResultList();

        } catch (Exception e) {

            System.out.println("Error while viewing employees:");
            e.printStackTrace();

            return List.of();
        }
    }


    // =========================
    // READ - FIND BY ID
    // =========================
    public Employee getEmployeeById(Long id) {

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            return session.get(Employee.class, id);

        } catch (Exception e) {

            System.out.println("Error while finding employee:");
            e.printStackTrace();

            return null;
        }
    }


    // =========================
    // UPDATE EMPLOYEE
    // =========================
    public boolean updateEmployee(Employee employee) {

        Transaction transaction = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Employee existingEmployee =
                    session.get(Employee.class, employee.getId());

            if (existingEmployee == null) {

                System.out.println("Employee ID not found!");

                transaction.rollback();

                return false;
            }

            existingEmployee.setRoleId(
                    employee.getRoleId()
            );

            existingEmployee.setDepartmentId(
                    employee.getDepartmentId()
            );

            existingEmployee.setName(
                    employee.getName()
            );

            existingEmployee.setEmail(
                    employee.getEmail()
            );

            existingEmployee.setPhone(
                    employee.getPhone()
            );

            existingEmployee.setDesignation(
                    employee.getDesignation()
            );

            transaction.commit();

            System.out.println("Employee updated successfully!");

            return true;

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            System.out.println("Error while updating employee:");
            e.printStackTrace();

            return false;
        }
    }


    // =========================
    // DELETE EMPLOYEE
    // =========================
    public boolean deleteEmployee(Long id) {

        Transaction transaction = null;

        try (Session session =
                     HibernateUtil.getSessionFactory().openSession()) {

            transaction = session.beginTransaction();

            Employee employee =
                    session.get(Employee.class, id);

            if (employee == null) {

                System.out.println("Employee ID not found!");

                transaction.rollback();

                return false;
            }

            session.remove(employee);

            transaction.commit();

            System.out.println("Employee deleted successfully!");

            return true;

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            System.out.println("Error while deleting employee:");
            e.printStackTrace();

            return false;
        }
    }
}