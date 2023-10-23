/*package yachts;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Yacht> flotaYachts = new ArrayList<Yacht>();
        Yacht yacht1 = new Yacht(2000000, "AtlantaBlue");
        Yacht yacht2 = new Yacht(1500000, "OceanDream");
        Yacht yacht3 = new Yacht(800000, "SailAway");

        flotaYachts.add(yacht1);
        flotaYachts.add(yacht2);
        flotaYachts.add(yacht3);
    }
}
*/
package yachts;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Yacht> flotaYachts = new ArrayList<>();
    private static JTextArea outputTextArea;
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Aplicație Yacht");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Nume Yacht:");
        nameLabel.setBounds(1,1,100,30);
        JTextField nameTextField = new JTextField();
        nameTextField.setBounds(100,1,100,30);

        JLabel lengthLabel = new JLabel("Lungime (m):");
        lengthLabel.setBounds(1,50,100,30);
        JTextField lengthTextField = new JTextField();
        lengthTextField.setBounds(100,50,100,30);

        JLabel priceLabel = new JLabel("Pret (euro):");
        priceLabel.setBounds(1,100,100,30);
        JTextField priceTextField = new JTextField();
        priceTextField.setBounds(100,100,100,30);

        JButton addButton = new JButton("Adauga Yacht");
        addButton.setBounds(220,1,120,50);
        JButton displayButton = new JButton("Afiseaza Flota");
        displayButton.setBounds(350, 1, 120, 50);

        JButton deleteButton = new JButton("Sterge Yacht");
        deleteButton.setBounds(220,60,120,50);
        panel.add(deleteButton);

        JButton calculateTotalValueButton = new JButton("Calculeaza Valoarea Totala");
        calculateTotalValueButton.setBounds(350, 60, 120, 50);
        panel.add(calculateTotalValueButton);

        outputTextArea = new JTextArea(10, 40);
        outputTextArea.setBounds(1,150,600,100);
        outputTextArea.setEditable(false);

        panel.setBackground(Color.black);
        outputTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        outputTextArea.setBackground(Color.white);
        addButton.setBackground(Color.blue);
        addButton.setForeground(Color.white);
        nameLabel.setForeground(Color.white);
        lengthLabel.setForeground(Color.white);
        priceLabel.setForeground(Color.white);
        displayButton.setBackground(Color.blue);
        displayButton.setForeground(Color.white);
        deleteButton.setBackground(Color.blue);
        deleteButton.setForeground(Color.white);
        calculateTotalValueButton.setBackground(Color.blue);
        calculateTotalValueButton.setForeground(Color.white);

        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(lengthLabel);
        panel.add(lengthTextField);
        panel.add(priceLabel);
        panel.add(priceTextField);
        panel.add(addButton);
        panel.add(displayButton);
        panel.add(deleteButton);
        panel.add(calculateTotalValueButton);
        panel.add(outputTextArea);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nume = nameTextField.getText();
                String lungimeText = lengthTextField.getText();
                String pretText = priceTextField.getText();
        
                if (nume.isEmpty() || lungimeText.isEmpty() || pretText.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Toate câmpurile trebuie completate.");
                    return;
                }
        
                int lungime;
                double pret;
        
                try {
                    lungime = Integer.parseInt(lungimeText);
                    pret = Double.parseDouble(pretText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Lungimea și prețul trebuie să fie numere valide.");
                    return;
                }
        
                if (pret < 0) {
                    JOptionPane.showMessageDialog(frame, "Pretul trebuie să fie pozitiv.");
                    return;
                }
        
                if (pret >= 1000000) {
                    int result = JOptionPane.showConfirmDialog(frame, "Acest yacht este de lux. Continuați?", "Verificare Lux", JOptionPane.YES_NO_OPTION);
                    if (result != JOptionPane.YES_OPTION) {
                        return;
                    }
                }
        
                Yacht yacht = new Yacht(nume, lungime, pret);
                flotaYachts.add(yacht);
        
                nameTextField.setText("");
                lengthTextField.setText("");
                priceTextField.setText("");
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayFlota();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nume = nameTextField.getText();
                boolean yachtGasit = false;
        
                for (int i = 0; i < flotaYachts.size(); i++) {
                    Yacht yacht = flotaYachts.get(i);
                    if (yacht.getNume().equals(nume)) {
                        flotaYachts.remove(i);
                        yachtGasit = true;
                        break;
                    }
                }
        
                if (yachtGasit) {
                    JOptionPane.showMessageDialog(frame, "Yacht-ul a fost șters din flotă.");
                    nameTextField.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Yacht-ul nu a fost găsit în flotă.");
                }
        
                displayFlota();
            }
        });
        
        

        calculateTotalValueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double totalValue = 0;

                for (Yacht yacht : flotaYachts) {
                    totalValue += yacht.getPret();
                }

                JOptionPane.showMessageDialog(frame, "Valoarea totala a flotei este: " + totalValue + " euro.");
            }
        });

        frame.add(panel);
        frame.setVisible(true);
    }

    private static void displayFlota() {
        StringBuilder flotaInfo = new StringBuilder();
        for (Yacht yacht : flotaYachts) {
            flotaInfo.append(yacht.toString()).append("\n");
        }
        outputTextArea.setText(flotaInfo.toString());
    }
}
