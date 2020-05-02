package com.company;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Enigma enigma = new Enigma(22);
        enigma.encodeFile(
                "D:\\Users\\drako\\Projects\\IJProjects\\CMTLab6\\in.txt",
                "D:\\Users\\drako\\Projects\\IJProjects\\CMTLab6\\out.txt"
        );
        enigma.decodeFile(
                "D:\\Users\\drako\\Projects\\IJProjects\\CMTLab6\\out.txt",
                "D:\\Users\\drako\\Projects\\IJProjects\\CMTLab6\\toIryna.txt"
        );
    }
}
