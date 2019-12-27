# CHANGELOG

Histórico de releases da SDK

## 2.4.5

- Correção no conversor de datas dentro do `GsonUTCDateAdapter`

## 2.4.4

- Otimizada a leitura da pasta de lotes fechados

## 2.4.3

- Estudo de caso de regressão de performance do envio de lote
- Caso de testes dedicado ao envio de vendas

## 2.4.2

- Adicionado valores padrões e atualizado readme

## 2.4.1

- Ajustes no parser da NFe

## 2.4.0

- mudando o limite de lote cheio para 300 itens ou 3kb, o que ocorrer primeiro.

## 2.3.1

- corrigindo o momento de deletar o lote fechado

## 2.3.0

- Lotes vazios são descartados direto em vez de serem salvos na pasta fechados.
- Criada configuração `maxAgeSent` com valor padrão de 24 horas. Lotes já
  enviados agora sao deletados após 24 horas.
- Correção do comportamento errático do `PanamahConfig.autoConfigure()`.
  Na sequência, primeiro procura-se pelas configurações nas propriedades da
  jvm, em seguida no _application.properties_ e por fim nas variáveis de
  ambiente. O autoConfigure fará uma mescla com o resultado do que for
  encontrado.

## 2.2.0

- Nova estratégia de sincronização do lote
- Melhoria no README principal para citar a necessidade do `PanamahAdmin`

## 2.1.5

- correção na validação da operação

## 2.1.4

- correção no tratamento de concorrência

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
