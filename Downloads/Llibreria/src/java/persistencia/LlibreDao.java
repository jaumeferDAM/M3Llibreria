package persistencia;

import java.io.*;
import java.sql.*;
import java.util.*;
import model.*;

public class LlibreDao {

    private Connection con;

    public LlibreDao(Connection con) {
        this.con = con;
    }

    public boolean afegir(Llibre l) {
        boolean afegit = true;
        PreparedStatement pt = null;
        String sentencia = "INSERT INTO JFERNANDEZ.Llibres(TITOL, AUTOR, ANYEDICIO, ISBN, EDITORIAL, ESTOC)"
        + " VALUES(?,?,?,?,?,?)";
        try {
            pt = con.prepareStatement(sentencia);
            pt.setString(1, l.getTitol());
            pt.setString(2, l.getAutor());
            pt.setInt(3, l.getAnyEdicio());
            pt.setString(4, l.getIsbn());
            pt.setString(5, l.getEditorial());
            pt.setInt(6, l.getEstoc());
            
            
            if (pt.executeUpdate() == 0) {
                afegit = false;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            afegit = false;
        } finally {
            tancarRecurs(pt);
        }

        return afegit;
    }

    public Llibre cercarPerISBN(String isbn) {
        String consulta = " SELECT * FROM LLIBRE WHERE isbn='" + isbn + "'";
        Statement st;
        ResultSet rs;
        Llibre llib = null;

        try {
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            if (rs.next()) {
                llib = new Llibre(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getInt(6));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return llib;
    }

    public List<Llibre> cercarTots() {
        String consulta = " SELECT * FROM LLIBRE";
        Statement st;
        ResultSet rs;
        List<Llibre> llista = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                llista.add(new Llibre(rs.getString(1),
                        rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6)));
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return llista;
    }

    private void tancarRecurs(AutoCloseable r) {
        try {
            r.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {

        }

    }

}
