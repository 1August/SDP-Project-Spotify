package com.company.FacadePattern;

import com.company.Entities.Artist;
import com.company.Entities.Song;
import com.company.Entities.Subscriber;
import com.company.Repositories.ArtistRepository;
import com.company.Repositories.SubscriberRepository;

import java.util.List;

public class SpotifySubAccount {
    private static SubscriberRepository subscriberRepository = new SubscriberRepository();
    private static ArtistRepository artistRepository = new ArtistRepository();
    private static AccountBalanceChecker balanceChecker = new AccountBalanceChecker();

    public Subscriber getSub(String email){
        return subscriberRepository.getSubs(email);
    }

    public Subscriber loginSub(String email, String password){
        balanceChecker = new AccountBalanceChecker(subscriberRepository.loginSubscriber(email, password));
        return subscriberRepository.loginSubscriber(email, password);
    }

    public Subscriber saveSub(Subscriber subscriber){
        subscriberRepository.saveSubscriber(new Subscriber(subscriber.getName(), subscriber.getSurname(), subscriber.getEmail(), subscriber.getPassword()));
        balanceChecker = new AccountBalanceChecker(subscriber);
        return subscriberRepository.loginSubscriber(subscriber.getEmail(), subscriber.getPassword());
    }

//  public getArtists()

    public void purchaseProduct(Subscriber subscriber, double money){
        balanceChecker.setSubscriber(subscriber);
        balanceChecker.decreaseMoney(money);
    }

    public void addMoney(Subscriber subscriber, double money){
        balanceChecker.setSubscriber(subscriber);
        balanceChecker.increaseMoney(money);
    }

    public List<Artist> getAllArtist(){
        return artistRepository.getAllArtist();
    }

    public List<Song> getSongsOfArtist(String artistName, String artistSurname){
        return artistRepository.getArtistByNameAndSurname(artistName, artistSurname).getSongs();
    }
}
