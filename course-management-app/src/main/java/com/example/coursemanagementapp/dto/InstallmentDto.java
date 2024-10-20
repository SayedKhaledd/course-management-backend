package com.example.coursemanagementapp.dto;

import com.example.backendcoreservice.dto.AbstractDto;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@Validated
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true, builderMethodName = "InstallmentDtoBuilder")
@Data
public class InstallmentDto extends AbstractDto {
    private Long id;
    private EnrollmentDto enrollment;
    private Long enrollmentId;
    @NotNull(message = "Amount is mandatory", groups = {Create.class, UpdateAmount.class})
    private Double amount;
    @NotNull(message = "Due Date is mandatory", groups = {Create.class, UpdateDueDate.class})
    private LocalDateTime dueDate;
    @NotNull(message = "Payment Date is mandatory", groups = {UpdatePaymentDate.class})
    private LocalDateTime paymentDate;
    private PaymentStatusDto paymentStatus;
    private Long paymentStatusId;
    private PaymentMethodDto paymentMethod;
    private Long paymentMethodId;

    public interface Create {
    }

    public interface UpdateAmount {
    }

    public interface UpdateDueDate {
    }

    public interface UpdatePaymentDate {
    }


}
