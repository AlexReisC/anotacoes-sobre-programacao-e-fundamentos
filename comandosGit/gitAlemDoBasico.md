# Git além do básico

## git merge
Merge significa mesclagem, no git é o ato de mesclar o que está em uma branch (ramififcação) em outra.
```console
$ git checkout <branch_que_recebe_as_alteracoes>
$ git merge <branch_com_as_alteracoes>
```
No caso em que uma branch está apenas um commit atrás da outra, o git apenas move o HEAD para o commit com as mudanças.

## git rebase
Também é uma maneira de integrar as mudanças de uma branch em outra. O rebase pega todas as alterações de uma branch e reproduz em outra.
```console
$ git checkout <branch_que_recebe_as_alteracoes>
$ git rebase <branch_com_as_alteracoes>
```

## git stash
Quando você quer trocar de branch mas não quer fazer um commit das alterações atuais, então você usa o stash.
```console
$ git stash 
```
Você pode listar os stashs armazendados
```console
$ git stash list
```
Então para aplicar as modificações:
```console
$ git stash apply
```
O git assume que você quer aplicar o stash mais recente, para especificar qual será indique o nome do stash.
```console
$ git stash list
stash@{0}: WIP on master: 049d078 added the index file
stash@{1}: WIP on master: c264051 Revert "added file_size"
stash@{2}: WIP on master: 21d80a5 added number to log
$ git stash apply stash@{2}
```

## git cherry pick
Este comando serve para pegar as altereações de um commit e tentar introduzi-las em um novo commit na branch atual. Pode ser usado para pegar um ou dois commits de uma branch individualmente melhor que o merge na branch, que pega todas as alterações.
```console
$ git cherry pick <hash_do_commit>
```

## git commit --amend
Com isto você pode modificar o seu último commit. Se você quiser apenas modificar a mensagem do último commit:
```console
$ git commit --amend
```
Então o editor de texto vai abrir e você digita a nova mensagem pro commit.
<br>Se quiser alterar o último commit adicionando, removendo ou alterando arquivos, use o `git add` ou `git rm`:
```console
$ git add <arquivo>
$ git commit --amend
```


## Referência
[Progit](https://git-scm.com/book/en/v2)