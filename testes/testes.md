# Testes 

## Testes Unitários
Um teste unitário é um teste voltado para uma unidade do sistema, ele visa testar componentes individuais (como classes ou módulos) de forma que cada unidade testada é independente das demais. Um teste não pode ser dependente de outro teste (incluindo estados globais).

Um teste unitário não deve guardar e nem depender de quaisquer propriedades passadas ou setadas por outro teste.

> Todo teste unitário deve criar e destruir seus próprios recursos, sem utilizar os previamente existentes.

Resumindo:
- Self-contained: não pode ser dependente de outros testes ou recursos
- Statelles: não pode saber de execuções prévis do seu próprio escopo ou de escopos externos.
- Unico: cada teste deve testar somente uma unidade do sistema

## Testes de Integração
Testes de integração são como uma extensão dos testes unitários. Eles são como uma sequência de testes unitários encadeadas que compartilham um contexto em comum.

Eles testam como um código interage com outro código. O objetivo é testar como uma funcionalidade se comunica com uma dependencia externa.

## Testes End-to-End (Testes E2E)
Estes testes verificam se a aplicação como um todo funciona da maneira esperada, o foco é na perspectiva do usuário final está vendo.

Podem ser confundidos com testes de integração, onde estes visão testar a interação entre componentes, já testes e2e visam analisar o sistema como um todo.

# Referência
[Testes o que são?](https://medium.com/trainingcenter/testes-o-que-s%C3%A3o-aonde-vivem-4b8dfe12269e)
[Test Automation Pyramid](https://www.browserstack.com/guide/testing-pyramid-for-test-automation)