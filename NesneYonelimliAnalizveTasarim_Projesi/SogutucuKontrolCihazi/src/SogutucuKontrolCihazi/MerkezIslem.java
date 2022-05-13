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

            System.out.println("\n Sogutucun önceden de açýktý ! ");

        } else {
            this.sogutucuDurum = islem.sogutucuAc();
            sicaklikAlgila.sicaklikAta(sogutucuDurum);

            System.out.println("\n*** Soðutucu Açýldý ! ***");

        }
    }

    @Override
    public void sogutucuKapali(IObserver observer) {
        if (!this.sogutucuDurum) //false ise
        {

            System.out.println("\n Sogutucu önceden de kapalýydý!");

        } else {
            this.sogutucuDurum = islem.sogutucuKapat();
            sicaklikAlgila.sicaklikAta(sogutucuDurum);

            System.out.println("\n*** Soðutucu kapalý! ***");

        }
    }

    @Override
    public void sicaklikGoster(IObserver observer) {

        System.out.println("\nSýcaklýk Degeri: " + sicaklikAlgila.sicaklikOku());

    }
}