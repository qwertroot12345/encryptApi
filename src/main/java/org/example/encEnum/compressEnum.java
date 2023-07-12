package org.example.encEnum;

import com.github.luben.zstd.ZstdOutputStream;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.deflate.*;
import org.apache.commons.compress.compressors.deflate64.*;
import org.apache.commons.compress.compressors.bzip2.*;
import org.apache.commons.compress.compressors.brotli.*;
import org.apache.commons.compress.compressors.gzip.*;
import org.apache.commons.compress.compressors.lzma.*;
import org.apache.commons.compress.compressors.snappy.*;
import org.apache.commons.compress.compressors.lz4.*;
import org.apache.commons.compress.compressors.xz.*;
import org.apache.commons.compress.compressors.z.*;
import org.apache.commons.compress.compressors.zstandard.*;
import org.example.utils.extCompressor.*;
import org.example.utils.extCompressor.SnappyCompressorOutputStream;
import org.tukaani.xz.ArrayCache;
import org.tukaani.xz.LZMA2Options;
import org.tukaani.xz.LZMAOutputStream;
import org.tukaani.xz.XZOutputStream;


import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPOutputStream;

public enum compressEnum {

    LZMA,BROTLI,BZ2,ZSTD,XZ,
    DEFLATE,DEFLATE64,GZIP,
    LZ4,Z,SNAPPY;

//    public static CompressorInputStream getCompressIS(compressEnum comName, InputStream in)
//            throws IOException {
//        CompressorInputStream CIS;
//        switch (comName){
//            case DEFLATE -> CIS=new DeflateCompressorInputStream(in);
//            case DEFLATE64 -> CIS=new Deflate64CompressorInputStream(in);
//            case Z -> CIS=new ZCompressorInputStream(in);//
//            case XZ -> CIS=new XZCompressorInputStream(in);
//            case BZ2 -> CIS=new BZip2CompressorInputStream(in);
//            case LZ4 -> CIS=new BlockLZ4CompressorInputStream(in);//
//            case GZIP -> CIS=new GzipCompressorInputStream(in);
//            case ZSTD -> CIS=new ZstdCompressorInputStream(in);
//            case LZMA -> CIS=new LZMACompressorInputStream(in);
//            case BROTLI -> CIS=new BrotliCompressorInputStream(in);//
//            case SNAPPY -> CIS=new SnappyCompressorInputStream(in);//
//            default -> CIS=null;
//        }
//        return CIS;
//    }
//
//    public static OutputStream getCompressOS(compressEnum comName, OutputStream out)
//            throws IOException {
//        OutputStream COS;
//        switch (comName){
//            case DEFLATE -> COS=new DeflaterOutputStream(out);
//            case XZ -> COS=new XZOutputStream(out,new LZMA2Options());
//            case BZ2 -> COS=new BZip2CompressorOutputStream(out);
//            case LZ4 -> COS=null;
//            case GZIP -> COS=new GZIPOutputStream(out);
//            case ZSTD -> COS=new ZstdOutputStream(out);
//            case LZMA -> COS=new LZMAOutputStream(out,new LZMA2Options(),true);
//            case Z -> COS=new ZCompressorOutputStream(out);
//            case BROTLI -> COS=new Br(out);
//            case SNAPPY -> COS=new SnappyCompressorOutputStream(out);
//            default -> COS=null;
//        }
//        return COS;
//    }
}
