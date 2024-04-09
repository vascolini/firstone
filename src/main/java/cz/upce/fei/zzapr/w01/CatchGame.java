package cz.upce.fei.zzapr.w01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

class Player {
    int x, y;
    int score;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.score = 0;
    }
}

class GameObject {
    int x, y;

    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class CatchGame extends JFrame implements KeyListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int NUM_OBJECTS = 10;
    private static final int OBJECT_SIZE = 20;
    private static final int PLAYER_SIZE = 20;

    private List<Player> players;
    private List<GameObject> objects;
    private Timer timer;

    public CatchGame() {
        setTitle("Catch Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        players = new ArrayList<>();
        players.add(new Player(WIDTH / 4, HEIGHT / 2));
        players.add(new Player(3 * WIDTH / 4, HEIGHT / 2));

        objects = new ArrayList<>();
        generateObjects();

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        startTimer();
    }

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                generateObjects();
                repaint();
            }
        }, 0, 2000); // Generate new objects every 2 seconds
    }

    private void generateObjects() {
        objects.clear();
        Random random = new Random();
        for (int i = 0; i < NUM_OBJECTS; i++) {
            int x = random.nextInt(WIDTH - OBJECT_SIZE);
            int y = random.nextInt(HEIGHT - OBJECT_SIZE);
            objects.add(new GameObject(x, y));
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw players
        g2d.setColor(Color.RED);
        for (Player player : players) {
            g2d.fillRect(player.x, player.y, PLAYER_SIZE, PLAYER_SIZE);
        }

        // Draw objects
        g2d.setColor(Color.GREEN);
        for (GameObject object : objects) {
            g2d.fillOval(object.x, object.y, OBJECT_SIZE, OBJECT_SIZE);
        }

        // Display scores
        g2d.setColor(Color.WHITE);
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            g2d.drawString("Player " + (i + 1) + " Score: " + player.score, 10, 20 + i * 20);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_UP) {
            movePlayer(0, -5, 0);
        } else if (keyCode == KeyEvent.VK_DOWN) {
            movePlayer(0, 5, 0);
        } else if (keyCode == KeyEvent.VK_LEFT) {
            movePlayer(-5, 0, 0);
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            movePlayer(5, 0, 0);
        } else if (keyCode == KeyEvent.VK_W) {
            movePlayer(0, 0, 1);
        } else if (keyCode == KeyEvent.VK_S) {
            movePlayer(0, 0, 1);
        } else if (keyCode == KeyEvent.VK_A) {
            movePlayer(0, 0, -1);
        } else if (keyCode == KeyEvent.VK_D) {
            movePlayer(0, 0, 1);
        }
    }

    private void movePlayer(int dx, int dy, int playerIndex) {
        Player player = players.get(playerIndex);
        player.x += dx;
        player.y += dy;
        checkCollision(player);
        repaint();
    }

    private void checkCollision(Player player) {
        Rectangle playerRect = new Rectangle(player.x, player.y, PLAYER_SIZE, PLAYER_SIZE);
        for (int i = 0; i < objects.size(); i++) {
            GameObject object = objects.get(i);
            Rectangle objectRect = new Rectangle(object.x, object.y, OBJECT_SIZE, OBJECT_SIZE);
            if (playerRect.intersects(objectRect)) {
                player.score++;
                objects.remove(i);
                break; // Exit loop after collision with one object
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CatchGame game = new CatchGame();
            game.setVisible(true);
        });
    }
}

