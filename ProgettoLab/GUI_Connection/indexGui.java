package GUI_Connection;

import javax.swing.*;

class Finestra implements ActionListeners
{
    public static void main(String[] args) {

        JFrame finestraIniziale = new JFrame();
        JButton bottoneIngressoCentro = new JButton("Centro Vaccinale");
        JButton bottoneIngressoOp = new JButton("Operatore Sanitario");


        bottoneIngressoCentro.setBounds(100,150,100,50);
        bottoneIngressoOp.setBounds(200,150,100,50);
        finestraIniziale.add(bottoneIngressoCentro);
        finestraIniziale.add(bottoneIngressoOp);
        finestraIniziale.setSize(300, 400); 
        
        finestraIniziale.setLayout(null); //Nessun layout
        finestraIniziale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        finestraIniziale.setVisible(true); 
    }
}
