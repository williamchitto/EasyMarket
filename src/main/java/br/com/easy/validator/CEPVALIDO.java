package br.com.easy.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

@Pattern(regexp = "[0-9]{8}")
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {ValidaCep.class})
public @interface CEPVALIDO {
	
	@OverridesAttribute(constraint = Pattern.class, name = "message")
	String message() default "{com.easy.constraints.CEP.message}";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	@OverridesAttribute(constraint=Pattern.class, name="message")
    String regexMessage() default "{com.easy.constraints.regex.message}";
	
	
	
}