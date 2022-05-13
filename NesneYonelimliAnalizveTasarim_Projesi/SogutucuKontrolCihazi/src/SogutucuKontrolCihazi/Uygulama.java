package SogutucuKontrolCihazi;

import java.sql.*;

public class Uygulama {
    public static void main(String[] args) throws SQLException {
        MerkezIslem merkezIslem = new MerkezIslem();
        merkezIslem.sistemiBaslat();
    }
}