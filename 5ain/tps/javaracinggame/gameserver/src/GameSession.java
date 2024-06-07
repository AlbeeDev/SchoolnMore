import java.util.ArrayList;
import java.util.List;

public class GameSession {
    private String sessionId;
    private List<Player> players;
    private GameState gameState;

    public GameSession(String sessionId, List<Player> players) {
        this.sessionId = sessionId;
        this.players = players;
        this.gameState = new GameState(); // Initialize game state
    }

    public synchronized List<Player> getPlayers() {
        return new ArrayList<>(players); // Return a copy to avoid concurrent modification
    }

    public int getnumplayers() {
        return players.size();
    }
}