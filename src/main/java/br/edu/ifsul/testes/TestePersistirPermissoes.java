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
public class TestePersistirPermissoes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PW-E1-IagoFigueiraPU");
        EntityManager em = emf.createEntityManager();
        Usuario u = em.find(Usuario.class, "iagofigueira");
        Permissao p1 = em.find(Permissao.class, "ADMINISTRADOR");
        Permissao p2 = em.find(Permissao.class, "USUARIO");
        u.getPermissoes().add(p1);
        u.getPermissoes().add(p2);
        em.getTransaction().begin();
        em.merge(u);        
        em.getTransaction().commit();
        em.close();
        emf.close();                        
    }

}
