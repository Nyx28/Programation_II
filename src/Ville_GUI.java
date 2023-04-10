import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
public class Ville_GUI extends  Ville{
    public static void main(String[] args) throws IOException {
        JFrame f=new JFrame("Schema de la ville");
        final JLabel label=new JLabel();
        label.setBounds(5,600, 950,50);
        JButton b1=new JButton("1");
        JButton b3=new JButton("3");
        JButton b5=new JButton("5");
        JButton b8=new JButton("8");
        JButton b10=new JButton("10");
        JButton b13=new JButton("13");
        JButton b15=new JButton("15");
        JButton b17=new JButton("17");
        JButton b19=new JButton("19");
        JButton b20=new JButton("20");
        b1.setBounds(150,700,50,50);
        b3.setBounds(200,700,50,50);
        b5.setBounds(250,700,50,50);
        b8.setBounds(300,700,50,50);
        b10.setBounds(350,700,50,50);
        b13.setBounds(150,650,50,50);
        b15.setBounds(200,650,50,50);
        b17.setBounds(250,650,50,50);
        b19.setBounds(300,650,50,50);
        b20.setBounds(350,650,50,50);
        label.setText("Veuillez sélectionner votre position");
        JLabel j1 = new JLabel();
        j1.setIcon(new ImageIcon(Ville_GUI.class.getResource("/Ville_Schema_Final (3).png")));
        j1.setBounds(0,0,600,600);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                label.setText(Djikstra(1));
            }
        });
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                label.setText(Djikstra(3));
            }
        });
        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                label.setText(Djikstra(5));
            }
        });
        b8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                label.setText(Djikstra(8));
            }
        });
        b10.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                label.setText(Djikstra(10));
            }
        });
        b13.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                label.setText(Djikstra(13));
            }
        });
        b15.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                label.setText(Djikstra(15));
            }
        });
        b17.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                label.setText(Djikstra(17));
            }
        });
        b19.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                label.setText(Djikstra(19));
            }
        });
        b20.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                label.setText(Djikstra(20));
            }
        });
        f.add(j1);
        f.add(b1);
        f.add(b3);
        f.add(b5);
        f.add(b8);
        f.add(b10);
        f.add(b13);
        f.add(b15);
        f.add(b17);
        f.add(b19);
        f.add(b20);
        f.add(label);
        f.setSize(750,850);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
