package com.app.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.ContactsMasterEntity;

@Repository
public interface IContactsMasterRepository extends JpaRepository<ContactsMasterEntity, Integer> {

	Optional<ContactsMasterEntity> findByContactNumber(Long contactNumber);

	Optional<ContactsMasterEntity> findByContactNameOrContactNumber(String contactName, Long contactNumber);

//	List<ContactsMasterEntity> findByContactStatusOrderByContactNameDesc(Integer status);

	List<ContactsMasterEntity> findByContactStatusOrderByContactNameDesc(Integer contactStatus);

	List<ContactsMasterEntity> findByContactStatusOrderByContactNameAsc(Integer contactStatus);

	List<ContactsMasterEntity> findByContactNameStartingWith(String pattern);

	@Query(value = "SELECT * FROM CONTACTS_MASTER WHERE CONTACT_NAME IS NULL", nativeQuery = true)
	List<ContactsMasterEntity> findAllIsNull();

	@Query(value = "select COUNT(*) from contacts_master where CONTACT_STATUS = 1", nativeQuery = true)
	Integer findByContactNameCount();
	
}
