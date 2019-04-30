# panamah-sdk-java

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
