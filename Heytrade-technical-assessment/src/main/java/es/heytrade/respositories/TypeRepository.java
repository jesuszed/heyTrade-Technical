package es.heytrade.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.heytrade.entities.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {

}
