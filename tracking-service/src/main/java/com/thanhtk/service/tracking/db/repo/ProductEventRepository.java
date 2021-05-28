package com.thanhtk.service.tracking.db.repo;

import com.thanhtk.service.tracking.db.entity.ConfigurationEntity;
import com.thanhtk.service.tracking.db.entity.ProductEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductEventRepository extends JpaRepository<ProductEventEntity, Integer> {

}
