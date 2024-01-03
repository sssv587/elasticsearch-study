package com.futurebytedance;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author yuhang.sun
 * @version 1.0
 * @date 2024/1/4 - 0:25
 * @Description
 */
@Repository
public interface ProductDao extends ElasticsearchRepository<Product, Long> {
}