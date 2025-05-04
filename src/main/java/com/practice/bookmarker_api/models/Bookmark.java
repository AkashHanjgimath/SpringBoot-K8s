package com.practice.bookmarker_api.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="bookmarks")
public class Bookmark {

    @Id
    @SequenceGenerator(name="bm_id_seq_gen",sequenceName = "bm_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "bm_id_seq_gen")
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String url;
    private Instant createdAt;

}
