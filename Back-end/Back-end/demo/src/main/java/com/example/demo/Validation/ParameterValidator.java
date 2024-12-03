package com.example.demo.Validation;

import com.example.demo.exception.InvalidInputException;
import org.springframework.stereotype.Component;
import javax.validation.*;
import java.util.Set;

@Component("parameter")
public class ParameterValidator {

    private final Validator validator;

    public ParameterValidator() {
        // 创建 ValidatorFactory 和 Validator 实例
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
    }

    /**
     * 校验参数是否符合规范
     * @param object 要验证的对象
     * @throws InvalidInputException 如果验证失败，抛出异常
     */
    public void validate(Object object) {
        Set<ConstraintViolation<Object>> violations = validator.validate(object);

        if (!violations.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder("输入参数错误: ");
            for (ConstraintViolation<Object> violation : violations) {
                errorMessage.append(violation.getMessage()).append("; ");
            }
            throw new InvalidInputException(errorMessage.toString());
        }
    }
}
