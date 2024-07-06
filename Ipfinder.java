
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

import javax.swing.*;

public class Ipfinder implements ActionListener {

  public static void main(String[] args) {

    JFrame jFrame = new JFrame("IP finder program");
    jFrame.setBounds(100, 100, 1000, 200);  // Increased height for better visibility
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the application on window close

    JLabel label = new JLabel("Enter URL: ");
    JTextField textField = new JTextField(20);
    JButton button = new JButton("Find IP");

    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String url = textField.getText();
        try {
          InetAddress ia = InetAddress.getByName(url);
          String ip = ia.getHostAddress();
          JOptionPane.showMessageDialog(jFrame, "IP Address: " + ip);
        } catch (UnknownHostException unknownHostException) {
          String nf = "Not Found";
          unknownHostException.printStackTrace();
          JOptionPane.showMessageDialog(jFrame, nf);
        }
      }
    });

    jFrame.setLayout(new FlowLayout()); // Using FlowLayout for simplicity
    jFrame.add(label);
    jFrame.add(textField);
    jFrame.add(button);
    jFrame.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // This method needs to be overridden because of the ActionListener interface
    // However, it's not used in this example
  }
}

