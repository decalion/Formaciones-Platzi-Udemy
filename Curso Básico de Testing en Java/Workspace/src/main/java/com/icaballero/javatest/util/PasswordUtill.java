package com.icaballero.javatest.util;

public class PasswordUtill {


    public  static enum SecurityLevel{
        WEAK,MEDIUM,STRONG
    }

    public static SecurityLevel asssessPassword(String password){

        if(password.length() < 8){
            return  SecurityLevel.WEAK;
        }

        if(password.matches("[a-zA-Z]+")){

            return  SecurityLevel.WEAK;
        }

        if(password.matches("[a-zA-Z0-9]+")){
            return  SecurityLevel.MEDIUM;
        }

        return SecurityLevel.STRONG;
    }
}
