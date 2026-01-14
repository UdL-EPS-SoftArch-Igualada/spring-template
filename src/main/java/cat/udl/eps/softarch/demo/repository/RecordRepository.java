package cat.udl.eps.softarch.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import cat.udl.eps.softarch.demo.domain.Record;
import cat.udl.eps.softarch.demo.domain.User;

@RepositoryRestResource
public interface RecordRepository extends CrudRepository<cat.udl.eps.softarch.demo.domain.Record, Long>,
		PagingAndSortingRepository<Record, Long> {
	List<cat.udl.eps.softarch.demo.domain.Record> findByOwnedBy(@Param("user") User owner);
}
