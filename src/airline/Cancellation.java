package airline;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cancellation extends JFrame {


    JTextField txt_cancellationDate, txt_passengerNO, txt_cancellationNo,textField_3, txt_flightCode;
    JLabel lbl_passengerNo,lbl_cancellationNo,lbl_cancellationDate,lbl_flightCode;
    JButton btn_cancel;

    public Cancellation(){

        this.setTitle("cancellation");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(860,500);
        this.setLayout(null);
        this.setLocationRelativeTo(null);


        lbl_passengerNo = new JLabel("passenger no");
        lbl_passengerNo.setBounds(60, 100, 132, 26);
        add(lbl_passengerNo);

        lbl_cancellationNo = new JLabel("cancellation no");
        lbl_cancellationNo.setBounds(60, 150, 150, 27);
        add(lbl_cancellationNo);

        lbl_cancellationDate = new JLabel("cancellation date");
        lbl_cancellationDate.setBounds(60, 200, 180, 27);
        add(lbl_cancellationDate);

        lbl_flightCode = new JLabel("flight code");
        lbl_flightCode.setBounds(60, 300, 150, 27);
        add(lbl_flightCode);

        JButton btn_cancel = new JButton("cancel");
        btn_cancel.setBounds(250, 350, 150, 30);
        add(btn_cancel);

        txt_passengerNO = new JTextField();
        txt_passengerNO.setBounds(250, 100, 150, 27);
        add(txt_passengerNO);

        txt_cancellationNo = new JTextField();
        txt_cancellationNo.setBounds(250, 150, 150, 27);
        add(txt_cancellationNo);

        txt_cancellationDate = new JTextField();
        txt_cancellationDate.setBounds(250, 200, 150, 27);
        add(txt_cancellationDate);

        txt_flightCode = new JTextField();
        txt_flightCode.setBounds(250, 300, 150, 27);
        add(txt_flightCode);

        btn_cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){

                String passenger_no = txt_cancellationDate.getText();
                String cancellation_no = txt_passengerNO.getText();
                String cancellation_date = txt_cancellationNo.getText();
                String flight_code = txt_flightCode.getText();


                try{
                    Conn con = new Conn();
                    String q = "INSERT INTO cancellation values('"+passenger_no+"', '"+cancellation_no+"', '"+cancellation_date+"', '"+flight_code+"')";

                    con.stm.executeUpdate(q);
                    JOptionPane.showMessageDialog(null,"Ticket Canceled");
                    setVisible(false);

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Cancellation();
    }
}
