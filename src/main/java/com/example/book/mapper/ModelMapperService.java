package com.example.book.mapper;

import org.modelmapper.ModelMapper;


public interface ModelMapperService {
	
	ModelMapper forResponse();
	ModelMapper forRequest();
}
