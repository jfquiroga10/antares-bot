/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.antaresbot.listeners;

import com.mycompany.antaresbot.events.MusicStatusEvent;
import com.mycompany.antaresbot.main.Bot;
import java.util.logging.Level;
import java.util.logging.Logger;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.ReadyEvent;
import sx.blah.discord.handle.impl.events.StatusChangeEvent;
import sx.blah.discord.handle.obj.Status;
import sx.blah.discord.handle.obj.Status.StatusType;
import sx.blah.discord.util.DiscordException;
import sx.blah.discord.util.MessageBuilder;
import sx.blah.discord.util.MissingPermissionsException;
import sx.blah.discord.util.RateLimitException;
import sx.blah.discord.util.RequestBuffer;
import sx.blah.discord.util.audio.events.AudioPlayerEvent;
import sx.blah.discord.util.audio.events.TrackStartEvent;

/**
 *
 * @author jFluxie
 */
public class EventListener {

    private boolean ready;

    private static Status status;

    public EventListener(IDiscordClient client) {
        client.getDispatcher().registerListener(this);
        status = null;
        ready = false;
    }

    @EventSubscriber
    public void onReady(ReadyEvent event) {

        ready = true;

    }

    /*
    @EventSubscriber
    public void onChangeGame(StatusChangeEvent event) {

        String oldGame = event.getOldStatus().getStatusMessage();
        String newGame = event.getNewStatus().getStatusMessage();

        String message;

        //User is not in a game at the moment and starts playing
        if (oldGame == null && newGame != null) {
            message = event.getUser() + " has entered " + newGame;

            //User is already in a game and stops playing
        } else if (oldGame != null && newGame == null) {
            message = event.getUser() + " has left " + oldGame;

            //User has two games active at the moment
        } else if (oldGame != null && newGame != null) {
            message = event.getUser() + " has changed from " + oldGame + " to " + newGame;
        } //We should never enter this place
        else {
            message = "";
        }

        RequestBuffer.request(() -> {

            try {
                new MessageBuilder(Bot.client).withChannel("182651110756974592").withContent(message).build();
            } catch (RateLimitException | DiscordException | MissingPermissionsException ex) {
                Logger.getLogger(EventListener.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
        );

    }
     */

    public boolean getReadyStatus() {
        return ready;
    }

    /*
    @EventSubscriber
    public void onSongStart(AudioPlayerEvent e) throws DiscordException, RateLimitException
    {
        System.out.println("LLEGAMOS A QUI PAPA");
        MusicStatusEvent musicStart=new MusicStatusEvent(StatusType.STREAM, "ola k asen");
        Bot.client.changeStatus(musicStart);
       
    
    }
     */
}
