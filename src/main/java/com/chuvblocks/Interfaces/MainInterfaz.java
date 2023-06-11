package com.chuvblocks.Interfaces;

import com.chuvblocks.Clases.Cliente;
import com.chuvblocks.Clases.ListaUsuarios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MainInterfaz extends JFrame {
    ListaUsuarios listaUsuarios = new ListaUsuarios();
    private JPanel mainPanel;
    private JPanel InicioSesion;
    private JButton iniciarSesionbtn;
    private JPanel Registro;
    private JButton registrarseButton;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton registrateButton;
    private JButton iniciarSesiónButton;
    private JTextField registro_txtNombre;
    private JTextField registro_txtApellido;
    private JTextField registro_txtEmail;
    private JTextField registro_txtCedula;
    private JPasswordField registro_txtContrasenia;

    public MainInterfaz() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(mainPanel);
        pack();
        registrateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarInterfaz("Registro");
            }
        });
        iniciarSesiónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarInterfaz("InicioSesion");
            }
        });
        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreCompleto = registro_txtNombre.getText() + " " + registro_txtApellido.getText();
                Cliente nuevoCliente = new Cliente(nombreCompleto, registro_txtCedula.getText(),
                        registro_txtEmail.getText(), Arrays.toString(registro_txtContrasenia.getPassword()));
                try {
                    listaUsuarios.agregarUsuario(nuevoCliente);
                    cambiarInterfaz("InicioSesion");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        iniciarSesionbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void cambiarInterfaz(String nombreInterfaz) {
        CardLayout layout = (CardLayout) mainPanel.getLayout();
        layout.show(mainPanel, nombreInterfaz);
    }

    public static void main(String[] args) {
        new MainInterfaz().setVisible(true);
    }
}
