package com.cqrs.complains.query.repositories;

import com.cqrs.complains.query.entities.ComplainQueryObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mradul on 03/03/17.
 */
public interface ComplainQueryObjectRepository extends JpaRepository<ComplainQueryObject,String> {
}
