package com.szczepanek.FrequencyCalc.Input;

import java.util.Scanner;

public class Input {
    private String key;
    private String input;

    public Input(String key, String input) {
        this.key = key;
        this.input = input;
    }

    public Input() {
    }

    public void readFromCommandLine(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type the key");
        key = scanner.nextLine();
        System.out.println("Type the input");
        input = scanner.nextLine();
    }


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
