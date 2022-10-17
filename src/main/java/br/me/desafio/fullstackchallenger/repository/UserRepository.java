package br.me.desafio.fullstackchallenger.repository;

import br.me.desafio.fullstackchallenger.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

}
