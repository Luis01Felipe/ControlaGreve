# Documentação

# Preparando o ambiente de desenvolvimento

1. Certifique-se de possuir o Java Development Kit (JDK) na versão 20 em diante, caso não possua, pode baixa-lo através deste link https://download.oracle.com/java/22/latest/jdk-22_windows-x64_bin.exe
    1. Após baixar o JDK, navegue até o diretório (Pasta) onde o mesmo foi baixado e clique duas vezes para abrir, por fim, siga o tutorial de instalação
2. Baixe o arquivo compilado (.zip) através do anexo presente no e-mail ou através do link https://github.com/Luis01Felipe/Prova-de-Selecao
    1. Caso esteja baixando através do link, clique em **<> Code** e em seguida **Download .zip**
3. Após baixar o arquivo compilado, navegue até o diretório (Pasta) onde o mesmo foi baixado e clique com o botão direito do mouse → Extrair → Extrair Arquivos
4. Após a extração dos arquivos, abra a pasta descompactada e navegue até `Prova-de-Selecao-newMaster\Prova-de-Selecao-newMaster`
5. Clique duas vezes no arquivo `Prova-de-Selecao.jar - Atalho` , caso alguma pasta abra, aperte o botão de voltar do mouse e então clique no arquivo com o botão direito → Abrir com → Selecione: **JAVA (TM) Plataform SE Binary** ou **OpenJDK Plataform Binary,** alguns gerenciadores de arquivos como o **Files** acabam por abrir arquivos compilados como se fossem pastas, mesmo que sejam do tipo executável como os .jar
6. Abra o navegador e digite na guia de pesquisa: [http://localhost:8080/greve](http://localhost:8080/greve)
    1. Caso o corpo (Body) da página esteja similar a imagem abaixo, então tudo está funcionando.

       ![image.png](Documentac%CC%A7a%CC%83o%2066255815701c4e74beabad29815902e6/bf4f6500-e54b-4c64-8810-41e4c7a906c9.png)

    2. Caso o corpo (Body) da página esteja similar a imagem abaixo, então volte a etapa 5.

       ![image.png](Documentac%CC%A7a%CC%83o%2066255815701c4e74beabad29815902e6/image.png)

7. Baixe o programa Insomnia através do site: https://insomnia.rest/download e siga todo o tutorial de instalação
8. Ao entrar no Insomnia, clique em **+ Create → Request Collection**

   ![image.png](Documentac%CC%A7a%CC%83o%2066255815701c4e74beabad29815902e6/image%201.png)

9. De um nome a coleção e então clique em Create

   ![image.png](Documentac%CC%A7a%CC%83o%2066255815701c4e74beabad29815902e6/image%202.png)

10. Após criar sua coleção, clique em **+ → HTTP Request**, ou utilize o atalho **CTRL + N**

    ![image.png](Documentac%CC%A7a%CC%83o%2066255815701c4e74beabad29815902e6/image%203.png)

11. Na barra de pesquisa digite o endereço [http://localhost:8080/greve](http://localhost:8080/greve), após isso, teremos um comando HTTP `GET` que ira buscar dados no nosso localhost

    ![image.png](Documentac%CC%A7a%CC%83o%2066255815701c4e74beabad29815902e6/image%204.png)

12. Agora iremos criar novas requisições de comando, basta seguir os passos 10 e 11 novamente, porém, após criarmos a requisição, ela estará como GET, portanto, devemos muda-la para POST, ao clicar em `GET` → `POST`

    ![image.png](Documentac%CC%A7a%CC%83o%2066255815701c4e74beabad29815902e6/image%205.png)

13. Após criarmos nossa requisição `POST` , devemos clicar em `Body`

    ![image.png](Documentac%CC%A7a%CC%83o%2066255815701c4e74beabad29815902e6/image%206.png)

14. Em **Body** clicaremos em **No Body → JSON**

    ![image.png](Documentac%CC%A7a%CC%83o%2066255815701c4e74beabad29815902e6/image%207.png)

15. Por fim, devemos criar as requisições de `PUT` e `DELETE` seguindo os mesmo passos, para o `PUT` seguiremos os passos 10 a 15, para o `DELETE` seguiremos os passos 10 a 12

    ![image.png](Documentac%CC%A7a%CC%83o%2066255815701c4e74beabad29815902e6/image%208.png)

16. Para melhorar a organização de nossa coleção, podemos renomear as requisições ao passar o mouse por cima delas e então clicar no **icone dropdown (seta pra baixo) → Rename**

    ![image.png](Documentac%CC%A7a%CC%83o%2066255815701c4e74beabad29815902e6/image%209.png)

    1. Exemplo de como ficou:

       ![image.png](Documentac%CC%A7a%CC%83o%2066255815701c4e74beabad29815902e6/image%2010.png)


# Utilizando o programa

1. Certifique-se de ter executado o arquivo `Prova-de-Selecao.jar - Atalho` , caso não, por favor volte ao passo 5 do tópico anterior
2. Vamos testar se tudo está funcionando, dentro do **Insomnia**, clique na requisição `GET` criada no passo 11 do tópico anterior e clique em Send

   ![image.png](Documentac%CC%A7a%CC%83o%2066255815701c4e74beabad29815902e6/image%2011.png)

    1. Como não adicionamos nenhum conteúdo através do `POST`, é normal que não apareça nada ou alguma mensagem como: `No body returned for responses`. Porem, caso o código de resposta seja algo como `Error: Couldn't connect to server` , isto indica que há um problema com a execução do servidor, portanto, é necessário retornar ao passo 5 do tópico anterior
        1. Imagem de referência

       ![image.png](Documentac%CC%A7a%CC%83o%2066255815701c4e74beabad29815902e6/image%2012.png)

3. Agora iremos adicionar dados ao nosso banco de dados, para isso clique na requisição `POST` que foi criada entre os passos 10 e 15 do tópico anterior, vá para a guia **Body**, clique em **JSON** e então adicione os dados seguindo a formatação abaixo, por fim, clique em **Send**
    1. **ATENÇÃO**: Não é necessário especificar o `id` pois o programa utiliza o Auto Incremento, ou seja, ele alocara um valor de `id` automaticamente com base na quantidade de registros na base de dados.

    ```
    {
    "dataInicio": "yyyy-mm-dd",
    "dataFim": "yyyy-mm-dd",
    "motivo": " ",
    "categoriaTrabalhadores": " ",
    "sindicatoResponsavel": " ",
    "numeroTrabalhadores": 0,
    "local": " "
    }
    ```

    1. Exemplo:

        ```
        {
        	"dataInicio": "2024-08-28",
        	"dataFim": "2024-08-30",
        	"motivo": "Salário baixo",
        	"categoriaTrabalhadores": "Professores",
        	"sindicatoResponsavel": "SinproSP",
        	"numeroTrabalhadores": 100,
        	"local": "SP"
        }
        ```

    2. Imagem de referencia

       ![image.png](Documentac%CC%A7a%CC%83o%2066255815701c4e74beabad29815902e6/image%2013.png)

4. Após enviarmos dados ao nosso banco de dados, podemos modifica-los utilizando a requisição **`PUT`** , para isso clique na requisição `PUT` caso não a tenha criado, volte aos passos 10 a 15 do tópico anterior, vá para a guia **Body**, clique em **JSON** e então adicione os dados seguindo a mesma formatação que a requisição `POST`, o `PUT` , diferentemente do `GET` e `POST` , exige que seja especificado um id, para isso, basta adicionar um `/{valorDoID}` na barra de endereço, como por exemplo: [http://localhost:8080/greve/1](http://localhost:8080/greve/1), por fim, clique em **Send**
    1. Imagem de referência

       No exemplo da imagem abaixo, alteremos o número de trabalhadores de 100 para 1000 nos dados presentes no `id = 1`

       ![image.png](Documentac%CC%A7a%CC%83o%2066255815701c4e74beabad29815902e6/image%2014.png)

5. Agora que adicionamos e atualizamos os dados presentes no nosso banco de dados, vamos checa-los novamente utilizando a requisição `GET` que aprendemos a usar no passo 2 deste tópico, porém, dessa vez utilizaremos o `GET` com o parâmetro de id, similarmente ao que fizemos com o `PUT`,  para isso, clique na requisição `GET` e então adicione um `/{valorDoID}` na barra de endereço, como por exemplo:  [http://localhost:8080/greve/1](http://localhost:8080/greve/1), por fim, clique em **Send.**
    1. O `GET` permite fazer tanto busca com algum `id` especifico como fazemos neste passo, quanto sem `id` específico, como foi feito no passo 2 deste tópico, a diferença entre os dois usos é que o com `id` retorna apenas o que foi especificado, enquanto que o outro, retorna todos os dados.
    2. Imagem de referência

       ![image.png](Documentac%CC%A7a%CC%83o%2066255815701c4e74beabad29815902e6/image%2015.png)

6. Após termos adicionado, atualizado e lido os dados, falta apenas deletarmos, para isto, basta fazer o mesmo que estivemos fazendo até então, clique na requisição `DELETE` criada entre os passos 10 e 15 do tópico anterior e então adicione um `/{valorDoID}` na barra de endereços, como por exemplo:  [http://localhost:8080/greve/1](http://localhost:8080/greve/1), por fim, clique em **Send**.
    1. Por questões de segurança e proteção, o `DELETE`, diferentemente do `GET`, não permite deletar todos os dados do banco de dados e só funcionará caso um `id` seja especificado.
    2. Imagem de referência

       ![image.png](Documentac%CC%A7a%CC%83o%2066255815701c4e74beabad29815902e6/image%2016.png)

7. Após termos concluído de manipular o banco de dados, podemos encerrar a conexão, para isso, aperte o conjunto de teclas: `CTRL + SHIFT + ESC` ou aperte a tecla `Windows` e digite: **Gerenciador de Tarefas**, na guia de pesquisa digite: **java**, após isto, clique com o botão direito em **Java (TM) Plataform SE binary** ou **OpenJDK Plataform Binary** e clique em **Finalizar tarefa**
    1. O que definira se é **Java (TM) Plataform SE binary** ou **OpenJDK Plataform Binary** é por meio de qual dos dois o arquivo .jar foi inicializado no passo 5 do tópico anterior
    2. Imagem de referencia

       ![image.png](Documentac%CC%A7a%CC%83o%2066255815701c4e74beabad29815902e6/image%2017.png)