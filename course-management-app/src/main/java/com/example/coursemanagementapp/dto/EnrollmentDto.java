package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true, builderMethodName = "EnrollmentDtoBuilder")
@Data
public class EnrollmentDto extends AbstractDto {
    private Long id;
    private CourseDto course;
    @NotNull(message = "Course is mandatory", groups = {Create.class})
    private Long courseId;
    private ClientDto client;
    @NotNull(message = "Client is mandatory", groups = {Create.class})
    private Long clientId;
    @NotNull(message = "Amount Paid is mandatory", groups = {UpdateAmountPaid.class})
    private Double amountPaid = 0.0;
    private Double remainingAmount =0.0;
    private Double totalAmount;


    @NotNull(message = "Currency is mandatory", groups = {UpdateCurrency.class})
    private String currency;
    @NotNull(message = "Discount is mandatory", groups = {UpdateDiscount.class})
    private Double discount;
    private PaymentStatusDto paymentStatus;
    private Long paymentStatusId;
    private PaymentMethodDto paymentMethod;
    private Long paymentMethodId;
    private Boolean payInInstallments = false;
    @NotNull(message = "Review is mandatory", groups = {UpdateReview.class})
    private String review;
    @NotNull(message = "Rating is mandatory", groups = {UpdateRating.class})
    private Integer rating;
    @NotNull(message = "Description is mandatory", groups = {UpdateDescription.class})
    private String description;
    private ActionTakenDto actionTaken;
    private Long actionTakenId;
    private ReferralSourceDto referralSource;
    private Long referralSourceId;

    private Boolean insideEgypt = true;
    private Boolean isReceived = false;

    public interface Create {

    }

    public interface UpdateAmountPaid {
    }

    public interface UpdateCurrency {

    }

    public interface UpdateDiscount {

    }


    public interface UpdateDescription {

    }

    public interface UpdateReview {

    }

    public interface UpdateRating {

    }


}
