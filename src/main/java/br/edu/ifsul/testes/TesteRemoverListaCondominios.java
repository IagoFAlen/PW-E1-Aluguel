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
public class TesteRemoverListaCondominios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-E1-IagoFigueiraPU");
        EntityManager em = emf.createEntityManager();
        
        UnidadeCondominial u = em.find(UnidadeCondominial.class, 1);
        Condominio c = em.find(Condominio.class, 1);
        
        u.removerCondominio(1);
        
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
