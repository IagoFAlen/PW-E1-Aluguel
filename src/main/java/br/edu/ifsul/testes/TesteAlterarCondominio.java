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
public class TesteAlterarCondominio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-E1-IagoFigueiraPU");
        EntityManager em = emf.createEntityManager();
        
        Condominio c = em.find(Condominio.class, 1);
        c.setNome("Condominio-B");
        c.setNumero("300");
        c.setEndereco("Rua 2");
        c.setCep("23900-140");
        c.setUnidadecondominial(em.find(UnidadeCondominial.class, 1));
        
        em.getTransaction().begin();
        em.merge(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
