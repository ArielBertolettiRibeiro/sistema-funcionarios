package com.empresa.funcionarios.application.funcionario.usecase;

import com.empresa.funcionarios.application.funcionario.dto.FuncionarioRequestDTO;
import com.empresa.funcionarios.application.funcionario.dto.FuncionarioResponseDTO;
import com.empresa.funcionarios.application.funcionario.service.FuncionarioService;
import com.empresa.funcionarios.domain.model.Funcionario;
import com.empresa.funcionarios.domain.repository.FuncionarioRepository;
import com.empresa.funcionarios.shared.mapper.FuncionarioMapper;
import com.empresa.funcionarios.infrastructure.persistence.JpaFuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateFuncionarioUseCase {

    private final FuncionarioRepository repository;
    private final FuncionarioMapper mapper;

    public FuncionarioResponseDTO execute(FuncionarioRequestDTO request) {
        var funcionario = Funcionario.criar(
                request.getNome(),
                request.getCargo(),
                request.getSalario(),
                request.getDataEmissao()
        );

        funcionario.setActive(true);

        return mapper.toResponse(repository.save(funcionario));
    }
}
