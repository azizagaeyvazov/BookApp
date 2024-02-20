package com.example.book.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
public class ModelMapperManager implements ModelMapperService {

	@Override
	public ModelMapper forResponse() {

		ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper;
    }

	@Override
	public ModelMapper forRequest() {

		ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
        return modelMapper;
    }
}