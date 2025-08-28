package com.ecommerce.repository;

import com.ecommerce.entity.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems,Long> {

    List<CartItems> findByUserId(Long id);

    void deleteByUserId(Long id);
}
