package main;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame {

    private JLabel LogL, NombreL, CorreoL, ContraL;
    private JTextField NombreT, CorreoT, ContraT;
    private JButton IngresarB;

    Connection con;

    public Login() {
        setTitle("Login usuario");
        setSize(500, 400);
        getContentPane().setBackground(Color.pink);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        conectar();

        LogL = new JLabel("LOGIN");
        LogL.setBounds(200, 20, 150, 50);
        LogL.setFont(new Font("Arial", Font.BOLD, 24));
        add(LogL);

        NombreL = new JLabel("Nombre: ");
        NombreL.setBounds(50, 80, 150, 50);
        NombreL.setFont(new Font("Arial", Font.BOLD, 16));
        add(NombreL);

        CorreoL = new JLabel("Correo: ");
        CorreoL.setBounds(50, 160, 150, 50);
        CorreoL.setFont(new Font("Arial", Font.BOLD, 16));
        add(CorreoL);
        
        ContraL = new JLabel("Contraseña: ");
        ContraL.setBounds(50, 240, 150, 50);
        ContraL.setFont(new Font("Arial", Font.BOLD, 16));
        add(ContraL);

        NombreT = new JTextField();
        NombreT.setBounds(160, 93, 100, 30);
        add(NombreT);

        CorreoT = new JTextField();
        CorreoT.setBounds(160, 170, 100, 30);
        add(CorreoT);

        ContraT = new JTextField();
        ContraT.setBounds(160, 250, 100, 30);
        add(ContraT);

        IngresarB = new JButton("Ingresar");
        IngresarB.addActionListener(e -> insertar());
        IngresarB.setBounds(350, 155, 100, 30);
        add(IngresarB);
    }

    public void conectar() {
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Usuario",
                    "root",
                    "admin"
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error conexión: " + e.getMessage());
        }
    }

    public void insertar() {
        try {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Login (nombre, correo, contraseña) VALUES (?, ?, ?)"
            );
            ps.setString(1, NombreT.getText());
            ps.setString(2, CorreoT.getText());
            ps.setString(3, ContraT.getText());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Insertado");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
}
