package org.serratec.api.domain;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O pedido tem que ter uma descrição.")
    @Size(min = 5, max = 100, message = "A descrição deve ter entre 5 e 100 caracteres.")
    @Column(nullable = false)
    private String descricao;

    @NotNull(message = "O valor total do pedido deve ser informado.")
    @DecimalMin(value = "0.01", message = "O valor total deve ser no mínimo R$ 0,01.")
    @Column(nullable = false)
    private Double total;

    @NotNull(message = "A data do pedido deve ser informada.")
    @Column(name = "data_pedido", nullable = false)
    private LocalDate dataPedido;

    public Pedido() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }
    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }
}