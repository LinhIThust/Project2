package com.example.project2.model;

public class KhachHang {
    private String nameKH;
    private String diaChiKH;
    private String sdtKH;
    private String maDonHang;

    public KhachHang() {
    }

    public KhachHang(String nameKH, String diaChiKH, String sdtKH, String maDonHang) {
        this.nameKH = nameKH;
        this.diaChiKH = diaChiKH;
        this.sdtKH = sdtKH;
        this.maDonHang = maDonHang;
    }

    public String getNameKH() {
        return nameKH;
    }

    public void setNameKH(String nameKH) {
        this.nameKH = nameKH;
    }

    public String getDiaChiKH() {
        return diaChiKH;
    }

    public void setDiaChiKH(String diaChiKH) {
        this.diaChiKH = diaChiKH;
    }

    public String getSdtKH() {
        return sdtKH;
    }

    public void setSdtKH(String sdtKH) {
        this.sdtKH = sdtKH;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }
}
