package yasmin.ayman.alzainy.jsonlistview;

import android.graphics.Bitmap;

public class Country {
    private String name ;
    private String desc ;
    private Bitmap imag ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Bitmap getImag() {
        return imag;
    }

    public void setImag(Bitmap imag) {
        this.imag = imag;
    }

    public Country(String name, String desc, Bitmap imag) {
        this.name = name;
        this.desc = desc;
        this.imag = imag;
    }
}
