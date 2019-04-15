package com.example.project2.model;

public class LichSuThay {
    private String maHD;
    private String thuTuBoLoc;
    private String ngayThayGanNhat;
    private String hanSuDung;
    private String ngayNenThay;

    public LichSuThay() {
    }

    public LichSuThay(String thuTuBoLoc, String ngayThayGanNhat, String hanSuDung) {
        this.thuTuBoLoc = thuTuBoLoc;
        this.ngayThayGanNhat = ngayThayGanNhat;
        this.hanSuDung = hanSuDung;
    }

    public LichSuThay(String maHD, String thuTuBoLoc, String ngayThayGanNhat, String hanSuDung) {
        this.maHD = maHD;
        this.thuTuBoLoc = thuTuBoLoc;
        this.ngayThayGanNhat = ngayThayGanNhat;
        this.hanSuDung = hanSuDung;
    }

    public String getNgayNenThay() {
        return ngayNenThay;
    }

    public void setNgayNenThay(String ngayNenThay) {
        this.ngayNenThay = ngayNenThay;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getThuTuBoLoc() {
        return thuTuBoLoc;
    }

    public void setThuTuBoLoc(String thuTuBoLoc) {
        this.thuTuBoLoc = thuTuBoLoc;
    }

    public String getNgayThayGanNhat() {
        return ngayThayGanNhat;
    }

    public void setNgayThayGanNhat(String ngayThayGanNhat) {
        this.ngayThayGanNhat = ngayThayGanNhat;
    }

    public String getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(String hanSuDung) {
        this.hanSuDung = hanSuDung;
    }

    @Override
    public String toString() {
        return "LichSuThay{" +
                "thuTuBoLoc=" + thuTuBoLoc +
                ", ngayThayGanNhat='" + ngayThayGanNhat + '\'' +
                ", hanSuDung='" + hanSuDung + '\'' +
                '}';
    }
}
