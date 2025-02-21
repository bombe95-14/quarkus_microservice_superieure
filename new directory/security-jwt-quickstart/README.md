# security-jwt-quickstart

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Dnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Dnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/security-jwt-quickstart-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- SmallRye JWT Build ([guide](https://quarkus.io/guides/security-jwt-build)): Create JSON Web Token with SmallRye JWT Build API
- SmallRye JWT ([guide](https://quarkus.io/guides/security-jwt)): Secure your applications with JSON Web Token


 SmallRye JWT espour utilisé pour :
    - vérifier les jetons Web JSON, les représenter en tant que MicroProfile JWT org.eclipse.microprofile.jwt.JsonWebToken 
    - Fournir un accès sécurisé aux endpoints HTTP Quarkus en utilisant Bearer Token Authorization et le RBAC

quarkus-oidc prend également en charge le Bearer Token Authorization et utilise smallrye-jwt pour représenter les bearer token sous forme de JsonWebToken. 
On peut également utilisé quarkus-oidc pour authentifier les utilisateurs à l'aide de l'OIDC Authorization Code Flow. 
        JsonWebToken représente le Principal actuel.


Les clés publiques peuvent être formatées dans l'un des formats suivants, spécifiés par ordre de priorité :

    Public Key Cryptography Standards #8 (PKCS#8) PEM
    JSON Web Key (JWK)
    JSON Web Key Set (JWKS)
    JSON Web Key (JWK) Base64 URL encoded
    JSON Web Key Set (JWKS) Base64 URL encoded


Cette clé secrète ( 
    {
 "keys": [
   {
     "kty":"oct",
     "kid":"secretKey",
     "k":"AyM1SysPpbyDfgZld3umj1qzKObwVMkoqQ-EstJQLr_T-1qS0gZH75aKtMN3Yj0iPS4hcgUuTwjAzZr1Z9CAow"
   }
 ]
}
 ) 
 
JWK devra également être référencée avec smallrye.jwt.verify.key.location. smallrye.jwt.verify.algorithm doit être réglé sur HS256/HS384/HS512.

Analyse et vérification de JsonWebToken avec JWTParser
        @Inject JWTParser parser;

String token = getTokenFromOidcServer();

// Parse and verify the token
        JsonWebToken jwt = parser.parse(token);