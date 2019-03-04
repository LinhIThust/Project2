package com.example.project2.model;

public class SanPham {
    private String maSP;
    private String nameSP;
    private String giaSP;
    private Integer soBoLoc;
    private String imageSP;

    public SanPham() {
    }

    public SanPham(String nameSP, String giaSP,String imageSP) {
        this.nameSP = nameSP;
        this.giaSP = giaSP;
        this.imageSP = imageSP;
    }

    public SanPham(String maSP, String nameSP, String giaSP, Integer soBoLoc, String imageSP) {
        this.maSP = maSP;
        this.nameSP = nameSP;
        this.giaSP = giaSP;
        this.soBoLoc = soBoLoc;
        this.imageSP = imageSP;
    }

    public String getImageSP() {
        return imageSP;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public Integer getSoBoLoc() {
        return soBoLoc;
    }

    public void setSoBoLoc(Integer soBoLoc) {
        this.soBoLoc = soBoLoc;
    }

    public void setImageSP(String imageSP) {
        this.imageSP = imageSP;
    }

    public String getNameSP() {
        return nameSP;
    }

    public void setNameSP(String nameSP) {
        this.nameSP = nameSP;
    }

    public String getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(String giaSP) {
        this.giaSP = giaSP;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                ", nameSP='" + nameSP + '\'' +
                ", giaSP='" + giaSP + '\'' +
                ", imageSP='" + imageSP + '\'' +
                '}';
    }
}
