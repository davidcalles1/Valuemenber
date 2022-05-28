/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.*;
import com.william.BD.ConexionAMYSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;


public class MateriaDao {
    
        ConexionAMYSQL con = new ConexionAMYSQL();
        Connection conexion = con.getConecction();

       public ArrayList<Materia> ListadoMateria() {
        ArrayList<Materia> listado = null;

        try {
            listado = new ArrayList<Materia>();

            CallableStatement cb = conexion.prepareCall("{call SP_S_MATERIAS()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                //Llamar a el objeto de entidades.
                Materia es = new Materia();
                es.setIdMateria(resultado.getInt("idMateria"));
                es.setNombreMateria(resultado.getString("NombreMateria"));
                listado.add(es);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listado;

    }
    
    
    
    
    
}
