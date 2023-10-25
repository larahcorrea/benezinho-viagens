package br.com.fiap.domain.entity;

import br.com.fiap.Main;
import br.com.fiap.domain.entity.transportavel.Transportavel;
import br.com.fiap.domain.service.EnderecoService;
import br.com.fiap.infra.security.entity.Pessoa;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;


public class Viagem {


    private Long id;


    private Pessoa cliente;


    private Set<Transportavel> transportaveis = new LinkedHashSet<>();

    private String origem;

    private String destino;


    private LocalDateTime saida;


    private LocalDateTime chegada;


    public Viagem() {
    }

    public Viagem(Long id, Pessoa cliente, Set<Transportavel> transportaveis, String origem, String destino, LocalDateTime saida, LocalDateTime chegada) {
        this.setId(id);
        this.setCliente(cliente);
        this.transportaveis = Objects.nonNull(transportaveis) && transportaveis.size() > 0 ? transportaveis : new LinkedHashSet<>();
        this.origem = origem;
        this.destino = destino;
        this.setSaida(saida);
        this.setChegada(chegada);
    }


    public Viagem(Long id, Pessoa cliente, Set<Transportavel> transportaveis, Endereco origem, Endereco destino, LocalDateTime saida, LocalDateTime chegada) {
        this.setId(id);
        this.setCliente(cliente);
        this.transportaveis = Objects.nonNull(transportaveis) && transportaveis.size() > 0 ? transportaveis : new LinkedHashSet<>();
        this.origem = origem.getCep();
        this.destino = destino.getCep();
        this.setSaida(saida);
        this.setChegada(chegada);
    }


    public Viagem addTransportavel(Transportavel t) {
        transportaveis.add(t);
        return this;
    }


    public Viagem removeTransportavel(Transportavel t) {
        transportaveis.remove(t);
        return this;
    }

    public Set<Transportavel> getTransportaveis() {
        return Collections.unmodifiableSet(transportaveis);
    }


    public Long getId() {
        return id;
    }

    public Viagem setId(Long id) {
        this.id = id;
        return this;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public Viagem setCliente(Pessoa cliente) {
        this.cliente = cliente;
        return this;
    }

    public Endereco getOrigem() {
        var service = EnderecoService.build(Main.PERSISTENCE_UNIT);
        return service.findByCEP(origem);
    }


    public Endereco getDestino() {
        var service = EnderecoService.build(Main.PERSISTENCE_UNIT);
        return service.findByCEP(destino);
    }


    public Viagem setOrigem(String origem) {
        this.origem = origem;
        return this;
    }


    public Viagem setDestino(String destino) {
        this.destino = destino;
        return this;
    }

    public LocalDateTime getSaida() {
        return saida;
    }

    public Viagem setSaida(LocalDateTime saida) {
        this.saida = saida;
        return this;
    }

    public LocalDateTime getChegada() {
        return chegada;
    }

    public Viagem setChegada(LocalDateTime chegada) {
        this.chegada = chegada;
        return this;
    }

    @Override
    public String toString() {
        return "Viagem{" +
                "id=" + getId() +
                ", cliente=" + getCliente() +
                ", transportavel=" + getTransportaveis() +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", saida=" + getSaida() +
                ", chegada=" + getChegada() +
                '}';
    }
}
