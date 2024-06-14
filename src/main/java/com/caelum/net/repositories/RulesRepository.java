package com.caelum.net.repositories;

import com.caelum.net.entities.RulesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RulesRepository extends CrudRepository<RulesEntity, Long> {

}
