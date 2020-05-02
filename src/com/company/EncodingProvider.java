package com.company;

import filter.IEncoder;

public class EncodingProvider implements IEncoder {
    private int _secretKeyCode;

    EncodingProvider(int secretKeyCode) {
        this._secretKeyCode = secretKeyCode;
    }

    public int encode(int b) {
        System.out.println(b);
        return b + this._secretKeyCode;
    }

    public int decode(int b) {
        System.out.println(b);
        return b - this._secretKeyCode;
    }
}
