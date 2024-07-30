package ProxyPatternExample;

interface Image {
    void display();
}


class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + filename);
    }
}


class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}


public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("C:\\Users\\lenovo\\Downloads\\image1.jpg");
        Image image2 = new ProxyImage("C:\\Users\\lenovo\\Downloads\\image2.jpg");

        image1.display();
        image1.display();

        image2.display();
    }
}
