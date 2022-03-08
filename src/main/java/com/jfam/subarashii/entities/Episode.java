package com.jfam.subarashii.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.JsonObject;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "episodes")
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull
    private long idApi;

    @Column @NotNull
    private String nom;


    @Column @NotNull
    private Long saison;

    private Float note;

    private Long numeroEpisode;



    @ManyToOne @NotNull
    @JoinColumn( name = "animeId")
    @JsonBackReference
    private Anime anime;

    @OneToMany(mappedBy = "episode")
    @JsonIgnoreProperties
    private List<EpisodeComment> episodeComments;

    private Long IdApiAnime;

    public Episode(){}

    public Episode(JsonObject jsonObject, Anime anime){
        this.idApi = jsonObject.get("id").getAsLong();
        this.nom = jsonObject.get("name").getAsString();
        this.saison = jsonObject.get("season_number").getAsLong();
        this.note = jsonObject.get("vote_average").getAsFloat();
        this.anime = anime;
        this.numeroEpisode = jsonObject.get("episode_number").getAsLong();
        this.IdApiAnime = anime.getIdApi();
    }
    //region  === getter-setter ===

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdApi() {
        return idApi;
    }

    public void setIdApi(long idApi) {
        this.idApi = idApi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getSaison() {
        return saison;
    }

    public void setSaison(Long saison) {
        this.saison = saison;
    }

    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }



    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }

    public Long getNumeroEpisode() {
        return numeroEpisode;
    }

    public void setNumeroEpisode(Long numeroEpisode) {
        this.numeroEpisode = numeroEpisode;
    }

    public Long getIdApiAnime() {
        return IdApiAnime;
    }

    public void setIdApiAnime(Long idApiAnime) {
        IdApiAnime = idApiAnime;
    }
//endregion
}

