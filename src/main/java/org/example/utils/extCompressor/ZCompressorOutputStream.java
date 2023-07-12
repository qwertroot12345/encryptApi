package org.example.utils.extCompressor;

import org.apache.commons.compress.compressors.CompressorOutputStream;

import java.io.IOException;
import java.io.OutputStream;

public class ZCompressorOutputStream extends CompressorOutputStream {
    public ZCompressorOutputStream(OutputStream out) {
    }

    @Override
    public void write(int b) throws IOException {

    }
}
