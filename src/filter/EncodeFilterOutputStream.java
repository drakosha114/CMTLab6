package filter;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncodeFilterOutputStream extends FilterOutputStream {
    private IEncoder encoder;

    public EncodeFilterOutputStream(OutputStream os, IEncoder encoderProvider) {
        super(os);
        this.encoder = encoderProvider;
    }

    public void write(int b) throws IOException {
        super.write(this.encoder.encode(b));
    }
}
