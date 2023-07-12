package org.example.utils.extCompressor;

import org.apache.commons.compress.compressors.CompressorOutputStream;

import java.io.IOException;
import java.io.OutputStream;

public class SnappyCompressorOutputStream extends CompressorOutputStream {
    public SnappyCompressorOutputStream(OutputStream out) {
    }

    @Override
    public void write(int b) throws IOException {
        
    }
}
