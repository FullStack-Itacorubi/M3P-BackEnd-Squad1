package br.senai.labmedicine.services;

import br.senai.labmedicine.dtos.Dieta.DietaAtualizacaoDTO;
import br.senai.labmedicine.dtos.Dieta.DietaCadastroDTO;
import br.senai.labmedicine.dtos.Dieta.DietaResponseDTO;
import br.senai.labmedicine.dtos.PacienteResponseDTO;
import br.senai.labmedicine.models.Dieta;
import br.senai.labmedicine.models.Paciente;
import br.senai.labmedicine.models.Pessoa;
import br.senai.labmedicine.repositories.DietaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DietaService {
    @Autowired
    private DietaRepository dietaRepository;
    @Autowired
    private PacienteService pacienteService;
    public DietaResponseDTO salvar(DietaCadastroDTO novaDieta) {
        Dieta dieta = new Dieta();
        DietaResponseDTO dietaDTO = new DietaResponseDTO();
        PacienteResponseDTO pacienteDTO = this.pacienteService.buscarPorId(novaDieta.getPaciente().getId());
        Paciente paciente = new Paciente();
        BeanUtils.copyProperties(novaDieta,dieta);
        dieta.setPaciente(paciente);
        dieta.getPaciente().setId(novaDieta.getPaciente().getId());
        dieta = this.dietaRepository.save(dieta);
        BeanUtils.copyProperties(dieta,dietaDTO);
        dietaDTO.setPaciente(pacienteDTO);
        return dietaDTO;
    }

    public DietaResponseDTO buscarDietaPorId(Long id) {
        Dieta dieta = this.dietaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Dieta não encontrada."));
        DietaResponseDTO dietaResponseDTO = new DietaResponseDTO();
        PacienteResponseDTO pacienteDTO = new PacienteResponseDTO();
        BeanUtils.copyProperties(dieta.getPaciente(),pacienteDTO);
        BeanUtils.copyProperties(dieta,dietaResponseDTO);
        dietaResponseDTO.setPaciente(pacienteDTO);
        return dietaResponseDTO;
    }

    public List<DietaResponseDTO> buscarDietaPorPaciente(String nomePaciente){
        List<Dieta> dietas;
        List<DietaResponseDTO> dietasDTO = new ArrayList<>();
        if(nomePaciente == null || nomePaciente.isEmpty()){
            dietas = this.dietaRepository.findAll();
        }else {
            dietas = this.dietaRepository.findAllByPacienteNomeCompletoOrderByDataAscHorario(nomePaciente);
        }
           for(Dieta dieta : dietas){
                PacienteResponseDTO pacienteDTO = new PacienteResponseDTO();
                DietaResponseDTO dietaDTO = new DietaResponseDTO();
                BeanUtils.copyProperties(dieta,dietaDTO);
                BeanUtils.copyProperties(dieta.getPaciente(),pacienteDTO);
                dietaDTO.setPaciente(pacienteDTO);
                dietasDTO.add(dietaDTO);
           }
           return dietasDTO;
    }

    public void deletarDieta(Long id){
        Dieta dieta = this.dietaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Dieta não encontrada."));
        this.dietaRepository.deleteById(id);
    }

    public DietaResponseDTO atualizarDieta(Long id,DietaAtualizacaoDTO dietaAtualizada) {
        Dieta dieta = this.dietaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Dieta não encontrada."));
        if (dietaAtualizada.getPaciente().getId() == null) {
            throw new EntityNotFoundException("Paciente não encontrado.");
        }
        PacienteResponseDTO pacienteDTO = this.pacienteService.buscarPorId(dietaAtualizada.getPaciente().getId());
        DietaResponseDTO dietaResponseDTO = new DietaResponseDTO();
        Paciente paciente = new Paciente();
        BeanUtils.copyProperties(dietaAtualizada,dieta);
        paciente.setId(dietaAtualizada.getPaciente().getId());
        dieta.setPaciente(paciente);
        dieta = this.dietaRepository.save(dieta);
        BeanUtils.copyProperties(dieta,dietaResponseDTO);
        dietaResponseDTO.setPaciente(pacienteDTO);
        return dietaResponseDTO;
    }
}
