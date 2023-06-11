package com.chuvblocks.Interfaces;

import com.chuvblocks.Clases.Cliente;
import com.chuvblocks.Clases.ListaUsuarios;
import com.chuvblocks.Clases.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainInterfaz extends JFrame {
    ListaUsuarios listaUsuarios = new ListaUsuarios();
    Usuario usuarioEnLinea;
    private JPanel mainPanel;
    private JPanel InicioSesion;
    private JButton iniciarSesionbtn;
    private JPanel Registro;
    private JButton registrarseButton;
    private JTextField inicioSesion_textCedula;
    private JPasswordField inicioSesion_Contrasenia;
    private JButton registrateButton;
    private JButton irAIniciarSesionbtn;
    private JTextField registro_txtNombre;
    private JTextField registro_txtApellido;
    private JTextField registro_txtEmail;
    private JTextField registro_txtCedula;
    private JPasswordField registro_txtContrasenia;
    private JPanel Clientes;
    private JPanel Empleados;
    private JButton cerrarSesionButton;
    private JTextField USmodificarPerfil_txtNombre;
    private JTextField USmodificarPerfil_txtCedula;
    private JTextField USmodificarPerfil_txtEmail;
    private JTextField USmodificarPerfil_txtContrasenia;
    private JButton USmodificarPerfil_btnModificar;
    private JTextField UScrearProyecto_txtNombre;
    private JTextField UScrearProyecto_Ubicacion;
    private JTextField UScrearProyecto_Tiempo;
    private JCheckBox UScrearProyecto_chkMateriales;
    private JCheckBox UScrearProyecto_chkEspaciosVerdes;
    private JCheckBox UScrearProyecto_chkParqueadero;
    private JCheckBox UScrearProyecto_chkExtras;
    private JTextArea UScrearProyecto_txtDetalles;
    private JButton UScrearProyecto_btnEnviar;
    private JTextArea USgestionarProyectos_txtProyectos;
    private JButton USgestionarProyectos_btnBuscarProyecto;
    private JProgressBar USgestionarProyectos_pbEstado;
    private JList USgestionarProyectos_jListTrabajadores;
    private JTextArea USagendarCita_txtMotivo;
    private JTextField USagendarCita_txtFecha;
    private JTextField USagendarCita_txtTrabajador;
    private JButton USagendarCita_btnEnviar;
    private JTextField USgestionarProyectos_NumProyecto;
    private JLabel USgestionarProyectos_lbNombreProyecto;
    private JLabel USgestionarProyectos_lbUbicacion;
    private JLabel USgestionarProyectos_lbTiempoInicio;
    private JLabel USgestionarProyectos_lbTiempoFinal;
    private JLabel USgestionarProyectos_lbEstado;

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
        irAIniciarSesionbtn.addActionListener(new ActionListener() {
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
                        registro_txtEmail.getText(), registro_txtContrasenia.getText());
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
                try {
                    usuarioEnLinea = listaUsuarios.obtenerUsuario(inicioSesion_textCedula.getText(),
                            inicioSesion_Contrasenia.getText());
                    if (usuarioEnLinea instanceof Cliente) {
                        cambiarInterfaz("Clientes");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        cerrarSesionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarInterfaz("InicioSesion");
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
