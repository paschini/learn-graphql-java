package com.titanstate.learn.graphql.resolver.bank;

import com.titanstate.learn.graphql.domain.bank.BankAccount;
import com.titanstate.learn.graphql.domain.bank.Client;
import graphql.GraphQLException;
import graphql.execution.DataFetcherResult;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class ClientResolver implements GraphQLResolver<BankAccount> {
  public DataFetcherResult<Client> client(BankAccount bankAccount) {
    log.info("Requesting client data for bank account id: {}", bankAccount.getId());

    // throw new GraphQLException("Client unavailable"); // internal server errors get hidden!

    /**
     * Dealing with partial responses
     * 1: Call multiple services
     * 2: call another graphql server
     * 3: call service that returns partial responses
     */

    return DataFetcherResult.<Client>newResult()
        .data(Client.builder()
            .id(UUID.randomUUID())
            .firstName("Camila")
            .lastName("Paschini")
            .build())
        .error(new GenericGraphQLError("Could not get client id!"))
        .build();
    // no throwing exception needed this way
  }
}
