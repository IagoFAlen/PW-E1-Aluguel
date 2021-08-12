/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.Locatario;
import br.edu.ifsul.modelo.Mensalidades;
import br.edu.ifsul.modelo.UnidadeCondominial;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Iago Figueira
 */
public class TesteAlterarAluguel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-E1-IagoFigueiraPU");
        EntityManager em = emf.createEntityManager();
        
        Aluguel a = em.find(Aluguel.class, 1);
        Locatario l = em.find(Locatario.class, 2);
        a.setValor(5000.25);
        a.setDiaVencimento(7);
        a.setFimContrato(Calendar.getInstance());
        a.setInicioContrato(Calendar.getInstance());
        a.setLocatario(l);
        a.setUnidadecondominial(em.find(UnidadeCondominial.class, 1));
        a.setMensalidade(em.find(Mensalidades.class, 1));
        
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}