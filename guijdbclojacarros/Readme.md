## Manual de Uso: Software de Gerenciamento de Dados com Java e Maven

Este guia é destinado aos usuários que utilizam o software de gerenciamento de dados para realizar operações com carros, clientes e vendas.

### Pré-requisitos

Antes de clonar o repositório, certifique-se de ter o link do driver do PostgreSQL nas dependências do arquivo `pom.xml`.

### 1. Login

Para acessar o sistema, é necessário fazer login. Insira o nome de usuário e a senha na tela de login e clique em "Entrar".

### 2. Interface de Usuário

O software possui os seguintes elementos:

#### Campos de Entrada:

- Marca
- Modelo
- Valor
- Placa
- Cliente
- Data

#### Botões:

- Cadastrar
- Editar
- Apagar
- Limpar

#### Tabelas:

Exibem informações de carros, clientes e vendas.

### 3. Funcionalidades

#### Operações com Carros:

1. Cadastro: Preencha todos os campos de entrada. Selecione o estado de venda. Clique em "Cadastrar".
2. Edição: Selecione um carro na tabela. Faça as alterações nos campos desejados. Clique em "Editar".
3. Remoção: Selecione um carro na tabela. Clique em "Apagar". Confirme a exclusão quando solicitado.
4. Limpeza: Clique em "Limpar" para limpar todos os campos de entrada.

#### Observações Importantes

- Formato da Placa: Deve seguir o formato "ABC-1234".
- Ano do Carro: Deve ser válido e não superior ao ano atual + 1 e não inferior a 1900.

### 4. Observações Finais

- Preencha corretamente todos os campos para evitar erros.
- Utilize os botões correspondentes às operações desejadas.

### Alterações na Abordagem:

- Informação sobre a dependência do driver do PostgreSQL no arquivo `pom.xml`.
- Explicação sobre as funcionalidades do software.
- Observações importantes sobre formatação e validação de campos.

### Exemplos de Utilização:

Para cadastrar um novo carro com a marca "Fiat", modelo "Palio", valor de R$ 50.000,00, placa "ABC-1234", e ano "2022":

1. Selecione "Fiat" na lista suspensa "Marca".
2. Insira "Palio" no campo "Modelo".
3. Insira "50.000,00" no campo "Valor".
4. Insira "ABC-1234" no campo "Placa".
5. Selecione a data atual no campo "Data".
6. Clique em "Cadastrar".

Após o cadastro, os detalhes serão exibidos na tabela de carros.
