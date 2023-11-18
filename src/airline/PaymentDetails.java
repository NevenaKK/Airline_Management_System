package airline;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDetails extends JFrame{

    JTextField txt_pnrNo;
    JTable table;
    JScrollPane scroll;
    JLabel lbl_pnrNo;
    JButton btn_show;

    public PaymentDetails(){

        this.setTitle("payment details");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(850,595);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);

        lbl_pnrNo = new JLabel("Passenger Name Record");
        lbl_pnrNo.setBounds(40, 60, 250, 26);
        lbl_pnrNo.setFont(new Font(Font.MONOSPACED, Font.ITALIC| Font.BOLD  , 15));
        add(lbl_pnrNo);

        txt_pnrNo = new JTextField();
        txt_pnrNo.setBounds(250, 60, 150, 26);
        txt_pnrNo.setFont(new Font(Font.MONOSPACED, Font.ITALIC| Font.BOLD  , 15));
        add(txt_pnrNo);

        btn_show = new JButton("show");
        btn_show.setBounds(250, 100, 150, 26);
        btn_show.setFont(new Font(Font.MONOSPACED, Font.ITALIC| Font.BOLD  , 15));
        btn_show.setFocusable(false);
        add(btn_show);

        table = new JTable();
        table.setBounds(45, 279, 766, 87);
        table.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 14));

        scroll=new JScrollPane(table);
        scroll.setBounds(20,140,805,400);
        add(scroll);


        btn_show.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){

                String pnrNo_text  = txt_pnrNo.getText();

                try {

                    Conn conn = new Conn();
                    String str = "select pnr_no,paid_amount,pay_date,cheque_no,card_no,phone_no from payment where pnr_no = '"+pnrNo_text+"'";

                    ResultSet resultSet = conn.stm.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                }catch(SQLException e) {
                    JOptionPane.showMessageDialog(null, "Database connection failure", "Error", JOptionPane.ERROR_MESSAGE);
                    System.exit(0);
                }
            }
        });

        this.setVisible(true);

    }

    public static void main(String[] args) {
        new PaymentDetails();
    }
}
