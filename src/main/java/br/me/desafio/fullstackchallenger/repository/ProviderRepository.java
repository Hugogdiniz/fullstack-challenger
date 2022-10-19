package br.me.desafio.fullstackchallenger.repository;

import br.me.desafio.fullstackchallenger.entity.Provider;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends MongoRepository<Provider, String> {

}
