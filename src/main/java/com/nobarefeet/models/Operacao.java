package com.nobarefeet.models;

import com.nobarefeet.enums.TipoOperacaoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Data
@Table(name = " tb_operacao")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Operacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_operacao")
    private Integer idOperacao;

    @Column(name = "tipo_operacao")
    private TipoOperacaoEnum tipoOperacao;

    @Column(name = "id_produto")
    private Integer idProduto;

    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column(name = "qtd")
    private Integer qtd;

    @Column(name = "custo")
    private Integer custo;

    @Column(name = "frete")
    private Integer frete;

    @Column(name = "custo_total")
    private Integer custoTotal;

    @Column(name = "data_cadastro")
    private OffsetDateTime dataCadastro;

    @Column(name = "data_alteracao")
    private OffsetDateTime dataAlteracao;
}
