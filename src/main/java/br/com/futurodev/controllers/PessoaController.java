package br.com.futurodev.controllers;

import br.com.futurodev.model.PessoaModel;
import br.com.futurodev.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pessoa")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @RequestMapping(value = "/{nome}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String mostrarnome(@PathVariable String nome) {
        return "O seu nome é " + nome;
    }

    @PostMapping(value = "/", produces = "application/json")
    public ResponseEntity<PessoaModel> cadastrar(@RequestBody PessoaModel pessoa) {
        PessoaModel modelo = pessoaRepository.save(pessoa);
        return new ResponseEntity<PessoaModel>(modelo, HttpStatus.CREATED);
    }

    @PutMapping(value = "/", produces = "application/json")
    public ResponseEntity<PessoaModel> atualizar(@RequestBody PessoaModel pessoa) {
        PessoaModel modelo = pessoaRepository.save(pessoa);
        return new ResponseEntity<PessoaModel>(modelo, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/")
    @ResponseBody
    public ResponseEntity<String> delete (@RequestParam Long idPessoa) {
        pessoaRepository.deleteById(idPessoa);
        return new ResponseEntity<String>("Usuário deletado com sucesso!", HttpStatus.OK);

    }

    @GetMapping(value = "/buscarPorNome", produces = "application/json")
    public ResponseEntity<List<PessoaModel>> getContatoById(@RequestParam(name = "nome") String nome){
        List<PessoaModel> pessoa = pessoaRepository.getPessoaByName(nome);
        return new ResponseEntity<List<PessoaModel>>(pessoa,HttpStatus.OK);

    }



}
