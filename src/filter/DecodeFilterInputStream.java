package filter;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecodeFilterInputStream extends FilterInputStream {
    private IEncoder encoder;
    public DecodeFilterInputStream (InputStream is, IEncoder encoderProvider) {
        super(is);
        this.encoder = encoderProvider;
    }

    public int read() throws IOException {
        int res = super.read();
        return this.encoder.decode(res);
    }
}
