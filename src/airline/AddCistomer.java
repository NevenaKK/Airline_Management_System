package airline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCistomer extends JFrame {

    JLabel lbl_flight_code,lbl_passport_no,lbl_pnr_no,lbl_address,lbl_nationality,lbl_name,lbl_gender,lbl_phone_no;
    JTextField flight_code,passport_no,pnr_no,address,nationality,name,gender,phone_no;
    JButton btn_save;
    JRadioButton rbtn_male,rbtn_female;
    ButtonGroup rbtn_group;
    public AddCistomer(){


        this.setTitle("Add customer details");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setSize(778,506);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.white);


        lbl_flight_code=new JLabel("flight code");
        lbl_flight_code.setBounds(60, 30, 150, 27);
        lbl_flight_code.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD , 15));
        flight_code=new JTextField();
        flight_code.setBounds(200,30,150,27);
        this.add(lbl_flight_code);
        this.add(flight_code);

        lbl_passport_no=new JLabel("passport no");
        lbl_passport_no.setBounds(60, 80, 150, 27);
        lbl_passport_no.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD , 15));
        passport_no=new JTextField();
        passport_no.setBounds(200,80,150,27);
        this.add(lbl_passport_no);
        this.add(passport_no);

        lbl_pnr_no=new JLabel("pnr no");
        lbl_pnr_no.setBounds(60, 120, 150, 27);
        lbl_pnr_no.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD , 15));
        pnr_no=new JTextField();
        pnr_no.setBounds(200,130,150,27);
        this.add(lbl_pnr_no);
        this.add(pnr_no);

        lbl_address=new JLabel("adrdress");
        lbl_address.setBounds(60, 170, 150, 27);
        lbl_address.setFont(new Font(Font.MONOSPACED, Font.ITALIC| Font.BOLD  , 15));
        address=new JTextField();
        address.setBounds(200,180,150,27);
        this.add(lbl_address);
        this.add(address);

        lbl_nationality=new JLabel("nationality");
        lbl_nationality.setBounds(60, 220, 150, 27);
        lbl_nationality.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD , 15));
        nationality=new JTextField();
        nationality.setBounds(200,230,150,27);
        this.add(lbl_nationality);
        this.add(nationality);

        lbl_name=new JLabel("name");
        lbl_name.setBounds(60, 270, 150, 27);
        lbl_name.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD , 15));
        name=new JTextField();
        name.setBounds(200,280,150,27);
        this.add(lbl_name);
        this.add(name);

        lbl_gender=new JLabel("gender");
        lbl_gender.setBounds(60, 320, 150, 27);
        lbl_gender.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD , 15));
        this.add(lbl_gender);

        rbtn_male=new JRadioButton("male");
        rbtn_male.setBackground(Color.white);
        rbtn_male.setBounds(196,320,70,27);
        rbtn_male.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD , 15));
        this.add(rbtn_male);
        rbtn_female=new JRadioButton("female");
        rbtn_female.setBackground(Color.white);
        rbtn_female.setBounds(274,320,80,27);
        rbtn_female.setFont(new Font(Font.MONOSPACED, Font.ITALIC| Font.BOLD  , 15));
        this.add(rbtn_female);
        rbtn_group=new ButtonGroup();
        rbtn_group.add(rbtn_male);
        rbtn_group.add(rbtn_female);

        lbl_phone_no=new JLabel("phone no");
        lbl_phone_no.setBounds(60, 370, 150, 27);
        lbl_phone_no.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD , 15));
        phone_no=new JTextField();
        phone_no.setBounds(200,380,150,27);
        this.add(lbl_phone_no);
        this.add(phone_no);


        btn_save=new JButton("save");
        btn_save.setBounds(200,420,150,30);
        btn_save.setFont(new Font(Font.MONOSPACED, Font.ITALIC | Font.BOLD , 15));
        this.add(btn_save);

        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String fligthCode=flight_code.getText();
                String passportNo=passport_no.getText();
                String pnrNo=pnr_no.getText();
                String addressText=address.getText();
                String nationalityText=nationality.getText();
                String nameText=name.getText();
                String genderText= null;
                String phoneNo=phone_no.getText();

                if(rbtn_male.isSelected())
                    genderText="male";
                else if(rbtn_female.isSelected())
                    genderText="female";

                try{
                    if (!fligthCode.isEmpty() && !passportNo.isEmpty() && !pnrNo.isEmpty()
                        && !addressText.isEmpty() && !nationalityText.isEmpty() && !nameText.isEmpty()
                            && !genderText.isEmpty() && !phoneNo.isEmpty())
                     {

                        Conn con=new Conn();
                        String q = "INSERT INTO passanger values( '"+pnrNo+"', '"+addressText+"', '"+nationalityText+
                                "','"+nameText+"', '"+genderText+"', '"+phoneNo+"','"+passportNo+"', '"+fligthCode+"')";

                        con.stm.executeUpdate(q);
                        JOptionPane.showMessageDialog(null,"Customer Added");
                        setVisible(false);
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Input all information.",
                                "Information message", JOptionPane.INFORMATION_MESSAGE);
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }


            }
        });

        this.setVisible(true);



    }

    public static void main(String[] args) {
        new AddCistomer();
    }
}
