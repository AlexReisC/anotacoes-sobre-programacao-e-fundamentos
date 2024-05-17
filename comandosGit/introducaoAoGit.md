# Introdução ao Git

## Controle de Versão
O que é controle de versão? É um sistema que registra alterações em um arquivo ou conjunto de arquivos ao longo do tempo para que você possa lembrar versões específicas mais tarde. Ou seja, você consegue manter versões do seus arquivos e se quiser pode reverter tudo, pode recuperar arquivos perdidos etc.

## Básico do Git
A principal diferença entre o Git e qualquer outro VCS (Subversion e similares) é a maneira como o Git trata seus dados. Estes sistemas (CVS, Subversion, Perforce, Bazaar, e assim por diante) tratam a informação como um conjunto de arquivos e as mudanças feitas em cada arquivo ao longo do tempo.

O Git trata seus dados mais como um conjunto de imagens de um sistema de arquivos em miniatura. Toda vez que você fizer
um *commit*, ou salvar o estado de seu projeto no Git, ele basicamente tira uma foto de todos os seus arquivos e armazena uma referência para esse conjunto de arquivos. Para ser eficiente, se os arquivos não foram alterados, o Git não armazena o arquivo novamente, apenas um link para o arquivo idêntico anterior já armazenado. O Git trata seus dados mais como um fluxo do estado dos arquivos.

## Git tem integridade
Tudo no Git passa por uma soma de verificações (checksum) antes de ser armazenado e é referenciado por esse checksum. Isto significa que é impossível mudar o conteúdo de qualquer arquivo ou pasta sem que Git saiba. Esta funcionalidade está incorporada no Git nos níveis mais baixos e é parte integrante de sua filosofia. Você não perderá informação durante a transferência e não receberá um arquivo corrompido sem que o Git seja capaz de detectar.

O mecanismo que o Git utiliza para esta soma de verificação é chamado um *hash* SHA-1. Esta é uma sequência de 40 caracteres composta de caracteres hexadecimais (0-9 e-f) e é calculada com base no conteúdo de uma estrutura de arquivo ou diretório no Git. Um *hash* SHA-1 é algo como o seguinte:
> 24b9da6552252987aa493b52f8696cd6d3b00373

## OS Três estados
O Git tem três estados principais que seus arquivos podem estar: *committed*, modificado (*modified*) e preparado (*staged*). *Committed* significa que os dados estão armazenados de forma segura em seu banco de dados local. Modificado significa que você alterou o arquivo, mas ainda não fez o *commit* no seu banco de dados. Preparado significa que você marcou a versão atual de um arquivo modificado para fazer parte de seu próximo *commit*.

Isso nos leva a três seções principais de um projeto Git: o diretório Git, o diretório de trabalho e área de preparo.

O diretório Git é onde o Git armazena os metadados e o banco de dados de objetos de seu projeto. Esta é a parte mais importante do Git, e é o que é copiado quando você clona um repositório de outro computador.

O diretório de trabalho é uma simples cópia de uma versão do projeto. Esses arquivos são pegos do banco de dados compactado no diretório Git e colocados no disco para você usar ou modificar.

A área de preparo é um arquivo, geralmente contido em seu diretório Git, que armazena informações sobre o que vai entrar em seu próximo commit. É por vezes referido como o “índice”, mas também é comum referir-se a ele como área de preparo (staging area).

## Referência
[Progit: Capitulo 1]()