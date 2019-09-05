# panamah-sdk-java

[![Maintainability](https://api.codeclimate.com/v1/badges/4f38bfb0bcf3566ba312/maintainability)](https://codeclimate.com/repos/5cc8bc7f389cf3174100021a/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/4f38bfb0bcf3566ba312/test_coverage)](https://codeclimate.com/repos/5cc8bc7f389cf3174100021a/test_coverage)
[![Build Status](https://travis-ci.org/casamagalhaes/panamah-sdk-java.svg?branch=development)](https://travis-ci.org/casamagalhaes/panamah-sdk-java)

Implementação java do panamah sdk

## Documentação

[Documentação geral](https://casamagalhaes.github.io/panamah-sdk/) e [exemplos de uso](https://github.com/casamagalhaes/panamah-sdk-java/wiki/Exemplo-de-uso)

## Requisitos

- java 1.7
- maven

## Testando

Para é preciso ter o
[servidor de testes](https://github.com/casamagalhaes/panamah-test-server)
rodando para executar corretamente os testes.

O comando abaixo roda os testes unitários e gerar a cobertura.

```bash
mvn test
```

## Usando em projetos gradle

```groovy
plugins {
    id 'java-library'
}

repositories {
    jcenter()
    maven {
        url  "https://dl.bintray.com/casamagalhaes/panamah-java-sdk"
    }
}

dependencies {
    implementation 'br.com.casamagalhaes.panamah.sdk:panamah-sdk:2.1.2'
    testImplementation 'junit:junit:4.12'
}
```

## Usando em projetos maven

Siga as instruções do link **set me up**
[desta página](https://bintray.com/beta/#/casamagalhaes/panamah-java-sdk/panamah-java-sdk/2.1.2?tab=overview)

## Uso básico

```java
// init no daemon do panamah junto com o início da aplicação
PanamahConfig config = PanamahConfig.autoConfigure();
Panamah panamah = Panamah.init(config);
//...

// envio dos modelos
PanamahVenda venda = new PanamahVenda();
panamah.save(venda);
```

### Importante

É preciso informar sem falta:

- AuthorizationToken
- Secret
- AssinanteId

Assinante é normalmente o cnpj, o authorization token e o secret são informados pela Casa Magalhães através dos canais de comunicação com os parceiros.
