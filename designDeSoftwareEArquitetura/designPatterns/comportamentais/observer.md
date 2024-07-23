# Observer
O Observer é um padrão de projeto comportamental que permite que você defina um mecanismo de assinatura para notificar múltiplos objetos sobre quaisquer eventos que aconteçam com o objeto que eles estão observando.

### Exemplo
Alguns clientes de uma loja tem interesse em um produto em promoção
- Opção 1: Clientes vão periodicamente até a loja verificar se a promoção já está em vigência
- Opção 2: Loja notifica toda a base de clientes de que o produto está em promoção
Ambos são ruins.

Você pode "assinar" uma notificação (subscription). Quando o evento de interesse acontecer, os assinantes são notificações (update).


