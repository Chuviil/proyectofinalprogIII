package com.chuvblocks.Interfaces;

import com.chuvblocks.Clases.*;
import com.chuvblocks.MapaYGrafo.Mapa;
import com.chuvblocks.MapaYGrafo.MapaComponent;
import com.chuvblocks.MapaYGrafo.PuntoMapa;
import org.piccolo2d.event.PBasicInputEventHandler;
import org.piccolo2d.event.PInputEvent;
import org.piccolo2d.nodes.PPath;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MainInterfaz extends JFrame {
    ListaUsuarios listaUsuarios = new ListaUsuarios();
    ListaSolicitudesProyectos listaSolicitudesProyectos = new ListaSolicitudesProyectos();
    ListaProyectos listaProyectos = new ListaProyectos();
    ListaSolicitudesCitas listaSolicitudesCitas = new ListaSolicitudesCitas();
    ListaCitas listaCitas = new ListaCitas();
    Usuario usuarioEnLinea;
    Mapa AMD_Mapa = Mapa.Ejemplo();
    MapaComponent AMD_MapaDisplay = new MapaComponent(AMD_Mapa);
    MapaComponent US_MapaDisplay = new MapaComponent(AMD_Mapa);
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
    private JPanel Administrador;
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
    private JComboBox<Empleado> USagendarCita_cboTrabajador;
    private JButton USagendarCita_btnEnviar;
    private JLabel USgestionarProyectos_lbNombreProyecto;
    private JButton gestionarUsuariosButton;
    private JButton EMP_cerrarSesionButton;
    private JTextField EMPCrearClientes_txtEmail;
    private JTextField EMPCrearClientes_txtCedula;
    private JTextField EMPCrearClientes_txtContrasenia;
    private JTextField EMPCrearClientes_txtNombre;
    private JTextField EMPCrearClientes_txtApellido;
    private JButton EMPCrearClientes_btnCrear;
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
    private JComboBox<PuntoMapa> EMPRevisionSolicitud_cboUbicacionSeleccionada;
    private JTextField EMPRevisionSolicitud_txtCostoInicial;
    private JTextField EMPRevisionSolicitud_txtCapitalInicial;
    private JTextField USgestionarProyectos_txtUbicacion;
    private JTextField USgestionarProyectos_txtTiempoInicio;
    private JTextField USgestionarProyectos_txtFechaFinal;
    private JTextField USgestionarProyectos_txtEstadoP;
    private JButton US_modificarPerfilButton;
    private JTextField USEdicionperfil_txtNombre;
    private JTextField USEdicionperfil_txtEmail;
    private JTextField USEdicionperfil_txtContrasenia;
    private JButton GUARDARButton;
    private JButton CANCELARButton;
    private JList<Cliente> EMPListadoClientes_lst;
    private JButton regresarRevisionButton;
    private JButton modificarButton;
    private JPanel ADM_GestionUsuariosMod;
    private JTextField ADM_modNombre;
    private JTextField ADM_modCedula;
    private JTextField ADM_modEmail;
    private JTextField ADM_modContrasenia;
    private JButton ADM_btnGuardar;
    private JButton ADM_btnCancelar;
    private JPanel Empleado;
    private JTabbedPane tabbedPane3;
    private JButton ADM_gestionarLugaresbtn;
    private JPanel ADM_mpPrincipal;
    private JTextField ADM_txtMapaX;
    private JTextField ADM_txtMapaY;
    private JTextField ADM_txtMapaNombre;
    private JButton agregarAlMapaButton;
    private JComboBox<PuntoMapa> ADM_MapaLugar1cbo;
    private JComboBox<PuntoMapa> ADM_MapaLugar2cbo;
    private JButton AMD_ConectarLugaresbtn;
    private JButton EMPListadoEmpleados_btnModificar;
    private JTextField EMPCrearEmpleados_txtEmail;
    private JTextField EMPCrearEmpleados_txtCedula;
    private JTextField EMPCrearEmpleados_txtContrasenia;
    private JButton EMPCrearEmpleados_btnCrear;
    private JTextField EMPCrearEmpleados_txtNombre;
    private JTextField EMPCrearEmpleados_txtApellido;
    private JList<Empleado> EMPListadoEmpleados_lst;
    private JTextField ADM_modEmpleadoNombre;
    private JTextField ADM_modEmpleadoCedula;
    private JTextField ADM_modEmpleadoEmail;
    private JTextField ADM_modEmpleadoContrasenia;
    private JButton ADM_modEmpleadobtnGuardar;
    private JButton ADM_modEmpleadobtnCancelar;
    private JPanel ADMGestionarUsuarios_lyEmpleadosLsMod;
    private JPanel US_mapaSeleccionSol;
    private JList<SolicitudCita> ADM_GestionProyectosCitaslst;
    private JButton revisarButton;
    private JTextArea ADM_CitasRevMotivo;
    private JTextField ADM_CitasRevSolicitante;
    private JTextField ADM_CitasRevEMPSolicitado;
    private JTextField ADM_CitasRevFechaHoraPref;
    private JSpinner ADM_CitasRevDia;
    private JSpinner ADM_CitasRevMes;
    private JSpinner ADM_CitasRevAnio;
    private JSpinner ADM_CitasRevHora;
    private JSpinner ADM_CitasRevMinuto;
    private JComboBox<Empleado> ADM_CitasRevEmpAsignado;
    private JButton AGENDARButton;
    private JButton RECHAZARButton;
    private JButton regresarButton;
    private JPanel ADM_Citasly;
    private JButton gestionarProyectosButton1;
    private JButton gestionarCitasButton;
    private JTabbedPane tabbedPane2;
    private JList<Proyecto> EMPGestionProyectosAsignadosls;
    private JTabbedPane tabbedPane4;
    private JPanel EMP_PrincipalLy;
    private JTextField EMPgestionarProyectosAsig_txtUbicacion;
    private JTextField EMPgestionarProyectosAsig_txtTiempoInicio;
    private JTextField EMPgestionarProyectosAsig_txtTiempoFinalizacion;
    private JTextField EMPgestionarProyectosAsig_txtEstado;
    private JProgressBar EMPgestionarProyectosAsig_pbProgreso;
    private JList<Empleado> EMPgestionarProyectos_jListTrabajadoresInv;
    private JButton COMPLETARESTADOButton;
    private JLabel EMPgestionarProyectosAsig_lbNombreProyecto;
    private JPanel ADM_GestionarProyectosEstados;
    private JList<Proyecto> ADMGestionarProyectos_lsTodos;
    private JButton iniciarButton;
    private JComboBox<Empleado> ADM_ProyectosIniciarcboAsigTrabajadores;
    private JButton ADM_ProyectosIniciarbtnAgregar;
    private JSpinner ADM_ProyectosIniciarspDia;
    private JSpinner ADM_ProyectosIniciarspMes;
    private JSpinner ADM_ProyectosIniciarspAnio;
    private JList<Cita> EMPGestionCitas_lsCitas;
    private JTextArea EMPGestionCitas_txMotivo;
    private JButton COMPLETARULTIMACITAButton;
    private JTextField ADM_ProyectosIniciartxtUbicacion;
    private JTextField ADM_ProyectosIniciartxtTiempoInicio;
    private JTextField ADM_ProyectosIniciartxtTiempoFinal;
    private JTextField ADM_ProyectosIniciartxtEstado;
    private JProgressBar ADM_ProyectosIniciarpbProgreso;
    private JList<Empleado> ADM_ProyectosIniciarlsTrabajadores;
    private JButton ADM_ProyectosIniciarbtnIniciar;
    private JLabel ADM_ProyectosIniciarlbNombreP;
    private JButton ADM_ProyectosIniciarbtnCancelar;
    private JButton CERRARSESIONButton;
    private JTextArea ADM_Adyacenciatxt;
    private JButton crearAdyacencia;
    private final DefaultListModel<SolicitudProyecto> solicitudesDLM = new DefaultListModel<>();
    private final DefaultListModel<Proyecto> proyectosClienteDLM = new DefaultListModel<>();
    private final DefaultListModel<Proyecto> proyectosEmpleadoDLM = new DefaultListModel<>();
    private final DefaultListModel<Proyecto> proyectosTodosDLM = new DefaultListModel<>();
    private final DefaultListModel<Cliente> listaClientesDLM = new DefaultListModel<>();
    private final DefaultListModel<Empleado> listaEmpleadosDLM = new DefaultListModel<>();
    private final DefaultListModel<SolicitudCita> listaCitasSolicitudDLM = new DefaultListModel<>();
    private final DefaultListModel<Cita> listaCitasDLM = new DefaultListModel<>();
    private final DefaultComboBoxModel<PuntoMapa> listaLugares1MapaDCM = new DefaultComboBoxModel<>();
    private final DefaultComboBoxModel<PuntoMapa> listaLugares2MapaDCM = new DefaultComboBoxModel<>();
    private final DefaultComboBoxModel<PuntoMapa> listaLugaresDisponiblesMapaDCM = new DefaultComboBoxModel<>();
    private final DefaultComboBoxModel<Empleado> listaEmpleadosDCM = new DefaultComboBoxModel<>();
    private final DefaultComboBoxModel<Empleado> listaEmpleadosInvolucrados = new DefaultComboBoxModel<>();

    public MainInterfaz() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().add(mainPanel);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        USSolicitarProyecto_spTiempo.setModel(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE,
                1));
        EMPGestionarProyectos_lstSolicitudes.setModel(solicitudesDLM);
        USgestionarProyectos_lstProyectos.setModel(proyectosClienteDLM);
        EMPGestionProyectosAsignadosls.setModel(proyectosEmpleadoDLM);
        EMPListadoClientes_lst.setModel(listaClientesDLM);
        EMPListadoEmpleados_lst.setModel(listaEmpleadosDLM);
        ADM_mpPrincipal.add(AMD_MapaDisplay);
        US_mapaSeleccionSol.add(US_MapaDisplay);
        ADM_MapaLugar1cbo.setModel(listaLugares1MapaDCM);
        ADM_MapaLugar2cbo.setModel(listaLugares2MapaDCM);
        EMPRevisionSolicitud_cboUbicacionSeleccionada.setModel(listaLugaresDisponiblesMapaDCM);
        USagendarCita_cboTrabajador.setModel(listaEmpleadosDCM);
        ADM_ProyectosIniciarcboAsigTrabajadores.setModel(listaEmpleadosDCM);
        ADM_GestionProyectosCitaslst.setModel(listaCitasSolicitudDLM);
        EMPGestionCitas_lsCitas.setModel(listaCitasDLM);
        USgestionarProyectos_jListTrabajadores.setModel(listaEmpleadosInvolucrados);
        EMPgestionarProyectos_jListTrabajadoresInv.setModel(listaEmpleadosInvolucrados);

        EMPRevisionSolicitud_spDia.setModel(
                new SpinnerNumberModel(LocalDate.now().getDayOfMonth(), 1, 31,
                        1));
        EMPRevisionSolicitud_spMes.setModel(
                new SpinnerNumberModel(LocalDate.now().getMonthValue(), 1, 12,
                        1));
        EMPRevisionSolicitud_spAnio.setModel(
                new SpinnerNumberModel(LocalDate.now().getYear(), LocalDate.now().getYear(), 3000, 1));

        ADM_CitasRevDia.setModel(
                new SpinnerNumberModel(LocalDate.now().getDayOfMonth(), 1, 31,
                        1));
        ADM_CitasRevMes.setModel(
                new SpinnerNumberModel(LocalDate.now().getMonthValue(), 1, 12,
                        1));
        ADM_CitasRevAnio.setModel(
                new SpinnerNumberModel(LocalDate.now().getYear(), LocalDate.now().getYear(), 3000, 1));
        ADM_CitasRevHora.setModel(new SpinnerNumberModel(0, 0, 23, 1));
        ADM_CitasRevMinuto.setModel(new SpinnerNumberModel(0, 0, 59, 1));

        ADM_ProyectosIniciarspDia.setModel(
                new SpinnerNumberModel(LocalDate.now().getDayOfMonth(), 1, 31,
                        1));
        ADM_ProyectosIniciarspMes.setModel(
                new SpinnerNumberModel(LocalDate.now().getMonthValue(), 1, 12,
                        1));
        ADM_ProyectosIniciarspAnio.setModel(
                new SpinnerNumberModel(LocalDate.now().getYear(), LocalDate.now().getYear(), 3000, 1));


        ADM_CitasRevEmpAsignado.setModel(listaEmpleadosDCM);
        ADMGestionarProyectos_lsTodos.setModel(proyectosTodosDLM);

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
                    JOptionPane.showMessageDialog(null, "Se ha registrado correctamente");
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
                    } else if (usuarioEnLinea instanceof Administrador) {
                        cambiarInterfaz("Administrador");
                        actualizarJListClientes();
                        actualizarJListEmpleados();
                        actualizarJListCitas();
                        actualizarListaSolicitudesProyectos();
                    } else if (usuarioEnLinea instanceof Empleado) {
                        cambiarInterfaz("Empleado");
                        actualizarListaProyectosEmpleado();
                        actualizarListaCitasEmpleado();
                    }
                    limpiarCampos(List.of(inicioSesion_textCedula, inicioSesion_Contrasenia));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } finally {
                    actualizarListaLugaresCBOs();
                    actualizarListasCBOs();
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
                US_MapaDisplay.graficar();
            }
        });
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarInterfaz("InicioSesion");
                limpiarListadosEmpleadosInvolucrados();
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
                    actualizarJListClientes();
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
                        EMPGestionarProyectos_lstSolicitudes.getSelectedValue().getSolicitante(), Proyecto.EstadoProyecto.PLANIFICACION,
                        LocalDate.of((int) EMPRevisionSolicitud_spAnio.getValue(), (int) EMPRevisionSolicitud_spMes.getValue(),
                                (int) EMPRevisionSolicitud_spDia.getValue()), listaLugares1MapaDCM.getSelectedItem().toString(),
                        Float.parseFloat(EMPRevisionSolicitud_txtCostoInicial.getText()),
                        Float.parseFloat(EMPRevisionSolicitud_txtCapitalInicial.getText()));
                ((PuntoMapa) listaLugares1MapaDCM.getSelectedItem()).ocuparLugar();
                AMD_MapaDisplay.graficar();
                US_MapaDisplay.graficar();
                actualizarListaLugaresCBOs();
                listaProyectos.agregarProyecto(nuevoProyecto);
                CardLayout layout = (CardLayout) EMPGestionarProyectos_lySolicitudes.getLayout();
                layout.show(EMPGestionarProyectos_lySolicitudes, "ListadoSolicitudes");
                listaSolicitudesProyectos.eliminarSolicitud(EMPGestionarProyectos_lstSolicitudes.getSelectedValue());
                actualizarListaSolicitudesProyectos();
                actualizarJListClientes();
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
                    USgestionarProyectos_txtEstadoP.setText(proyectoSeleccionado.getEstado().toString());
                    USgestionarProyectos_pbEstado.setValue((int) (((proyectoSeleccionado.getEstado().ordinal() + 1) / 6.0d) * 100));
                    actualizarListadosEmpleadosInvolucrados(proyectoSeleccionado.getEmpleadosInvolucrados());
                }
            }
        });
        US_modificarPerfilButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) Clientes.getLayout();
                layout.show(Clientes, "EdicionPerfil");
                USEdicionperfil_txtNombre.setText(usuarioEnLinea.getNombre());
                USEdicionperfil_txtEmail.setText(usuarioEnLinea.getEmail());
                USEdicionperfil_txtContrasenia.setText(usuarioEnLinea.getContrasenia());
            }
        });
        CANCELARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) Clientes.getLayout();
                layout.show(Clientes, "General");
            }
        });
        GUARDARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuarioEnLinea.setNombre(USEdicionperfil_txtNombre.getText());
                usuarioEnLinea.setEmail(USEdicionperfil_txtEmail.getText());
                usuarioEnLinea.setContrasenia(USEdicionperfil_txtContrasenia.getText());
                CardLayout layout = (CardLayout) Clientes.getLayout();
                layout.show(Clientes, "General");
            }
        });
        regresarRevisionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) EMPGestionarProyectos_lySolicitudes.getLayout();
                layout.show(EMPGestionarProyectos_lySolicitudes, "ListadoSolicitudes");
            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (EMPListadoClientes_lst.getSelectedValue() == null) {
                    JOptionPane.showMessageDialog(null, "Seleccione un cliente primero!");
                    return;
                }
                Cliente clienteSeleccionado = EMPListadoClientes_lst.getSelectedValue();
                ADM_modNombre.setText(clienteSeleccionado.getNombre());
                ADM_modCedula.setText(clienteSeleccionado.getCedula());
                ADM_modEmail.setText(clienteSeleccionado.getEmail());
                ADM_modContrasenia.setText(clienteSeleccionado.getContrasenia());
                CardLayout layout = (CardLayout) ADM_GestionUsuariosMod.getLayout();
                layout.show(ADM_GestionUsuariosMod, "modificacionPerfil");
            }
        });
        ADM_btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) ADM_GestionUsuariosMod.getLayout();
                layout.show(ADM_GestionUsuariosMod, "listadoClientes");
            }
        });
        ADM_btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cliente clienteSeleccionado = EMPListadoClientes_lst.getSelectedValue();
                clienteSeleccionado.setNombre(ADM_modNombre.getText());
                clienteSeleccionado.setEmail(ADM_modEmail.getText());
                clienteSeleccionado.setContrasenia(ADM_modContrasenia.getText());
                CardLayout layout = (CardLayout) ADM_GestionUsuariosMod.getLayout();
                layout.show(ADM_GestionUsuariosMod, "listadoClientes");
            }
        });
        ADM_modCedula.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                JOptionPane.showMessageDialog(null, "La cedula es inmutable y no puede ser modificada");
            }
        });
        ADM_gestionarLugaresbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarInterfazEmpleado("GestionarLugares");
            }
        });
        AMD_MapaDisplay.addInputEventListener(new PBasicInputEventHandler() {
            @Override
            public void mousePressed(PInputEvent event) {
                AMD_MapaDisplay.graficar();
                int x = (int) event.getPosition().getX();
                int y = (int) event.getPosition().getY();
                PPath marcadorSeleccionado = PPath.createEllipse(
                        x - 6,
                        y - 6, 12, 12);
                marcadorSeleccionado.setPaint(Color.BLUE);
                AMD_MapaDisplay.getLayer().addChild(marcadorSeleccionado);
                ADM_txtMapaX.setText(Integer.toString((x)));
                ADM_txtMapaY.setText(Integer.toString((y)));
            }
        });
        agregarAlMapaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = 0;
                int y = 0;
                try {
                    x = Integer.parseInt(ADM_txtMapaX.getText());
                    y = Integer.parseInt(ADM_txtMapaY.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Seleccione un punto en el mapa");
                    return;
                }
                PuntoMapa nuevoPunto = new PuntoMapa(ADM_txtMapaNombre.getText(), x, y);
                AMD_Mapa.addPuntoMapa(nuevoPunto);
                AMD_MapaDisplay.graficar();
                US_MapaDisplay.graficar();
                actualizarListaLugaresCBOs();
            }
        });
        AMD_ConectarLugaresbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PuntoMapa punto1 = (PuntoMapa) listaLugares1MapaDCM.getSelectedItem();
                PuntoMapa punto2 = (PuntoMapa) listaLugares2MapaDCM.getSelectedItem();
                if (punto1 == null || punto2 == null) {
                    JOptionPane.showMessageDialog(null, "Seleccione 2 puntos primero!");
                    return;
                }

                try {
                    AMD_Mapa.conectarPuntos(punto1, punto2);
                } catch (Exception ignored) {
                    JOptionPane.showMessageDialog(null, "Estos lugares ya estan conectados");
                }
                AMD_MapaDisplay.graficar();
                US_MapaDisplay.graficar();
            }
        });
        EMPCrearEmpleados_btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreCompleto = EMPCrearEmpleados_txtNombre.getText() + " " + EMPCrearEmpleados_txtApellido.getText();
                Empleado nuevoEmpleado = new Empleado(nombreCompleto, EMPCrearEmpleados_txtCedula.getText(),
                        EMPCrearEmpleados_txtEmail.getText(), EMPCrearEmpleados_txtContrasenia.getText());
                try {
                    listaUsuarios.agregarUsuario(nuevoEmpleado);
                    actualizarJListEmpleados();
                    actualizarListasCBOs();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        EMPListadoEmpleados_btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (EMPListadoEmpleados_lst.getSelectedValue() == null) {
                    JOptionPane.showMessageDialog(null, "Seleccione un empleado primero!");
                    return;
                }
                Empleado clienteSeleccionado = EMPListadoEmpleados_lst.getSelectedValue();
                ADM_modEmpleadoNombre.setText(clienteSeleccionado.getNombre());
                ADM_modEmpleadoCedula.setText(clienteSeleccionado.getCedula());
                ADM_modEmpleadoEmail.setText(clienteSeleccionado.getEmail());
                ADM_modEmpleadoContrasenia.setText(clienteSeleccionado.getContrasenia());
                CardLayout layout = (CardLayout) ADMGestionarUsuarios_lyEmpleadosLsMod.getLayout();
                layout.show(ADMGestionarUsuarios_lyEmpleadosLsMod, "modificacionEmpleado");
            }
        });
        ADM_modEmpleadobtnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) ADMGestionarUsuarios_lyEmpleadosLsMod.getLayout();
                layout.show(ADMGestionarUsuarios_lyEmpleadosLsMod, "listadoEmpleados");
            }
        });
        ADM_modEmpleadobtnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Empleado empleadoSeleccionado = EMPListadoEmpleados_lst.getSelectedValue();
                empleadoSeleccionado.setNombre(ADM_modEmpleadoNombre.getText());
                empleadoSeleccionado.setEmail(ADM_modEmpleadoEmail.getText());
                empleadoSeleccionado.setContrasenia(ADM_modEmpleadoContrasenia.getText());
                CardLayout layout = (CardLayout) ADMGestionarUsuarios_lyEmpleadosLsMod.getLayout();
                layout.show(ADMGestionarUsuarios_lyEmpleadosLsMod, "listadoEmpleados");
            }
        });
        US_MapaDisplay.addInputEventListener(new PBasicInputEventHandler() {
            @Override
            public void mousePressed(PInputEvent event) {
                US_MapaDisplay.graficar();
                int x = (int) event.getPosition().getX();
                int y = (int) event.getPosition().getY();
                PPath marcadorSeleccionado = PPath.createEllipse(
                        x - 6,
                        y - 6, 12, 12);
                marcadorSeleccionado.setPaint(Color.BLUE);
                US_MapaDisplay.getLayer().addChild(marcadorSeleccionado);
                USSolicitarProyecto_txtUbicacionPreferencia.setText(
                        "Cerca de " + AMD_Mapa.encontrarPuntoMapaMasCercanoACordenada(x, y));
            }
        });
        USagendarCita_btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SolicitudCita nuevaSolicitud = new SolicitudCita(USagendarCita_txtMotivo.getText(),
                        USagendarCita_txtFecha.getText(), (Empleado) listaEmpleadosDCM.getSelectedItem(),
                        (Cliente) usuarioEnLinea);
                listaSolicitudesCitas.addSolicitudCita(nuevaSolicitud);
            }
        });
        revisarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ADM_GestionProyectosCitaslst.getSelectedValue() != null) {
                    CardLayout layout = (CardLayout) ADM_Citasly.getLayout();
                    layout.show(ADM_Citasly, "revisionCita");
                    actualizarPresentacionRevisionCita(ADM_GestionProyectosCitaslst.getSelectedValue());
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione una solicitud primero!");
                }
            }
        });
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) ADM_Citasly.getLayout();
                layout.show(ADM_Citasly, "listaCitas");
            }
        });
        RECHAZARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) ADM_Citasly.getLayout();
                layout.show(ADM_Citasly, "listaCitas");
                listaSolicitudesCitas.removeSolicitudCita(ADM_GestionProyectosCitaslst.getSelectedValue());
                actualizarJListCitas();
            }
        });
        AGENDARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDateTime tiempoAsignado = LocalDateTime.of(
                        (int) ADM_CitasRevAnio.getValue(),
                        (int) ADM_CitasRevMes.getValue(),
                        (int) ADM_CitasRevDia.getValue(),
                        (int) ADM_CitasRevHora.getValue(),
                        (int) ADM_CitasRevMinuto.getValue()
                        , 0);
                SolicitudCita citaSeleccionada = ADM_GestionProyectosCitaslst.getSelectedValue();
                Cita cita = new Cita(citaSeleccionada.getMensaje(), tiempoAsignado, citaSeleccionada.getEmpleadoPreferido(),
                        citaSeleccionada.getSolicitante());
                listaCitas.agregar(cita);
                CardLayout layout = (CardLayout) ADM_Citasly.getLayout();
                layout.show(ADM_Citasly, "listaCitas");
                listaSolicitudesCitas.removeSolicitudCita(ADM_GestionProyectosCitaslst.getSelectedValue());
                actualizarJListCitas();
            }
        });
        EMPGestionProyectosAsignadosls.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Proyecto proyectoSeleccionado = EMPGestionProyectosAsignadosls.getSelectedValue();
                if (proyectoSeleccionado != null) {
                    EMPgestionarProyectosAsig_lbNombreProyecto.setText(proyectoSeleccionado.getNombre());
                    EMPgestionarProyectosAsig_txtUbicacion.setText(proyectoSeleccionado.getUbicacion());
                    EMPgestionarProyectosAsig_txtTiempoFinalizacion.setText(proyectoSeleccionado.getFechaFin().toString());
                    EMPgestionarProyectosAsig_txtTiempoInicio.setText((proyectoSeleccionado.getFechaInicio()) == null ?
                            "Aun no se ha iniciado" : proyectoSeleccionado.getFechaInicio().toString());
                    EMPgestionarProyectosAsig_txtEstado.setText(proyectoSeleccionado.getEstado().toString());
                    EMPgestionarProyectosAsig_pbProgreso.setValue((int) (((proyectoSeleccionado.getEstado().ordinal() + 1) / 6.0d) * 100));
                    actualizarListadosEmpleadosInvolucrados(proyectoSeleccionado.getEmpleadosInvolucrados());
                }
            }
        });
        gestionarProyectosButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) EMP_PrincipalLy.getLayout();
                layout.show(EMP_PrincipalLy, "gestionProyectos");
            }
        });
        gestionarCitasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) EMP_PrincipalLy.getLayout();
                layout.show(EMP_PrincipalLy, "gestionCitas");
            }
        });
        EMPGestionCitas_lsCitas.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (EMPGestionCitas_lsCitas.getSelectedValue() != null) {
                    EMPGestionCitas_txMotivo.setText(EMPGestionCitas_lsCitas.getSelectedValue().getMotivo());
                }
            }
        });
        COMPLETARULTIMACITAButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cita citaCompletada = listaCitas.desencolarCita();
                JOptionPane.showMessageDialog(null, "Se completo la cita de "
                        + citaCompletada.getSolicitante().getNombre() + "\nMotivo: " + citaCompletada.getMotivo() +
                        "\nFecha: " + citaCompletada.getFechaYHora().toString());
                EMPGestionCitas_txMotivo.setText("");
                actualizarListaProyectosEmpleado();
                actualizarListaCitasEmpleado();
            }
        });
        iniciarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ADMGestionarProyectos_lsTodos.getSelectedValue() == null) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un proyecto");
                    return;
                }
                if (ADMGestionarProyectos_lsTodos.getSelectedValue().getFechaInicio() != null) {
                    JOptionPane.showMessageDialog(null, "Este proyecto ya fue iniciado");
                    return;
                }
                Proyecto proyectoSeleccionado = ADMGestionarProyectos_lsTodos.getSelectedValue();
                ADM_ProyectosIniciarlbNombreP.setText(proyectoSeleccionado.getNombre());
                ADM_ProyectosIniciartxtUbicacion.setText(proyectoSeleccionado.getUbicacion());
                ADM_ProyectosIniciartxtTiempoFinal.setText(proyectoSeleccionado.getFechaFin().toString());
                ADM_ProyectosIniciartxtTiempoInicio.setText((proyectoSeleccionado.getFechaInicio()) == null ?
                        "Aun no se ha iniciado" : proyectoSeleccionado.getFechaInicio().toString());
                ADM_ProyectosIniciartxtEstado.setText(proyectoSeleccionado.getEstado().toString());
                ADM_ProyectosIniciarpbProgreso.setValue((int) (((proyectoSeleccionado.getEstado().ordinal() + 1) / 6.0d) * 100));
                CardLayout layout = (CardLayout) ADM_GestionarProyectosEstados.getLayout();
                layout.show(ADM_GestionarProyectosEstados, "iniciarProyecto");
            }
        });
        ADM_ProyectosIniciarbtnIniciar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ADMGestionarProyectos_lsTodos.getSelectedValue().getEmpleadosInvolucrados().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe agregar al menos un empleado");
                    return;
                }
                LocalDate fechaInicio = LocalDate.of((int) ADM_ProyectosIniciarspAnio.getValue(),
                        (int) ADM_ProyectosIniciarspMes.getValue(), (int) ADM_ProyectosIniciarspDia.getValue());
                ADMGestionarProyectos_lsTodos.getSelectedValue().setFechaInicio(fechaInicio);
                ADMGestionarProyectos_lsTodos.getSelectedValue().completarUltimoEstado();
                CardLayout layout = (CardLayout) ADM_GestionarProyectosEstados.getLayout();
                layout.show(ADM_GestionarProyectosEstados, "listaTodosProyectos");
            }
        });
        ADM_ProyectosIniciarbtnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout layout = (CardLayout) ADM_GestionarProyectosEstados.getLayout();
                layout.show(ADM_GestionarProyectosEstados, "listaTodosProyectos");
            }
        });
        ADM_ProyectosIniciarbtnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Proyecto proyectoSeleccionado = ADMGestionarProyectos_lsTodos.getSelectedValue();
                proyectoSeleccionado.agregarEmpleadoInvolucrado((Empleado) ADM_ProyectosIniciarcboAsigTrabajadores.getSelectedItem());
                DefaultListModel<Empleado> listaEmpleadosInv = new DefaultListModel<>();
                proyectoSeleccionado.getEmpleadosInvolucrados().forEach(listaEmpleadosInv::addElement);
                ADM_ProyectosIniciarlsTrabajadores.setModel(listaEmpleadosInv);
            }
        });
        COMPLETARESTADOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (EMPGestionProyectosAsignadosls.getSelectedValue() == null) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un proyecto");
                    return;
                }
                try {
                    EMPGestionProyectosAsignadosls.getSelectedValue().completarUltimoEstado();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
                actualizarListaProyectosEmpleado();
            }
        });
        CERRARSESIONButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cambiarInterfaz("InicioSesion");
                limpiarListadosEmpleadosInvolucrados();
            }
        });
        crearAdyacencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ADM_Adyacenciatxt.setText(AMD_Mapa.imprimirMatrizAdyacencia());
            }
        });
    }

    private void actualizarListaCitasEmpleado() {
        listaCitasDLM.removeAllElements();
        listaCitas.obtenerCitasPorEmpleado((Empleado) usuarioEnLinea).forEach(listaCitasDLM::addElement);
    }

    private void actualizarListaProyectosEmpleado() {
        proyectosEmpleadoDLM.clear();
        listaProyectos.obtenerProyectosPorEmpleado((Empleado) usuarioEnLinea).forEach(proyectosEmpleadoDLM::addElement);
    }

    private void actualizarPresentacionRevisionCita(SolicitudCita citaSolicitud) {
        ADM_CitasRevSolicitante.setText(citaSolicitud.getSolicitante().toString());
        ADM_CitasRevMotivo.setText(citaSolicitud.getMensaje());
        ADM_CitasRevEMPSolicitado.setText(citaSolicitud.getEmpleadoPreferido().toString());
        ADM_CitasRevFechaHoraPref.setText(citaSolicitud.getFechaYHoraPrefencia());
    }

    private void actualizarJListCitas() {
        listaCitasSolicitudDLM.clear();
        listaSolicitudesCitas.getSolicitudesCitas().forEach(listaCitasSolicitudDLM::addElement);
    }

    private void actualizarListasCBOs() {
        listaEmpleadosDCM.removeAllElements();
        listaUsuarios.obtenerEmpleados().forEach(listaEmpleadosDCM::addElement);
    }

    private void cambiarInterfaz(String nombreInterfaz) {
        CardLayout layout = (CardLayout) mainPanel.getLayout();
        layout.show(mainPanel, nombreInterfaz);
    }

    private void cambiarInterfazEmpleado(String nombreInterfaz) {
        CardLayout layout = (CardLayout) mainEmpleadoPanel.getLayout();
        layout.show(mainEmpleadoPanel, nombreInterfaz);
    }

    private void actualizarJListClientes() {
        listaClientesDLM.clear();
        proyectosTodosDLM.clear();
        listaUsuarios.obtenerClientes().forEach(listaClientesDLM::addElement);
        listaProyectos.getProyectos().forEach(proyectosTodosDLM::addElement);
    }

    private void actualizarJListEmpleados() {
        listaEmpleadosDLM.clear();
        listaUsuarios.obtenerEmpleados().forEach(listaEmpleadosDLM::addElement);
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

    public void actualizarListadosEmpleadosInvolucrados(ArrayList<Empleado> empleados) {
        limpiarListadosEmpleadosInvolucrados();
        empleados.forEach(listaEmpleadosInvolucrados::addElement);
    }

    public void limpiarListadosEmpleadosInvolucrados() {
        listaEmpleadosInvolucrados.removeAllElements();
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

    public void actualizarListaLugaresCBOs() {
        listaLugares1MapaDCM.removeAllElements();
        listaLugares2MapaDCM.removeAllElements();
        listaLugaresDisponiblesMapaDCM.removeAllElements();
        AMD_Mapa.obtenerPuntosMapa().forEach(listaLugares1MapaDCM::addElement);
        AMD_Mapa.obtenerPuntosMapa().forEach(listaLugares2MapaDCM::addElement);
        AMD_Mapa.obtenerPuntosMapa().stream().filter(p -> !p.estaOcupado())
                .forEach(listaLugaresDisponiblesMapaDCM::addElement);
    }

    public static void main(String[] args) {
        new MainInterfaz().setVisible(true);
    }
}
