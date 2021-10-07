package br.edu.ifsul.util.relatorios;

import br.edu.ifsul.modelo.Aluguel;
import br.edu.ifsul.modelo.Condominio;
import br.edu.ifsul.modelo.Locatario;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.UnidadeCondominial;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Iago Figueira
 */
public class FabricaObjetos {
    public static List<Aluguel> carregaAlugueis(){
        
        List<Aluguel> lista = new ArrayList<>();
        Aluguel a = new Aluguel();
        Locatario l = new Locatario();
        a.setId(1);
        a.setValor(2000.21);
        a.setDiaVencimento(5);
        a.setFimContrato(Calendar.getInstance());
        a.setInicioContrato(Calendar.getInstance());
        
        l.setLocalTrabalho("IFSUL");
        l.setRenda(1000000.00);
        l.setTelefoneTrabalho("98765432111111");
        l.setNome("Iago");
        l.setCpf("15912422562");
        l.setEmail("emailteste@gmail.com");
        l.setTelefone("999444151");
        a.setLocatario(l);
        
        UnidadeCondominial u = new UnidadeCondominial();
        u.setArea(1866.38);
        u.setDescricao("Descrição da unidade condominial");
        u.setNumero("291");
        u.setNumeroQuarto(42);
        
        Pessoa p = new Pessoa();
        p.setNome("Proprietario");
        p.setCpf("15487648799");
        p.setTelefone("894965233");
        u.setProprietario(p);
        
        Condominio c = new Condominio();
        c.setNome("Condominio-A");
        c.setNumero("291");
        c.setEndereco("Rua principal");
        c.setCep("23900-000");
        u.setCondominio(c);
        
        a.setUnidadecondominial(u);
        
        
        lista.add(a);
        
        return lista;
    }
}
