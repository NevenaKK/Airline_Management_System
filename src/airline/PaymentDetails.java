package airline;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentDetails extends JFrame{

    JTextField txt_pnrNo;
    JTable table;
    JLabel lbl_pnrNo;
    JButton btn_show;
    JLabel lbl_lightCode, lbl_capacity, lbl_classCode, lbl_className,lbl_cardNo,lbl_phoneNo;

    public PaymentDetails(){

        this.setTitle("payment details");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(960,590);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        lbl_pnrNo = new JLabel("pnr no");
        lbl_pnrNo.setBounds(60, 160, 150, 26);
        add(lbl_pnrNo);

        txt_pnrNo = new JTextField();
        txt_pnrNo.setBounds(200, 160, 150, 26);
        add(txt_pnrNo);

        btn_show = new JButton("show");
        btn_show.setBounds(200, 210, 150, 26);
        add(btn_show);

        table = new JTable();
        table.setBounds(45, 329, 766, 87);
        add(table);

        lbl_lightCode = new JLabel("pnr no");
        lbl_lightCode.setBounds(84, 292, 108, 26);
        add(lbl_lightCode);

        lbl_capacity = new JLabel("paid amount");
        lbl_capacity.setBounds(183, 298, 92, 14);
        add(lbl_capacity);

        lbl_classCode = new JLabel("pay date");
        lbl_classCode.setBounds(322, 294, 101, 24);
        add(lbl_classCode);

        lbl_className = new JLabel("cheque no");
        lbl_className.setBounds(455, 298, 114, 14);
        add(lbl_className);

       /* label = new JLabel("");
        label.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/payment.png")));
        label.setBounds(425, 15, 239, 272);
        add(label); SLIKAAAA */

        lbl_cardNo = new JLabel("card no");
        lbl_cardNo.setBounds(602, 299, 101, 19);
        add(lbl_cardNo);

        lbl_phoneNo = new JLabel("phone no");
        lbl_phoneNo.setBounds(712, 294, 86, 24);
        add(lbl_phoneNo);

        btn_show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){

                try {
                    String pnrNo_text  = txt_pnrNo.getText();

                    Conn conn = new Conn();
                    String str = "select pnr_no,paid_amount,pay_date,cheque_no,card_no,phone_no from payment where pnr_no = '"+pnrNo_text+"'";

                    ResultSet resultSet = conn.stm.executeQuery(str);

                    table.setModel(DbUtils.resultSetToTableModel(resultSet));

                }catch(SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        this.setVisible(true);

    }

    public static void main(String[] args) {
        new PaymentDetails();
    }
}
