package pl.edu.agh.soa;

import com.fasterxml.classmate.AnnotationConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Main {



    public static void main(String [] args){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soa_db"); //name of persistence unit here

    }

}


