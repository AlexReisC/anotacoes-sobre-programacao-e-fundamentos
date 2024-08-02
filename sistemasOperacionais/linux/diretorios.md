# Diretórios
O diretório `/` (barra) é o diretório raiz do Linux. É a origem de todos os diretórios. Dentro deste diretório existem alguns com indicações visuais especificas:
- Icones de pastas e arquivos com uma 'seta': São chamadas de links simbolicas. São atalhos para outras pastas e arquivos. Ao entrar nela você estará dentro de outra.
- Icones com um 'x': Significam que não podem ser acessados sem ser como um *root* (usuário administrador).
  
Geralmente o layout das pastas no Linux segue o FHS (FILESYSTEM HIERARCHY STANDARD), um padrão construído pela Linux Fundation. Não necessariamente é mantido por todas as Distros.

```markdown
/

|-- bin

|   |-- file1

|   |-- file2

|-- etc

|   |-- file3

|   `-- directory1

|       |-- file4

|       `-- file5

|-- home

|-- var
```

## /bin (binaries)
Onde estão os executavéis de diversos programas. Também encontram-se aqui tanbém os link simbolicos e *shell scripts*.

Comparavél com a pasta 'Arquivos e Programas' do Windows, mas nesta apenas estão os arquivos executavéis e não estão separados por empresa.

## /boot
Contém os arquivos necessários para o sistema operacional iniciar.

## /cdrom
Diretório legado, a menos que o computador possua um driver de cd/dvd. A imagem do disco será montada aqui.

## /dev (devices)
Contém arquivos que correspondem ao seu hardware. Arquivos que podem ser configurados e mudar a forma como um hardware está funcionando.

### /dev/null
Perde todo arquivo que for mandado para cá.

## /etc
A sua função é manter os arquivos de configuração do sistema para todos os usuários do sistema e não configurações especificas de um usuário.

## /home
Dentro desta pasta encontram-se pastas com os nomes dos usuários cadastrados na máquina. 

Dentro de uma delas estão as pastas de imagens, músicas, documentos entre outras. Também há uma série de arquivos ocultos que armazenam configurações de preferências de aplicativos do usuário.

## /lib, /lib32, /lib64, /libx32 (librarie)
Todas contém bibliotecas de softwares pro aplicativos instalados.

Bibliotecas que podem ser usadas pelos binários do sistema para que os softwares executem suas funções.

- lib : para bibliotecas multi-arquitetura
- lib32: para bibliotecas de 32 bits
- lib64: para bibliotecas de 64 bits
- lib32x: menos comum, tipo especifico de biblioteca chamada x32 ABI

## /media
Onde são montados automaticamente as unidades removivéis do sistema (pen-drive, hd externo). Inclui unidades de rede.

## /mnt
Ponto de montagem de unidades de disco feitas manualmente pelo usuário editando o arquivo `fstab` (fica dentro do `/etc`).

## /opt (optional)
Onde encontram-se softwares de fabricantes que enviam computadores com Linux. Exemplo: Google Chrome.

## /proc (processes)
Onde encontram-se arquivos com informações sobre o sistema e processos dele. Diretório virtual, os arquivos não existem realmente, são criados ao inicar o computador.

## /root
Como o diretório `/home` mas para o usuário root. Fica separado dos diretórios de usuário normais para que possa ter permissões especiais de acesso.

Dentro dele estão todos os arquivos de configurações dos plaicativos do usuário root.

## /run (runtime)
Diretório virtual, carregado na memória e apagado quando a máquina é desligada. Armazena sobre o sistema desde o último boot, como usuários logados etc.

## /sbin (system binaries)
Como o `/bin`, armazena binários dos programas que só podem ser acessados pelo administrador.

## /snap
Arquivos para pacotes *snap*.

## /srv (services)
Serve para armazenar arquivos acessiveis à usuários de um servidor web ou ftp. Pode ser montada a partir de um disco externo.

## /sys (system)
Onde estão armazenados os drivers e módulos. Como o `/run`, não mantém arquivos no disco, é criado quando o computador é iniciado.

## /tmp (temporary)
Diretório de arquivos temporários.

## /usr
Arquivos de programas e bibliotecas que são utéis paras os usuários mas que não são vitais para o sistema.

### /usr/local
Onde programas instalados via código finte vão parar.

## /var (variable)
Armazena arquivos que sõ esperados que aumentem de tamanhao ao longo do tempo.
