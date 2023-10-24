package airline;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class JourneyDetails extends JFrame {
    JTable table;
    JLabel lbl_source, lbl_destination, lbl_pnrNo, lbl_ticketId, lbl_flCode, lbl_jnyDate, lbl_jnyTime,label,label1;
    JButton btn_show;
    JScrollPane scroll;

    public  JourneyDetails(){

        this.setTitle("journey details");
        this.setLayout(null);
        this.setSize(860,650);
        this.setLocationRelativeTo(null);

        lbl_source = new JLabel("source");
        lbl_source.setBounds(60, 100, 150, 27);
        this.add(lbl_source);

        lbl_destination = new JLabel("destination");
        lbl_destination.setBounds(350, 100, 150, 27);
        this.add(lbl_destination);



        btn_show = new JButton("show");
        btn_show.setBounds(680, 100, 100, 30);
        this.add(btn_show);


        lbl_pnrNo = new JLabel("pnr_no");
        lbl_pnrNo.setBounds(79, 270, 83, 20);
        add(lbl_pnrNo);

        lbl_ticketId = new JLabel("ticket_id");
        lbl_ticketId.setBounds(172, 270, 71, 20);
        add(lbl_ticketId);

        lbl_flCode = new JLabel("fl_code");
        lbl_flCode.setBounds(297, 270, 103, 20);
        add(lbl_flCode);

        lbl_jnyDate = new JLabel("journet_date");
        lbl_jnyDate.setBounds(390, 270, 94, 20);
        add(lbl_jnyDate);

        lbl_jnyTime = new JLabel("journey_time");
        lbl_jnyTime.setBounds(494, 270, 83, 20);
        add(lbl_jnyTime);

        lbl_source = new JLabel("location");
        lbl_source.setBounds(613, 270, 94, 20);
        add(lbl_source);

        lbl_destination = new JLabel("destination");
        lbl_destination.setBounds(717, 270, 94, 20);
        add(lbl_destination);

        String[] cities_1 =  {"Belgrade", "Ankara", "Thessaloniki", "Patina","Zurich"};
        JComboBox<String> comboBox_1 = new JComboBox<>(cities_1);
        comboBox_1.setBounds(150, 100, 150, 27);
        add(comboBox_1);


        String[] cities_2 =  {"Belgrade", "Ankara", "Thessaloniki", "Patina","Zurich"};
        JComboBox<String> comboBox_2 = new JComboBox<>(cities_2);
        comboBox_2.setBounds(500, 100, 150, 27);
        add(comboBox_2);

        table = new JTable();
        table.setBounds(38, 310, 770, 130);
        this.add(table);

        scroll = new JScrollPane(table);
        scroll.setBounds(23, 250, 800, 300);
        scroll.setBackground(Color.WHITE);
        add(scroll);

        btn_show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try{
                    String location  = (String) comboBox_1.getSelectedItem();
                    String destination  = (String) comboBox_2.getSelectedItem();

                    Conn con = new Conn();

                    String str = "select * from reservation where start_location = '"+location+"' and destination = '"+destination+"'";
                    ResultSet rs= con.stm.executeQuery(str);


                    //if(rs.next())
                        table.setModel(DbUtils.resultSetToTableModel(rs));
                   /*else{
                        JOptionPane.showMessageDialog(null,"No flights between Start location and Destination");

                    }*/


                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        });


        this.setVisible(true);
    }

    public static void main(String[] args) {
        new JourneyDetails();
    }
}
