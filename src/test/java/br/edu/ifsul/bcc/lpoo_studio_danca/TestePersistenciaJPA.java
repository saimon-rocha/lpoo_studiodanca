/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.edu.ifsul.bcc.lpoo_studio_danca;

import br.edu.ifsul.bcc.lpoo_studio_danca.dao.PersistenciaJPA;
import br.edu.ifsul.bcc.lpoo_studio_danca.model.Modalidade;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Saimon AS Rocha
 */
public class TestePersistenciaJPA {

    PersistenciaJPA jpa = new PersistenciaJPA();

    public TestePersistenciaJPA() {
    }

    @Before
    public void setUp() {
        jpa.conexaoAberta();
        System.out.println("conectou no BD via jpa ...");
    }

    @After
    public void tearDown() {
        jpa.fecharConexao();
        System.out.println("nao conectou no BD ...");
    }

    @Test
    public void testePersistenciaJPA() throws Exception {
        //Cria Objeto
        Modalidade m = new Modalidade();
        m.setDescricao("Danca Salao");
        //Persistir objeto
        jpa.persist(m);

        //Busca objeto Persistido
        //Produto persistidoProduto = (Produto)jpa.find(Produto.class, p.getId());
        //Verifica se o objeto persistido é igual ao criado
        //Assert.assertEquals(p.getDescricao(), persistidoProduto.getDescricao());
    }
}
