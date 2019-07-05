package com.example.prova.lightlife;


public class InformazioniDAO {
    public InformazioniDAO(String id, String nome, String immagine, String testo){
        this.id = id;
        this.nome = nome;
        this.immagine = immagine;
        this.testo = testo;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getImmagine() {
        return immagine;
    }
    public void setImmagine(String immagine) {
        this.immagine = immagine;
    }
    public String getTesto() {
        return testo;
    }
    public void setTesto(String testo) {
        this.testo = testo;
    }

    private String  id;
    private String nome;
    private String immagine;
    private String testo;
}
