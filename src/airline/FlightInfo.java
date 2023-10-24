package airline;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FlightInfo extends JFrame {


        JLabel flightCode , flightInformation;
        JButton btnShow;
        JTextField txt_flightCode;
        JTable table;
        JScrollPane scroll;

    public FlightInfo(){

        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(842,642);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);



        flightInformation = new JLabel("flight information");
        flightInformation.setBounds(270, 22, 345, 35);
        this.add(flightInformation);

        flightCode = new JLabel("flight code");
        flightCode.setBounds(50, 100, 200, 30);
        this.add(flightCode);

        txt_flightCode = new JTextField();
        txt_flightCode.setBounds(180, 100, 150, 30);
        add(txt_flightCode);

        btnShow = new JButton("show");
        btnShow.setBounds(180, 135, 150, 22);
        btnShow.setFocusable(false);
        this.add(btnShow);

        table=new JTable();
        table.setBounds(20,190,805,400);

        scroll=new JScrollPane(table);
        scroll.setBounds(20,190,805,400);
        add(scroll);



        btnShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String f_code= txt_flightCode.getText();

                try {

                    Conn conn=new Conn();
                    String q="select fl_code,fl_name,start_location,destination,capacity,class_code,class_name from flight ,sector where fl_code = '"+f_code+"'";

                    ResultSet resultSet=conn.stm.executeQuery(q);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));


                }catch (SQLException e){
                    JOptionPane.showMessageDialog(null, "Database connection failure", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }


            }
        });


        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FlightInfo();
    }
}
