# panamah-sdk-java

[![Maintainability](https://api.codeclimate.com/v1/badges/4f38bfb0bcf3566ba312/maintainability)](https://codeclimate.com/repos/5cc8bc7f389cf3174100021a/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/4f38bfb0bcf3566ba312/test_coverage)](https://codeclimate.com/repos/5cc8bc7f389cf3174100021a/test_coverage)

Implementação java do panamah sdk

## Documentação

[Aqui](https://casamagalhaes.github.io/panamah-sdk/)

## Requisitos

- java 1.7
- maven

## Testando

Roda os testes unitários e gerar a cobertura.

```bash
mvn test
```

## Uso básico

```java
// init no daemon do panamah junto com o início da aplicação
Panamah panamah = Panamah.init(config);
//...

// envio dos modelos
PanamahVenda venda = new PanamahVenda();
panamah.send(venda);
```
