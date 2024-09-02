package com.solutis.locadoraVeiculos.controller;

import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.solutis.locadoraVeiculos.dtos.ApoliceDto;
import com.solutis.locadoraVeiculos.service.ApoliceSeguroService;

@RestController
@RequestMapping("/api/apolices")
@Tag(name = "Apolice", description = "Endpoints para Gerenciamento de Apolices")
public class ApoliceController {


    @Autowired
    private ApoliceSeguroService apoliceSeguroService;

    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Adicionar um novo Apolice",
            description = "Adiciona um novo Apolice passando uma representação JSON ou XML do Apolice!",
            tags = {"Apolice"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = ApoliceDto.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public ApoliceDto cadastrarApolice (@RequestBody ApoliceDto apoliceDto) {

        return apoliceSeguroService.criarApolice(apoliceDto);

    }

    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Encontrar um Apolice", description = "Encontrar um Apolice",
            tags = {"Apolice"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = ApoliceDto.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ApoliceDto buscarApoliceById (@PathVariable(value = "id") Long id) {
        return apoliceSeguroService.retornarApolicesById(id);

    }

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Encontrar todos Apolices", description = "Encontrar todos Apolices",
            tags = {"Apolice"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = ApoliceDto.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<List<ApoliceDto>> buscarTodosAlugueis () {
        List<ApoliceDto> listaApoliceDto = apoliceSeguroService.retornarTodasApolices();
        return ResponseEntity.ok(listaApoliceDto);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um Apolice",
            description = "Adiciona um Apolice passando uma representação JSON ou XML do Apolice!",
            tags = {"Apolice"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> deletarApolice (@PathVariable(value = "id") Long id) {
        apoliceSeguroService.deletarApolice(id);
        return ResponseEntity.noContent().build();

    }

}
