package com.devsmms.mindgames.game.controllers;

import com.devsmms.mindgames.game.enums.GameTypes;
import com.devsmms.mindgames.game.factories.GameFactoryGenerator;
import com.devsmms.mindgames.game.factories.GameFactory;
import com.devsmms.mindgames.game.players.GamePlayer;
import com.devsmms.mindgames.game.tables.GameTable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class GameController {
    private final GameTable gameTable;
    private final GamePlayer p1;
    private final GamePlayer p2;
    private GamePlayer winner;

    GameController(GameTypes target) {
        GameFactory gameFactory = GameFactoryGenerator.getGameFactory(target);
        p1 = gameFactory.createPlayer();
        p2 = gameFactory.createPlayer();
        gameTable = gameFactory.createTable();
        winner = null;
    }

    public GameTable getGameTable() {
        return gameTable;
    }

    public GamePlayer getP1() {
        return p1;
    }

    public GamePlayer getP2() {
        return p2;
    }

    public GamePlayer getWinner() { return winner; }

    public void setUpPlayers(String p1, String p2){
        this.p1.setName(p1);
        this.p2.setName(p2);
    }

    public boolean coordinatesValidation(String coords) {
        coords = coords.toUpperCase();
        int dim = this.gameTable.getTable().length;
        char maxWord = (char) (64 + dim);
        Pattern p = Pattern.compile("^[A-" + maxWord + "][1-" + dim + "]$");
        Matcher m = p.matcher(coords);
        return m.matches();
    }

}
