                                                                RELATÓRIO GERAL

INTEGRANTES: Igor Oliveira & Eduardo Ananias

        INTERFACES GRÁFICAS DE USUÁRIO:
No desenvolvimento de aplicativos Java, a criação de interfaces gráficas de usuário (GUIs) eficazes e visualmente agradáveis desempenhaM um papel fundamental na experiência do usuário. O layout da interface gráfica é um dos aspectos mais importantes a serem considerados ao projetar uma GUI. Um layout bem projetado permite que os elementos da interface sejam organizados de maneira atraente e funcional, proporcionando uma experiência de usuário agradável e intuitiva.

        LAYOUTS EM JAVA:
Em Java, os layouts são responsáveis pela disposição e organização dos componentes de interface gráfica, como botões, caixas de texto, rótulos e painéis. Os layouts determinam como esses componentes são posicionados e dimensionados dentro de um contêiner.

Existem vários tipos de layouts disponíveis em Java, cada um com suas próprias características e uso adequado. Alguns dos layouts mais comuns incluem:

FlowLayout: Os componentes são organizados em uma única linha, um após o outro, respeitando o tamanho natural de cada componente. É adequado para criar layouts simples, como barras de ferramentas.

BorderLayout: Os componentes são organizados em cinco regiões: norte, sul, leste, oeste e centro. É útil para criar layouts que têm um componente principal no centro e outros componentes auxiliares nas bordas, como barras de menu.

GridLayout: Os componentes são organizados em uma grade retangular de células, com linhas e colunas de tamanho igual. É adequado para criar layouts de grade regulares, como tabelas.

GridBagLayout: É uma versão mais avançada do GridLayout, permitindo maior controle sobre o posicionamento e o dimensionamento dos componentes.

        ESCOLHA DO LAYOUT E IMPORTÂNCIA:
A escolha do layout adequado é crucial para o sucesso de um aplicativo Java, dentre as quais:

Estética e Usabilidade: Um layout bem projetado torna a GUI agradável visualmente e fácil de usar. Ele permite que os elementos da interface estejam alinhados e organizados de maneira intuitiva, melhorando a experiência do usuário.

Responsividade: Diferentes layouts respondem de maneira diferente a redimensionamento da janela ou a diferentes tamanhos de tela. Escolher um layout responsivo garante que sua GUI funcione bem em diferentes dispositivos e tamanhos de tela.

Organização Lógica: Um layout apropriado ajuda a organizar os componentes de forma lógica e coerente. Por exemplo, um BorderLayout é adequado quando há um componente principal no centro e componentes auxiliares nas bordas.

Economia de Tempo: A escolha do layout correto pode economizar tempo de desenvolvimento, pois alguns layouts, como o GridLayout, simplificam a organização de muitos componentes sem a necessidade de cálculos manuais de posicionamento.



        CONCLUSÃO:
Tivemos uma ótima experiência ao explorar os diferentes tipos de Layouts em java! Combinamos de fazer duas calculadoras de forma individual, para além de termos o poder de personalização apropriado, adquirir a sua própria experiência manipulando este tipo de conceito. Acredito que a realização do projeto desta forma, nos deu uma bagagem do entendimento geral sobre a GUI em java, entendendo suas interpelações - AWT e SWING além de tipos de LayoutManager.

De início encontramos empecilhos ao tentar realizar a mudança do tipo de Layout, mas com a prática de codar e (um pouco de ajuda :), desvencilhamos diversas formas diferentes de realizar o projeto, como por exemplo fizemos - a criação de uma Janela principal - "JFrame" - e a criação de um container - "JPanel" - para manipular individualmente cada calculadora, e, no caso da calc1 por exemplo, fora colocado 1 container dentro de outro container usando "Border e Grid".

Em busca de obter a experiência completa, fomos atrás de "colocar pra funcionar" uma das calculadoras, após muitas pesquisas e refatoração do código, chegamos a um resultado satisfatório na calc2 que realiza as 4 operações aritméticas simples.
A terceira e última calculadora - calc3 explora um outro tipo de layout que não foi apresentado em sala de aula e tem a simples tarefa de converter milhas para km.


        Calculadora 1:

A calculadora 1 simula uma calculadora científica e utiliza o container principal como border - que redimensiona outro container que é grid que aloca os componentes - botoes e uma caixa de texto.
Comentei o código dividindo suas linhas para uma maior compreensão. Cada linha contém 'n' componentes pré-definidos pelas cols do layout grid. Utilizei códigos para simular alguns caracteres especiais, como "\u27A1".
Criei uma classe chamada MeuBotao onde setei todas as configs que queria para cada botão novo a ser adicionado e com um método privado, instanciei esta classe e a partir daí pude criar meus botões com a sintaxe:    painel.add(new MeuBotao("sin"));

    CONCLUSÃO

A calculadora ficou visualmente agradável e bem organizada, mas não tem funcionalidades.



        Calculadora 2:

A calculadora 2 é uma calculadora padrão simples que realiza com eficiência as 4 operações aritméticas.
Novamente usamos dois containers para distribuição dos componentes, border e grid. Criamos os botões todos a partir de um vetor e um for que percorre adicionando os componentes.
Definimos cores e algumas estilizações e depois demos a dinâmica da funcionalidade com os ouvintes de botões.
Essa com toda certeza foi a parte mais difícil, precisamos refatorar todo o código varias vezes até adapta-lo a ponto de funcionar corretamente. Basicamente adicionamos um ouvinte que atende o código quando PRESSIONADO - o @override sobrescreve o o método da classe Pai "ActionListener" adaptando as suas necessidades. 
String comando = e.getActionCommand();: Isso obtém o comando associado ao evento e. Em interfaces gráficas, os botões geralmente têm um comando associado a eles, e este comando é usado para identificar qual ação foi realizada.

Inicia-se com um bloco try para o tratamento de excessões e começa a fazer verificações, como a primeira que denota se o comando é digito ou um ponto decimal;

else if ("+-*/".contains(comando)) {: Este bloco verifica se o comando é um dos caracteres "+", "-", "*", ou "/". Se for, ele armazena o valor atual no display na variável valor1 e registra a operação correspondente (um dos caracteres mencionados) na variável operacao. Em seguida, ele limpa o display para que o próximo número possa ser inserido.

else if (comando.equals("=")) {: Aqui, ele verifica se o comando é "=". Se for, ele armazena o valor atual no display na variável valor2, chama uma função calcular() para executar a operação entre valor1 e valor2, armazena o resultado em resultado e exibe o resultado no display.

else if (comando.equals("C")) {: Isso verifica se o comando é "C". Se for, ele limpa todo o conteúdo do display.

else if (comando.equals("CE")) {: Aqui, ele verifica se o comando é "CE". Se for, ele remove o último caractere do texto exibido no display, se houver algum texto presente.

Termina com um bloco catch para realizar o tratamento das Excessões;

Ao final é feito um método privado com Switch and Case para realizar as operações aritméticas com as variáveis valor1 e valor2.

        CONCLUSÃO

Não é a calculadora mais agradável visuamente, mas realiza suas funções com eficácia.



        Calculadora 3:

A calculadora 3 utiliza um tipo de layout que não foi visto em sala de aula, que é o cardLayout -

 "Um gerenciador do tipo CardLayout empilha os componentes de um container de tal forma que apenas o componente que está no topo permanece visível. Esse gerenciador implementa a interface LayoutManager2.
Os métodos do gerenciador estabelecem funcionalidades que permitem "navegar" entre os componentes empilhados, determinando qual item deve estar visível em um dado momento. Os métodos de navegação first(), next(), previous() e last() permitem realizar uma varredura seqüencial pelos componentes de container especificado, cujo gerenciador de layout deve ser do tipo CardLayout."

Começamos estilizando o botão de converter e o JtextField e conseguinte adicionamos um ouvinte ao botão de converter que realiza o metodo privado converterMilhasKm; 
Os trechos abaixo empilham de forma que um componente fica acima do outro, e dois fiquem lado a lado.

Método de converterMilhasKm é feito para armazenar o valor que foi digitado na caixa de texto e multiplicar por uma constante que fará a conversão das milhas para km - há um tratamente de excessões caso o user digite letras



        CONCLUSÃO 

Chegamos a uma calculadora de conversão até que visualmente agradável e satisfatória quanto ao seu resultado, mas com toda certeza, tivemos muita dificuldade em adaptar o layout do jeito que queriamos.









        CONCLUSÃO FINAL:

Usamos 4 tipos de layout e obtemos uma experiência de como funcionam as GUI em java. Claro que tivemos preferências ou facilidade de manipulação de cada layout, mas no geral todos os tipos exercem uma função que se adequa ao tipo de software que você deseja fazer.
Pensamos também em um projeto futuro de fazer um sistema de cadastro de produtos - entrada e saída de dados usando GUI em java.
Com esse projeto aprendemos sobre diversos tipos de Layouts - existem ainda alguns a serem explorados. Entendemos como funcionam os containers e componentes, entendemos como adicionar ouvintes aos botões e realizar determinadas tarefas(a parte de realizar algo foi uma dificuldade e que só pode ser superada assistindo vídeos, consultando blogs e até usando o chatgpt) - acredito que o próximo passo é fazer cada componente realizar uma função que você queira, como por exemplo fazer a calculadora funcionar.
