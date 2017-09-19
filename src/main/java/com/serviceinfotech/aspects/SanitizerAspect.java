package com.serviceinfotech.aspects;

import com.serviceinfotech.FormDataSanitiser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SanitizerAspect {
    private FormDataSanitiser formDataSanitiser;

    public SanitizerAspect(FormDataSanitiser formDataSanitiser) {
        this.formDataSanitiser = formDataSanitiser;
    }

    @Before("execution(* com.serviceinfotech.controllers.IncomeController.doPost(..))")
    public void sanitiseFormData(JoinPoint jp){
        String message = jp.getKind() + ":" + jp.getSignature().getName();
        System.out.println("Sanitizer Aspect : " + message);
        formDataSanitiser.sanitise(jp.getArgs()[0]);
    }
}
