package org.acme.aws.graphql_quarkus.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
//import un.my.ext.runtime.dto.bodyrequest.AuthenticationStudent;

import org.acme.aws.graphql_quarkus.dto.request.EleveInput;
import org.acme.aws.graphql_quarkus.dto.response.EleveResponseDto;
import org.acme.aws.graphql_quarkus.entity.Eleve;
import org.acme.aws.graphql_quarkus.traitement.EleveTraitement;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import io.smallrye.graphql.api.Subscription;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.operators.multi.processors.BroadcastProcessor;

import java.util.List;

@GraphQLApi
public class EleveResource {

    BroadcastProcessor<Eleve> processor = BroadcastProcessor.create(); 

//         @Mutation
//     public Hero createHero(Hero hero) {
//         service.addHero(hero);
//         processor.onNext(hero); 
//         return hero;
//     }

//     @Subscription
//     public Multi<Hero> heroCreated(){
//         return processor; 
//     }

//     subscription ListenForNewHeroes {
//   heroCreated {
//     name
//     surname
//   }
// }
//      public Film getFilm(Context context, int filmId) {



    @Inject
    EleveTraitement eleveTraitement;

    @Query
    public List<EleveResponseDto> globalListStudent() {
        return eleveTraitement.getListEleve().stream().map( eleve -> new EleveResponseDto( eleve ) ).toList();
    }

    @Query
    public EleveResponseDto informationsStudent( Long idEleve ) {
        return new EleveResponseDto( eleveTraitement.informationsStudent(idEleve) );
    }

    @Mutation
    @Transactional
    public EleveResponseDto createStudent( EleveInput eleveInput ) {
        Eleve eleveToSave =  eleveTraitement.createStudent( eleveInput );

        return new EleveResponseDto( eleveToSave );
    }

    // @Mutation
    // @Transactional
    // public EleveResponseDto loginStudent( AuthenticationStudent authenticationStudent ) {
    //     Eleve eleveToSave =  eleveTraitement.loginStudent( authenticationStudent );

    //     return new EleveResponseDto( eleveToSave );
    // }

}
