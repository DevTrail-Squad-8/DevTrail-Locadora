package com.solutis.locadoraVeiculos.controller;

import com.solutis.locadoraVeiculos.dtos.carroDtos.CarroDto;
import com.solutis.locadoraVeiculos.dtos.carroDtos.LerCarroDto;
import com.solutis.locadoraVeiculos.service.CarroService;
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

import java.util.List;

@Controller
@RequestMapping("/api/carros")
@Tag(name = "Carro", description = "Endpoints para Gerenciamento de Carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

    @PostMapping(
            consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Adicionar um nov Carro",
            description = "Adiciona um novo carro passando uma representação JSON ou XML do carro!",
            tags = {"Carro"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = CarroDto.class))
                    ),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<LerCarroDto> cadastrarCarro (@RequestBody CarroDto carroDTO){
        var carroCriado = carroService.criarCarro(carroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(carroCriado);
    }

    @GetMapping(
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Encontrar todos os carros", description = "Encontrar todos os carros",
            tags = {"Carro"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = LerCarroDto.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<List<LerCarroDto>> retornarCarros (){
        var listaDeCarros = carroService.retornarTodosOsCarros();
        return ResponseEntity.status(HttpStatus.OK).body(listaDeCarros);
    }

    @GetMapping(value = "/{id}",
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @Operation(summary = "Encontrar um Carro", description = "Encontrar um Carro",
            tags = {"Carro"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = LerCarroDto.class))
                    ),
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<LerCarroDto> retornarCarroPorId (@PathVariable(value = "id") Long id){
        var carroRetornado = carroService.retornarCarroPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(carroRetornado);

    }

    @DeleteMapping(value = "/{id}")
    @Operation(summary = "Deletar um carro",
            description = "Deleta um carro passando uma representação JSON ou XML do carro!",
            tags = {"Carro"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = @Content),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
            }
    )
    public ResponseEntity<?> deletarCarroPorId (@PathVariable(value = "id") Long id){
        carroService.deletarCarro(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    public static class AdicionarAcessorioDTO {
      public long idAcessorio;
      public long idCarro;
    }

  @PostMapping(
      consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
      produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
      value = "/acessorio")
  @Operation(summary = "Adicionar um nov Carro",
      description = "Adiciona um novo carro passando uma representação JSON ou XML do carro!",
      tags = {"Carro"},
      responses = {
          @ApiResponse(description = "Success", responseCode = "200",
              content = @Content(schema = @Schema(implementation = CarroDto.class))
          ),
          @ApiResponse(description = "Bad Request", responseCode = "400", content = @Content),
          @ApiResponse(description = "Unauthorized", responseCode = "401", content = @Content),
          @ApiResponse(description = "Internal Error", responseCode = "500", content = @Content)
      }
  )
  public ResponseEntity<LerCarroDto> adicionarAcessorio (@RequestBody AdicionarAcessorioDTO dto){
      var carro = carroService.adicionarAcessorio(dto.idCarro, dto.idAcessorio);
      return ResponseEntity.status(HttpStatus.CREATED).body(new LerCarroDto(carro));
  }
}
