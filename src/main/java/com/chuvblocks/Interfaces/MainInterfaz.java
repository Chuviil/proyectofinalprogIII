package com.chuvblocks.Interfaces;

import com.chuvblocks.Clases.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainInterfaz extends JFrame {
    ListaUsuarios listaUsuarios = new ListaUsuarios();
    ListaSolicitudesProyectos listaSolicitudesProyectos = new ListaSolicitudesProyectos();
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
    private JButton US_cerrarSesionButton;
    private JTextField USSolicitarProyecto_txtNombre;
    private JTextField USSolicitarProyecto_txtUbicacionPreferencia;
    private JSpinner USSolicitarProyecto_spTiempo;
    private JCheckBox USSolicitarProyecto_chkMateriales;
    private JCheckBox USSolicitarProyecto_chkEspaciosVerdes;
    private JCheckBox USSolicitarProyecto_chkParqueadero;
    private JCheckBox USSolicitarProyecto_chkExtras;
    private JTextArea USSolicitarProyecto_txtDetalles;
    private JButton USSolicitarProyecto_btnEnviar;
    private JList<Proyecto> USgestionarProyectos_lstProyectos;
    private JButton USgestionarProyectos_btnBuscarProyecto;
    private JProgressBar USgestionarProyectos_pbEstado;
    private JList<Empleado> USgestionarProyectos_jListTrabajadores;
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
    private JButton gestionarUsuariosButton;
    private JTabbedPane tabbedPane1;
    private JTable EMPGestionUsuarios_tbUsuarios;
    private JButton EMP_cerrarSesionButton;
    private DefaultTableModel clientesTM = new DefaultTableModel(new String[]{"Nombre", "Cedula", "Email"}, 0);

    public MainInterfaz() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(mainPanel);
        pack();
        USSolicitarProyecto_spTiempo.setModel(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE,
                1));
        EMPGestionUsuarios_tbUsuarios.setModel(clientesTM);

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
                    } else if (usuarioEnLinea instanceof Empleado) {
                        cambiarInterfaz("Empleados");
                        actualizarTablaClientes();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } finally {
                    pack();
                }
            }
        });
        USSolicitarProyecto_btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SolicitudProyecto proyectoSolicitado = new SolicitudProyecto(
                        USSolicitarProyecto_txtNombre.getText(),
                        USSolicitarProyecto_txtUbicacionPreferencia.getText(),
                        (int) USSolicitarProyecto_spTiempo.getValue(),
                        USSolicitarProyecto_chkMateriales.isSelected(),
                        USSolicitarProyecto_chkEspaciosVerdes.isSelected(),
                        USSolicitarProyecto_chkParqueadero.isSelected(),
                        USSolicitarProyecto_chkExtras.isSelected(),
                        USSolicitarProyecto_txtDetalles.getText(),
                        (Cliente) usuarioEnLinea
                );
                listaSolicitudesProyectos.agregarSolicitud(proyectoSolicitado);
            }
        });
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarInterfaz("InicioSesion");
            }
        };
        US_cerrarSesionButton.addActionListener(listener);
        EMP_cerrarSesionButton.addActionListener(listener);
    }

    private void cambiarInterfaz(String nombreInterfaz) {
        CardLayout layout = (CardLayout) mainPanel.getLayout();
        layout.show(mainPanel, nombreInterfaz);
    }

    private void actualizarTablaClientes() {
        clientesTM.setRowCount(0);
        listaUsuarios.obtenerClientes().forEach(cliente -> {
            clientesTM.addRow(new Object[]{cliente.getNombre(), cliente.getCedula(), cliente.getEmail()});
        });
    }

    public static void main(String[] args) {
        new MainInterfaz().setVisible(true);
    }
}
