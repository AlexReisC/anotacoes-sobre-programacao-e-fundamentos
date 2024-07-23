# Templete Method
O Template Method é um padrão de projeto comportamental que define o esqueleto de um algoritmo na superclasse mas deixa as subclasses sobrescreverem etapas específicas do algoritmo sem modificar sua estrutura.

Você define o "o que" e a "Ordem do que vai ser executado". A partir daí as classes filhas implementam o "como" de acordo com suas especificidades.

## Exemplo
Se tivermos um processador de dados (ou leitor de arquivos) quel ê informações de pessoas. Mas aí tem 3 possibilidades:
- Arquivo A: cada linha tem os dados separados por ;
- Arquivo B: cada linha tem os dados formatados em XML
- Arquivo C: cada linha tem os dados separados por |

A questão é que nos 3 casos o algoritmo básico é
1. abrir o arquivo
2. ler todas as linhas e colocá-las num vetor de Strings
3. para cada linha, decodifica-la e transformar em objeto do tipo Pessoa
4. fechar o arquivo

O que muda efetivamente em cada caso é o passo 3. Então podemos criar um "template" onde podemos apenas tornar o passo 3 abstrato e, a partir daí, recriar este método bas classes filhas.

## Estrutura
A classe Abstrata define o "esqueleto" do algoritmo, separando cada etapa em métodos específicos. Cada filho pode implementar o método abstrato de acordo com sua necessaidade.
