package SogutucuKontrolCihazi;

import java.sql.SQLException;

public class MerkezIslem implements IObservableMerkezIslem {
    private boolean sogutucuDurum;

    /* Dependency Inversion ----- Factory method   */
    IEyleyici islem = new Eyleyici.EyleyiciFactory()
            .Factory(); 

    ISicaklikAlgilayici sicaklikAlgila = new SicaklikAlgilayici.SicaklikAlgilayiciFactory()
            .Factory();

    
    public void sistemiBaslat() throws SQLException {
        new AgArayuzu();
    }


    @Override
    public void sogutucuAcik(IObserver observer) {
        if (this.sogutucuDurum)
        {

            System.out.println("\n Sogutucun �nceden de a��kt� ! ");

        } else {
            this.sogutucuDurum = islem.sogutucuAc();
            sicaklikAlgila.sicaklikAta(sogutucuDurum);

            System.out.println("\n*** So�utucu A��ld� ! ***");

        }
    }

    @Override
    public void sogutucuKapali(IObserver observer) {
        if (!this.sogutucuDurum) //false ise
        {

            System.out.println("\n Sogutucu �nceden de kapal�yd�!");

        } else {
            this.sogutucuDurum = islem.sogutucuKapat();
            sicaklikAlgila.sicaklikAta(sogutucuDurum);

            System.out.println("\n*** So�utucu kapal�! ***");

        }
    }

    @Override
    public void sicaklikGoster(IObserver observer) {

        System.out.println("\nS�cakl�k Degeri: " + sicaklikAlgila.sicaklikOku());

    }
}