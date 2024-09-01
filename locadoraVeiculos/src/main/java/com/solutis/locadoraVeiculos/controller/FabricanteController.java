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
import com.solutis.locadoraVeiculos.dtos.fabricantesDto.FabricanteDto;
import com.solutis.locadoraVeiculos.dtos.fabricantesDto.LerFabricanteDto;
import com.solutis.locadoraVeiculos.service.FabricanteService;

import java.util.List;

@Controller
@RequestMapping("api/fabricantes")
@Tag(name = "Fabricante", description = "Endpoints para Gerenciamento de Fabricantes")
public class FabricanteController {
    @Autowired
    private FabricanteService fabricanteService;

    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Adicionar um novo Fabricante",
            description = "Adiciona um novo fabricante passando uma representação JSON ou XML do fabricante!",
            tags = {"Fabricante"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = FabricanteDto.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<FabricanteDto>  cadastrar (@RequestBody FabricanteDto fabricanteDto) {
        var fabricanteCriadoDto = fabricanteService.criarFabricante(fabricanteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(fabricanteCriadoDto);
    }

    @GetMapping(
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Encontrar todos Fabricantes", description = "Encontrar todos Fabricantes",
            tags = {"Fabricante"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = LerFabricanteDto.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<List<LerFabricanteDto>> retornar () {
        var listaRetorna = fabricanteService.retornar();
       return ResponseEntity.status(HttpStatus.OK).body(listaRetorna);
   }

   @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Encontrar um Fabricante", description = "Encontrar um Fabricante",
            tags = {"Fabricante"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = LerFabricanteDto.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> retornarPorId (@PathVariable Long id){
       var fabricanteDto = fabricanteService.retornarPorId(id);
       return ResponseEntity.status(HttpStatus.OK).body(fabricanteDto);
   }

   @DeleteMapping("/{id}")
   @Operation(summary = "Deletar um Fabricante",
           description = "Deleta um fabricante passando uma representação JSON ou XML do fabricante!",
           tags = {"Fabricante"},
           responses = {
                   @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                   @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                   @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                   @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                   @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
           }
   )
    public ResponseEntity<?> deletePorId(@PathVariable Long id){
        fabricanteService.deletarPorId(id);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   }
}

