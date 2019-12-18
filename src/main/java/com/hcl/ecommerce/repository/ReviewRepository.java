package com.hcl.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

	@Query("select avg(s.rating) from Review s where s.storeId=?1")
	Double findByStoreId(Integer storeId);

}
