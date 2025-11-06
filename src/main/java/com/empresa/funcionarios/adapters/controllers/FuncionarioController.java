package com.empresa.funcionarios.adapters.controllers;

import com.empresa.funcionarios.application.funcionario.dto.FuncionarioRequestDTO;
import com.empresa.funcionarios.application.funcionario.dto.FuncionarioResponseDTO;
import com.empresa.funcionarios.application.funcionario.service.FuncionarioServiceImpl;
import com.empresa.funcionarios.application.funcionario.usecase.*;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/funcionarios_db")
@RequiredArgsConstructor
public class FuncionarioController {

    private final CreateFuncionarioUseCase create;
    private final FindAllFuncionariosUseCase findAll;
    private final FindFuncionarioByIdUserCase findByFuncionario;
    private final DeleteFuncionarioUseCase delete;
    private final UpdateFuncionarioUseCase update;

    @PostMapping
    public ResponseEntity<FuncionarioResponseDTO> creat(@Valid @RequestBody FuncionarioRequestDTO request, UriComponentsBuilder uriBuilder) {
        FuncionarioResponseDTO response = create.execute(request);
        var uri = uriBuilder.path("/funcionarios_db/{id}").buildAndExpand(response.getId()).toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<FuncionarioResponseDTO>> findAll(@PageableDefault(size = 10)Pageable pageable) {
        return ResponseEntity.ok(findAll.execute(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(findByFuncionario.execute(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FuncionarioResponseDTO> update(@PathVariable Long id, @RequestBody @Valid FuncionarioRequestDTO request){
        return ResponseEntity.ok(update.execute(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delet(@PathVariable Long id) {
        delete.execute(id);
        return ResponseEntity.noContent().build();
    }

}
