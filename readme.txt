Modo de utiliza��o:
-Abra o arquivo Servico de Ordenacao.jar
-Abra o arquivo config.properties com o bloco de notas 
-Escolha os crit�rios de ordena��o e salve
-Clique em carregar lista de livros
-Selecione onde se encontra a lista de livros ( h� um modelo de lista na pasta "Modelo de lista de livro")
-Clique em Ordenar
-Selecione onde a Lista ordenada ser� salva.

Sobre o arquivo config.properties:
Ao abrir o Servi�o de Ordena��o .jar pela primeira vez ser� gerado um arquivo config.properties no mesmo diret�rio do programa. Este arquivo dever� ser aberto com o bloco de notas e as configura��es de ordena��o dever�o ser passadas atrav�s deste arquivo.

� necess�rio seguir as seguintes regras para sucesso na ordena��o da lista:

Aten��o: � necess�rio ter o JRE instalado e atualizado no micro.

Se o arquivo Servi�o de Ordena��o.jar estiver abrindo com o winRar ou outro descompactador, clique com o bot�o direito em cima do �cone>abrir com> e selecione o java platform.

-Deve-se separar os atributos autor, titulo e ano por "/" e sem espa�os ex: autor/titulo/ano assim como a ordem ascendente/descendente. 
-O programa s� aceitar� as seguintes palavras reservadas para ordena��o:
titulo - Representa o t�tulo do livro
autor - Representa o autor do livro
ano - Representa o ano de edi��o do livro
ascendente - o parametro ficar� em ordem ascendente
descendente - o par�metro ficar� em ordem descendente
-A ordena��o ou os dados dos livros poder�o estar em letra mai�scula ou min�scula.
-Cada atributo dever� ter sua respectiva ordem. Se houver 2 Atributos dever� haver 2 parametros de ordena��o.
ex: 
atributos = autor/ano
ordem = descendente/ascendente
-Poder� haver no m�nimo um atributo e sua respectiva ordem e no m�ximo 3.
-A lista de livros tamb�m dever� ser divida com "/" entre os Titulo do livro/Autor do livro/Ano de edi��o e cada livro dever� ficar em sua pr�pria linha.
ex:
Java How To Program/Deitel & Deitel/2007
Patterns of Enterprise Application Architecture/Martin Fowler/2002
-O programa s� aceita arquivos com a extrens�o ".txt".