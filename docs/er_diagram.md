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
    
    INSTALLMENTS {
        LONG Id
        LONG EnrollmentId
        DOUBLE Amount
        DATE PaymentDueDate
        DATE PaymentDate
        LONG PaymentMethodId
    }
    
    EVALUATIONS {
        LONG Id
        LONG EnrollmentId
        LONG ExamId
        STRING Status
    }
    
    EXAMS {
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
    
    USER ||--|| CLIENT : "creates"
    CLIENT ||--|| CLIENT_HISTORY : "has"
    CLIENT ||--|| ENROLLMENT : "has"
    REFERRAL_SOURCE ||--|| CLIENT : "has"
    ACTION ||--|| CLIENT : "takes"
    PAYMENT_METHOD ||--|| ENROLLMENT : "uses"
    REFUND_REASON ||--|| REFUND : "explains"
    SPECIALITY ||--|| COURSE : "belongs to"
    COURSE ||--|| ENROLLMENT : "has"
    ENROLLMENT ||--|| INSTALLMENTS : "divides"
    ENROLLMENT ||--|| EVALUATIONS : "evaluates"
    EXAMS ||--|| EVALUATIONS : "tests"
    ENROLLMENT ||--|| REFUND : "may have"
