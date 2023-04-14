package com.example.sales.models.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Modifying
    @Transactional
    @Query(value = "UPDATE products SET status = :status WHERE id = :id", nativeQuery = true)
    Integer updateStatusById(
            @Param("status") Boolean status,
            @Param("id")Long id);
    boolean existsByName (String name);
}
