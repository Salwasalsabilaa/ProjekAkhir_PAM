package com.example.projekakhir_pam.database;

import java.io.Serializable;

public class bookingdata implements Serializable {
    String id;
    String nama;
    String nomortelepon;
    String nomorktp;

    public  bookingdata() {
    }

    public bookingdata (String id, String nama, String nomortelepon, String nomorktp){
        this.id = id;
        this.nama = nama;
        this.nomortelepon = nomortelepon;
        this.nomorktp = nomorktp;
    }

    public  String getId() { return id; }

    public  void  setId(String id) { this.id = id; }

    public  String getnama(){ return  nama; }

    public  void setNama(String nama) { this.nama = nama; }

    public String getNomortelepon(){ return nomortelepon; }

    public  void setTanggallahir(String tanggallahir){ this.nomortelepon = tanggallahir; }

    public String getNomorKtp() {return nomorktp;}

    public void  setJeniskelamin(String jeniskelamin) {this.nomorktp = jeniskelamin;}
}
