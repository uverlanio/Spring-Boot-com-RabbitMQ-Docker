package io.github.cursodsousa.msclientes.application;

import io.github.cursodsousa.msclientes.application.representation.ClienteSaveRequest;
import io.github.cursodsousa.msclientes.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
@Slf4j
public class ClientesController {

    private final ClienteService service;
    @GetMapping
    public String status(){
        return "ok";
    }
    @PostMapping
    public ResponseEntity save(@RequestBody ClienteSaveRequest request){
        Cliente cliente = request.toModel();
        service.save(cliente);

        //Construir um url dinâmica
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(cliente.getCpf())
                .toUri();

        return ResponseEntity.created(headerLocation).build();
    }
    @GetMapping(params = "cpf")
    public ResponseEntity dadosCliente(@RequestParam("cpf") String cpf){

        Optional<Cliente> cliente = service.getbyCpf(cpf);

        if(cliente.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(cliente);

    }
}
