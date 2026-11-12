package com.encurtadorurlk.link.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "url")
@Data
@NoArgsConstructor
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "url_raiz", length = 20)
    private String urlRaiz;

    @Column(name = "url_encurtada", length = 40)
    private String  urlEncurtada;

    private LocalDateTime data_expiracao;
}
