/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Mensalidades;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Iago Figueira
 */
public class TesteAlterarMensalidades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-E1-IagoFigueiraPU");
        EntityManager em = emf.createEntityManager();
        
        Mensalidades m = em.find(Mensalidades.class, 1);
        m.setValor(9000.50);
        m.setDataPagamento(Calendar.getInstance());
        m.setVencimento(Calendar.getInstance());
        m.setValorPagamento(9950.00);
        
        
        em.getTransaction().begin();
        em.merge(m);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
