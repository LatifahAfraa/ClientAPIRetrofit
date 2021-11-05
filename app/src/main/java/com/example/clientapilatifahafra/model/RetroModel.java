package com.example.clientapilatifahafra.model;

import java.util.List;

public class RetroModel {
    private int kode;
    private String pesan;
    private List<BarangModel> hasil;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public List<BarangModel> getHasil() {
        return hasil;
    }

    public void setHasil(List<BarangModel> hasil) {
        this.hasil = hasil;
    }
}
