package main.java.Database;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.ReplaceOptions;
import main.java.Model.Player;
import org.bson.Document;
import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Projections.fields;

/*
 * Main class to communicate with database - MongoDB
 *
 * Author: Luu Pham Manh Ha - 1752001
 */
public class Database {

    private static MongoClient client;

    private static MongoDatabase db;

    private static String currentUsername;

    public static String getCurrentUsername() {

        return currentUsername;
    }

    public static void connect(String connection, String database) {

        client = MongoClients.create(connection);
        db = client.getDatabase(database);
    }

    public static void close() {
        client.close();
    }

    public static boolean addUser(String username, String password) {

        String hash = BCrypt.hashpw(password, BCrypt.gensalt());
        Document user = new Document("username", username).append("password", hash);

        MongoCollection users = db.getCollection("Users");
        Document existUser = (Document) users.find(new Document("username", username)).first();
        if (existUser == null) {
            db.getCollection("Users").insertOne(user);
            return true;
        }

        return false;
    }

    public static boolean authenticate(String username, String password) {

        Document user = new Document("username", username);

        Document getResult  = db.getCollection("Users").find(user).first();
        if (getResult == null)
            return false;

        if (BCrypt.checkpw(password, getResult.get("password").toString())) {

            currentUsername = username;
            //System.out.println(getResult.get("username") + " " + getResult.get("password"));
            return true;
        }

        return false;
    }

    public static List<Document> getRankingBoard() {

        MongoCollection rankingBoard = db.getCollection("Player");

        List<Document> list = new ArrayList<>();

        for (Object doc : rankingBoard.find()
                        .projection(fields(excludeId()))) {

            list.add((Document)doc);
        }

        return list;
    }

    public static Player getPlayerInfo(String username) {

        Document user = new Document("username", username);

        Document player = db.getCollection("Player").find(user).first();

        if (player == null)
            return new Player();

        return new Player(username, player.get("playerName").toString(),
                        Integer.parseInt(player.get("highScoreEasy").toString()),
                        Integer.parseInt(player.get("highScoreNormal").toString()),
                        Integer.parseInt(player.get("highScoreHard").toString()));
    }

    public static void update(Player player) {

        String username = player.getUsername();
        if (username == "" || username == null)
            return;
        Document playerUpdate = new Document("username", username)
                                    .append("playerName", player.getName())
                                    .append("highScoreEasy", player.getHighScoreEasy())
                                    .append("highScoreNormal", player.getHighScoreNormal())
                                    .append("highScoreHard", player.getHighScoreHard());

        ReplaceOptions replaceOptions = new ReplaceOptions().upsert(true).bypassDocumentValidation(true);

        try {
            db.getCollection("Player")
                    .replaceOne(eq("username", username), playerUpdate, replaceOptions);
        } catch (MongoException ex) {
            System.out.println("Update failed");
        }
    }
}