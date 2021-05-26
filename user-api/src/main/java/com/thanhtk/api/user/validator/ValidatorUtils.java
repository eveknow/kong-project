package com.thanhtk.api.user.validator;

import com.thanhtk.api.user.exception.BadRequestException;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.regex.Pattern;

public class ValidatorUtils {

    private ValidatorUtils() {
    }

    private static final String MISSING_FIELD_FORMAT = "Missing field %s.";
    private static final String NAME = "[a-zA-Z0-9\\-_.]{5,50}";


    private static void validate(String field, String value, String regex, boolean nullable) throws BadRequestException {
        if (StringUtils.isEmpty(value)) {
            if (nullable) {
                return;
            } else {
                throw new BadRequestException(String.format(MISSING_FIELD_FORMAT, field));
            }
        }
        if (!Pattern.matches(regex, value)) {
            throw new BadRequestException(String.format("The value %s for the field %s is an invalid. Regex " + NAME,
                    value, field));
        }
    }


    public static void validateName(String field, String value, boolean nullable) throws BadRequestException {
        validate(field, value, NAME, nullable);
    }

}
