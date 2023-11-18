package airline;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    JLabel background;
    JMenuBar menuBar;
    JMenu system, exit_logout;
    JMenuItem flight, addCustomer, journey, payment, cancellation, logout, exit;

    public MainFrame() {

        this.setSize(842, 682);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        background = new JLabel("");
        background.setIcon(new ImageIcon(ClassLoader.getSystemResource("airplane_2.jpg")));
        background.setSize(842, 622);

        menuBar = new JMenuBar();

        system = new JMenu("Airline system  ");
        system.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 16));

        exit_logout = new JMenu("Exit / Logout");
        exit_logout.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 16));


        flight = new JMenuItem("flight info");
        flight.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 16));
        system.add(flight);
        addCustomer = new JMenuItem("add customer");
        addCustomer.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 16));
        system.add(addCustomer);
        journey = new JMenuItem("journey details");
        journey.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 16));
        system.add(journey);
        payment = new JMenuItem("payment details");
        payment.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 16));
        system.add(payment);
        cancellation = new JMenuItem("cancellation");
        cancellation.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 16));
        system.add(cancellation);

        logout = new JMenuItem("logout      ");
        logout.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 16));
        exit_logout.add(logout);
        exit = new JMenuItem("exit       ");
        exit.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 16));
        exit_logout.add(exit);


        menuBar.add(system);
        menuBar.add(exit_logout);

        this.setJMenuBar(menuBar);


        logout.addActionListener(actionEvent -> {
            setVisible(false);
            new Login();
        });

        exit.addActionListener(actionEvent -> System.exit(0));

        flight.addActionListener(ae -> new FlightInfo());

        addCustomer.addActionListener(ae -> new AddCistomer());

        journey.addActionListener(ae -> new JourneyDetails());

        payment.addActionListener(ae -> new PaymentDetails());

        cancellation.addActionListener(ae -> new Cancellation());

        this.add(background);
        this.setVisible(true);



    }

    public static void main(String[] args) {
        new MainFrame();
    }

}
