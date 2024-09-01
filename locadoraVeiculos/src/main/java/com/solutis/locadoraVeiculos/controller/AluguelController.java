package com.solutis.locadoraVeiculos.controller;

import com.solutis.locadoraVeiculos.dtos.aluguelDtos.CriarAluguelDto;
import com.solutis.locadoraVeiculos.dtos.aluguelDtos.LerAluguelDto;
import com.solutis.locadoraVeiculos.service.AluguelService;
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


import java.util.List;


@RestController
@RequestMapping("/api/alugueis")
@Tag(name = "Aluguel", description = "Endpoints para Gerenciamento de Alugueis")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Adicionar um novo Aluguel",
            description = "Adiciona um novo Aluguel passando uma representação JSON ou XML do Aluguel!",
            tags = {"Aluguel"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = CriarAluguelDto.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public LerAluguelDto cadastrarAluguel (@RequestBody CriarAluguelDto criarAluguelDto) {

        return aluguelService.criarAluguel(criarAluguelDto);
    }

    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Encontrar um Aluguel", description = "Encontrar um Aluguel",
            tags = {"Aluguel"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = LerAluguelDto.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public LerAluguelDto buscarAluguelById (@PathVariable(value = "id") Long id) {

        return aluguelService.retornarAlugueisById(id);

    }

    @GetMapping(
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Encontrar todos os Alugueis", description = "Encontrar todos os Alugueis",
            tags = {"Aluguel"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = LerAluguelDto.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            })
    public ResponseEntity<List<LerAluguelDto>> buscarTodosAlugueis () {

        List<LerAluguelDto> listaAluguelDto = aluguelService.retornarTodosAlugueis();
        return ResponseEntity.ok(listaAluguelDto);

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar um Aluguel",
            description = "Deleta um passando uma representação JSON ou XML do Aluguel!",
            tags = {"Aluguel"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> deletarAlugueis (@PathVariable(value = "id") Long id) {

        aluguelService.deletarAluguel(id);
        return ResponseEntity.noContent().build();

    }
}