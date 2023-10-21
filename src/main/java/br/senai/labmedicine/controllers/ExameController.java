package br.senai.labmedicine.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.senai.labmedicine.dtos.exame.ExameCadastroDTO;
import br.senai.labmedicine.dtos.exame.ExameEdicaoDTO;
import br.senai.labmedicine.dtos.exame.ExameResponseDTO;
import br.senai.labmedicine.services.ExameService;

@RestController
@RequestMapping("/exames")
public class ExameController {

	@Autowired
	private ExameService exameService;

	@GetMapping
	public ResponseEntity<List<ExameResponseDTO>> buscar(@RequestBody String nomeUsuario) {
		return new ResponseEntity<>(this.exameService.buscarExamePorPaciente(nomeUsuario), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ExameResponseDTO> buscarPorId(@PathVariable Long id) {
		return new ResponseEntity<>(this.exameService.buscarExamePorId(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<ExameResponseDTO> salvar(@RequestHeader(value = "idUsuarioLogado",required = true)Long idUsuarioLogado,@RequestBody ExameCadastroDTO exameDTO) {
		return new ResponseEntity<>(this.exameService.salvar(idUsuarioLogado,exameDTO), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ExameResponseDTO> editar(@RequestHeader(value = "idUsuarioLogado",required = true)Long idUsuarioLogado,@PathVariable Long id, @RequestBody ExameEdicaoDTO exameDTO) {
		return new ResponseEntity<>(this.exameService.atualizarExame(idUsuarioLogado,id, exameDTO), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@RequestHeader(value = "idUsuarioLogado",required = true)Long idUsuarioLogado,@PathVariable Long id) {
		this.exameService.deletarExame(idUsuarioLogado,id);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
