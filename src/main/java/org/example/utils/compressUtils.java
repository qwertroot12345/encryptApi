package org.example.utils;

import org.bouncycastle.util.encoders.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class compressUtils {
    public static byte[] textCompress(String text) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream)) {
            gzipOutputStream.write(text.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }

    public static String textCompressBase64(String text) {
        return Base64.toBase64String(textCompress(text));
    }

    public static String textDecompress(String Base64CompressedBytes) {
        byte[] compressedBytes = Base64.decode(Base64CompressedBytes);
        ByteArrayOutputStream uncompressedStream = new ByteArrayOutputStream();
        try (
                ByteArrayInputStream inputStream = new ByteArrayInputStream(compressedBytes);
                GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream)
        ) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = gzipInputStream.read(buffer)) > 0) {
                uncompressedStream.write(buffer, 0, length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uncompressedStream.toString(StandardCharsets.UTF_8);
    }

    //=================================================================

    public static byte[] binaryCompress(byte[] input) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream)) {
            gzipOutputStream.write(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }

    public static String binaryCompressBase64(byte[] input) {
        return Base64.toBase64String(binaryCompress(input));
    }

    public static byte[] binaryDecompress(byte[] input) {
        ByteArrayOutputStream uncompressedStream = new ByteArrayOutputStream();
        try (
                ByteArrayInputStream inputStream = new ByteArrayInputStream(input);
                GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream)
        ) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = gzipInputStream.read(buffer)) > 0) {
                uncompressedStream.write(buffer, 0, length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uncompressedStream.toByteArray();
    }

    public static String binaryDeompressBase64(byte[] input) {
        return Base64.toBase64String(binaryDecompress(input));
    }
}
