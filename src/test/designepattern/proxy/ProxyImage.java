package test.designepattern.proxy;

/**
 * @author XXX
 * @site www.muddywater.com
 * @company muddywater .corp
 * @create 2020-12-16 1:49
 */
public class ProxyImage implements Image {

    private RealImage realImage;

    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
    public static void main(String[] args) {
        Image image = new ProxyImage("test.png");
        image.display();
        System.out.println("");
        image.display();
    }
}
