package com.example.book.mapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
public class ModelMapperManager implements ModelMapperService {

	@Override
	public ModelMapper forResponse() {

		ModelMapper modelMapper = new ModelMapper();
		if (modelMapper != null) {
			modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.LOOSE);
			return modelMapper;
		} else {
			throw new IllegalStateException("modelMapper is not initialized");
		}
	}

	@Override
	public ModelMapper forRequest() {

		ModelMapper modelMapper = new ModelMapper();
		if (modelMapper != null) {
			modelMapper.getConfiguration().setAmbiguityIgnored(true).setMatchingStrategy(MatchingStrategies.STANDARD);
			return modelMapper;
		} else {
			throw new IllegalStateException("modelMapper is not initialized");
		}
	}
}