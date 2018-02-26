package com.ray.es.people.Service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.ray.es.people.model.Man;
import com.ray.es.people.repository.ManRepository;

@Component("manService")
public class ManServiceImpl implements ManService {

	@Resource(name = "manRepository")
	private ManRepository manRepository;

	@Override
	public Man findById(String id) {
		
		return manRepository.findOne(id) ;
	}
	
}
