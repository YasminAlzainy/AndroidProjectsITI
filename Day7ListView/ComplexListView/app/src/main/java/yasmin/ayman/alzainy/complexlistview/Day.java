package yasmin.ayman.alzainy.complexlistview;

public class Day {
    private String name ;
    private String desc ;
    private int imag ;

    @Override
    public String toString() {
        return "Day{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", imag=" + imag +
                '}';
    }

    public Day(String name, String desc, int imag) {
        this.name = name;
        this.desc = desc;
        this.imag = imag;
    }

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

    public int getImag() {
        return imag;
    }

    public void setImag(int imag) {
        this.imag = imag;
    }
}
