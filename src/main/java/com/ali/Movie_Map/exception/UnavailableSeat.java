package com.ali.Movie_Map.exception;

public class UnavailableSeat extends RuntimeException{
    public UnavailableSeat(String message){
        super(message);
    }
}
