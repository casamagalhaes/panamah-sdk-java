# CHANGELOG

Histórico de releases da SDK

## 2.1.3

- correção na checagem de lote cheio

## 2.1.2

- corrigido bug na montagem dos lotes
- corrigido bug na montagem tipos de dado do modelo
- corrigido bug de acesso concorrente no momento do fechamento do lote

## 2.1.1

- refatoração do `PanamahStream`
- novos casos de teste para estudar fechamento e abertura de lotes

## 2.1.0

- alterada forma de fechamento de lote
- adotando sincronização de lista
- correções na bateria de testes

## 2.0.1

- removidos `System.out.println()`
- ajuste no PanamahTask
  - agora envios ocorrem duas vezes no tempo de fechamento de lote
  - lotes fechados ao serem enviados sempre serão movidos para pasta de envio
  - na listagem de lotes fechados o primeiro da lista é que será enviado 

## 2.0.0

- quebra de api
  - mudando atributos do tipo Double para BigDecimal

## 1.0.1

Corrigindo documentação

## 1.0.0

- quebra de API
  - na configuração agora procuramos 'secret' em vez de 'key'
- ajuste na bateria de testes

## 0.3.4

Ajuste de API

- suporte a multi-assinante
- mudança no retorno de pendências

## 0.3.3

Primeiro G.A.
