package airline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cancellation extends JFrame {


    JTextField txt_cancellationDate, txt_passengerNO, txt_cancellationNo, txt_flightCode;
    JLabel lbl_passengerNo,lbl_cancellationNo,lbl_cancellationDate,lbl_flightCode;
    JButton btn_cancel;

    public Cancellation(){

        this.setTitle("cancellation");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.white);
        this.setSize(520,400);
        this.setLayout(null);
        this.setLocationRelativeTo(null);


        lbl_passengerNo = new JLabel("passenger number");
        lbl_passengerNo.setBounds(40, 50, 200, 26);
        lbl_passengerNo.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 15));
        add(lbl_passengerNo);

        lbl_cancellationNo = new JLabel("cancellation number");
        lbl_cancellationNo.setBounds(40, 100, 200, 27);
        lbl_cancellationNo.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 15));
        add(lbl_cancellationNo);

        lbl_cancellationDate = new JLabel("cancellation date");
        lbl_cancellationDate.setBounds(40, 150, 200, 27);
        lbl_cancellationDate.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 15));
        add(lbl_cancellationDate);

        lbl_flightCode = new JLabel("flight code");
        lbl_flightCode.setBounds(40, 200, 200, 27);
        lbl_flightCode.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 15));
        add(lbl_flightCode);

        btn_cancel = new JButton("cancel");
        btn_cancel.setBounds(230, 250, 200, 30);
        btn_cancel.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 15));
        btn_cancel.setFocusable(false);

        add(btn_cancel);

        txt_passengerNO = new JTextField();
        txt_passengerNO.setBounds(230, 50, 200, 27);
        txt_passengerNO.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 15));
        add(txt_passengerNO);

        txt_cancellationNo = new JTextField();
        txt_cancellationNo.setBounds(230, 100, 200, 27);
        txt_cancellationNo.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 15));
        add(txt_cancellationNo);

        txt_cancellationDate = new JTextField();
        txt_cancellationDate.setBounds(230, 150, 200, 27);
        txt_cancellationDate.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 15));
        add(txt_cancellationDate);

        txt_flightCode = new JTextField();
        txt_flightCode.setBounds(230, 200, 200, 27);
        txt_flightCode.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 15));
        add(txt_flightCode);

        btn_cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){

                String passenger_no = txt_cancellationDate.getText();
                String cancellation_no = txt_passengerNO.getText();
                String cancellation_date = txt_cancellationNo.getText();
                String flight_code = txt_flightCode.getText();


                try{
                    if (!passenger_no.isEmpty() && !cancellation_no.isEmpty() && !cancellation_date.isEmpty() && !flight_code.isEmpty()) {

                        Conn con = new Conn();
                        String q = "INSERT INTO cancellation values('"+passenger_no+"', '"+cancellation_no+"', '"+cancellation_date+"', '"+flight_code+"')";

                        con.stm.executeUpdate(q);
                        JOptionPane.showMessageDialog(null,"Ticket Canceled");
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Input all information.",
                                "Information message", JOptionPane.INFORMATION_MESSAGE);
                    }


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
