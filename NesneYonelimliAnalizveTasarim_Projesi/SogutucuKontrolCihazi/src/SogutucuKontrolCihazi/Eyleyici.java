package SogutucuKontrolCihazi;

public class Eyleyici implements IEyleyici {
    private boolean sogutucuDurumu;

    private Eyleyici(EyleyiciFactory builder) {

    }

    @Override
    public boolean sogutucuAc() {
        this.sogutucuDurumu = true;
        return sogutucuDurumu;
    }

    @Override
    public boolean sogutucuKapat() {
        this.sogutucuDurumu = false;
        return sogutucuDurumu;
    }

    public static class EyleyiciFactory {

        public Eyleyici Factory() {
            return new Eyleyici(this);
        }
    }
}