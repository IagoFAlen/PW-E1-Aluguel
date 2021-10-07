/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.Mensalidades;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Iago Figueira
 */
public class TestePersistirMensalidades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-E1-IagoFigueiraPU");
        EntityManager em = emf.createEntityManager();
        
        Mensalidades m = new Mensalidades();
        m.setValor(2000.00);
        m.setDataPagamento(Calendar.getInstance());
        m.setVencimento(Calendar.getInstance());
        m.setValorPagamento(2000.21);
        m.setAluguel(em.find(Aluguel.class, 1));
        
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
        em.close();
        emf.close();
        
    }
    
}
