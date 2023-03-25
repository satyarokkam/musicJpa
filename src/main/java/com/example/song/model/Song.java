package com.example.song.model;

import javax.persistence.*;

@Entity
@Table(name="playlist")
public class Song{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="songid")
    private int songId;

    @Column(name="songname")
    private String songName;

    @Column(name="lyricist")
    private String lyricist;

    @Column(name="singer")
    private String singer;


    @Column(name="musicdirector")
    private String musicDirector;

    public Song(){

    }

    public Song(int songId,String songName,String lyricist,String singer,String musicDirector){
        this.songId=songId;
        this.songName=songName;
        this.lyricist=lyricist;
        this.singer=singer;
        this.musicDirector=musicDirector;
    }

    public void setsongId(int songId){
        this.songId=songId;

    }
    public int getsongId(){
        return songId;
    }

    public void setsongName(String songName){
        this.songName=songName;
    }
    public String getsongName(){
        return songName;
    }

    public void setlyricist(String lyricist){
        this.lyricist=lyricist;
    }
    public String getlyricist(){
        return lyricist;
    }

    public void setsinger(String singer){
        this.singer=singer;
    }
    public String getsinger(){
        return singer;
    }

    public void setmusicDirector(String musicDirector){
        this.musicDirector=musicDirector;
    }
    public String getmusicDirector(){
        return musicDirector;
    }

}