# panamah-sdk-java

[![Maintainability](https://api.codeclimate.com/v1/badges/4f38bfb0bcf3566ba312/maintainability)](https://codeclimate.com/repos/5cc8bc7f389cf3174100021a/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/4f38bfb0bcf3566ba312/test_coverage)](https://codeclimate.com/repos/5cc8bc7f389cf3174100021a/test_coverage)
[![Build Status](https://travis-ci.org/casamagalhaes/panamah-sdk-java.svg?branch=development)](https://travis-ci.org/casamagalhaes/panamah-sdk-java)
[![Download](https://api.bintray.com/packages/casamagalhaes/panamah-java-sdk/panamah-java-sdk/images/download.svg)](https://bintray.com/casamagalhaes/panamah-java-sdk/panamah-java-sdk/_latestVersion)

Implementação java do panamah sdk

## Visão Geral

[Visão Geral](https://github.com/casamagalhaes/panamah-sdk-java/wiki/Vis%C3%A3o-geral)

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
    implementation 'br.com.casamagalhaes.panamah.sdk:panamah-sdk:2.4.6'
    testImplementation 'junit:junit:4.12'
}
```

## Usando em projetos maven

Siga as instruções do link **set me up**
[desta página](https://bintray.com/beta/#/casamagalhaes/panamah-java-sdk/panamah-java-sdk/2.4.6?tab=overview)

## Registrando o assinante

Ao menos uma vez será preciso criar o assinante no Panamah.

Para tanto, segue o processo:

```java
PanamahConfig cfg = PanamahConfig.fromProperties("application");

cfg.getAuth().getAssinante().setNome("<Nome aqui>");
cfg.getAuth().getAssinante().setFantasia("<Nome fantasia aqui>");

PanamahAdmin admin = PanamahAdmin.getInstance();

admin.createAssinante(cfg);
```

## Uso básico

```java
// init do panamah junto com o início da aplicação
PanamahConfig config = PanamahConfig.fromProperties("application");
PanamahStream stream = Panamah.init(config);
//...

// envio dos modelos
PanamahVenda venda = new PanamahVenda();
// preencher os modelos...
stream.save(venda);
```

### Importante

É preciso informar sem falta:

- AuthorizationToken
- Secret
- AssinanteId

Assinante é normalmente o cnpj, o authorization token e o secret são informados
pela Casa Magalhães através dos canais de comunicação com os parceiros.
