package ru.pavel2107.hwind.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.pavel2107.hwind.model.Product;

import java.util.List;

/**
 * Created by admin on 29.03.2016.
 */
public interface ProductRepository extends JpaRepository<Product, Integer>{
  //  List<Product> findByProductNamesLanguage(String lang, Pageable pageable);
}
