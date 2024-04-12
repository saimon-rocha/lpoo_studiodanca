/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.edu.ifsul.bcc.lpoo_studio_danca;

import br.edu.ifsul.bcc.lpoo_studio_danca.dao.PersistenciaJPA;
import br.edu.ifsul.bcc.lpoo_studio_danca.model.Modalidade;
import br.edu.ifsul.bcc.lpoo_studio_danca.model.Pagamento;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
    }
    
    @Test
    public void testePersistenciaJPA() throws Exception {
        //Cria Objeto
        Modalidade m = new Modalidade();
        m.setDescricao("Danca Salao");
        //Persistir objeto
        jpa.persist(m);
        
        Pagamento p = new Pagamento();
        p.setValor(1000.00);
        p.setValorPgto(900.00);
        // Define a data de vencimento
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar dataVcto = Calendar.getInstance();
        Calendar dataPgto = Calendar.getInstance();
        try {
            dataVcto.setTime(sdf.parse("20/05/2024"));
            dataPgto.setTime(sdf.parse("12/04/2024"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        p.setDataVcto(dataVcto);
        p.setDataPgto(dataPgto);
        jpa.persist(p);
        
        System.out.println("Pagamento de R$" + p.getValor());
        System.out.println("Dia de Vencimento " + p.getDataVcto());
        
        System.out.println("Valor Pago R$ " + p.getValorPgto());
        System.out.println("Dia de Pagamento " + p.getDataPgto());
    }
}
