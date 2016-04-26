/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Empresa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class CrearEmpresa {

    
public static void main(String[] args) {
    EntityManagerFactory per = Persistence.createEntityManagerFactory("PersistenceEmpresaPU");
    EntityManager en = per.createEntityManager();
    
    en.getTransaction().begin();

    Empresa em = new Empresa();
    Scanner Empresa= new Scanner(System.in);
    System.out.println("Ingrese el ID de la empresa");
    em.setIdEmpresa(Integer.parseInt(Empresa.nextLine()));
    System.out.println("Ingrese el nombre de la empresa");
    em.setNombre(Empresa.nextLine());
    System.out.println("Ingrese la actividad de la empresa");
    em.setActividad(Empresa.nextLine());
    en.persist(em);
    
    Area a2 = new Area();
    Scanner Area= new Scanner(System.in);
    System.out.println("Ingrese el codigo del area");
    a2.setIdArea(Integer.parseInt(Area.nextLine()));
    System.out.println("Ingrese el nombre del area");
    a2.setNombre(Area.nextLine());
    a2.setIdEmpresa(em);
    en.persist(a2);
    
    Cargo c = new Cargo();
    Scanner Cargo = new Scanner(System.in);
    System.out.println("Ingrese el codigo del cargo");
    c.setIdCargo(Integer.parseInt(Cargo.nextLine()));
    System.out.println("ingrese el nombre del cargo");
    c.setNombre(Cargo.nextLine());
    System.out.println("Ingrese la funcion que se cumple en el cargo");
    c.setFuncion(Cargo.nextLine());
    c.setIdArea(a2);
    en.persist(c);
    
    Empleados emp = new Empleados();
    Scanner Empleado = new Scanner(System.in);
    System.out.println("Ingrese la identificacion del empleado");
    emp.setIdEmpleados(Integer.parseInt(Empleado.nextLine()));
    System.out.println("Ingrese el nombre del empleado");
    emp.setNombres(Empleado.nextLine());
    emp.setIdCargo(c);
    en.persist(emp);
 
    en.getTransaction().commit();
    
    en.close();
    per.close();
}

}
    
