package org.acme.aws.reactive_quarkus;

import java.util.List;

import org.acme.aws.reactive_quarkus.dto.requestbody.from_graphql_service.Eleve;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Query;

import io.smallrye.graphql.client.typesafe.api.GraphQLClientApi;

@GraphQLClientApi(configKey = "microservice_scolarite")
public interface EleveService {

    @Query
    @Description("Get all students")
    public List<Eleve> globalListStudent() ;    
    
/*     @Query
    @Description("Get a specific post by providing an id")
    public Post getPostById(@Name("postId") String id);    @Mutation
    @Description("Create a new post")
    public Post createPost(@Valid CreatePost createPostInput); */
}