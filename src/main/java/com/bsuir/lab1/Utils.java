package com.bsuir.lab1;

import javax.lang.model.SourceVersion;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Utils {

    boolean isNumberFrom1to100(String number) {
        try {
            Integer num = Integer.parseInt(number);
            if(num>0 && num<=100){
                return true;
            } else {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
