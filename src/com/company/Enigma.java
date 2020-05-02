package com.company;

import filter.DecodeFiltredOutputStream;
import filter.EncodeFilterOutputStream;
import filter.IEncoder;

import java.io.*;

public class Enigma {
    public static IEncoder getEncoder(final int secret) {
        return new EncodingProvider(secret);
    }

    private IEncoder _encoderProvider;
    Enigma(int secret) {
        this._encoderProvider = getEncoder(secret);
    }

    public void encodeFile(String inputFileName, String outputFileName) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            FileInputStream fsi = new FileInputStream(inputFileName);
            FileOutputStream fso = new FileOutputStream(outputFileName);
            BufferedInputStream bufInput = new BufferedInputStream(fsi);
            BufferedOutputStream bufOut = new BufferedOutputStream(fso);
            EncodeFilterOutputStream encodedOut = new EncodeFilterOutputStream(bufOut, this._encoderProvider);

            inputStream = bufInput;
            outputStream = encodedOut;

            int c;

            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if(outputStream != null) {
                outputStream.close();
            }
        }
    }

    public void decodeFile(String inputFileName, String outputFileName) throws IOException {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            FileInputStream fsi = new FileInputStream(inputFileName);
            FileOutputStream fso = new FileOutputStream(outputFileName);
            BufferedInputStream bufInput = new BufferedInputStream(fsi);
            BufferedOutputStream bufOut = new BufferedOutputStream(fso);
            DecodeFiltredOutputStream decodedOut = new DecodeFiltredOutputStream(bufOut, this._encoderProvider);

            inputStream = bufInput;
            outputStream = decodedOut;

            int c;

            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }

        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if(outputStream != null) {
                outputStream.close();
            }
        }
    }
}
