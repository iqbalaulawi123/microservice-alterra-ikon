package com.example.bookserviceredis.model;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("Book")
public class Book {
    private String id;
    private String isbn;
    private String judul;
    private String penulis;
    private String deskrpsi;
    public  Book(String id,String isbn,String judul,String penulis, String deskripsi){
        this.id = id;
        this.isbn = isbn;
        this.judul = judul;
        this.penulis = penulis;
        this.deskrpsi = deskripsi;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getDeskrpsi() {
        return deskrpsi;
    }

    public void setDeskrpsi(String deskrpsi) {
        this.deskrpsi = deskrpsi;
    }
}
