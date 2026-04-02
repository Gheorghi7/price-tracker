package org.application.projectapi.store.repository;

import org.application.projectapi.store.entities.Good;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GoodRepository extends JpaRepository<Good,Long> {
}
