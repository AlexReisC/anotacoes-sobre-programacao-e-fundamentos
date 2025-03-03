# HTTP

## O que significa HTTP?
A sigla vem de HyperText Transfer Protocol, em português, Protocolo de Transferência de Hipertexto.

O termo "hipertexto" descreve um sistema de organização de informações em que documentos tem conexões clicáveis, permitindo aos usuários saltar de uma parte do texto para outra.

Dessa forma, HTTP é um protocolo, uma forma de conversa entre duas máquinas, que permite transferir um hipertexto de um lado a outro.

## O que é HTTP?
HTTP é um protocolo de comunicação utilizado para a transferência de informações na World Wide Web (WWW) e em outros sistemas de rede. O HTTP permite a requisição e a resposta de recursos, como imagens, arquivos e paginas web, entre cliente e servidor.

## Como funciona
1. o cliente estabelece contato com o servidor, encaminhando uma requisição HTTP;
2. Nessa solicitação, o cliente especifica o método pretendido (por exemplo, GET para obter informações) e o caminho do recurso desejado;
3. Ao receber essa requisição, o servidor a processa e responde com uma mensagem HTTP, incluindo o recurso requisitado e informações adicionais no cabeçalho da resposta.

Toda essa interação acontece por meio do protocolo TCP, que garante uma comunicação confiável e orientada à conexão. 

Cada requisição do cliente é tratada de forma independente, isto é, não é necessário informações das requisições anteriores. Sem a necessidade de gerir o estado entre requisições, o protocolo mantém uma certa simplicidade, promovendo também escalabilidade.

### Cliente
O termo "cliente" refere-se ao dispositivo ou software que age em nome do usuário para interagir com os recursos na web. Isso inclui navegadores web, aplicativos móveis, scripts automatizados ou qualquer outra entidade que envia solicitações HTTP para acessar informações ou serviços em servidores web.

### Servidor
É o dispositivo que hospeda e fornece recursos solicitados pelo cliente, ele pode ser apenas uma máquina ou várias operando juntas. O servidor processa as requisições, executa a lógica e retorna as respostas adequadas.

A introdução do cabeçalho Host no HTTP 1.1 foi crucial para permitir que vários servidores compartilhassem o mesmo endereço IP, facilitando a hospedagem de múltiplos sites em um único servidor.

### Proxie
Os proxies atuam como intermediários entre clientes e servidores, facilitando o fluxo de tráfego de dados entre eles.

Podemos citar dois tipos existentes de proxie, o *forward proxie* que atua pelo cliente para busca recursos no servidor, e o *reverse proxie* que atua em nome do servidor para receber solicitações dos clientes.

Além de otimizar o trafégo e eficiência da rede, proxies podem:
- implementar mecanismos de cache para armazenar localmente recursos frequentemente solicitados
- permitem anonimato na web
- filtrar conteúdo malicioso e dar controle de acesso
- podem realizar balanceamento de carga entre servidores
- acelerar o carregamento de páginas por meio da compressão de dados

## Aspectos fundamentais do HTTP na comunicação entre clientes e servidores web
- **Métodos HTTP**: O HTTP utiliza métodos como GET, POST, PUT e DELETE, para indicar uma ação desejada. Esses métodos definem operações comuns como obter dados, enviar dados, atualizar ou excluir.
- **Headers (Cabeçalhos)**: Os cabeçalhos HTTP contém informações adicionais sobre a requisição ou resposta, tais como o tipo de conteúdo, a data de requisição, cookies etc.
- **URI (Uniform Resource Identifier)**: Os recursos na web são indentificados por URLs (Unirform Resource Locale) ou URIs. Uma URI é uma sequência de caracteres que identifica um nome ou um recurso na web.
- **Cache**: 
- **Tipo de hipermídia**: O tipo de hipermídia comum no HTTP é o HTML, mas ele suporta também uma variedade de típos de midia como XML, JSON, videos e imagens.

## Fluxo HTTP
1. Uma pessoa acessa um site, estabelecendo uma conexão.
2. Se a URL pertencer a um domínio próprio, o navegador inicia conectando-se a um servidor e recuperando o endereço IP correspondente ao servidor associado ao domínio.
3. O navegador envia uma solicitação HTTP para a página desejada.
4. O servidor recebe essa solicitação, busca a página e ao encontrar envia de volta ao navegador. Caso não encontre, o servidor responde com um erro HTTP 404 (Você pode já ter visto esse número por ai! Agora você sabe o que ocorreu por baixo dos panos)
5. O navegador recebe a página enviada pelo servidor, e em seguida, encerra a conexão estabelecida.
6. Agora o navegador irá analisar o conteúdo e buscar todos elementos necessários para completar a exibição. Se existir necessidade de elementos complementares, o navegador realizará conexões adicionais e envia mais solicitações de protocolo ao servidor.
7. E por último, a página é finalmente carregada por completo no navegador, que é quando conseguir visualizar e acessar os sites!

## O processo Request-Response
Uma mensagem de requisição é enviada de um cliente para um servidor para solicitar algum recurso.

### Linha de Solicitação (Request Line)
Na linha de solicitação, presente em uma solicitação HTTP, são especificados três elementos principais: o método HTTP, a URI e a versão do protocolo HTTP.

Exemplo: `GET /exemplo/recurso HTTP/1.1`

Neste exemplo "GET" é o método, "/exemplo/recurso" é a URI e "HTTP/1.1"

### Linha de status (Status Line)
São fornecidos três elementos principais: a versão do protocolo HTTP, um código de status e uma mensagem de status.

Exemplo: `HTTP/1.1 200 OK`
Neste exemplo "HTTP/1.1" é a versão do protocolo, "200" é o código de status e "OK" a mensagem associada.

A linha de solicitação informa ao servidor qual ação o cliente deseja realizar, enquanto a linha de status na resposta indica o resultado da solicitação, seja ele um sucesso, um redirecionamento ou um erro específico.

## Métodos

### GET
O método GET é usado para solicitar dados de um recurso específico. É possível utilizar para recuperar informações, como as páginas web, através de um servidor. 

Headers também podem ser incluídos na solicitação GET, e são frequentemente utilizados para fornecer informações adicionais ao servidor, como informações de autenticação ou preferências de conteúdo.

### HEAD
É usado para obter informações sobre um recurso, mas apenas os cabeçalhos da resposta, sem o corpo. É útil para obter metadados sem carregar o conteúdo completo do recurso.

### POST
O método POST é utilizado para enviar dados ao servidor para processamento.

### PUT
O método PUT é usado para enviar dados ao servidor para criar ou atualizar um recurso específico na localização especificada pelo URI. Ele substitui completamente o recurso existente.

### DELETE
É utilizado para solicitar a remoção de um recurso específico no servidor. Após uma solicitação DELETE bem-sucedida, o recurso deve ser removido ou tornar-se inacessível, é recomendado o uso de um parâmetro na URL para que evite problemas como a remoção de mais de um arquivo ao mesmo tempo.

### TRACE
Quando um servidor recebe uma solicitação TRACE, ele reflete a solicitação de volta ao cliente, permitindo que o cliente veja quais alterações foram feitas no caminho durante o percurso até o servidor.

### OPTIONS
O método OPTIONS é usado para obter as opções de comunicação permitidas para um recurso ou servidor. Isso pode incluir métodos permitidos, cabeçalhos aceitáveis, entre outras informações relevantes.

### CONNECT
O método CONNECT é usado para estabelecer uma conexão de túnel com o servidor, geralmente para comunicações seguras através de um proxy HTTP. Ele é usado principalmente para estabelecer conexões SSL/TLS para comunicações seguras.

## Diferença entre HTTP e HTTPS
A sigla HTTPS vem de Hypertext Transfer Protocol **Secure**, ou Protocolo de Transferência de Hipertexto **Seguro**. O HTTPS é uma versão mais segura do HTTP.

O HTTP transmite dados sem criptografia, o que pode torná-los mais suscetíveis a ameaças de terceiros. Já o HTTPS, utiliza uma criptografía SSL/TLS para proteger a integridade de dados, ou seja, se alguém conseguir interromper de alguma forma a comunicação, os dados estão protegidos por uma criptografia.

# Referência
- [HTTP: um guia completo](https://www.alura.com.br/artigos/http)
- [What is HTTP?](https://www.freecodecamp.org/news/what-is-http/#introduction-to-http)
