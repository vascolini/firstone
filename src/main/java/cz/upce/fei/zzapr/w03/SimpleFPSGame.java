package cz.upce.fei.zzapr.w03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

class Dot {
    int x;
    int y;
    Color color;
    Rectangle boundingBox;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = Color.YELLOW; // All dots are yellow
        this.boundingBox = new Rectangle(x, y, 20, 20);
    }
}

public class SimpleFPSGame extends JFrame implements MouseListener {
    private int playerX, playerY;
    private List<Dot> dots;
    private int score;
    private JLabel scoreLabel;
    private Timer timer;
    private int currentDelay; // Current delay for dot appearance

    private static final int EASY_DELAY = 3000; // 2 seconds
    private static final int MEDIUM_DELAY = 2000; // 1.5 seconds
    private static final int HARD_DELAY = 1900; // 1 second
    private static final int SCORE_TO_MEDIUM = 10; // Score threshold to switch to medium difficulty
    private static final int SCORE_TO_HARD = 15; // Score threshold to switch to hard difficulty

    public SimpleFPSGame() {
        setTitle("Simple FPS Game");
        setSize(2024, 1600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);

        playerX = getWidth() / 2;
        playerY = getHeight() / 2;

        addMouseListener(this);

        score = 0;
        dots = new ArrayList<>();
        currentDelay = EASY_DELAY; // Start with easy difficulty
        startTimer();

        scoreLabel = new JLabel("Score: " + score);
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setBounds(10, 10, 100, 30);
        add(scoreLabel);
    }

    private void startTimer() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                generateObject();
            }
        }, 0, currentDelay);
    }

    private void generateObject() {
        Random random = new Random();
        int x = random.nextInt(getWidth() - 20);
        int y = random.nextInt(getHeight() - 20);
        dots.add(new Dot(x, y));
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw dots
        for (Dot dot : dots) {
            g2d.setColor(dot.color);
            g2d.fillOval(dot.x, dot.y, 20, 20);
        }

        // Draw player
        g2d.setColor(Color.RED);
        g2d.fillOval(playerX, playerY, 20, 20);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        Point clickPoint = e.getPoint();
        for (int i = 0; i < dots.size(); i++) {
            Dot dot = dots.get(i);
            if (dot.boundingBox.contains(clickPoint)) {
                explodeDot(dot);
                dots.remove(i);
                score++;
                updateScore();
                break; // Exit loop after removing dot
            }
        }
        repaint();
    }

    private void explodeDot(Dot dot) {
        Timer explodeTimer = new Timer();
        explodeTimer.scheduleAtFixedRate(new TimerTask() {
            int explosionSize = 1;
            @Override
            public void run() {
                explosionSize += 10; // Increase explosion size
                dot.boundingBox.width = explosionSize;
                dot.boundingBox.height = explosionSize;
                repaint();
                if (explosionSize >= 40) { // Max explosion size
                    explodeTimer.cancel(); // Stop the timer
                }
            }
        }, 0, 20); // Increase the explosion every 20 milliseconds
    }

    private void updateScore() {
        scoreLabel.setText("Score: " + score);
        checkDifficulty();
    }

    private void checkDifficulty() {
        if (score >= SCORE_TO_HARD) {
            currentDelay = HARD_DELAY;
        } else if (score >= SCORE_TO_MEDIUM) {
            currentDelay = MEDIUM_DELAY;
        }
        stopTimer();
        startTimer();
    }

    private void stopTimer() {
        if (timer != null) {
            timer.cancel();
            timer.purge();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleFPSGame game = new SimpleFPSGame();
            game.setVisible(true);
        });
    }
}
