package com.example.prova.lightlife;

public class ProdottoBean {
    public ProdottoBean(Integer photo, String nome, String prezzo, String descrizione){
        this.photo = photo;
        this.nome = nome;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPrezzo() {
        return prezzo;
    }
    public void setPrezzo(String prezzo) {
        this.prezzo = prezzo;
    }
    public Integer getPhoto() {return photo;}
    public void setPhoto(Integer photo) {this.photo = photo;}
    public String getDescrizione() {return descrizione;}
    public void setDescrizione(String descrizione) {this.descrizione = descrizione;}

    private int id;
    private Integer photo;
    private String nome;
    private String prezzo;
    private String descrizione;
}
