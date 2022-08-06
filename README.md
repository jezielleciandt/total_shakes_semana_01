# ToTal Shakes

```
Guilherme Castilho Casassanta @gcastilho
Vitor Rangel Carneiro da Silva @vitorrangel
Andreus Daltro de Oliveira Brazil @andreus


Foi solicitado que fosse criado um sistema para uma Loja de Shakes, e você como desenvolvedor 
recebeu a tarefa de implementá-lo. E para isso você deve seguir as seguintes especificações.
```

<h3>Dentro do package de Ingrediente temos a seguinte estrutura</h3>
<ul>
    <li><code>Interface</code> Ingrediente</li>
    <ul>
        <li>Método(s):</li>
        <ul>
            <li>Enum obterTipo();</li>
        </ul>
    </ul>
    <li><code>Interface</code> Adicional</li>
        <ul>
            <li>Extends:</li>
            <ul>
                <li>Ingrediente</li>
            </ul>
        </ul>
    <li><code>Enum</code> TipoBase</li>
    <ul>
        <li>Valores: Iorgurte, Sorvete e Leite.</li>
    </ul>
    <li><code>Enum</code> TipoTopping</li>
    <ul>
        <li>Valores: Aveia, Mel e Chocolate.</li>
    </ul>
    <li><code>Enum</code> TipoFruta</li>
    <ul>
        <li>Valores: Morango, Banana e Abacate.</li>
    </ul>
    <li><code>Class</code> Base</li>
    <ul>
        <li>Implements:</li>
        <ul>
            <li>Ingrediente</li>
            <li>Comparable&lt;Ingrediente&gt;</li>
        </ul>
    </ul>
    <ul>
        <li>Atributo(s):</li>
        <ul>
            <li><code>private</code> TipoBase tipoBase;</li>
        </ul>
        <li>Método(s):</li>
        <ul>
            <li><code>public</code> Base(TipoBase tipoBase)</li>
            <li><code>public</code> TipoBase getTipoBase()</li>
            <li><code>public</code> Enum obterTipo()</li>
            <li><code>public</code> boolean equals(Object o)</li>
            <li><code>public</code> int hashCode()</li>
            <li><code>public</code> int compareTo(Ingrediente ingrediente)</li>
            <li><code>public</code> String toString()</li>
        </ul>
        </ul>
    <li><code>Class</code> Topping</li>
    <ul>
        <li>Implements:</li>
        <ul>
            <li>Adicional</li>
            <li>Comparable&lt;Ingrediente&gt;</li>
        </ul>
    </ul>
    <ul>
        <li>Atributo(s):</li>
        <ul>
            <li><code>private</code> TipoTopping tipoTopping;</li>
        </ul>
        <li>Método(s):</li>
        <ul>
            <li><code>public</code> Topping(TipoTopping tipoTopping)</li>
            <li><code>public</code> TipoTopping getTipoTopping()</li>
            <li><code>public</code> Enum obterTipo()</li>
            <li><code>public</code> boolean equals(Object o)</li>
            <li><code>public</code> int hashCode()</li>
            <li><code>public</code> int compareTo(Ingrediente ingrediente)</li>
            <li><code>public</code> String toString()</li>
        </ul>
    </ul>
    <li><code>Class</code> Fruta</li>
    <ul>
        <li>Implements:</li>
        <ul>
            <li>Adicional</li>
            <li>Comparable&lt;Ingrediente&gt;</li>
        </ul>
    </ul>
    <ul>
        <li>Atributo(s):</li>
        <ul>
            <li><code>private</code> TipoFruta tipoFruta;</li>
        </ul>
        <li>Método(s):</li>
        <ul>
            <li><code>public</code> Fruta(TipoFruta tipoFruta)</li>
            <li><code>public</code> TipoFruta getTipoFruta()</li>
            <li><code>public</code> Enum obterTipo()</li>
            <li><code>public</code> boolean equals(Object o)</li>
            <li><code>public</code> int hashCode()</li>
            <li><code>public</code> int compareTo(Ingrediente ingrediente)</li>
            <li><code>public</code> String toString()</li>
        </ul>
    </ul>
</ul>

<h3>Dentro do package de Produto temos a seguinte estrutura</h3>
<ul>
    <li><code>Enum</code> TipoTamanho</li>
    <ul>
        <li>Valores: P, M, e G</li>
    </ul>
    <li><code>Class</code> Shake</li>
    <ul>
        <li>Atributo(s):</li>
    <ul>
        <li><code>private</code> Base base</li>
        <li><code>private</code> Fruta fruta</li>
        <li><code>private</code> Topping topping</li>
        <li><code>private</code> List&lt;Adicional&gt; adicionais</li>
        <li><code>private</code> TipoTamanho tipoTamanho</li>
    </ul>
    <li>Método(s):</li>
    <ul>
         <li><code>public</code> Shake(Base base, Fruta fruta, Topping topping, List&lt;Adicional&gt; adicionais, TipoTamanho tipoTamanho)</li>
         <li><code>public</code> Shake(Base base, Fruta fruta, Topping topping, TipoTamanho tipoTamanho)</li>
         <li><code>public</code> Base getBase()</li>
         <li><code>public</code> Fruta getFruta()</li>
         <li><code>public</code> Topping getTopping()</li>
         <li><code>public</code> List&lt;Adicional&gt; getAdicionais()</li>
         <li><code>public</code> TipoTamanho getTipoTamanho()</li>
         <li><code>public</code> String toString()</li>
   </ul>
   </ul>
   </ul>

<h3>Dentro do package de Pedido temos a seguinte estrutura</h3>
<ul>
    <li><code>Class</code> Cardapio</li>
        <ul>
           <li>Atributo(s):</li>
        <ul>
            <li><code>private</code> TreeMap&lt;Ingrediente,Double&gt; precos</li>
    </ul>
    <li>Método(s):</li>
    <ul>
         <li><code>public</code> Cardapio()</li>
         <li><code>public</code> void adicionarIngrediente(Ingrediente ingrediente, Double preco)</li>
         <li><code>public</code> boolean atualizarIngrediente(Ingrediente ingrediente, Double preco)</li>
         <li><code>public</code> boolean removerIngrediente(Ingrediente ingrediente)</li>
         <li><code>public</code> Double buscarPreco(Ingrediente ingrediente)</li>
         <li><code>public</code> String toString()</li>
   </ul>
   </ul>
    <li><code>Class</code> Cliente</li>
         <ul>
           <li>Atributo(s):</li>
         <ul>
            <li><code>private</code> int id</li>
            <li><code>private</code> String nome</li>
            <li><code>private</code> String email</li>
         </ul>
         <li>Método(s):</li>
         <ul>
            <li><code>public</code> Cliente(int id, String nome, String email)</li>
            <li><code>public</code> void serializarCliente()</li>
            <li><code>public static</code> Cliente desserializarCliente(int id)</li>
            <li><code>public</code> boolean equals(Object o)</li>
            <li><code>public</code> int hashCode()</li>
            <li><code>public</code> String toString()</li>
         </ul>
         </ul>
    <li><code>Class</code> ItemPedido</li>
          <ul>
           <li>Atributo(s):</li>
          <ul>
            <li><code>private</code> Shake shake</li>
            <li><code>private</code> int quantidade</li>
         </ul>
         <li>Método(s):</li>
         <ul>
            <li><code>public</code> ItemPedido(Shake shake, int quantidade)</li>
            <li><code>public</code> Shake getShake()</li>
            <li><code>public</code> int getQuantidade()</li>
            <li><code>public</code> setQuantidade(int quantidade)</li>
            <li><code>public</code> String toString()</li>
         </ul>
         </ul>
    <li><code>Class</code> Pedido</li>
       <ul>
           <li>Atributo(s):</li>
          <ul>
            <li><code>private</code> int id</li>
            <li><code>private</code> ArrayList&lt;ItemPedido&gt; itens</li>
            <li><code>private</code> Cliente cliente</li>
         </ul>
         <li>Método(s):</li>
         <ul>
            <li><code>public</code> Pedido(int id, ArrayList&lt;ItemPedido&gt; itens,Cliente cliente)</li>
            <li><code>public</code> ArrayList&lt;ItemPedido&gt; getItens()</li>
            <li><code>public</code> int getId()</li>
            <li><code>public</code> Cliente getCliente()</li>
            <li><code>public</code> double calcularTotal(Cardapio cardapio)</li>
            <li><code>public</code> adicionarItemPedido(ItemPedido itemPedidoAdicionado)</li>
            <li><code>public</code> boolean removeItemPedido(ItemPedido itemPedidoRemovido)</li>
            <li><code>public</code> String toString()</li>
         </ul>
       </ul>
</ul>

<h3>Dentro do package de Demo temos a seguinte estrutura</h3>
<ul>
    <li><code>Class</code> Program</li>
    <ul>
        <li>Método(s):</li>
        <ul>
            <li><code>public static void</code>main (String[] args)</li>
            <li>Utilize o método main para testar a sua aplicação e verificar se está tendo a saída esperada</li>
        </ul>
    </ul>
</ul>

```
::::: Cardapio ShakeCIT
{Aveia=3.0, Banana=5.0, Iorgute=8.0, Mel=1.0, Morango=7.5, Sorvete=10.0}
::::: Criando um Shake Básico 1:1:1:0
[Sorvete / Banana / Mel / [] / P / x1] - 1 - Pedro - pedro@email.com
10.0
::::: Criando um Shake Básico 1:1:1:1
[Sorvete / Banana / Mel / [Aveia] / G / x1] - 1 - Pedro - pedro@email.com
18.0
::::: Adicionando um Shake igual no mesmo pedido
[Sorvete / Banana / Mel / [Aveia] / G / x2] - 1 - Pedro - pedro@email.com
36.0
::::: Adicionando um Shake diferente no mesmo pedido
[Sorvete / Banana / Mel / [Aveia] / G / x2, Sorvete / Banana / Mel / [] / P / x1] - 1 - Pedro - pedro@email.com
46.0
::::: Removendo um itemPedido de um pedido
[Sorvete / Banana / Mel / [Aveia] / G / x2, Sorvete / Banana / Mel / [] / P / x1] - 1 - Pedro - pedro@email.com
[Sorvete / Banana / Mel / [Aveia] / G / x1, Sorvete / Banana / Mel / [] / P / x1] - 1 - Pedro - pedro@email.com
[Sorvete / Banana / Mel / [] / P / x1] - 1 - Pedro - pedro@email.com
[] - 1 - Pedro - pedro@email.com
::::: Item pedido com dois adicionais
[Iorgute / Morango / Mel / [Banana, Morango] / P / x1] - 1 - Pedro - pedro@email.com
20.5
[Iorgute / Morango / Mel / [Banana, Morango] / P / x3] - 1 - Pedro - pedro@email.com
61.5
::::: Serializando Cliente 1 e Desserializando Cliente 1
1 - Pedro - pedro@email.com
true

Process finished with exit code 0

```

<h3>Regras de negócio</h3>
<ul>
    <li><code>Shake</code>:</li>
    <ul>
        <li>Regra 1: um <code>Shake</code> é composto obrigatoriamente de uma <code>Base</code>, uma <code>Fruta</code>, um <code>Topping</code>, um <code>TipoTamanho</code> e opcionalmente por uma <code>List&lt;Adicional&gt;</code></li>
    </ul>
    <li><code>Pedido</code>:</li>
    <ul>
        <li>Regra 1: Quando adicionar um novo <code>ItemPedido</code> em um <code>Pedido</code> que já contenha um outro <code>ItemPedido</code> com o mesmo <code>Shake</code> nos dois <code>ItemPedido</code>, então o <code>Pedido</code> deve conter apenas um <code>ItemPedido</code> daquele <code>Shake</code>, porém com a <code>quantidade</code> atualizada do <code>Shake</code></li>
        <li>Regra 2: O preço de um <code>Shake</code> é calculado com o valor da <code>Base</code> de acordo com o <code>TipoTamanho</code>, somado com o custo dos <code>adicionais</code></li>
        <ul>
            <li><code>P</code>: preco da <code>Base</code> original no <code>Cardapio</code></li>
            <li><code>M</code>: preco da <code>Base</code> acrescentado de 30%</li>
            <li><code>G</code>: preco da <code>Base</code> acrescentado de 50%</li>         
        </ul>   
        <li>Regra 3: O custo de um <code>Pedido</code> é o somatório do custo de todos os <code>Shake</code> presentes nos <code>ItemPedido</code> desse <code>Pedido</code> (dica: <code>ItemPedido</code> possui um atributo <code>quantidade</code>)</li>
        <li>Regra 4: A função <code>boolean removeItemPedido(ItemPedido itemPedidoRemovido)</code> deve lançar uma exceção do tipo <code>IllegalArgumentException</code> com a mensagem <code>Item nao existe no pedido.</code> caso o <code>ItemPedido</code> a ser removido não exista no <code>Pedido</code></li>
        <li>Regra 5: A função <code>boolean removeItemPedido(ItemPedido itemPedidoRemovido)</code> irá sempre reduzir apenas UMA unidade do <code>ItemPedido</code>, independente da <code>quantidade</code> que foi informada no parâmetro da função.</li>
    </ul>
    <li><code>Cardapio</code>:</li>
    <ul>
        <li>Regra 1: O preco de um <code>Ingrediente</code> deve ser <code>maior que zero</code>, caso contrário irá disparar uma exceção do tipo <code>IllegalArgumentException</code> com a mensagem <code>Preco invalido.</code></li>
        <li>Regra 2: Os métodos <code>boolean atualizarIngrediente(Ingrediente ingrediente,Double preco)</code>, <code>boolean removerIngrediente(Ingrediente ingrediente)</code> e <code>Double buscarPreco(Ingrediente ingrediente)</code> devem disparar uma exceção do tipo <code>IllegalArgumentException</code> com a mensagem <code>Ingrediente nao existe no cardapio.</code> caso o <code>Ingrediente</code> passado como parâmetro não exista no cardápio.</li>
        <li>Regra 3: Os itens do <code>Cardapio</code> devem estar sempre ordenados em ordem alfabética do nome do <code>Ingrediente</code>.</li>
    </ul>
</ul>

<h3>Desafio</h3>

```
O seu objetivo é fazer o código funcionar. 
Para isso complete os métodos que estão sem implementação
E faça as correções necessárias nos outros arquivos
Sempre consultando a estrutura e as regras de negócio que foram passadas aqui e verificando
a saída do Program esperada.
```

