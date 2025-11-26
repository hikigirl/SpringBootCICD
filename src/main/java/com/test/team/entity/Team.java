package com.test.team.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tblTeam")
public class Team {

    @Id
    @SequenceGenerator(name = "seqTeamGen", allocationSize = 1, sequenceName = "seqTeam")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTeamGen")
    private Long seq;

    private String name;
    private String description;

}