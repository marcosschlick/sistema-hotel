package com.hotel.gerenciador.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.hotel.gerenciador.utils.StatusManutencao;
import com.hotel.gerenciador.utils.Formatter;
import com.hotel.gerenciador.utils.Validator;

public class Manutencao {
    private int id;
    private Integer idQuarto;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private String descricao;
    private StatusManutencao status;
    private Integer idFuncionario;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataAtualizacao;

    public Manutencao(Integer idQuarto, LocalDate dataInicio, LocalDate dataFim, String descricao, 
                      StatusManutencao status, Integer idFuncionario) {
        setIdQuarto(idQuarto);
        setDataInicio(dataInicio);
        setDataFim(dataFim);
        setDescricao(descricao);
        setStatus(status);
        setIdFuncionario(idFuncionario);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        Validator.validatePositiveId(id, "ID da manutenção");
        this.id = id;
    }

    public Integer getIdQuarto() {
        return idQuarto;
    }
    public void setIdQuarto(Integer idQuarto) {
        Validator.validateNotNull(idQuarto, "ID do quarto");
        this.idQuarto = idQuarto;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }
    public void setDataInicio(LocalDate dataInicio) {
        Validator.validateNotNull(dataInicio, "Data de início");
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }
    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        Validator.validateDescription(descricao, 255);
        this.descricao = descricao == null ? "" : descricao.trim();
    }

    public StatusManutencao getStatus() {
        return status;
    }
    public void setStatus(StatusManutencao status) {
        Validator.validateEnum(status, "Status da manutenção");
        this.status = status;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }
    public void setIdFuncionario(Integer idFuncionario) {
        Validator.validateNotNull(idFuncionario, "ID do funcionário");
        this.idFuncionario = idFuncionario;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(LocalDateTime dataCriacao) {
        if (dataCriacao != null) {
            Validator.validateNotFutureDateTime(dataCriacao);
        }
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }
    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        if (dataAtualizacao != null) {
            Validator.validateNotFutureDateTime(dataAtualizacao);
        }
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString() {
        return "Manutencao{" +
                "id=" + id +
                ", idQuarto=" + idQuarto +
                ", dataInicio=" + Formatter.formatDate(dataInicio) +
                ", dataFim=" + Formatter.formatDate(dataFim) +
                ", descricao='" + descricao + '\'' +
                ", status=" + status +
                ", idFuncionario=" + idFuncionario +
                ", dataCriacao=" + Formatter.formatDateTime(dataCriacao) +
                ", dataAtualizacao=" + Formatter.formatDateTime(dataAtualizacao) +
                '}';
    }
}
