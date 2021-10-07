/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Permissao;
import br.edu.ifsul.modelo.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Iago Figueira
 */
public class TestePersistirUsuario {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-E1-IagoFigueiraPU");
        EntityManager em = emf.createEntityManager();
        Usuario u = new Usuario();
        u.setNomeUsuario("teste");
        u.setSenha("22222");
        u.setAtivo(true);
        u.setEmail("email@gmail.com");        
        u.setNome("Iago Teste");        
        em.getTransaction().begin();
        em.persist(u);        
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
        
    }

}