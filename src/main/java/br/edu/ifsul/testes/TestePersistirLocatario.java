/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Locatario;  
import br.edu.ifsul.modelo.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Iago Figueira
 */
public class TestePersistirLocatario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-E1-IagoFigueiraPU");
        EntityManager em = emf.createEntityManager();
        
        Locatario l = new Locatario();
        Pessoa p = em.find(Pessoa.class, 1);
        l.setLocalTrabalho("IFSUL");
        l.setRenda(1000000.00);
        l.setTelefoneTrabalho("98765432111111");
        l.setNome(p.getNome());
        l.setCpf(p.getCpf());
        l.setEmail(p.getEmail());
        l.setTelefone(p.getTelefone());
        
        em.getTransaction().begin();
        em.persist(l);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
