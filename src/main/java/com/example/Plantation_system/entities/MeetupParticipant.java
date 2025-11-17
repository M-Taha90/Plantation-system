package com.example.Plantation_system.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "meetup_participants",
       uniqueConstraints = @UniqueConstraint(columnNames = {"meetup_id","participant_id"}))
@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(onlyExplicitlyIncluded = true)

public class MeetupParticipant {
    @EmbeddedId
    private MeetupParticipantId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("meetupId")
    @JoinColumn(name = "meetup_id")
    private Meetup meetup;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("participantId")
    @JoinColumn(name = "participant_id")
    private User participant;

    private String status = "JOINED";

    @CreationTimestamp
    private Instant joinedAt;

    private Instant attendedAt;

    private BigDecimal hoursContributed;

    @Column(columnDefinition = "text")
    private String note;
}
