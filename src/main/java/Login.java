import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.text.SimpleDateFormat;


public class Login extends JFrame {

    //gambar
    ImageIcon img1 = new ImageIcon(getClass().getResource("bmilogo.jpg"));
    JLabel imglogo = new JLabel(img1);


    //panel1 submit
    JLabel id = new JLabel("Nama:");
    JLabel pass = new JLabel("DateOfBirth:");
    public static JTextField idtext = new JTextField();
    public static JDateChooser dobtext = new JDateChooser();
    SimpleDateFormat dobformat = new SimpleDateFormat("dd MMMM yyyy");
    JPanel mainPanel = new JPanel();
    JPanel panelsubmit = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panelimg = new JPanel();
    JButton button1 = new JButton("Submit");
    JButton button2 = new JButton("Cari Data");

    //panel2 kedua
    JPanel panelcari = new JPanel();
    JPanel paneltextcari = new JPanel();
    JLabel caridata = new JLabel("Cari Data Berdasarkan ID : ");
    JTextField caridatatf = new JTextField();

    //panel isi data
    JPanel isidata =  new JPanel();
    JLabel ID =  new JLabel("No Data: ");
    JTextField idtf = new JTextField();
    JLabel nama =  new JLabel("Nama: ");
    JTextField namatf =  new JTextField();
    JLabel dob = new JLabel("Date Of Birth: ");
    JTextField dobtf = new JTextField();
    JLabel weight = new JLabel("Weight: ");
    JTextField weighttf = new JTextField();
    JLabel height = new JLabel("Height: ");
    JTextField heighttf = new JTextField();
    JLabel age = new JLabel("Age: ");
    JTextField agetf = new JTextField();
    JLabel hasilbmi = new JLabel("Hasil BMI: ");
    JTextField hasilbmitf = new JTextField();
    JLabel hasilkalori = new JLabel("Hasil Kalori: ");
    JTextField hasilkaloritf = new JTextField();
    JLabel detakjantung = new JLabel("Heart Rate: ");
    JTextField detakjantungtf = new JTextField();



    //panel button cari
    JPanel panelbuttoncari =  new JPanel();
    JButton buttoncari = new JButton("Cari");

    //panel button back
    JPanel panelback = new JPanel();
    JButton buttonback = new JButton("Kembali");


    public Login(){
        setTitle("Isi Biodata");
        setSize(550,470);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        ImageIcon img = new ImageIcon(getClass().getResource("icon.jpg"));
        setIconImage(img.getImage());


        setLayout(new BoxLayout(getContentPane(),BoxLayout.Y_AXIS));

        mainPanel.setLayout(new CardLayout(10,10));
        add(mainPanel);
        mainPanel.add(panelsubmit);
        panelsubmit.setLayout(new BoxLayout(panelsubmit,BoxLayout.Y_AXIS));
        panelcari.setLayout(new BoxLayout(panelcari,BoxLayout.Y_AXIS));

        //Panel Submit
        panelsubmit.add(panelimg);
        panelimg.add(imglogo);

        panelsubmit.add(panel1);
        panel1.setLayout( new GridLayout(2,2));
        panel1.add(id);
        panel1.add(idtext);
        panel1.add(pass);
        panel1.add(dobtext);

        panelsubmit.add(panel2);
        panel2.add(button1);
        panel2.add(button2);

        Border border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorder = BorderFactory.createTitledBorder(border,"");
        titledBorder.setTitleFont(titledBorder.getTitleFont().deriveFont(Font.BOLD));
        panel1.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5,5,5,5),titledBorder));


        //Panel Cari Data
        panelcari.add(paneltextcari);
        paneltextcari.setLayout(new GridLayout(1,1));
        paneltextcari.add(caridata);
        paneltextcari.add(caridatatf);

        //panel button cari
        panelcari.add(panelbuttoncari);
        panelbuttoncari.add(buttoncari);

        //Panel Isi data
        panelcari.add(isidata);
        isidata.setLayout(new GridLayout(9,2));
        isidata.add(ID);
        isidata.add(idtf);
        isidata.add(nama);
        isidata.add(namatf);
        isidata.add(dob);
        isidata.add(dobtf);
        isidata.add(weight);
        isidata.add(weighttf);
        isidata.add(height);
        isidata.add(heighttf);
        isidata.add(age);
        isidata.add(agetf);
        isidata.add(hasilbmi);
        isidata.add(hasilbmitf);
        isidata.add(hasilkalori);
        isidata.add(hasilkaloritf);
        isidata.add(detakjantung);
        isidata.add(detakjantungtf);

        Border borderdata = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        TitledBorder titledBorderdata = BorderFactory.createTitledBorder(borderdata,"");
        titledBorderdata.setTitleFont(titledBorderdata.getTitleFont().deriveFont(Font.BOLD));
        isidata.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5,5,5,5),titledBorderdata));


        //panel button
        panelcari.add(panelback);
        panelback.add(buttonback);



        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = idtext.getText();
                String d = dobformat.format(dobtext.getDate());

                if (idtext.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Silahkan Isi Data terlebih dahulu");
                    setVisible(true);
                } else {


                    try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bmicalculator", "root", "Master123@");

                        String Query = "Insert into biodata" + "(Nama,DateOfBirth)" + "values (?,?)";
                        PreparedStatement pst = connection.prepareStatement(Query);

                        pst.setString(1, idtext.getText());
                        pst.setString(2, dobformat.format(dobtext.getDate()));
                        pst.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Selamat Datang Pada Aplikasi BMI Calculator Kami");

                        Statement st = connection.createStatement();

                        String sql = "select * from biodata";
                        ResultSet rs = st.executeQuery(sql);
                        BMI bmi = new BMI();
                        bmi.setVisible(false);


                        while (rs.next()) {

                            String ID = String.valueOf(rs.getInt("ID"));

                            bmi.idd.setText(ID);
                        }

                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }

                    BMI bmi = new BMI();


                    bmi.idtext1.setText(s);
                    bmi.dobtext1.setText(String.valueOf(d));

                    setVisible(false);
                    bmi.setVisible(true);
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(panelcari);
                mainPanel.repaint();
                mainPanel.revalidate();
                setTitle("Cari Data");
            }
        });

        buttonback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();
                mainPanel.add(panelsubmit);
                mainPanel.repaint();
                mainPanel.revalidate();
                setTitle("Isi Biodata");
            }
        });

        buttoncari.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bmicalculator", "root", "Master123@");
                    String values = caridatatf.getText();
                    String query1 = "select D.NoData,A.Nama, A.DateOfBirth, D.Weight, D.Height, D.Age,H.HasilBMI,H.HasilCalorie,H.HasilHeartRate\n" +
                            "From bmicalculator.biodata A\n" +
                            "Join bmicalculator.data D ON A.ID = D.ID\n" +
                            "Join bmicalculator.hasil H ON D.NoData = H.NoData\n" +
                            "where A.ID =" + values;

                    PreparedStatement stm = connection.prepareStatement(query1);

                    ResultSet rs = stm.executeQuery(query1);


                    while(rs.next()) {
                        String nodata = String.valueOf(rs.getInt("NoData"));
                        String nama = String.valueOf(rs.getString("Nama"));
                        String dob = String.valueOf(rs.getString("DateOfBirth"));
                        String weight = String.valueOf(rs.getDouble("Weight"));
                        String height = String.valueOf(rs.getDouble("Height"));
                        String age = String.valueOf(rs.getInt("Age"));
                        String hasilbmi = String.valueOf(rs.getDouble("HasilBMI"));
                        String hasilkalori = String.valueOf(rs.getDouble("HasilCalorie"));
                        String detakjantung = String.valueOf(rs.getString("HasilHeartRate"));

                        idtf.setText(nodata);
                        namatf.setText(nama);
                        dobtf.setText(dob);
                        weighttf.setText(weight + " KG");
                        heighttf.setText(height + " CM");
                        agetf.setText(age + " Years Old");
                        hasilbmitf.setText(hasilbmi);
                        hasilkaloritf.setText(hasilkalori);
                        detakjantungtf.setText(detakjantung);
                    }

                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
