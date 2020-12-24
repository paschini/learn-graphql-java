package com.titanstate.learn.graphql.exceptions;

import graphql.GraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomGraphQLErrorHandler implements GraphQLErrorHandler {
  @Override
  public List<GraphQLError> processErrors(List<GraphQLError> errors) {
    // this way you can mask / transform errors, choose what you want to do which each error.
    // the graphql.servlet.exception-handlers-enabled must be set to false in application.yml

    return errors;
  }
}
