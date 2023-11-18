package airline;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class JourneyDetails extends JFrame {
    JTable table;
    JLabel lbl_source, lbl_destination;
    JButton btn_show;
    JScrollPane scroll;

    public  JourneyDetails(){

        this.setTitle("journey details");
        this.setLayout(null);
        this.setSize(848,518);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);

        lbl_source = new JLabel("source");
        lbl_source.setBounds(50, 80, 150, 27);
        lbl_source.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 15));
        this.add(lbl_source);

        lbl_destination = new JLabel("destination");
        lbl_destination.setBounds(330, 80, 150, 27);
        lbl_destination.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 15));
        this.add(lbl_destination);


        btn_show = new JButton("show");
        btn_show.setBounds(680, 80, 120, 30);
        btn_show.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD, 15));
        this.add(btn_show);



        String[] cities_1 =  {"Belgrade", "Ankara", "Thessaloniki", "Patina","Zurich"};
        JComboBox<String> comboBox_1 = new JComboBox<>(cities_1);
        comboBox_1.setBounds(112, 80, 150, 27);
        add(comboBox_1);


        String[] cities_2 =  {"Belgrade", "Ankara", "Thessaloniki", "Patina","Zurich"};
        JComboBox<String> comboBox_2 = new JComboBox<>(cities_2);
        comboBox_2.setBounds(442, 80, 150, 27);
        add(comboBox_2);

        table = new JTable();
        table.setBounds(38, 200, 770, 100);
        table.setFont(new Font(Font.MONOSPACED, Font.ITALIC, 14));

        scroll = new JScrollPane(table);
        scroll.setBounds(23, 200, 800, 250);
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
