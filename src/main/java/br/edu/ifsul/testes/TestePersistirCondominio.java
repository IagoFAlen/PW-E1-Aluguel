/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.UnidadeCondominial;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Iago Figueira
 */
public class TestePersistirCondominio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-E1-IagoFigueiraPU");
        EntityManager em = emf.createEntityManager();
        
        Condominio c = new Condominio();
        c.setNome("Condominio-A");
        c.setNumero("291");
        c.setEndereco("Rua principal");
        c.setCep("23900-000");
        
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
