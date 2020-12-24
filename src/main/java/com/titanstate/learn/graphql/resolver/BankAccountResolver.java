package com.titanstate.learn.graphql.resolver;

import com.titanstate.learn.graphql.domain.bank.BankAccount;
import com.titanstate.learn.graphql.domain.bank.Client;
import com.titanstate.learn.graphql.domain.bank.Currency;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {
  public BankAccount bankAccount(UUID id) {
    log.info("Retrieving bank account id: {}", id);

    return BankAccount.builder()
        .id(id)
        .client(Client.builder()
            .id(UUID.randomUUID())
            .firstName("Camila")
            .lastName("Paschini")
            .build())
        .currency(Currency.SWK)
        .build();
  }
}
