Quarkus guide: https://quarkus.io/guides/rest-client-reactive


# Your configuration properties
quarkus.rest-client."org.acme.rest.client.ExtensionsService".url=https://stage.code.quarkus.io/api # 
 	Cette configuration signifie que toutes les requêtes effectuées à l'aide de org.acme.rest.client.ExtensionsService utiliseront      
        https://stage.code.quarkus.io/api comme URL de base. 


L'interface QuarkusRestClientBuilder est une API spécifique à Quarkus qui permet de créer par programme des clients avec des options de configuration supplémentaires. Sinon, vous pouvez également utiliser l'interface RestClientBuilder de l'API Microprofile :