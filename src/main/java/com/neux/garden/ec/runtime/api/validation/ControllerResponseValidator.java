
/*
* <p> Source File Name: ControllerResponseValidator.java </p>
*/

package com.neux.garden.ec.runtime.api.validation;

import com.neux.garden.ec.runtime.api.exception.InvalidResponseFormatException;
import com.neux.garden.ec.runtime.api.model.APIModel;
import com.neux.garden.ec.runtime.api.model.ResponseHeader;
import com.neux.garden.ec.runtime.service.DateService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Aspect
@Component
public class ControllerResponseValidator {
    private Logger logger = LoggerFactory.getLogger(ControllerResponseValidator.class);

    @Autowired
    private Validator validator;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private DateService dateService;

    @AfterReturning(pointcut = "execution(* com.neux.garden.ec.runtime.api.controller.*.*(..))", returning = "result")
    public void validateResponse(JoinPoint joinPoint, Object result) {
        validateResponse(result);
    }

    private void validateResponse(Object object) {

        if(object instanceof APIModel) {
            APIModel apiModel = (APIModel) object;
            ResponseHeader header = apiModel.getHeader();
            if(header == null) {
                header = new ResponseHeader();
                header.setRequestTime(String.valueOf(request.getAttribute("RequestTime")));
                header.setResponseCode("0");
                header.setResponseTime(dateService.toDateString(dateService.getTodayDate(),"yyyy-MM-dd HH:mm:ss"));
                apiModel.setHeader(header);
            }
        }

        Set<ConstraintViolation<Object>> validationResults = validator.validate(object);

        if (validationResults.size() > 0) {

            StringBuffer sb = new StringBuffer();

            for (ConstraintViolation<Object> error : validationResults) {
                sb.append(error.getPropertyPath()).append(" - ").append(error.getMessage()).append("\\n\\n");
            }

            String msg = sb.toString();

            logger.error("InvalidResponseFormatException = " + object);

            throw new InvalidResponseFormatException(msg);
        }
    }

}
    