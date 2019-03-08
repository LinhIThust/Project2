package com.example.project2.model;

public class DonHang {
    private String maHD;
    private String ngayMua;
    private String thietBi;

    public DonHang() {
    }

    public DonHang(String maHD, String ngayMua, String thietBi) {
        this.maHD = maHD;
        this.ngayMua = ngayMua;
        this.thietBi = thietBi;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(String ngayMua) {
        this.ngayMua = ngayMua;
    }

    public String getThietBi() {
        return thietBi;
    }

    public void setThietBi(String thietBi) {
        this.thietBi = thietBi;
    }

    @Override
    public String toString() {
        return "DonHang{" +
                "maHD='" + maHD + '\'' +
                ", ngayMua='" + ngayMua + '\'' +
                ", thietBi='" + thietBi + '\'' +
                '}';
    }
}

