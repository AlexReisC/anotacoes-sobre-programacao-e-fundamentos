package DesignPatterns.comportamentais.command;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EditorGUI extends JFrame {
    JButton btnSalvar;
    JButton btnGravar;
    JTextArea areaDeTexto;
    JTextField nomeDoArquivo;

    Command cmdSalvar;

    public EditorGUI(){
        setTitle("Simple Editor");
        setLayout(null);
        setBounds(2000,100,640,480);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        btnSalvar = new JButton();
        btnSalvar.setText("Salvar");
        btnSalvar.setBounds(10, 10, 100, 50);
        getContentPane().add(btnSalvar);
        
        btnGravar = new JButton();
        btnGravar.setText("Gravar");
        btnGravar.setBounds(150, 10, 100, 50);
        getContentPane().add(btnGravar);

        nomeDoArquivo = new JTextField();
        nomeDoArquivo.setBounds(10, 90, 100, 30);
        getContentPane().add(nomeDoArquivo);

        areaDeTexto = new JTextArea();
        areaDeTexto.setBounds(10, 150, 400, 200);
        areaDeTexto.setEnabled(true);
        getContentPane().add(areaDeTexto);
        
        setVisible(true);

        btnGravar.addActionListener((e) -> {
            cmdSalvar = new SaveCommand(nomeDoArquivo.getText(), areaDeTexto.getText());
            cmdSalvar.execute();
        });

        btnSalvar.addActionListener((e) -> {
            cmdSalvar = new SaveCommand(nomeDoArquivo.getText(), areaDeTexto.getText());
            cmdSalvar.execute();
        });
    }
}
