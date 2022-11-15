package com.asherbakov.hwAnother;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PassportList {
    private static Map<String, Passport> passportSet = new HashMap<>();

    public void addPassport(Passport passport) {
        if (!passportSet.containsKey(passport.getNumber())) {
            passportSet.put(passport.getNumber(), passport);
        } else {
            passportSet.replace(passport.getNumber(), passport);
        }
    }

    public Passport getPassport(String number) {
        Passport result = null;
        if (passportSet.containsKey(number)) {
            result = passportSet.get(number);
        }
        return result;
    }
}
