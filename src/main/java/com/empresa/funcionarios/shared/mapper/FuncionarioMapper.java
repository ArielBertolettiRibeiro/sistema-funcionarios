package com.empresa.funcionarios.shared.mapper;

import com.empresa.funcionarios.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FuncionarioMapper {

    private final ModelMapper mapper;

}
