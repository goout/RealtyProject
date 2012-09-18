package validators;

import org.realty.entity.Adress;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NumberValidator implements Validator {
    private static final String NUMBERREGEX = "\\d{3}";
    private Pattern pattern;
    private Matcher matcher;
    public NumberValidator()
    {
        pattern = Pattern.compile(NUMBERREGEX);
    }
    public boolean supports(Class aClass) {
        return Adress.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        Adress adress = (Adress) o;
        int appNum =  adress.getApartmentNum();
        String toMatch = Integer.toString(appNum);
        matcher = pattern.matcher(toMatch);
        if(!matcher.matches())
        {
           // errors.rejectValue();
        }

    }
}
