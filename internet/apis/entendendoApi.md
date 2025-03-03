# API
API é a sigla em inglês para *Application Programming Interface*, ou interface de programação de aplicações. As interfaces de programação de aplicativos (APIs) são conjuntos de ferramentas, definições e protocolos para a criação de aplicações de software. APIs conectam soluções e serviços, sem a necessidade de saber como esses elementos foram implementados.

## Como as APIs funcionam
Com as APIs, sua solução ou serviço pode se comunicar com outros produtos ou serviços sem precisar saber como eles foram implementatdos.

As APIs funcionam como se fossem contratos, com documentações que representam um acordo entre as partes interessadas. Se uma dessas partes enviar uma solicitação remota estruturada de uma forma específica, isso determinará como a aplicação da outra parte responderá.

## Vantagens de usar API
As APIs simplificam a forma como os desenvolvedores integram novos componentes de aplicações a uma arquitetura preexistente.

As APIs são uma maneira simplificada de conectar a própria infraestrutura por meio do desenvolvimento de aplicações nativas em nuvem. No entanto, elas também possibilitam o compartilhamento de dados com clientes e outros usuários externos. As APIs públicas agregam valor de negócios porque simplificam e ampliam como você se conecta aos parceiros, além de, possivelmente, monetizar seus dados. Um exemplo famoso é a API do Google Maps.

Com as APIs, você libera o acesso aos seus recursos sem abdicar da segurança e do controle. É você quem determina como isso será feito e quem terá acesso. A segurança das APIs depende de um bom gerenciamento, que inclui o uso de um gateway de APIs. É possível conectar APIs e criar aplicações que usam os dados ou funcionalidades disponibilizadas por elas usando uma plataforma de integração distribuída que ligue todos os elementos, incluindo sistemas legados e dispositivos de Internet das Coisas (IoT).

## Tipos de API
- Privada: A API é usada apenas internamente. Isso oferece às empresas um maior controle.
- Publica: A API é disponibilizada para todos. Terceiros podem desenvolver aplicações que interajam com a sua API e isso pode se tornar uma fonte de inovação.
- Parceiros: A API é compartilhada com parceiros de negócios específicos. Isso pode fornecer fluxos de receita adicionais sem comprometer a qualidade.

## APIs remotas ou APIs Web
As APIs remotas foram projetadas para interagir por meio de uma rede de comunicações. Quando falamos *remota*, queremos dizer que os recursos utilizados pela API estão em algum lugar fora do computador que realiza a solicitação. Como a rede de comunicações mais usada é a Internet, a maioria das APIs são projetadas com base em padrões da web. Nem todas as APIs remotas são web, mas é justo afirmar que, em geral, as APIs web são remotas.

As APIs web normalmente usam o protocolo HTTP para mensagens de solicitação e fornecem uma definição da estrutura das mensagens de resposta. Essas mensagens de resposta geralmente têm o formato de arquivo XML ou JSON. Tanto XML quanto JSON são formatos de preferência porque apresentam os dados de forma simplificada, facilitando a manipulação por outras aplicações.

## API SOAP E API REST
O Simple Object Access Protocol, mais conhecido como SOAP, é uma especificação de protocolo que foi desenvolvida para ajudar a padronizar a troca de informações. As APIs projetadas com SOAP usam o XML como formato de mensagem e recebem solicitações por HTTP ou SMTP. O SOAP facilita o compartilhamento de informações por aplicações executadas em ambientes diferentes ou escritos em linguagens diferentes.

Outra especificação é a Representational State Transfer (REST). APIs web que adotam as restrições de arquitetura da REST são chamadas de APIs RESTful. A REST é fundamentalmente diferente do SOAP: o SOAP é um protocolo e a REST é um estilo de arquitetura. Isso significa que não há um padrão oficial para APIs RESTful web. Conforme definido na dissertação de Roy Fielding "Architectural Styles and the Design of Network-based Software Architectures", as APIs serão consideradas RESTful se estiverem em conformidade com seis restrições de arquitetura:
- **Arquitetura cliente-servidor:** a arquitetura REST é composta por clientes, servidores e recursos. Ela lida com as solicitações via HTTP.
- **Sem monitoração de estado:** nenhum conteúdo do cliente é armazenado no servidor entre as solicitações. Em vez disso, as informações sobre o estado da sessão são mantidas com o cliente.
- **Capacidade de cache:** o armazenamento em cache pode eliminar a necessidade de algumas interações entre o cliente e o servidor.
- **Sistema em camadas:** as interações entre cliente e servidor podem ser mediadas por camadas adicionais. Essas camadas podem oferecer recursos extras, como balanceamento de carga, caches compartilhados ou segurança.
- **Código sob demanda (opcional):** os servidores podem ampliar a funcionalidade de um cliente por meio da transferência de códigos executáveis.
- **Interface uniforme:** essa restrição é essencial para o design de APIs RESTful e inclui quatro vertentes:
    - Identificação de recursos nas solicitações: os recursos são identificados nas solicitações e separados das representações retornadas para o cliente.
    - Manipulação de recursos por meio de representações: os clientes recebem arquivos que representam recursos. Essas representações precisam ter informações suficientes para permitir a modificação ou exclusão.
    - Mensagens autodescritivas: cada mensagem retornada para um cliente contém informações suficientes para descrever como ele deve processá-las.
    - Hipermídia como plataforma do estado das aplicações: depois de acessar um recurso, o cliente REST pode descobrir todas as outras ações disponíveis no momento por meio de hiperlinks.

Essas restrições podem parecer excessivas, mas são muito mais simples do que um protocolo prescrito. Por isso, as APIs RESTful estão se tornando mais comuns do que as APIs SOAP.

Nos últimos anos, as especificações da OpenAPI se tornaram o padrão na hora de definir APIs REST. A OpenAPI permite que desenvolvedores de todas as linguagens criem interfaces de API REST compreensíveis com o mínimo de suposições.

## GraphQL
Outro padrão de API emergente é o GraphQL, uma linguagem de consulta e ambiente de execução voltado a servidores alternativa ao REST. A prioridade do GraphQL é fornecer exatamente os dados que os clientes solicitam e nada além. Como alternativa à arquitetura REST, o GraphQL permite aos desenvolvedores construir solicitações que extraem os dados de várias fontes em uma única chamada de API.

## APIs e Webhooks
Um webhook é uma função de retorno de chamada baseada em HTTP que viabiliza uma comunicação lightweight e orientada por eventos entre duas APIs. Os webhooks são usados por várias aplicações web para receber pequenos volumes de dados de outras aplicações, mas também podem ser utilizados para acionar fluxos de trabalho de automação nos ambientes do GitOps.

Em geral, os webhooks são descritos como APIs reversas ou APIs de push, porque colocam a responsabilidade da comunicação no servidor, e não no cliente. Em vez de o cliente enviar as solicitações HTTP pedindo os dados até receber uma resposta, o servidor envia para o cliente uma solicitação HTTP POST exclusiva quando os dados estiverem disponíveis. Apesar dos apelidos, os webhooks não são APIs. Eles trabalham juntos. Uma aplicação precisa ter uma API para usar um webhook. 

# Referência
[O que é API? Guia de APIs para iniciantes](https://www.redhat.com/pt-br/topics/api/what-are-application-programming-interfaces)
