package com.empresa.funcionarios.infrastructure.controllers;

import com.empresa.funcionarios.application.dto.FuncionarioDTO;
import com.empresa.funcionarios.application.dto.FuncionarioReturnDTO;
import com.empresa.funcionarios.application.response.ApiResponse;
import com.empresa.funcionarios.application.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios_db")
public class FuncionarioController {

    private FuncionarioService service;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.service = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<FuncionarioReturnDTO>> created(@Valid @RequestBody FuncionarioDTO funcionarioDTO) {
        FuncionarioReturnDTO funcionarioReturnDTO = service.created(funcionarioDTO);
        ApiResponse<FuncionarioReturnDTO> response =
                new ApiResponse<>("Funcionário cadastrado com sucesso!", funcionarioReturnDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<FuncionarioReturnDTO>> findAll() {
        List<FuncionarioReturnDTO> funcionarios = service.findAll();
        ApiResponse<List<FuncionarioReturnDTO>> response =
                new ApiResponse<>("Funcionários recuperados com sucesso", funcionarios);

        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<FuncionarioReturnDTO>> findById(@PathVariable Long id) {
        FuncionarioReturnDTO funcionario = service.findById(id);

        ApiResponse<FuncionarioReturnDTO> response =
                new ApiResponse<>("Funcionário encontrado com sucesso!", funcionario);

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<FuncionarioReturnDTO>> update(@PathVariable Long id, @RequestBody @Valid  FuncionarioDTO funcionarioDTO){
        FuncionarioReturnDTO funcionario = service.update(id, funcionarioDTO);

        ApiResponse<FuncionarioReturnDTO> response =
                new ApiResponse<>("Funcionário atualizado com sucesso!", funcionario);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delet(@PathVariable Long id) {
        service.delet(id);

        ApiResponse<Void> response = new ApiResponse<>("Funcionário deletado com sucesso!", null);
        return ResponseEntity.ok(response);
    }

}
