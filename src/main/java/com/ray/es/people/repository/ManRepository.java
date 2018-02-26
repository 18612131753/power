package com.ray.es.people.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import com.ray.es.people.model.Man;

@Component("manRepository")
public interface ManRepository extends ElasticsearchRepository<Man,String>{

}
