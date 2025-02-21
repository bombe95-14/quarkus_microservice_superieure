package org.acme.aws.reactive_quarkus.simple.global;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;
import org.jboss.resteasy.reactive.server.multipart.MultipartFormDataOutput;

import io.smallrye.mutiny.Multi;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.NewCookie;
import jakarta.ws.rs.core.UriInfo;

import org.jboss.resteasy.reactive.ResponseStatus;
import org.jboss.resteasy.reactive.RestMulti;

@Path("multipart")
public class EndPoint {
    
    @GET
    @Produces(MediaType.MULTIPART_FORM_DATA)
    @Path("file")
    @ResponseStatus(200)

    public MultipartFormDataOutput getFile() {
        MultipartFormDataOutput form = new MultipartFormDataOutput();
       // form.addFormData("person", new Person("John"), MediaType.APPLICATION_JSON_TYPE);
        form.addFormData("status", "a status", MediaType.TEXT_PLAIN_TYPE)
                .getHeaders().putSingle("extra-header", "extra-value");
        return form;
    }

        @GET
    public RestResponse<String> hello() {
        // HTTP OK status with text/plain content type
      /*   return ResponseBuilder.ok("Hello, World!", MediaType.TEXT_PLAIN_TYPE)
         .header("X-Cheese", "Camembert")
         .expires(Date.from(Instant.now().plus(Duration.ofDays(2))))
         .cookie(new NewCookie("Flavour", "chocolate"))
         .build(); */
         return ResponseBuilder.ok("Hello, World!", MediaType.TEXT_PLAIN_TYPE).build();
    }
/* 
    @POST
    public RestResponse<Fruit> add(Fruit fruit, @Context UriInfo uriInfo) {
        fruit.id = ids.incrementAndGet();
        fruits.put(fruit.id, fruit);
        // seeOther results in an HTTP 303 response with the Location header set to the value of the URI
        return RestResponse.seeOther(uriInfo.getAbsolutePathBuilder().path(Long.toString(fruit.id)).build());
    }
 */
    @Inject
    Multi<String> logs;

    @GET
    public Multi<String> streamLogs() {
        return RestMulti.fromMultiData(logs).status(222).header("foo", "bar").build();
    }

}
/* 

Si vous souhaitez diffuser des objets JSON dans votre réponse, vous pouvez utiliser les événements envoyés par le serveur en annotant votre méthode d'extrémité avec @Produces(MediaType.SERVER_SENT_EVENTS)
 et en spécifiant que chaque élément doit être sérialisé en JSON avec @RestStreamElementType(MediaType.APPLICATION_JSON). 
 
 Les méthodes REST Jakarta peuvent être annotées avec @JsonView afin de personnaliser 
 la sérialisation du POJO retourné, pour chaque méthode. La meilleure façon de l'expliquer est de prendre un exemple.

 Les méthodes REST Jakarta peuvent être annotées avec @JsonView 
 afin de personnaliser la sérialisation du POJO retourné, pour chaque méthode.

RESTEasy Reactive est mis en œuvre à l'aide de deux types de threads principaux :

    Les threads Event-loop : qui sont responsables, entre autres, de la lecture des octets de la requête HTTP et de l'écriture des octets dans la réponse HTTP.

    Les threads de travail : ils sont mis en commun et peuvent être utilisés pour décharger les opérations de longue durée.

    Les threads de boucle d'événements (également appelés threads IO) sont chargés d'exécuter toutes les opérations IO de manière asynchrone et de déclencher tout auditeur intéressé par l'achèvement de ces opérations IO.

Par défaut, le thread sur lequel RESTEasy Reactive exécutera les méthodes de endpoints dépend de la signature de la méthode. Si une méthode renvoie l'un des types suivants, (     io.smallrye.mutiny.Uni,    io.smallrye.mutiny.Multi,    java.util.concurrent.CompletionStage,
    org.reactivestreams.Publisher )  elle est considérée
 comme non bloquante et sera exécutée par défaut sur le thread IO :

 Si vous écrivez du code bloquant, vos méthodes renverront 
 généralement le résultat directement et seront exécutées sur un thread de travail.


 Si votre application doit renvoyer des codes HTTP non nominaux en cas d'erreur, le mieux est de lancer des exceptions qui entraîneront l'envoi de la bonne réponse HTTP par 
            le framework en utilisant WebApplicationException ou l'un de ses sous-types : 

            Si votre méthode de point final délègue des appels à une autre couche de service qui ne connaît pas Jakarta REST, vous avez besoin d'un moyen de transformer les exceptions de service en une réponse HTTP, et vous pouvez le faire en utilisant l'annotation @ServerExceptionMapper sur une méthode, avec un paramètre du type 
            d'exception que vous voulez gérer, et en transformant cette exception en une RestResponse (ou une Uni<RestResponse<?>>).


            Les filtres de requête peuvent être déclarés avec l'annotation @ServerRequestFilter :
            @ServerRequestFilter(nonBlocking=true



Such a response filter will also be called for handled exceptions.

Your filters may declare any of the following parameter types:

Vos filtres peuvent déclarer n'importe lequel des types de paramètres suivants : 
                - Any of the Context objects
                ContainerRequestContext
                ContainerResponseContext
                Throwable:
	

Any thrown and handled exception, or null (only for response filters).


Les requêtes et les réponses HTTP peuvent être interceptées en fournissant respectivement les implémentations ContainerRequestFilter et ContainerResponseFilter. Ces filtres permettent de traiter les métadonnées associées à un message : En-têtes HTTP, paramètres de requête, type de média et autres métadonnées. Ils ont également la capacité d'interrompre le
 traitement de la demande, par exemple lorsque l'utilisateur n'a pas les autorisations nécessaires pour accéder au point d'accès.


 Tous les paramètres de requête peuvent être déclarés comme des chaînes de caractères, mais aussi comme n'importe lequel des types suivants :

    Types pour lesquels un ParamConverter est disponible via un ParamConverterProvider enregistré.

    Types primitifs.

    Les types dont le constructeur accepte un seul argument de type chaîne.

    Les types qui ont une méthode statique nommée valueOf ou fromString avec un seul argument String qui renvoie une instance du type. Si les deux méthodes sont présentes, valueOf sera utilisée, sauf si le type est un enum, auquel cas fromString sera utilisé.

    List<T>, Set<T> ou SortedSet<T>, où T satisfait à l'un des critères ci-dessus.



Dans Quarkus, l'extension RESTEasy Reactive et l'extension REST Client Reactive partagent la même infrastructure. Une conséquence importante de cette considération est qu'elles partagent la même liste de fournisseurs (au sens REST de Jakarta).

Par exemple, si vous déclarez un WriterInterceptor, il interceptera par défaut à la fois les appels du serveur et ceux du client, ce qui n'est pas forcément le comportement souhaité.

Cependant, vous pouvez modifier ce comportement par défaut et contraindre un fournisseur à :

    ne prendre en compte que les appels du serveur en ajoutant l'annotation @ConstrainedTo(RuntimeType.SERVER) à votre fournisseur ;

    ne prendre en compte que les appels clients en ajoutant l'annotation @ConstrainedTo(RuntimeType.CLIENT) à votre fournisseur.
 */