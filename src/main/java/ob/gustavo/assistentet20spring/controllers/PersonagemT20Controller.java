package ob.gustavo.assistentet20spring.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import ob.gustavo.assistentet20spring.models.PersonagemT20;
import ob.gustavo.assistentet20spring.models.PoderT20;
import ob.gustavo.assistentet20spring.services.PersonagemT20Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/t20/personagens")
@Validated
public class PersonagemT20Controller {

    private final PersonagemT20Service personagemT20Service;

    public PersonagemT20Controller(PersonagemT20Service personagemT20Service){
        this.personagemT20Service = personagemT20Service;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public List<PersonagemT20> listar(){
        return personagemT20Service.listar();
    }

    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public PersonagemT20 exibirPorId(@PathVariable @NotNull @Positive Long id){
        return personagemT20Service.exibirPorId(id);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:5173")
    public PersonagemT20 criar(@RequestBody @NotNull @Valid PersonagemT20 personagemT20){
        System.out.println(personagemT20);
        return personagemT20Service.criar(personagemT20);
    }

    @PutMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public PersonagemT20 atualizar(@PathVariable @NotNull @Positive Long id, @RequestBody @NotNull @Valid PersonagemT20 personagemT20){
        return personagemT20Service.atualizar(id, personagemT20);
    }
    @DeleteMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public void deletar(@PathVariable @NotNull @Positive Long id){
        personagemT20Service.deletar(id);
    }

    @PostMapping("/poderes")
    @CrossOrigin(origins = "http://localhost:5173")
    public PoderT20 adicionarPoder(@RequestParam @NotNull @Positive Long idPersonagem,@RequestBody @NotNull @Valid PoderT20 poderT20){
        return personagemT20Service.adicionarPoder(idPersonagem, poderT20);
    }

    @DeleteMapping("/poderes/{id}")
    @CrossOrigin(origins = "http://localhost:5173")
    public void removerPoder(@PathVariable @NotNull @Positive Long id){
        personagemT20Service.removerPoder(id);
    }
}
