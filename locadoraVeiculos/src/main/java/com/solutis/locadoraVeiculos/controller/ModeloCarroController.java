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
import com.solutis.locadoraVeiculos.dtos.modelosCarroDto.LerModeloCarroDto;
import com.solutis.locadoraVeiculos.dtos.modelosCarroDto.ModeloCarroDto;
import com.solutis.locadoraVeiculos.service.ModeloCarroService;

import java.util.List;

@Controller
@RequestMapping("/api/modelos-carros")
@Tag(name = "ModeloCarro", description = "Endpoints para Gerenciamento de Modelos de Carro")
public class ModeloCarroController {

    @Autowired
    private ModeloCarroService modeloCarroService;


    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Adicionar um novo Modelo de Carro",
            description = "Adicionar um novo Modelo de Carro passando uma representação JSON ou XML do Modelo!",
            tags = {"ModeloCarro"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = ModeloCarroDto.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<LerModeloCarroDto> cadastrarModeloCarro(@RequestBody ModeloCarroDto modeloDto){
        var modeloCarroCriado = modeloCarroService.criarModeloCarro(modeloDto);
        return  ResponseEntity.status(HttpStatus.CREATED).body(modeloCarroCriado);
    }

    @GetMapping(
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Encontrar todos os modelos de carro", description = "Encontrar todos os modelos de carro",
            tags = {"ModeloCarro"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = LerModeloCarroDto.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public  ResponseEntity<List<LerModeloCarroDto>> retornarTodosOsModelosCarro(){
        var listaRetornada = modeloCarroService.retornarTodosOsModelosCarro();
        return  ResponseEntity.status(HttpStatus.OK).body(listaRetornada);
    }

    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Encontrar um modelo de carro", description = "Encontrar um modelo de carro",
            tags = {"ModeloCarro"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = LerModeloCarroDto.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public  ResponseEntity<LerModeloCarroDto> retornarModelosCarroPorId(@PathVariable(value = "id") Long id){
        var modeloRetornado = modeloCarroService.retornarModeloCarroPorId(id);
        return  ResponseEntity.status(HttpStatus.CREATED).body(modeloRetornado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um modelo de carro",
            description = "Deletar um Modelo de Carro passando uma representação JSON ou XML do Modelo!",
            tags = {"ModeloCarro"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public  ResponseEntity<?> deletarCarroPorId(@PathVariable(value = "id") Long id){
        modeloCarroService.deletarModeloCarroPorId(id);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}

