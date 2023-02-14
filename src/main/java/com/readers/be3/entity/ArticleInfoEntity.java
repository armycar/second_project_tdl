package com.readers.be3.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.DynamicInsert;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamicInsert
@Entity
@Table(name = "article_info")
public class ArticleInfoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ai_seq") private Long aiSeq;
    @Column(name = "ai_title") private String aiTitle;
    @Column(name = "ai_content") private String aiContent;
    @Column(name = "ai_reg_dt") private LocalDateTime aiRegDt;
    @Column(name = "ai_mod_dt") private LocalDateTime aiModDt;
    @Column(name = "ai_status") private Integer aiStatus;
    @Column(name = "ai_purpose") private Integer aiPurpose;
    @Column(name = "ai_public") private Integer aiPublic;
    @Column(name = "ai_ui_seq") private Long aiUiSeq;
}
