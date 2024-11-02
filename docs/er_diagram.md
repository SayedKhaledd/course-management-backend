```mermaid
erDiagram
USER {
LONG Id
STRING Name
STRING Email
STRING PhoneNumber
STRING Role
}

    CLIENT {
        LONG Id
        STRING Name
        STRING Email
        STRING PhoneNumber
        STRING AlternatePhoneNumber
        STRING Nationality
        STRING Country
        STRING Address
        LONG ReferralSourceId
        STRING Description
        LONG ActionId
    }
    
    CLIENT_HISTORY {
        LONG Id
        LONG ClientId
        STRING Name
        STRING Email
        STRING PhoneNumber
        STRING AlternatePhoneNumber
        STRING Nationality
        STRING Country
        STRING Address
        LONG ReferralSourceId
        STRING Description
        LONG ActionId
    }
    
    REFERRAL_SOURCE {
        LONG Id
        STRING Source
    }
    
    ACTION {
        LONG Id
        STRING Description
    }
    
    PAYMENT_METHOD {
        LONG Id
        STRING Method
    }
    
    REFUND_REASON {
        LONG Id
        STRING Reason
    }
    
    SPECIALITY {
        LONG Id
        STRING Name
    }
    
    COURSE {
        LONG Id
        STRING Code
        STRING Part
        LONG SpecialtyId
        STRING Status
        DATE StartDate
        DATE EndDate
        LONG NextCourseId
    }
    
    ENROLLMENT {
        LONG Id
        LONG CourseId
        LONG ClientId
        DOUBLE AmountPaid
        DOUBLE RemainingAmount
        STRING Currency
        DOUBLE Discount
        BOOLEAN PaymentVerified
        BOOLEAN ReceivedReceipt
        LONG PaymentMethodId
        BOOLEAN PayInInstallments
        STRING Role
    }
    
    INSTALLMENT {
        LONG Id
        LONG EnrollmentId
        DOUBLE Amount
        DATE PaymentDueDate
        DATE PaymentDate
        LONG PaymentMethodId
    }
    
    EVALUATION {
        LONG Id
        LONG EnrollmentId
        LONG ExamId
        STRING Status
    }
    
    EXAM {
        LONG Id
        STRING Name
    }
    
    REFUND {
        LONG Id
        LONG EnrollmentId
        STRING Reason
        DOUBLE Amount
        DATE RefundDate
        BOOLEAN Approved
        STRING Status
    }
    
    USER ||--o{ CLIENT : "creates"
    CLIENT ||..o{ CLIENT_HISTORY : "has"
    CLIENT ||..o{ ENROLLMENT : "has"
    CLIENT ||--||  REFERRAL_SOURCE: "has"
    ACTION ||--|| CLIENT : "takes"
    PAYMENT_METHOD ||--|| ENROLLMENT : "uses"
    REFUND_REASON ||--|| REFUND : "explains"
    SPECIALITY ||--|| COURSE : "belongs to"
    COURSE ||--o{ ENROLLMENT : "has"
    ENROLLMENT ||--o{ INSTALLMENT : "divides"
    ENROLLMENT ||--o{ EVALUATION : "evaluates"
    EXAM ||--|| EVALUATION : "tests"
    ENROLLMENT ||--o{ REFUND : "may have"
