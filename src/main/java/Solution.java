import javax.swing.*;
import java.awt.*;

public class Solution extends JFrame {

    public Solution() throws HeadlessException {
        setBounds(300, 300, 300, 300);
        setLayout(new FlowLayout());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String args[]) throws Exception {
        new Solution();
    }
}