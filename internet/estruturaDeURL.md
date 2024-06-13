# Estrutura de URL

URL exemplo:
```
https://blog.alex.com.br:3000/index.html?value1=internet&value2=url#anywhere
```

## Protocolo
```
https://
```
Sinaliza o tipo comunicação que será feito através do endereço digitado.

## Sub-dominio
```
blog
```
Parte adicional do dominio, por exemplo: www

## Dominio
```
alex.com.br
```
Identifica o endereço. É o nome da URL.

## Porta
```
3000
```
A Porta é um número *TCP* associado ao protocolo da URL (http tem 80 como porta padrão), é usado para identificar um serviço especifico. Normalmente não fica explicíta na URL.

## Path (caminho)
```
index.html
```
Indica a localização de um recurso em um servidor web. É basicamente a página que você está acessando naquele dominio.

## Query
```
?value1=internet&value2=url
```
É o conjunto de um mais pares "parametro-argumento". As query strings são enviadas ao servidor para filtrar ou criar um recurso. Inicia-se após `?`. 

### Parametros
```
value1=internet&value2=url
```
São basicamente variavéis na URL. `nomeDaVariavel = valor` & (separar parametros) `nomeDaVariavel2 = valor2`.

## Fragmento
São usados para identificar seções especificas dentro de uma página web. Quando você visita uma URL com um fragmento, o navegador geralmente rola a página automaticamente para exibir a seção identificada pelo fragmento.

## Referência
- [Estrutura de uma URL](https://dev.to/dnovais/estrutura-de-uma-url-357e)
- [Estrutura de URL](https://x.com/Luciano655dev/status/1760448499840155719)