/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.UnidadeCondominial;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Iago Figueira
 */
public class TesteAlterarUnidadeCondominial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-E1-IagoFigueiraPU");
        EntityManager em = emf.createEntityManager();
        
        UnidadeCondominial u = em.find(UnidadeCondominial.class, 1);
        u.setArea(7000.14);
        u.setDescricao("Descrição 2 da unidade condominial");
        u.setNumero("300");
        u.setNumeroQuarto(7);
        u.setProprietario(em.find(Pessoa.class, 1));
        
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
