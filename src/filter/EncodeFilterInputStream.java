package filter;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class EncodeFilterInputStream extends FilterInputStream {
    private IEncoder encoder;

    public EncodeFilterInputStream(InputStream is, IEncoder encoderProvider) {
        super(is);
        this.encoder = encoderProvider;
    }

    public int read() throws IOException {
        int b = super.read();
        return this.encoder.encode(b);
    }
}
