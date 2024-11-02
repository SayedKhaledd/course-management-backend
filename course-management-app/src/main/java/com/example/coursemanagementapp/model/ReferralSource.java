package com.example.coursemanagementapp.model;

import com.example.backendcoreservice.model.AbstractEntity;
import com.example.coursemanagementapp.enums.GenericEnumConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "referral_source")
public class ReferralSource extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "referral_source_id_sequence")
    @SequenceGenerator(name = "referral_source_id_sequence", sequenceName = "referral_source_id_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "source")
    @Convert(converter = ReferralSourceConverter.class)
    private com.example.coursemanagementapp.enums.ReferralSource source;

    public static class ReferralSourceConverter extends GenericEnumConverter<com.example.coursemanagementapp.enums.ReferralSource> {
        public ReferralSourceConverter() {
            super(com.example.coursemanagementapp.enums.ReferralSource.class);
        }
    }

}
