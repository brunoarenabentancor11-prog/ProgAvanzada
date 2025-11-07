/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaPersistencia;


import Capa_Logica.Ingreso;
import Capa_Logica.Profesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author bruno
 */
public class Persistencia {
     private static final String SQL_GUARDAR_INASISTENCIA=("INSERT INTO proyecto.persona(ci,nombre,apellido,tareas)"
            + "VALUES (?,?,?,?)");
    private static final String SQL_CONSULTA_PERSONA = ("SELECT * FROM proyecto.persona where Ci=?");
    private static final String SQL_ELIMINAR_PERSONA = ("DELETE FROM persona WHERE Ci= ?");
     private static final String SQL_REGISTRAR = ("INSERT INTO proyecto.ingreso(CI, Contrasenia) VALUES (?, ?)");
    private static final String SQL_INICIAR_SESION = ("SELECT * FROM proyecto.ingreso WHERE  CI= ? AND Contrasenia = ?");
    public Conexion cone=new Conexion();
     public PreparedStatement ps;//prepara los datos
     public ResultSet rs;//devuelve los datos
//PreparedStatement es una interfaz en Java que hereda de la interfaz Statement. 
//Se utiliza para representar una sentencia SQL precompilada. 
//A diferencia de un objeto Statement normal, un PreparedStatement se precompila 
//y se almacena en caché en el servidor de la base de datos,lo que puede mejorar significativamente 
//el rendimiento en situaciones donde se ejecutan consultas similares varias veces.  
// Un PreparedStatement se compila una vez y puede ser reutilizado con diferentes 
//     conjuntos de parámetros. Esto puede ser más eficiente 
  //que crear y ejecutar nuevas declaraciones SQL cada vez que se necesita realizar 
 //una consulta o una actualización. 
  // Método para registrar un nuevo usuario
    public void registrar(Ingreso ing) throws Exception {
        try {
            Connection con = cone.getConnection();
            ps = con.prepareStatement(SQL_REGISTRAR);
            ps.setString(1, ing.getcI());
            ps.setString(2, ing.getContrasenia());
            int resultado = ps.executeUpdate();

            if (resultado <= 0) {
                throw new Exception("No se pudo registrar el usuario.");
            }
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error al registrar usuario: " + e.getMessage());
        }
    }

    // Método para validar usuario y contraseña
    public boolean iniciarSesion(String nombreUsuario, String contrasenia) throws Exception {
        boolean valido = false;
        try {
            Connection con = cone.getConnection();
            ps = con.prepareStatement(SQL_INICIAR_SESION);
            ps.setString(1, nombreUsuario);
            ps.setString(2, contrasenia);
            rs = ps.executeQuery();

            if (rs.next()) {
                valido = true; // usuario encontrado
            }
            con.close();
        } catch (SQLException e) {
            throw new Exception("Error al validar inicio de sesión: " + e.getMessage());
        }
        return valido;
    }    
      public void  guardarInasistencia(Profesor in)throws Exception,SQLException {
 //try: Marca el comienzo del bloque de código en el que se intentará ejecutar ciertas operaciones. 
 //Si ocurre una excepción durante la ejecución de este bloque, el control se transfiere al bloque 
 //catch correspondiente.        
        try { 
        int resultado = 0;



 //operaciones de base de datos, como ejecutar consultas o transacciones.      

            Connection con = cone.getConnection();
//con.prepareStatement(SQLGuardar): Aquí, con es una instancia de la clase Connection, y prepareStatement
//(SQLGuardar) es un método que se utiliza para crear un objeto PreparedStatement. 
//Un PreparedStatement es una clase que representa una instrucción SQL precompilada.
//esta línea de código está preparando una instrucción SQL para guardar un personaje en la base de datos 
//y asignando esa instrucción preparada a una variable ps de tipo PreparedStatement.
//            ps = (PreparedStatement) con.prepareStatement(SQL_GUARDAR_INASISTENCIA);
//            ps.setString(1, in.getCi());  
//            ps.setString(2, in.getNombre());
//            ps.setString(3, in.getApellido());
//            ps.setString(4, in.); 
//          
            
//Este método executeUpdate,se emplea para ejecutar consultas SQL que realizan actualizaciones, 
//eliminaciones o inserciones en una base de datos. 
//Este método devuelve un entero que indica el número de filas afectadas por la operación.
            resultado = ps.executeUpdate();
//catch: Es una palabra clave que indica el comienzo de un bloque de código que manejará 
//una excepción específica.

//(SQLException e)Especifica el tipo de excepción que este bloque catch manejará. En este caso, 
//se está manejando una excepción de tipo SQLException. 
//La variable e es una referencia a la instancia de la excepción, y se puede usar para acceder a 
//información sobre la excepción, como mensajes de error.

        } catch (SQLException e) {
//El comando throw en Java se utiliza para lanzar una excepción manualmente. 
//Cuando se detecta una condición inusual o un error en tu código y deseas notificar ese error.
//Aquí, excepcion es una instancia de una clase que hereda de la clase Throwable. 
//Puedes lanzar tanto excepciones estándar proporcionadas por Java como crear tus propias clases de excepción.
//La clase Throwable es la clase base para todas las clases de excepciones y errores en Java. 
//Tanto las excepciones como los errores son subclases de Throwable. 
//Esta clase implementa la interfaz Serializable, lo que significa que las instancias de sus subclases 
//se pueden convertir en una secuencia de bytes y posteriormente restaurar.
            throw new Exception("Tuve un problemita en la base");

        }
    }
//   public void guardarProfesor(Persona perso, Date fechaInicio, Date fechaFin, String grupo, String turno, String materia) throws Exception, BDException, SQLException {

    public void guardarProfesor(String ci, String nombre, String apellido, String grupo, String turno, String materia, Date fechaInicio, Date fechaFin) throws Exception{
    Connection con = null;
    try {
        con = cone.getConnection();

        String sql = "INSERT INTO profesores (cI, nombre, apellido, grupo, turno, materia, fechaFaltainicio, fechaFaltaFin) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        ps = con.prepareStatement(sql);

        ps.setString(1, ci);
        ps.setString(2, nombre);
        ps.setString(3, apellido);
        ps.setString(4, grupo);
        ps.setString(5, turno);
        ps.setString(6, materia);
        java.sql.Date sqlInicio = new java.sql.Date(fechaInicio.getTime());
        java.sql.Date sqlFin = new java.sql.Date(fechaFin.getTime());
        ps.setDate(7, sqlInicio);
        ps.setDate(8, sqlFin);
        ps.executeUpdate(); 
        con.close();
    } catch (SQLException e) {
        System.out.println(e);
        throw new Exception("No fue posible guardar el profesor en la base de datos.");
    }
}


//    } 
public void eliminarProfesor(String ci) throws Exception {

    Connection con = null;
    PreparedStatement ps = null;

    try {
        con = cone.getConnection();

        String sql = "DELETE FROM profesores WHERE ci = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, ci);

        int resultado = ps.executeUpdate(); // cuántas filas eliminó

        if (resultado == 0) {
            throw new Exception("El profesor con esa CI no existe en la base de datos.");
        }

    } catch (SQLException e) {
        System.out.println(e);
        throw new Exception("No fue posible eliminar el profesor.");
    } finally {
        if (ps != null) try { ps.close(); } catch (Exception ignored) {}
        if (con != null) try { con.close(); } catch (Exception ignored) {}
    }
}

 public List<Profesor> listarProfesores() throws Exception {
    List<Profesor> lista = new ArrayList<>();
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        con = cone.getConnection();
        String sql = "SELECT ci, nombre, apellido, grupo, fechaFaltaInicio, fechaFaltaFin, turno, materia FROM profesores";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
            Profesor p = new Profesor();
            p.setCi(rs.getString("ci"));
            p.setNombre(rs.getString("nombre"));
            p.setApellido(rs.getString("apellido"));
            p.setGrupo(rs.getString("grupo"));
            p.setFechaInicio(rs.getDate("fechaFaltaInicio"));
            p.setFechaFin(rs.getDate("fechaFaltaFin"));
            p.setTurno(rs.getString("turno"));
            p.setMateria(rs.getString("materia"));
            lista.add(p);
        }

    } catch (SQLException e) {
        throw new Exception("No fue posible obtener los profesores.");
    } finally {
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        if (con != null) con.close();
    }
    return lista;
}}


