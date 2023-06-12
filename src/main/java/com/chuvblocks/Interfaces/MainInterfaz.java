package com.chuvblocks.Interfaces;

import com.chuvblocks.Clases.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.List;

public class MainInterfaz extends JFrame {
    ListaUsuarios listaUsuarios = new ListaUsuarios();
    ListaSolicitudesProyectos listaSolicitudesProyectos = new ListaSolicitudesProyectos();
    ListaProyectos listaProyectos = new ListaProyectos();
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
    private JProgressBar USgestionarProyectos_pbEstado;
    private JList<Empleado> USgestionarProyectos_jListTrabajadores;
    private JTextArea USagendarCita_txtMotivo;
    private JTextField USagendarCita_txtFecha;
    private JTextField USagendarCita_txtTrabajador;
    private JButton USagendarCita_btnEnviar;
    private JLabel USgestionarProyectos_lbNombreProyecto;
    private JButton gestionarUsuariosButton;
    private JTable EMPGestionUsuarios_tbUsuarios;
    private JButton EMP_cerrarSesionButton;
    private JTextField EMPCrearClientes_txtEmail;
    private JTextField EMPCrearClientes_txtCedula;
    private JPasswordField EMPCrearClientes_txtContrasenia;
    private JTextField EMPCrearClientes_txtNombre;
    private JTextField EMPCrearClientes_txtApellido;
    private JButton EMPCrearClientes_btnCrear;
    private JTabbedPane tabbedPane2;
    private JTabbedPane tabbedPane1;
    private JButton gestionarProyectosButton;
    private JList<SolicitudProyecto> EMPGestionarProyectos_lstSolicitudes;
    private JPanel mainEmpleadoPanel;
    private JButton REVISARButton;
    private JPanel EMPGestionarProyectos_lySolicitudes;
    private JTextField EMPRevisionSolicitud_txtNProyecto;
    private JTextField EMPRevisionSolicitud_txtUbPreferencia;
    private JTextField EMPRevisionSolicitud_txtUMaterialesEco;
    private JTextField EMPRevisionSolicitud_txtTEstimado;
    private JTextField EMPRevisionSolicitud_txtEspaciosVerdes;
    private JTextField EMPRevisionSolicitud_txtTParqueaderos;
    private JTextArea EMPRevisionSolicitud_txtDescripcion;
    private JTextField EMPRevisionSolicitud_txtNSolicitante;
    private JTextField EMPRevisionSolicitud_txtNSolicitanteCedula;
    private JButton EMPRevisionSolicitud_btnAceptar;
    private JButton EMPRevisionSolicitud_btnRechazar;
    private JSpinner EMPRevisionSolicitud_spDia;
    private JSpinner EMPRevisionSolicitud_spMes;
    private JSpinner EMPRevisionSolicitud_spAnio;
    private JTextField EMPRevisionSolicitud_txtUbicacionSeleccionada;
    private JTextField EMPRevisionSolicitud_txtCostoInicial;
    private JTextField EMPRevisionSolicitud_txtCapitalInicial;
    private JTextField USgestionarProyectos_txtUbicacion;
    private JTextField USgestionarProyectos_txtTiempoInicio;
    private JTextField USgestionarProyectos_txtFechaFinal;
    private JTextField USgestionarProyectos_txtEstadoP;
    private JButton US_modificarPerfilButton;
    private final DefaultListModel<SolicitudProyecto> solicitudesDLM = new DefaultListModel<>();
    private final DefaultListModel<Proyecto> proyectosClienteDLM = new DefaultListModel<>();
    private final DefaultTableModel clientesTM = new DefaultTableModel(new String[]{"Nombre", "Cedula", "Email"}, 0);

    public MainInterfaz() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(mainPanel);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        USSolicitarProyecto_spTiempo.setModel(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE,
                1));
        EMPGestionUsuarios_tbUsuarios.setModel(clientesTM);
        EMPGestionarProyectos_lstSolicitudes.setModel(solicitudesDLM);
        USgestionarProyectos_lstProyectos.setModel(proyectosClienteDLM);

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
                    limpiarCampos(List.of(registro_txtNombre, registro_txtApellido, registro_txtCedula,
                            registro_txtEmail, registro_txtContrasenia));
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
                        actualizarListaProyectosCliente();
                    } else if (usuarioEnLinea instanceof Empleado) {
                        cambiarInterfaz("Empleados");
                        actualizarTablaClientes();
                        actualizarListaSolicitudesProyectos();
                    }
                    limpiarCampos(List.of(inicioSesion_textCedula, inicioSesion_Contrasenia));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
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
        EMPCrearClientes_btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreCompleto = EMPCrearClientes_txtNombre.getText() + " " + EMPCrearClientes_txtApellido.getText();
                Cliente nuevoCliente = new Cliente(nombreCompleto, EMPCrearClientes_txtCedula.getText(),
                        EMPCrearClientes_txtEmail.getText(), EMPCrearClientes_txtContrasenia.getText());
                try {
                    listaUsuarios.agregarUsuario(nuevoCliente);
                    actualizarTablaClientes();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        gestionarUsuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarInterfazEmpleado("GestionarUsuarios");
            }
        });
        gestionarProyectosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarInterfazEmpleado("GestionarProyectos");
            }
        });
        REVISARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (EMPGestionarProyectos_lstSolicitudes.getSelectedValue() != null) {
                    CardLayout layout = (CardLayout) EMPGestionarProyectos_lySolicitudes.getLayout();
                    layout.show(EMPGestionarProyectos_lySolicitudes, "RevisionSolicitud");
                    actualizarPresentacionRevisionSolicitud(EMPGestionarProyectos_lstSolicitudes.getSelectedValue());
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una solicitud primero!");
                }
            }
        });
        EMPRevisionSolicitud_btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Proyecto nuevoProyecto = new Proyecto(EMPRevisionSolicitud_txtNProyecto.getText(),
                        EMPGestionarProyectos_lstSolicitudes.getSelectedValue().getSolicitante(), "Planificacion",
                        LocalDate.of((int) EMPRevisionSolicitud_spAnio.getValue(), (int) EMPRevisionSolicitud_spMes.getValue(),
                                (int) EMPRevisionSolicitud_spDia.getValue()), EMPRevisionSolicitud_txtUbicacionSeleccionada.getText(),
                        Float.parseFloat(EMPRevisionSolicitud_txtCostoInicial.getText()),
                        Float.parseFloat(EMPRevisionSolicitud_txtCapitalInicial.getText()));
                listaProyectos.agregarProyecto(nuevoProyecto);
                CardLayout layout = (CardLayout) EMPGestionarProyectos_lySolicitudes.getLayout();
                layout.show(EMPGestionarProyectos_lySolicitudes, "ListadoSolicitudes");
                listaSolicitudesProyectos.eliminarSolicitud(EMPGestionarProyectos_lstSolicitudes.getSelectedValue());
                actualizarListaSolicitudesProyectos();
            }
        });
        EMPRevisionSolicitud_btnRechazar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) EMPGestionarProyectos_lySolicitudes.getLayout();
                layout.show(EMPGestionarProyectos_lySolicitudes, "ListadoSolicitudes");
                listaSolicitudesProyectos.eliminarSolicitud(EMPGestionarProyectos_lstSolicitudes.getSelectedValue());
                actualizarListaSolicitudesProyectos();
            }
        });
        USgestionarProyectos_lstProyectos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Proyecto proyectoSeleccionado = USgestionarProyectos_lstProyectos.getSelectedValue();
                if (proyectoSeleccionado != null) {
                    USgestionarProyectos_lbNombreProyecto.setText(proyectoSeleccionado.getNombre());
                    USgestionarProyectos_txtUbicacion.setText(proyectoSeleccionado.getUbicacion());
                    USgestionarProyectos_txtFechaFinal.setText(proyectoSeleccionado.getFechaFin().toString());
                    USgestionarProyectos_txtTiempoInicio.setText((proyectoSeleccionado.getFechaInicio()) == null ?
                            "Aun no se ha iniciado" : proyectoSeleccionado.getFechaInicio().toString());
                    USgestionarProyectos_txtEstadoP.setText(proyectoSeleccionado.getEstado());
                }
            }
        });
        US_modificarPerfilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) Clientes.getLayout();
                layout.show(Clientes, "EdicionPerfil");
            }
        });
    }

    private void cambiarInterfaz(String nombreInterfaz) {
        CardLayout layout = (CardLayout) mainPanel.getLayout();
        layout.show(mainPanel, nombreInterfaz);
    }

    private void cambiarInterfazEmpleado(String nombreInterfaz) {
        CardLayout layout = (CardLayout) mainEmpleadoPanel.getLayout();
        layout.show(mainEmpleadoPanel, nombreInterfaz);
    }

    private void actualizarTablaClientes() {
        clientesTM.setRowCount(0);
        listaUsuarios.obtenerClientes().forEach(cliente -> {
            clientesTM.addRow(new Object[]{cliente.getNombre(), cliente.getCedula(), cliente.getEmail()});
        });
    }

    private void actualizarListaSolicitudesProyectos() {
        solicitudesDLM.clear();
        listaSolicitudesProyectos.obtenertSolicitudesProyectos().forEach(solicitudesDLM::addElement);
    }

    private void actualizarPresentacionRevisionSolicitud(SolicitudProyecto solicitudSeleccionada) {
        EMPRevisionSolicitud_txtNProyecto.setText(solicitudSeleccionada.getNombre());
        EMPRevisionSolicitud_txtUbPreferencia.setText(solicitudSeleccionada.getUbicacionPreferencia());
        EMPRevisionSolicitud_txtUMaterialesEco.setText(solicitudSeleccionada.getUsoMaterialesEcoAgradables() ? "Si" : "No");
        EMPRevisionSolicitud_txtTEstimado.setText(String.valueOf(solicitudSeleccionada.getTiempoEstimado()));
        EMPRevisionSolicitud_txtEspaciosVerdes.setText(solicitudSeleccionada.getTieneEspaciosVerdes() ? "Si" : "No");
        EMPRevisionSolicitud_txtTParqueaderos.setText(solicitudSeleccionada.getTieneParqueaderos() ? "Si" : "No");
        EMPRevisionSolicitud_txtDescripcion.setText(solicitudSeleccionada.getDetalles());
        EMPRevisionSolicitud_txtNSolicitante.setText(solicitudSeleccionada.getSolicitante().getNombre());
        EMPRevisionSolicitud_txtNSolicitanteCedula.setText(solicitudSeleccionada.getSolicitante().getCedula());
    }

    private void actualizarListaProyectosCliente() {
        proyectosClienteDLM.clear();
        listaProyectos.obtenerProyectosPorCliente((Cliente) usuarioEnLinea).forEach(proyectosClienteDLM::addElement);
    }

    private void limpiarCampos(List<JTextField> campos) {
        for (JTextField campo : campos) {
            campo.setText("");
        }
    }

    public static void main(String[] args) {
        new MainInterfaz().setVisible(true);
    }
}
