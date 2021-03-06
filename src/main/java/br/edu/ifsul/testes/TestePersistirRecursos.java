/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Recurso;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Iago Figueira
 */
public class TestePersistirRecursos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-E1-IagoFigueiraPU");
        EntityManager em = emf.createEntityManager();
        
        Condominio c = em.find(Condominio.class, 1);
        Recurso r = em.find(Recurso.class, 1);
        c.getRecursos().add(r);
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
