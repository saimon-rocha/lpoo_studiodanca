
# Sistema de Gerenciamento de Estúdio de Dança
Este projeto consiste em um sistema de gerenciamento para um estúdio de dança, desenvolvido como parte de um trabalho acadêmico. O sistema permite a gestão de contratos, pacotes de aulas, modalidades de dança e pagamentos.

## Documentação

#### Como Executar

Configure um banco de dados PostgreSQL e ajuste as configurações de conexão no arquivo persistence.xml no diretório 
```http
  src/main/resources/META-INF.
```
Importe o projeto para sua IDE favorita (recomendado: NetBeans, IntelliJ IDEA ou Eclipse).
Execute os testes unitários para verificar se tudo está funcionando corretamente.
Execute a aplicação principal para interagir com o sistema.
## Funcionalidades Implementadas
Instale my-project com npm

Cadastro de Contratos: Permite registrar contratos de alunos para aulas de dança, incluindo informações como data de início, forma de pagamento e detalhes do pacote contratado.

Cadastro de Pacotes de Aulas: Permite criar pacotes de aulas de dança, especificando a descrição, valor e modalidades inclusas.

Cadastro de Modalidades de Dança: Permite cadastrar diferentes modalidades de dança oferecidas pelo estúdio.

Registro de Pagamentos: Permite registrar os pagamentos realizados pelos alunos, incluindo informações como valor, data de vencimento e data de pagamento.    
## Stack utilizada

**Java**
**Java Persistence API (JPA)**
**Hibernate**
**Banco de Dados Relacional PostgreSQL**
**JUnit (para testes unitários)**


## Estrutura do Projeto

O projeto está estruturado em pacotes que representam diferentes partes do sistema:

br.edu.ifsul.bcc.lpoo_studio_danca.model: Contém as classes que representam os modelos de dados do sistema, como Contrato, Pacote, Modalidade e Pagamento.
br.edu.ifsul.bcc.lpoo_studio_danca.dao: Contém as classes responsáveis pela persistência dos dados, utilizando JPA e Hibernate.
br.edu.ifsul.bcc.lpoo_studio_danca: Contém os testes unitários e a classe principal do sistema.



## Contribuindo

Contribuições são sempre bem-vindas! Se você encontrar algum problema, ou desejar adicionar novas funcionalidades, sinta-se à vontade para abrir uma issue ou enviar um pull request.
