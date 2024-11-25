# Docker

## O que é Container
Um *Container* é um agrupamento de uma aplicação com suas dependências, que compartilham o *kernel* do sistema operacional da máquina (física ou virtual) onde está rodando. 

Na maioria dos casos, a imagem de um container é bastante enxuta, havendo somente o necessário para o funcionamento da aplicação, que, quando em execução, possui um pequeno overhead se comparada à mesma aplicação rodando nativamente no sistema operacional, grande parte disso por conta do compartilhamento dos recursos com a máquina host.

Containers são similares à máquinas virtuias, porém são mais leves e mais integrados aos sistema operacional. Quando utilizamos uma máquina virtual nós emulamos um novo sistema operacional dentro do sistemal operacional do host. Já o container emula somente as aplicações e suas depedências.

Um container criado no seu ambiente, irá rodar em qualquer outro (Linux, MacOS, Windows), que tenha o Docker instalado.

## O que é o Docker
Emm 2013, a empresa dotCloud especializada em PaaS (*Plataform-as-a-Service*) decidiu tornar open source o core da sua plataforma, assim surgiu o Docker. Com o rápido crescimento do projeto, a dotCloud decidiu se chamar Docker e a versão 1.0 foi lançada após 15 meses da sua versão 0.1.

Assim Docker é uma tecnologia de conteinerização, a principal ferramenta para implantar aplicativos dentro de containers virtuais.

### Copy-On-Writer
Significa que um novo recuros, seja um bloco no disco ou uma área em memória, só é alocado quando for modificado.

O docker usa um esquema de camadas (ou layers) e para monatr essas cmaadas são usadas técnicas de Copy-On-Writer. Um container é basicamente uma pilha de N camadas read-only e uma, superior, read-write.

### O que é Imagem de Container
Um container é uma imagem de container em execução. É uma imagem que foi criada utilizando um **Dockerfile**, por exemplo, com as instruções para configurar sua aplicação no container. Quando ela é posta em execução temos então um container.

Funciona em camadas, exemplo:

| Imagem |
|--------|
| (read-write) |
| copy app |
| install nginx |
| debain |

Dados importantes não podem estar dentro do container.

Alteração em coisas existentes do container, na verdade são cópias na camada read-write.

### O que são namespaces e cgroup
Namespace servem para limitar ou isolar recursos de uma máquina. Cgroup servem para isolar cpu e memória. A tecnologia Docker os utilliza para segregar processos, assim eles podem ser executados de maneira independente.

## Instalando Docker no Linux

Instalar:
```
$ sudo apt install docker.io
```

Criar um grupo docker e adicionar o seu usuário para usar comandos Docker sem `sudo`:
```
$ sudo usermod -aG docker seu_usuario
```

## Primeiros passos

Rodar um container:
```
$ docker run -d -p 80:80 docker/getting-started
```
* docker -> comando para interagir com o docker
* run -> comando para executar uma imagem de container
* -d -> (daemon) container executa em background
* -p 80:80 -> atrelar a porta 80 do container a porta 80 do host
* docker/getting-started -> nome completo da imagem
> **Neste exemplo estamos carregando a imagem de getting started do docker**

Ver containers em execução:
```
$ docker container ls
```

Ver todos os containers já criados:
```
$ docker container ls -a
```

Ver os logs do container:
```
$ docker logs -f <id do container>
```

Remover container:
```
$ docker rm <id do container>
```

Parar executação do container:
```
$ docker stop <id do container>
```

Iniciar container:
```
$ docker start <id do container>
```

Executar um comando dentro do container:
```
$ docker container exec -it <id do container> bash
```
* docker container exec -> Executa algo em um container
* -it -> indica que quer um terminal
* bash( ou sh) -> o que será executado (precisa existir dentro do container)

> CRTL+D (ou CRTL+C) para sair do container

## Imagem de container

### Dockerfile
Arquivo com instruções para o que o container deve fazer. Exemplo de um Dockerfile e suas instruções:

```markdown
`FROM debian`(em que a imagem será baseada)
`RUN apt-get update && apt-get install ...` (execute alguma coisa na criação da imagem)
`WORKDIR /app` (diretório padrão ao iniciar o container)
`COPY /app/src /app` (copia aplicacao da sua máquina para o container)
`EXPOSED 80` (se é webserver vai ter a porta http exposta)
`CMD projeto --start` (comando para executar algo no container)
```

### Rodando um app
Criado o arquivo `Dockerfile` é preciso fazer o build:
```
$ docker build -t <nome-do-app> <caminho/do/diretorio/do/Dockerfile>
```
> Caso o `Dockerfile` esteja no mesmo diretorio do build apenas usa-se um ponto `.`

Mostrar as imagens:
```
$ docker images
```

Ver detalhas da imagem (a versão padrão é `latest`):
```
$ docker image inspect nome-do-container:versao
```

> **Dados escritos dentro do container são perdidos quando o container é apagado.**

Editar a versão (tag) de um container:
```
$ docker image tag nome-container:tag nome-container:nova-tag
```

### Atualizar um app

Fazer o build da versão atualizada da imagem:
```
$ docker build -t nome-do-container caminho/do/diretorio/do/Dockerfile
```

Pare e remova o container antigo, pode fazer isso rapidamente com:
```
$ docker rm --force id-do-container
```

Inicie o novo container:
```
$ docker run -dp portaDocker:portaHost nome-do-container
```

### Compartilhando imagem no Docker Hub

Atualize o nome da imagem adicionando seu usuario a ele:
```
docker image tag nome-da-imagem:versao seu-usuario/nome-da-imagem:versao
```

Crie conta no Docker Hub e faça login no terminal:
```
$ docker login -u seu-usuario
```

Fazer o push (enviar) da imagem
```
$ docker push seu-usuario/nome-da-imagem:versao
```

Qualquer pessoa poderá baixar a imagem
```
$ docker pull nome-da-imagem:tag
```

## Volumes
Volumes fornecem a habilidade para conectar caminhos especificos do filesystem do container com o host. Mudanças feitas em um diretório do container vão ser vistas também no diretório do host.

O Docker gerencia totalmente o volume, incluindo a localização do armazenamento no disco. Você só precisa lembrar do nome do volume.

### Criando um volume

Criar um volume:
```
$ docker volume create nome-volume
```

Pare e remova o container que está executando sem o volume:
```
$ docker rm -f id-container
```

Iniciar o container:
```
$ docker run -dp 127.0.0.1:3000:3000 --mount type=volume,src=nome-volume,target=/etc/todos nome-do-container
```
* --mount > indica que é o tipo de volume
* type=volume > para indicar que é um volume
* src > nome-do-volume
* target > onde o volume será montado

Para inspecionar o volume:
```
$ docker inspect volume nome-volume
```
- **No output, `Mountpoint` é a localização dos dados no disco**

## Container Network
Containers, por padrão, executam isolados e não sabem nada sobre outros processos ou containers na mesma máquina. Colocando containers na mesma rede (network) eles podem conversar um com o outro.

Há duas formas de por um container em uma network:
* Atribuir a network quando o container iniciar
* Conectar um container já em execução em uma network

A seguir vamos criar uma network e conectar um container MySQL a ela.

### Iniciar um container MySQL

Criar uma network:
```
$ docker network create nome-da-network
```

Iniciar um container MySQL e conectar à network:
```
docker run -d --network nome-da-network --network-alias mysql -v mysql-todo-db:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=secret -e MYSQL_DATABASE=todos mysql:8.0
```

Verificar se o banco de dados está rodando:
```
$ docker exec -it <mysql-container-id> mysql -u root -p
```
A senha para entrar é `secret`.

Para ver o banco de dados:
```
mysql> SHOW DATABASES;
```

Sair do MySQL `mysql> exit`.

### Conectar ao MySQL

Especifique as variavéis de ambiente, bem como conecte o container network da aplicação, exemplo:
```
$ docker run -dp 127.0.0.1:3000:3000 \
  -w /app -v "$(pwd):/app" \
  --network todo-app \
  -e MYSQL_HOST=mysql \
  -e MYSQL_USER=root \
  -e MYSQL_PASSWORD=secret \
  -e MYSQL_DB=todos \
  node:18-alpine \
  sh -c "yarn install && yarn run dev"
```
Assim neste exemplo temos dois containers dentro de uma mesma rede e contectados entre si.

## Referências
[Livro: Descomplicando Docker](https://livro.descomplicandodocker.com.br/)
[Primeiros passos no Docker](https://dev.to/clintonrocha98/primeiros-passos-no-docker-m0k)
