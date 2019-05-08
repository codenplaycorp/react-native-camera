package br.com.cnp.compressor;

import android.content.Context;
import android.graphics.Bitmap;

import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;

public class Compressor {

    private Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.JPEG;
    private int quality = 80;
    private byte[] data;

    public Compressor(byte[] data) {
      this.data = data;
    }

    public Compressor setFormat(Bitmap.CompressFormat compressFormat) {
        this.compressFormat = compressFormat;
        return this;
    }

    public Compressor setQuality(int quality) {
        this.quality = quality;
        return this;
    }

    public File compressToFile(File imageFile) throws IOException {
        FileOutputStream fos = new FileOutputStream(imageFile);
        fos.write(this.data);
        fos.close();
        return ImageUtil.apply(imageFile, this.quality, this.compressFormat);
    }

}
