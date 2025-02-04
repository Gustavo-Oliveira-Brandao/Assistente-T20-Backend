package ob.gustavo.assistentet20spring.services;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import ob.gustavo.assistentet20spring.exceptions.RegistroNaoEncontrado;
import ob.gustavo.assistentet20spring.models.PersonagemT20;
import ob.gustavo.assistentet20spring.models.PoderT20;
import ob.gustavo.assistentet20spring.repositories.PersonagemT20Repository;
import ob.gustavo.assistentet20spring.repositories.PoderT20Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonagemT20Service {

    private final PersonagemT20Repository personagemT20Repository;
    private final PoderT20Repository poderT20Repository;
    public PersonagemT20Service(PersonagemT20Repository personagemT20Repository, PoderT20Repository poderT20Repository){
        this.personagemT20Repository = personagemT20Repository;
        this.poderT20Repository = poderT20Repository;
    }

    public List<PersonagemT20> listar(){
        return personagemT20Repository.findAll();
    }

    public PersonagemT20 exibirPorId(@NotNull @Positive Long id){
        return personagemT20Repository.findById(id).orElseThrow(() -> new RegistroNaoEncontrado(id));
    }

    public PersonagemT20 criar(@Valid @NotNull PersonagemT20 personagemT20){
        personagemT20.getAtributos().forEach(atributo -> {
            atributo.setPersonagem(personagemT20);
        });
        personagemT20.getPericias().forEach(pericia -> {
            pericia.setPersonagem(personagemT20);
        });

        return personagemT20Repository.save(personagemT20);
    }

    public PersonagemT20 atualizar(@NotNull @Positive Long id, @Valid @NotNull PersonagemT20 personagemT20){
        return personagemT20Repository.findById(id).map(personagem -> {
            personagem.setNome(personagemT20.getNome());
            personagem.setRaca(personagemT20.getRaca());
            personagem.setClasse(personagemT20.getClasse());
            personagem.setOrigem(personagemT20.getOrigem());
            personagem.setDivindade(personagemT20.getDivindade());
            personagem.setAtributos(personagemT20.getAtributos());
            personagem.setPericias(personagemT20.getPericias());
            personagem.setDefesa(personagem.getDefesa());
            personagem.setVida(personagemT20.getVida());
            personagem.setMana(personagemT20.getMana());
            personagem.setDeslocamento(personagemT20.getDeslocamento());

            return personagemT20Repository.save(personagem);
        }).orElseThrow(() -> new RegistroNaoEncontrado(id));
    }

    public void deletar(@NotNull @Positive Long id){
        personagemT20Repository.delete(personagemT20Repository.findById(id).orElseThrow(() -> new RegistroNaoEncontrado(id)));
    }

    public PoderT20 adicionarPoder(@NotNull @Positive Long idPersonagem, @NotNull @Valid PoderT20 poderT20){
        PersonagemT20 personagem = exibirPorId(idPersonagem);
        poderT20.setPersonagem(personagem);
        poderT20.getTags().forEach(tag -> {
            tag.setPoder(poderT20);
        });
        poderT20.getTopicos().forEach(topico -> {
            topico.setPoder(poderT20);
        });
        return poderT20Repository.save(poderT20);
    }

    public void removerPoder(@NotNull @Positive Long id){
        poderT20Repository.delete(poderT20Repository.findById(id).orElseThrow(() -> new RegistroNaoEncontrado(id)));
    }

}
