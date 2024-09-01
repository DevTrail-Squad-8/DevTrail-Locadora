package com.solutis.locadoraVeiculos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.solutis.locadoraVeiculos.dtos.acessorioDto.AcessorioDto;
import com.solutis.locadoraVeiculos.dtos.acessorioDto.LerAcessorioDto;
import com.solutis.locadoraVeiculos.service.AcessorioService;

import java.util.List;

@Controller
@RequestMapping("api/acessorios")
@Tag(name = "Acessorio", description = "Endpoints para Gerenciamento de Acessorios")
public class AcessorioController {

    @Autowired
    private AcessorioService acessorioService;

    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Adicionar um novo Acessorio",
            description = "Adiciona um novo Acessorio passando uma representação JSON ou XML do Acessorio!",
            tags = {"Acessorio"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = AcessorioDto.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<AcessorioDto> criar (@RequestBody AcessorioDto acessorioDto) {
        var acessorioCriadoDto = acessorioService.criarAcessorio(acessorioDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(acessorioCriadoDto);
    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Encontrar todos os Acessorios", description = "Encontrar todos os Acessorios",
            tags = {"Acessorio"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = LerAcessorioDto.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<List<LerAcessorioDto>> retornarTodos () {
        var listaRetornada = acessorioService.retornarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(listaRetornada);
    }


    @GetMapping(value = "{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Encontrar um Acessorio", description = "Encontrar um Acessorio",
            tags = {"Acessorio"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = LerAcessorioDto.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?>  retornarPorId (@PathVariable Long id) {
        var acessorioDto = acessorioService.retornaPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(acessorioDto);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um Acessorio",
            description = "Deleta um Acessorio passando uma representação JSON ou XML do Acessorio!",
            tags = {"Acessorio"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> deletarPorId (@PathVariable Long id) {
        acessorioService.deletarPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

