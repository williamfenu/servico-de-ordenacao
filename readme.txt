Modo de utilização:
-Abra o arquivo Servico de Ordenacao.jar
-Abra o arquivo config.properties com o bloco de notas 
-Escolha os critérios de ordenação e salve
-Clique em carregar lista de livros
-Selecione onde se encontra a lista de livros ( há um modelo de lista na pasta "Modelo de lista de livro")
-Clique em Ordenar
-Selecione onde a Lista ordenada será salva.

Sobre o arquivo config.properties:
Ao abrir o Serviço de Ordenação .jar pela primeira vez será gerado um arquivo config.properties no mesmo diretório do programa. Este arquivo deverá ser aberto com o bloco de notas e as configurações de ordenação deverão ser passadas através deste arquivo.

É necessário seguir as seguintes regras para sucesso na ordenação da lista:

Atenção: É necessário ter o JRE instalado e atualizado no micro.

Se o arquivo Serviço de Ordenação.jar estiver abrindo com o winRar ou outro descompactador, clique com o botão direito em cima do ícone>abrir com> e selecione o java platform.

-Deve-se separar os atributos autor, titulo e ano por "/" e sem espaços ex: autor/titulo/ano assim como a ordem ascendente/descendente. 
-O programa só aceitará as seguintes palavras reservadas para ordenação:
titulo - Representa o título do livro
autor - Representa o autor do livro
ano - Representa o ano de edição do livro
ascendente - o parametro ficará em ordem ascendente
descendente - o parâmetro ficará em ordem descendente
-A ordenação ou os dados dos livros poderão estar em letra maiúscula ou minúscula.
-Cada atributo deverá ter sua respectiva ordem. Se houver 2 Atributos deverá haver 2 parametros de ordenação.
ex: 
atributos = autor/ano
ordem = descendente/ascendente
-Poderá haver no mínimo um atributo e sua respectiva ordem e no máximo 3.
-A lista de livros também deverá ser divida com "/" entre os Titulo do livro/Autor do livro/Ano de edição e cada livro deverá ficar em sua própria linha.
ex:
Java How To Program/Deitel & Deitel/2007
Patterns of Enterprise Application Architecture/Martin Fowler/2002
-O programa só aceita arquivos com a extrensão ".txt".