package airline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JLabel lbl_username, lbl_password, background;
    JPasswordField txt_password;
    JTextField txt_username;
    JButton btn_login, btn_cancel;

    public Login() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(590, 590);
        this.setTitle("Login");
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.white);
        background = new JLabel("");
        background.setIcon(new ImageIcon(ClassLoader.getSystemResource("airplane.png")));
        background.setSize(580, 580);

        lbl_username = new JLabel("Username");
        lbl_username.setBounds(60, 200, 100, 33);
        lbl_username.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 16));


        lbl_password = new JLabel("Password");
        lbl_password.setBounds(60, 250, 100, 33);
        lbl_password.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 16));



        txt_username = new JTextField();
        txt_username.setBounds(160, 200, 250, 33);
        txt_username.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 15));

        txt_password = new JPasswordField();
        txt_password.setBounds(160, 250, 250, 33);
        txt_password.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 15));

        btn_login = new JButton("Login");
        btn_login.setBounds(160, 305, 120, 30);
        btn_login.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 15));
        btn_login.setFocusable(false);
        btn_login.addActionListener(this);


        btn_cancel = new JButton("Cancel");
        btn_cancel.setBounds(290, 305, 120, 30);
        btn_cancel.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 15));
        btn_cancel.setFocusable(false);
        btn_cancel.addActionListener(this);

        this.add(background);
        this.add(lbl_username);
        this.add(txt_username);
        this.add(lbl_password);
        this.add(txt_password);
        this.add(btn_login);
        this.add(btn_cancel);

        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent event) {

        if (event.getSource() == btn_login) {
            try {
                Conn con = new Conn();
                String username = txt_username.getText();
                char[] passwordChar=txt_password.getPassword();
                String password = new String(passwordChar);
                String q = "select * from login where username='" + username + "' and password='" + password + "'";
                ResultSet resultSet = con.stm.executeQuery(q);

                if (resultSet.next()) {
                    new MainFrame().setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password.", "Information message", JOptionPane.INFORMATION_MESSAGE);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Database connection failure", "Error", JOptionPane.ERROR_MESSAGE);
                this.setVisible(false);
            }
        } else if (event.getSource() == btn_cancel) {
            System.exit(0);

        }

    }

    public static void main(String[] args) {
        new Login();
    }
}




