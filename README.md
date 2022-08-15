# Semana 2 - Desafio TDD

```
Arnald da Costa Queiroga @arnald
André Luiz Vieira Mostaro @amostaro
Elvis William De Oliveira Barbieri @ebarbieri
Eric de Sousa Andrade @ericsousa
Jezielle de Fátima Farias da Cunha @jezielle
Rebeca Baptista Fonseca Viana @rebecav

Após cumprir o desafio do sistema para uma Loja de Shakes, foi solicidado 
a criação de um armazem, para um maior controle dos ingredientes.

Para isso, você como desenvolvedor precisará desenvolver uma classe Armazem 
usando o TDD (Test-driven development) seguindo as seguintes especificações.
```
<h3>Primeiro passo para a continuação do desafio</h3>
No mesmo projeto que foi desenvolvido na semana 1, você irá criar uma nova branch (<code>git checkout -b “feature/week-2”</code>) e desenvolver a solução nela. Após finalizar o desafio, abrir um Pull Request no GitHub (para a main do seu projeto) para que então o grupo possa fazer o Code Review.
<br>

<h3>Criar uma classe Armazém que irá armazenar os Ingredientes e a quantidade de Ingrediente</h3>
<ul>
    <li>A classe deve ter um atributo private TreeMap&lt;Ingrediente, Integer&gt; chamado estoque.</li>
    <li>Criar um package chamado armazem e criar a classe Armazem dentro deste package.</li>
</ul>

<h3>Criar um TDD para os seguintes métodos dessa classe:</h3>
<ul>
    <li>Método(s):</li>
    <br>
    <ul>
        <li><code>public void cadastrarIngredienteEmEstoque(Ingrediente ingrediente)</code></li>
        <ul>
            <li>Reponsabilidade: Cadastrar no estoque um novo ingrediente. </li>
<li> Regra: A quantidade deve ser setada como zero sempre que for cadastrar um novo ingrediente. </li>
<li> Exception: Caso o ingrediente já esteja cadastrado deve retornar IllegalArgumentException com a seguinte mensagem de erro: “Ingrediente já cadastrado”.</li>
        </ul>
    </ul>
    <ul><br>
        <li><code>public void descadastrarIngredienteEmEstoque(Ingrediente ingrediente)</code></li>
        <ul>
            <li>Responsabilidade: Descadastra o ingrediente do estoque.</li>
<li> Regra: O ingrediente deve ser excluido do estoque. </li>
<li> Exception: Caso o ingrediente não exista no estoque deve retornar IllegalArgumentException com a seguinte mensagem de erro: “Ingrediente não encontrado”.</li>
        </ul>
    </ul>
    <ul><br>
        <li><code>public void adicionarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade) </code></li>
        <ul>
            <li>Reponsabilidade: Adicionar uma determinada quantidade de um ingrediente específico no estoque.</li>
<li> Regra: Deve ser somado a quantidade solicitada do ingrediente a quantidade que estava no estoque; a quantidade tem que ser maior que zero e o ingrediente que vai receber a quantidade deve existir no estoque.</li>
<li> Exception: Caso o ingrediente não exista no estoque deve retornar IllegalArgumentException com a seguinte mensagem de erro: “Ingrediente não encontrado” e caso a quantidade que foi passada para ser somada for menor ou igual a zero deve retornar IllegalArgumentException com a seguinte mensagem de erro: “Quantidade invalida” </li>
        </ul>
    </ul>
    <ul><br>
        <li><code>public void reduzirQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente, Integer quantidade)</code></li>
        <ul>
            <li>Reponsabilidade:Reduzir a quantidade de um determinado ingrediente no estoque. </li>
            <li> Regra: Deve ser subtraído a quantidade solicitada do ingrediente a quantidade que estava no estoque. Caso a quantidade a ser removida seja a mesma da quantidade em estoque, o ingrediente deve ser excluído do estoque.</li>
            <li> Exception: Caso o ingrediente não exista no estoque deve retornar IllegalArgumentException com a seguinte mensagem de erro: “Ingrediente não encontrado” e caso a quantidade que foi passada para ser excluida for menor ou igual a zero e a quantidade em estoque seja insuficiente para ser removida retornar um IllegalArgumentException com a seguinte mensagem de erro: “Quantidade invalida”.</li>
         </ul>
	</ul>
    <ul><br>
        <li><code>public Integer consultarQuantidadeDoIngredienteEmEstoque(Ingrediente ingrediente)</code></li>
        <ul>
            <li>Reponsabilidade: Busca a quantidade de um determinado ingrediente no estoque. </li>
<li> Exception: Caso o ingrediente não exista no estoque deve retornar IllegalArgumentException com a seguinte mensagem de erro: “Ingrediente não encontrado”. </li>
        </ul>
    </ul>
</ul>

<h3>Atenção</h3>
O objetivo deste desafio é que você escreva primeiro os testes e depois desenvolva a classe (caso tiver dificuldade, escrever os cenários de testes pode ajudar no desenvolvimento).

<h3>Desafio Extra</h3>
Refatoração dos testes e do projeto. Tem alguns fatores que podem ser melhorados nos testes e no projeto. Desta forma, você como desenvolvedor deve ter um olhar crítico e levar em consideração as boas práticas de Clean Code e refatorar o projeto. Segue alguns exemplos a serem refatorados: 
<ul>
	<li>Classes de teste: Nomenclatura dos testes, utilização da anotação <code>@DisplayName</code>, substituição dos try/catch por <code>assertThrows</code> e entre outros. </li>
<li>Classe main: Nome do enum em maiúsculo, criação de Exceções específicas (IngredienteNotFoundException, por exemplo), utilização do modificador <code>final</code> e entre outros. </li>
</ul>
Além disso, implementar testes parametrizados nas classes de teste.


<h3>Links de apoio</h3>

 <ul>
	<li>Clean Code in Java: https://www.baeldung.com/java-clean-code </li>
            <li>JUnit 5 Expected Exception: https://howtodoinjava.com/junit5/expected-exception-example/
</li>
<li>TDD Best Practices: 
<ul>
<li>https://xperti.io/blogs/test-driven-development-java/</li>
<li>https://technologyconversations.com/2013/12/24/test-driven-development-tdd-best-practices-using-java-examples-2/</li>
</ul>
</li>
<li>Best Practices For Unit Testing: https://www.baeldung.com/java-unit-testing-best-practices/</li>

</ul>
