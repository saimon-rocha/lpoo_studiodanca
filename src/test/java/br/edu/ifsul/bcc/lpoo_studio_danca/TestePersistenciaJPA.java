/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.edu.ifsul.bcc.lpoo_studio_danca;

import br.edu.ifsul.bcc.lpoo_studio_danca.dao.PersistenciaJPA;
import br.edu.ifsul.bcc.lpoo_studio_danca.model.Contrato;
import br.edu.ifsul.bcc.lpoo_studio_danca.model.FormaPgto;
import br.edu.ifsul.bcc.lpoo_studio_danca.model.Modalidade;
import br.edu.ifsul.bcc.lpoo_studio_danca.model.Pacote;
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
        System.out.println("Conexão estabelecida com o banco de dados via JPA...");
    }

    @After
    public void tearDown() {
        jpa.fecharConexao();
    }

    @Test
    public void testePersistenciaJPA() throws Exception {
        // Criar e persistir uma modalidade
        Modalidade modalidade = new Modalidade();
        modalidade.setDescricao("Dança de Salão");
        jpa.persist(modalidade);

        // Criar um pacote
        Pacote pacote = new Pacote();
        pacote.setDescricao("Pacote Iniciante");
        pacote.setValor(500.00);

        // Associar modalidade ao pacote
        pacote.getModalidades().add(modalidade);

        // Criar um contrato
        Contrato contrato = new Contrato();
        contrato.setFormaPagamento(FormaPgto.PIX);

        // Criar e associar um pagamento ao contrato
        Pagamento pagamento = new Pagamento();
        pagamento.setValor(1000.00);
        pagamento.setValorPgto(900.00);

        // Definir datas para o pagamento e o contrato
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar dataVcto = Calendar.getInstance();
        Calendar dataPgto = Calendar.getInstance();
        Calendar dataInicio = Calendar.getInstance();
        try {
            dataVcto.setTime(sdf.parse("20/04/2024"));
            dataPgto.setTime(sdf.parse("12/04/2024"));
            dataInicio.setTime(sdf.parse("12/03/2024"));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        pagamento.setDataVcto(dataVcto);
        pagamento.setDataPgto(dataPgto);
        contrato.setDataInicio(dataInicio);

        // Associar o pagamento ao contrato
        contrato.getPagamentos().add(pagamento);
        pagamento.setContrato(contrato);

        // Associar pacote ao contrato
        contrato.setPacote(pacote);

        // Persistir o contrato, pagamento e pacote
        jpa.persist(pacote);
        jpa.persist(contrato);
        jpa.persist(pagamento);

        // Exibir informações sobre o pagamento, contrato e pacote
        System.out.println("Pagamento de R$ " + pagamento.getValor());
        System.out.println("Dia de Vencimento: " + pagamento.getDataVcto().getTime());
        System.out.println("Valor Pago R$ " + pagamento.getValorPgto());
        System.out.println("Dia de Pagamento: " + pagamento.getDataPgto().getTime());
        System.out.println("Pacote: " + pacote.getDescricao());
    }
}
