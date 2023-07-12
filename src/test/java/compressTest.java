import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.example.encEnum.compressEnum;
import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class compressTest {

    @Test
    public void init() throws IOException {
        String input = "0000000000000000000000", output;
//        CompressorOutputStream cos = compressEnum.getCompressOS(compressEnum.LZMA,
//                new BufferedOutputStream(new FileOutputStream("0.json")));
//        Scanner scanner = new Scanner(System.in);
//        cos.write(input.getBytes(StandardCharsets.UTF_8));
    }


}
