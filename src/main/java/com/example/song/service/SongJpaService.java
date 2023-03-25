package com.example.song.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.song.repository.SongJpaRepository;
import com.example.song.model.*;
import com.example.song.repository.*;

@Service
public class SongJpaService implements SongRepository{

    @Autowired 
    private SongJpaRepository songJpaRepository;

    @Override
    public ArrayList<Song>getSongsList(){
        List<Song>songsList=songJpaRepository.findAll();
        ArrayList<Song>getSongsList=new ArrayList<>(songsList);
        return getSongsList;
    }

    @Override

    public Song getSong(int songId){
        try{
                Song song=songJpaRepository.findById(songId).get();

                return song;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
    }

    @Override

    public Song addSong(Song song){
        songJpaRepository.save(song);
        return song;
    }

    @Override
    public Song updateSong(int songId,Song song){
         try{
                Song newsong=songJpaRepository.findById(songId).get();

                if(song.getsongName()!=null){
                    newsong.setsongName(song.getsongName());
                }

                if(song.getlyricist()!=null){
                    newsong.setlyricist(song.getlyricist());
                }
                if(song.getsinger()!=null){
                    newsong.setsinger(song.getsinger());
                }
                if(song.getmusicDirector()!=null){
                    newsong.setmusicDirector(song.getmusicDirector());
                }

                songJpaRepository.save(newsong);
                return newsong;

        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
    }
    
    @Override

    public void deleteSong(int songId){  
        try{
            songJpaRepository.deleteById(songId);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}