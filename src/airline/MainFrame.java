package airline;

import javax.swing.*;

public class MainFrame extends JFrame {


    JMenuBar menuBar;
    JMenu system, exit_logout;
    JMenuItem flight, addCustomer, journey, payment, cancellation, logout, exit;

    public MainFrame() {

        this.setTitle("Airline reservation management system");
        this.setSize(580, 280);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        menuBar = new JMenuBar();

        system = new JMenu("Airline system  ");
        exit_logout = new JMenu("Exit / Logout");
        flight = new JMenuItem("flight info");
        system.add(flight);
        addCustomer = new JMenuItem("add customer");
        system.add(addCustomer);
        journey = new JMenuItem("journey details");
        system.add(journey);
        payment = new JMenuItem("payment details");
        system.add(payment);
        cancellation = new JMenuItem("cancellation");
        system.add(cancellation);

        logout = new JMenuItem("logout      ");
        exit_logout.add(logout);
        exit = new JMenuItem("exit       ");
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


        this.setVisible(true);


    }

    public static void main(String[] args) {
        new MainFrame();
    }

}
