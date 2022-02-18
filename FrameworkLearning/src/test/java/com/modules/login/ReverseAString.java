package com.modules.login;

public class ReverseAString {
    String name = "Prateek1234";
    int leng = name.length();
    String rev = "";

    public ReverseAString(String name) {
        this.name = name;
        for(int i=leng-1;i>=0;i--){

            rev = rev + name.charAt(i);
    }
        System.out.println("Reverse of "+name+ " is "+rev);
    }


}
