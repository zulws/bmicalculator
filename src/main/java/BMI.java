import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class BMI extends JFrame {
    //Panel BMI 1
    JPanel panel = new JPanel();
    JPanel panelbtn = new JPanel();
    JPanel panelbmi1 = new JPanel();
    JPanel panelbmi12 = new JPanel();
    JPanel panelbmi13 = new JPanel();
    JPanel panelbmi14 = new JPanel();
    JPanel panelbmi15 = new JPanel();
    JPanel panelbmi16 = new JPanel();
    JPanel panelBMI = new JPanel();
    JPanel panelBMI2 = new JPanel();
    JPanel panelBMI3 = new JPanel();
    JPanel mainPanel = new JPanel();

    //panel BMI 2
    JPanel panelbmi21 = new JPanel();
    JPanel panelbmi22 = new JPanel();
    JPanel panelbmi23 = new JPanel();
    JPanel panelbmi24 = new JPanel();
    JPanel panelbmi25 = new JPanel();
    JPanel panelbmi26 = new JPanel();

    //panel BMI3
    JPanel panelbmi31 = new JPanel();
    JPanel panelbmi32 = new JPanel();
    JPanel panelbmi33 = new JPanel();
    JPanel panelbmi34 = new JPanel();
    JPanel panelbmi35 = new JPanel();
    JPanel panelbmi36 = new JPanel();
    JPanel panelbmi37 = new JPanel();
    JPanel panelbmi38 = new JPanel();

    //Panel datauser
    JPanel isidata = new JPanel();
    public static JTextField idtext1 = new JTextField();
    public static JTextField dobtext1 = new JTextField();
    public static JTextField nodata1 = new JTextField();
    JTextField hasilbmi = new JTextField();
    JTextField hasilkalori = new JTextField();
    JTextField hasildetakjantung = new JTextField();
    JLabel labelnodata = new JLabel("Nomor Data: ");
    JLabel labelnama = new JLabel("Nama: ");
    JLabel labeldob = new JLabel("Date Of Birth: ");
    JLabel labelbmi = new JLabel("Hasil BMI: ");
    JLabel labelkalori = new JLabel("Hasil Calorie: ");
    JLabel labeljantung = new JLabel("Hasil HeartRate: ");
    JTextField berattf = new JTextField();
    JTextField tinggitf = new JTextField();
    JLabel labelberat = new JLabel("Weight: ");
    JLabel labeltinggi = new JLabel("Height: ");
    JButton buttondone = new JButton("Selesai");



    //panel 1

    ImageIcon img1 = new ImageIcon(getClass().getResource("timbangan.png"));
    ImageIcon img2 = new ImageIcon(getClass().getResource("calori.png"));
    ImageIcon img3 = new ImageIcon(getClass().getResource("heart.png"));
    ImageIcon img4 = new ImageIcon(getClass().getResource("male.png"));
    ImageIcon img5 = new ImageIcon(getClass().getResource("female.png"));
    ImageIcon img6 = new ImageIcon(getClass().getResource("calendar.png"));

    //BMI2 button img
    ImageIcon gam1 = new ImageIcon(getClass().getResource("sedentary.png"));
    ImageIcon gam2 = new ImageIcon(getClass().getResource("walk.png"));
    ImageIcon gam3 = new ImageIcon(getClass().getResource("jumping.png"));
    ImageIcon gam4 = new ImageIcon(getClass().getResource("run.png"));
    ImageIcon gam5 = new ImageIcon(getClass().getResource("weightlift.png"));


    public static JLabel nomorid = new JLabel("Nomor ID: ");
    public static JLabel idd = new JLabel("ID");


    JButton btn1 = new JButton("BMI Calculator",img1);
    JButton btn2 = new JButton("Calory Intake Daily",img2);
    JButton btn3= new JButton("Heart Rate Zone",img3);

    //BMI 2 button
    JButton tomb1 = new JButton(gam1);
    JButton tomb2 = new JButton(gam2);
    JButton tomb3 = new JButton(gam3);
    JButton tomb4 = new JButton(gam4);
    JButton tomb5 = new JButton(gam5);

    //panel1.5
    //BMI 1 button gender age
    JButton malebmi1 = new JButton("Male", img4);
    JButton fembmi1 = new JButton("Female", img5);
    JButton agebmi1 = new JButton("Age", img6);

    //BMI 2 button gender age
    JButton malebmi2 = new JButton("Male", img4);
    JButton fembmi2 = new JButton("Female", img5);
    JButton agebmi2 = new JButton("Age", img6);

    //BMI 3 button gender age
    JButton malebmi3 = new JButton("Male", img4);
    JButton fembmi3 = new JButton("Female", img5);
    JButton agebmi3 = new JButton("Age", img6);

    //BMI1 textfiel dll
    public static JTextField textf = new JTextField();
    public static JLabel gender = new JLabel();
    public static JLabel umur = new JLabel();

    // BMI2 label textfield
    JTextField textfbmi2 = new JTextField();
    JLabel genderbmi2 = new JLabel();
    JLabel umurbmi2 = new JLabel();

    //BMI 3 label textfield
    JTextField textfbmi3 = new JTextField();
    JLabel genderbmi3 = new JLabel();
    JLabel umurbmi3 = new JLabel();


    //panel2
    //BMI 1 weight height
    JLabel weight = new JLabel("Weight");
    JLabel height = new JLabel("Height");
    public static JTextField weighttext = new JTextField();
    public static JTextField heighttext = new JTextField();
    JButton hitung = new JButton("Hitung");

    //BMI 2 weight Height
    JLabel weightbmi2 = new JLabel("Weight");
    JLabel heightbmi2 = new JLabel("Height");
    public static JTextField weighttextbmi2 = new JTextField();
    public static JTextField heighttextbmi2 = new JTextField();
    JButton hitungbmi2 = new JButton("Hitung");

    //panel3
    JLabel result = new JLabel("Result");
    JLabel hasil = new JLabel();

    //panel34
    ImageIcon imgbmi = new ImageIcon(getClass().getResource("bmipic2.png"));


    JLabel imgbmipic = new JLabel(imgbmi);




    //label BMI 1
    JLabel u = new JLabel("UnderWeight");
    JLabel p = new JLabel("<18.5");
    JLabel x = new JLabel("Normal");
    JLabel y = new JLabel("18.5-24.9");
    JLabel z = new JLabel("OverWeight");
    JLabel m = new JLabel("25-29.9");
    JLabel b = new JLabel("Obese");
    JLabel q = new JLabel("30-39.9");
    JLabel s = new JLabel("Morbidly Obese");
    JLabel l = new JLabel(">40");

    //label BMI 2
    JLabel level = new JLabel("Activity");
    JLabel leb1 = new JLabel("Basal Metabolic Rate");
    JLabel leb2 = new JLabel("-");
    JLabel leb3 = new JLabel("Mantain Weight");
    JLabel leb4 = new JLabel("-");
    JLabel leb5 = new JLabel("Smooth Weight loss");
    JLabel leb6 = new JLabel("-");
    JLabel leb7 = new JLabel("Fast Weight Loss");
    JLabel leb8 = new JLabel("-");

    //label BMI3
    JLabel MHR = new JLabel("Maximum Heart Rate ");
    JLabel BPM1 = new JLabel("-");


    JLabel HHZ = new JLabel("50-60% ");
    JLabel BPM2 = new JLabel("-");

    JLabel FHRZ = new JLabel("60-70% ");
    JLabel BPM3 = new JLabel("-");

    JLabel AHRZ = new JLabel("70-80% ");
    JLabel BPM4 = new JLabel("-");

    JLabel AZTZ = new JLabel("80-90% ");
    JLabel BPM5 = new JLabel("-");

    JButton hitungbmi3 = new JButton("Hitung");
    JButton selesaibmi3 = new JButton("Next");



    public BMI() {
        setTitle("BMI Calculator");
        setSize(600,800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        ImageIcon img = new ImageIcon(getClass().getResource("icon.jpg"));
        setIconImage(img.getImage());


        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));


        //panelID
        add(panel);
        panel.add(nomorid);
        panel.add(idd);


        //panel1 button
        add(panelbtn);
        panelbtn.add(btn1);
        panelbtn.add(btn2);
        panelbtn.add(btn3);

        mainPanel.setLayout(new CardLayout(10,10));
        add(mainPanel);
        mainPanel.add(panelBMI);
        panelBMI.setLayout(new BoxLayout(panelBMI,BoxLayout.Y_AXIS));
        panelBMI2.setLayout(new BoxLayout(panelBMI2,BoxLayout.Y_AXIS));
        panelBMI3.setLayout(new BoxLayout(panelBMI3,BoxLayout.Y_AXIS));

        //BMI 1
        panelBMI.add(panelbmi1);
        panelbmi1.setLayout(new GridLayout(1, 2));
        panelbmi1.add(malebmi1);
        panelbmi1.add(fembmi1);
        panelbmi1.add(agebmi1);
        panelbmi1.add(textf);



        panelBMI.add(panelbmi12);
        panelbmi12.add(gender);
        panelbmi12.add(umur);



        panelBMI.add(panelbmi13);
        panelbmi13.setLayout( new GridLayout(2,2));

        panelbmi13.add(weight);
        panelbmi13.add(height);
        panelbmi13.add(weighttext);
        panelbmi13.add(heighttext);
        panelBMI.add(hitung);



        //BORDER
        Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border,"BMI Calculator");
        titledBorder.setTitleFont(titledBorder.getTitleFont().deriveFont(Font.BOLD));
        panelbmi13.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10,10,10,10),titledBorder));

        Border bord = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBord = BorderFactory.createTitledBorder(bord, "");
        titledBord.setTitleFont(titledBord.getTitleFont().deriveFont(Font.BOLD));
        panelbmi1.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), titledBord));


        panelBMI.add(panelbmi14);
        panelbmi14.setLayout( new GridLayout(1,2));
        panelbmi14.add(result);
        panelbmi14.add(hasil);


        panelBMI.add(panelbmi15);
        panelbmi15.add(imgbmipic);


        panelBMI.add(panelbmi16);
        panelbmi16.setLayout(new GridLayout(5,2));
        panelbmi16.add(u);
        panelbmi16.add(p);
        panelbmi16.add(x);
        panelbmi16.add(y);
        panelbmi16.add(z);
        panelbmi16.add(m);
        panelbmi16.add(b);
        panelbmi16.add(q);
        panelbmi16.add(s);
        panelbmi16.add(l);



        //BORDER
        Border bor = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBor = BorderFactory.createTitledBorder(bor,"WeightResult");
        titledBor.setTitleFont(titledBor.getTitleFont().deriveFont(Font.BOLD));
        panelbmi16.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(15,15,15,15),titledBor));


        //BMI2
        panelBMI2.add(panelbmi21);
        panelbmi21.setLayout(new GridLayout(1, 2));
        panelbmi21.add(malebmi2);
        panelbmi21.add(fembmi2);
        panelbmi21.add(agebmi2);
        panelbmi21.add(textfbmi2);

        panelBMI2.add(panelbmi22);
        panelbmi22.add(genderbmi2);
        panelbmi22.add(umurbmi2);

        panelBMI2.add(panelbmi23);
        panelbmi23.setLayout( new GridLayout(2,2));

        panelbmi23.add(weightbmi2);
        panelbmi23.add(heightbmi2);
        panelbmi23.add(weighttextbmi2);
        panelbmi23.add(heighttextbmi2);
        panelBMI2.add(hitungbmi2);

        panelBMI2.add(panelbmi24);
        panelbmi24.add(level);

        panelBMI2.add(panelbmi25);
        panelbmi25.add(tomb1);
        panelbmi25.add(tomb2);
        panelbmi25.add(tomb3);
        panelbmi25.add(tomb4);
        panelbmi25.add(tomb5);

        panelBMI2.add(panelbmi26);
        panelbmi26.setLayout(new GridLayout(4, 2));
        panelbmi26.add(leb1);
        panelbmi26.add(leb2);
        panelbmi26.add(leb3);
        panelbmi26.add(leb4);
        panelbmi26.add(leb5);
        panelbmi26.add(leb6);
        panelbmi26.add(leb7);
        panelbmi26.add(leb8);



        //BORDER BMI2
        Border borderbmi2 = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorderbmi2 = BorderFactory.createTitledBorder(borderbmi2, "");
        titledBorder.setTitleFont(titledBorderbmi2.getTitleFont().deriveFont(Font.BOLD));
        panelbmi23.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), titledBorderbmi2));


        //BORDER
        Border borbmi2 = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorbmi2 = BorderFactory.createTitledBorder(borbmi2, "");
        titledBor.setTitleFont(titledBorbmi2.getTitleFont().deriveFont(Font.BOLD));
        panelbmi21.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(15, 15, 15, 15), titledBorbmi2));

        //BORDER
        Border border6 = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBord6 = BorderFactory.createTitledBorder(border6, "Your Activity Level");
        titledBord.setTitleFont(titledBord6.getTitleFont().deriveFont(Font.BOLD));
        panelbmi26.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), titledBord6));


        //BMI 3
        panelBMI3.add(panelbmi31);
        panelbmi31.setLayout(new GridLayout(1, 4));
        panelbmi31.add(malebmi3);
        panelbmi31.add(fembmi3);
        panelbmi31.add(agebmi3);
        panelbmi31.add(textfbmi3);

        panelBMI3.add(panelbmi32);
        panelbmi32.add(genderbmi3);
        panelbmi32.add(umurbmi3);

        panelBMI3.add(panelbmi33);
        panelbmi33.setLayout(new GridLayout(1,2));
        panelbmi33.add(MHR);
        panelbmi33.add(BPM1);

        panelBMI3.add(panelbmi34);
        panelbmi34.setLayout(new GridLayout(1,2));
        panelbmi34.add(HHZ);
        panelbmi34.add(BPM2);

        panelBMI3.add(panelbmi35);
        panelbmi35.setLayout(new GridLayout(1,2));
        panelbmi35.add(FHRZ);
        panelbmi35.add(BPM3);

        panelBMI3.add(panelbmi36);
        panelbmi36.setLayout(new GridLayout(1,2));
        panelbmi36.add(AHRZ);
        panelbmi36.add(BPM4);

        panelBMI3.add(panelbmi37);
        panelbmi37.setLayout(new GridLayout(1,2));
        panelbmi37.add(AZTZ);
        panelbmi37.add(BPM5);

        panelBMI3.add(panelbmi38);
        panelbmi38.setLayout(new GridLayout(1,2));
        panelbmi38.add(hitungbmi3);
        panelbmi38.add(selesaibmi3);

        //BORDER Heart Rate Zone
        Border borderbmi33 = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorderbmi33 = BorderFactory.createTitledBorder(borderbmi33, "Heart Rate Zone");
        titledBorderbmi33.setTitleFont(titledBorderbmi33.getTitleFont().deriveFont(Font.BOLD));
        panelbmi33.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), titledBorderbmi33));

        //BORDER Healthy Heart Rate Zone
        Border borderbmi34 = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorderbmi34 = BorderFactory.createTitledBorder(borderbmi34, " Healthy Heart Rate Zone");
        titledBorderbmi34.setTitleFont(titledBorderbmi34.getTitleFont().deriveFont(Font.BOLD));
        panelbmi34.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), titledBorderbmi34));

        //BORDER Fitness Heart Rate Zone
        Border borderbmi35 = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorderbmi35 = BorderFactory.createTitledBorder(borderbmi35, " Fitness Heart Rate Zone");
        titledBorderbmi35.setTitleFont(titledBorderbmi35.getTitleFont().deriveFont(Font.BOLD));
        panelbmi35.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), titledBorderbmi35));

        //BORDER Aerobic Heart Rate Zone
        Border borderbmi36 = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorderbmi36 = BorderFactory.createTitledBorder(borderbmi36, " Aerobic Heart Rate Zone");
        titledBorderbmi36.setTitleFont(titledBorderbmi36.getTitleFont().deriveFont(Font.BOLD));
        panelbmi36.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), titledBorderbmi36));

        //BORDER Anaerobic Heart Rate Zone
        Border borderbmi37 = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorderbmi37 = BorderFactory.createTitledBorder(borderbmi37, " Anaerobic Zone - Threshold Zone");
        titledBorderbmi37.setTitleFont(titledBorderbmi37.getTitleFont().deriveFont(Font.BOLD));
        panelbmi37.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), titledBorderbmi37));

        //Panel data User
        mainPanel.add(isidata);
        isidata.setLayout(new GridLayout(10,2));
        isidata.add(labelnodata);
        isidata.add(nodata1);
        isidata.add(labelnama);
        isidata.add(idtext1);
        isidata.add(labeldob);
        isidata.add(dobtext1);
        isidata.add(labelberat);
        isidata.add(berattf);
        isidata.add(labeltinggi);
        isidata.add(tinggitf);
        isidata.add(labelbmi);
        isidata.add(hasilbmi);
        isidata.add(labelkalori);
        isidata.add(hasilkalori);
        isidata.add(labeljantung);
        isidata.add(hasildetakjantung);
        isidata.add(buttondone);

        Border borderdata = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorderdata = BorderFactory.createTitledBorder(borderdata, "Data Hasil");
        titledBorderdata.setTitleFont(titledBorder.getTitleFont().deriveFont(Font.BOLD));
        isidata.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), titledBorderdata));


        malebmi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text2;
                text2 = "Male";


                gender.setText(String.valueOf(text2));
                genderbmi2.setText(String.valueOf(text2));
                genderbmi3.setText(String.valueOf(text2));
            }
        });

        fembmi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text2;
                text2 = "Female";


                gender.setText(String.valueOf(text2));
                genderbmi2.setText(String.valueOf(text2));
                genderbmi3.setText(String.valueOf(text2));
            }
        });

        agebmi1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int age;
                age = Integer.valueOf(textf.getText());


                umur.setText(String.valueOf(", "+ age + " Years Old"));
                umurbmi2.setText(String.valueOf(", "+ age + " Years Old"));
                umurbmi3.setText(String.valueOf(", "+ age + " Years Old"));
            }
        });

        //BMI 2 activity
        tomb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text2;
                double text3;
                double text4;
                double text5;
                double text6;


                text2 = "Sedentary Activity";

                text3 = Double.parseDouble(leb2.getText());
                text4 = text3 + 364;
                text5 = text3 - 136;
                text6 = text3 - 320;

                leb6.setText(String.valueOf(text5));
                leb4.setText(String.valueOf(text4));
                leb8.setText(String.valueOf(text6));

                level.setText(String.valueOf(text2));

            }
        });

        tomb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text2;
                double text3;
                double text4;
                double text5;
                double text6;

                text2 = "Light Activity";

                text3 = Double.parseDouble(leb2.getText());
                text4 = text3 + 682;
                text5 = text3 + 182;
                text6 = text3 - 318;

                leb6.setText(String.valueOf(text5));
                leb4.setText(String.valueOf(text4));
                leb8.setText(String.valueOf(text6));

                level.setText(String.valueOf(text2));
            }
        });

        tomb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text2;
                double text3;
                double text4;
                double text5;
                double text6;

                text2 = "Moderate Activity";

                text3 = Double.parseDouble(leb2.getText());
                text4 = text3 + 1001;
                text5 = text3 + 501;
                text6 = text3 + 1;

                leb6.setText(String.valueOf(text5));
                leb4.setText(String.valueOf(text4));
                leb8.setText(String.valueOf(text6));

                level.setText(String.valueOf(text2));
            }
        });

        tomb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text2;
                double text3;
                double text4;
                double text5;
                double text6;

                text2 = "Vigorous Activity";

                text3 = Double.parseDouble(leb2.getText());
                text4 = text3 + 1320;
                text5 = text3 + 1360;
                text6 = text3 + 1340;

                leb6.setText(String.valueOf(text5));
                leb4.setText(String.valueOf(text4));
                leb8.setText(String.valueOf(text6));

                level.setText(String.valueOf(text2));
            }
        });

        tomb5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text2;
                double text3;
                double text4;
                double text5;
                double text6;

                text2 = "Extreme Activity";

                text3 = Double.parseDouble(leb2.getText());
                text4 = text3 + 1638;
                text5 = text3 + 1138;
                text6 = text3 + 638;

                leb6.setText(String.valueOf(text5));
                leb4.setText(String.valueOf(text4));
                leb8.setText(String.valueOf(text6));

                level.setText(String.valueOf(text2));
            }
        });

        hitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double berat, tinggi, bmi, last;
                berat = Double.parseDouble(weighttext.getText());
                tinggi = Double.parseDouble(heighttext.getText());

                bmi = berat / (tinggi * tinggi);
                last = bmi * 10000;

                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bmicalculator","root","Master123@");

                    String Query = "Insert Into data" + "(ID,Weight,Height,Age,Gender)" + "values(?,?,?,?,?)";
                    PreparedStatement pst = connection.prepareStatement(Query);

                    pst.setString(1,idd.getText());
                    pst.setString(2,weighttext.getText());
                    pst.setString(3,heighttext.getText());
                    pst.setString(4,textf.getText());
                    pst.setString(5,gender.getText());
                    pst.executeUpdate();

                    Statement st = connection.createStatement();

                    String sql = "select * from data";
                    ResultSet rs = st.executeQuery(sql);


                    while (rs.next()){
                        String nodata = String.valueOf(rs.getInt("NoData"));
                        nodata1.setText(nodata);
                    }

                } catch (Exception exception){
                    exception.printStackTrace();
                }


                hasil.setText(String.valueOf(last));
                String s = hasil.getText();
                String b = weighttext.getText();
                String h = heighttext.getText();

                hasilbmi.setText(s);
                berattf.setText(b);
                tinggitf.setText(h);

            }
        });

        //BMI 2 hitung
        hitungbmi2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double berat, tinggi,  hasilak;
                int age1;
                berat = Double.parseDouble(weighttextbmi2.getText());
                tinggi = Double.parseDouble(heighttextbmi2.getText());
                age1 = Integer.valueOf(textfbmi2.getText());


                hasilak = 66 + (13 * berat) + (5 * tinggi) - (6 * age1);
                leb2.setText(String.valueOf(hasilak));
                String s = leb2.getText();
                hasilkalori.setText(s);

            }
        });

        //BMI3 Hitung
        hitungbmi3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int text3;
                int text4;
                double text5;
                double text6;
                double text7;
                double text8;


                text3 =Integer.valueOf(textfbmi3.getText());
                text4 = 220-text3;
                text5 = text4 * 0.6;
                text6 = text4 * 0.7;
                text7 = text4 * 0.8;
                text8 = text4 * 0.9;

                BPM1.setText(String.valueOf(text4 + "  BPM"));
                String s = BPM1.getText();
                hasildetakjantung.setText(s);
                BPM2.setText(String.valueOf(text5 + "  BPM"));
                BPM3.setText(String.valueOf(text6 + "  BPM"));
                BPM4.setText(String.valueOf(text7 + "  BPM"));
                BPM5.setText(String.valueOf(text8 + "  BPM"));

            }
        });

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(panelBMI);
                mainPanel.repaint();
                mainPanel.revalidate();
                setTitle("BMI Calculator");

            }
        });


        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(panelBMI2);
                mainPanel.repaint();
                mainPanel.revalidate();
                setTitle("Calorie Intake Daily");

                String age = textf.getText();
                String w = weighttext.getText();
                String h = heighttext.getText();
                textfbmi2.setText(age);
                weighttextbmi2.setText(w);
                heighttextbmi2.setText(h);
                textfbmi3.setText(age);
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(panelBMI3);
                mainPanel.repaint();
                mainPanel.revalidate();
                setTitle("Heart Rate Zone");
            }
        });

        selesaibmi3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelbtn.removeAll();
                mainPanel.removeAll();
                mainPanel.add(isidata);
                mainPanel.repaint();
                mainPanel.revalidate();
                setTitle("Data User");
                setSize(500,500);
                setLocationRelativeTo(null);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
            }
        });

        buttondone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bmicalculator","root","Master123@");

                    String query = "insert into hasil" + "(NoData,HasilBMI,HasilCalorie,HasilHeartRate)" + "values (?,?,?,?)";
                    PreparedStatement pst = connection.prepareStatement(query);

                    pst.setString(1,nodata1.getText());
                    pst.setString(2,hasilbmi.getText());
                    pst.setString(3,hasilkalori.getText());
                    pst.setString(4,hasildetakjantung.getText());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Terima kasih telah menggunakan Program kami");
                    System.exit(0);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    BMI bmi = new BMI();
                    bmi.setVisible(true);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}