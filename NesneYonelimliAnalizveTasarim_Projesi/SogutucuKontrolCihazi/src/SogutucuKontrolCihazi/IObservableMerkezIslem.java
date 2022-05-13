package SogutucuKontrolCihazi;

public interface IObservableMerkezIslem {
    void sogutucuAcik(IObserver observer);

    void sogutucuKapali(IObserver observer);

    void sicaklikGoster(IObserver observer);
}
